package batch;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Henkilo;
import dao.HenkiloDAO;





@WebServlet("/lisaa-henkilo")
public class LisaaHenkiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HenkiloDAO dao;
	
	public HenkiloDAO getDao() {
		return dao;
	}

	public void setDao(HenkiloDAO dao) {
		this.dao = dao;
	}
       
	/**
	 * L�hett��  selaimelle taytteen tietojen lisayslomake
	 * 
	 * @param request
	 *            pyynt�
	 * @param response
	 *            vastaus
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			// Haetaan kaikki henkilot
			
			List<Henkilo> henkilot = dao.haeHenkilot();
			System.out.println("dao luotu");
			// Talletetaan request-olion alle henkil�lista, jotta tiedot ovat k�yt�ss� jsp:ll�
			request.setAttribute("henkilot", henkilot);
			
			String jsp = "/view/lisaa-henkilo.jsp";
			System.out.println("view");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Vastaanottaa tietoa selaimelta:
	 * 
	 * Haetaan lomakkeella sy�tetyn henkil�n tiedot  request (pyynt�)-olion parametritiedoista
	 * ja lis�t��n henkil�n tiedot tietokantaan.
	 * tietokantaan
	 * 
	 * @param request
	 *            pyynt�
	 * @param response
	 *            vastaus
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			//Haetaan lomakkeelta sy�tetyn henkil�n tiedot request-oliolta
			
			String hlo_etunimi = request.getParameter("hlo_etunimi");
			String hlo_sukunimi = request.getParameter("hlo_sukunimi");
			
	
			//Luodaan uusi henkil� edellisill� parametreill�
			Henkilo henkilo = new Henkilo(0,hlo_etunimi, hlo_sukunimi);

			//Lis�t��n henkil�n tiedot tietokantaan
			dao.talleta(henkilo);
			
		} catch (Exception e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}
		
		// p�ivitet��n sivu
		response.sendRedirect("lisaa-henkilo");
	}

}
