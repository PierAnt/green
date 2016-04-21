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
	 * Lähettää  selaimelle taytteen tietojen lisayslomake
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			// Haetaan kaikki henkilot
			
			List<Henkilo> henkilot = dao.haeHenkilot();
			System.out.println("dao luotu");
			// Talletetaan request-olion alle henkilölista, jotta tiedot ovat käytössä jsp:llä
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
	 * Haetaan lomakkeella syötetyn henkilön tiedot  request (pyyntö)-olion parametritiedoista
	 * ja lisätään henkilön tiedot tietokantaan.
	 * tietokantaan
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			//Haetaan lomakkeelta syötetyn henkilön tiedot request-oliolta
			
			String hlo_etunimi = request.getParameter("hlo_etunimi");
			String hlo_sukunimi = request.getParameter("hlo_sukunimi");
			
	
			//Luodaan uusi henkilö edellisillä parametreillä
			Henkilo henkilo = new Henkilo(0,hlo_etunimi, hlo_sukunimi);

			//Lisätään henkilön tiedot tietokantaan
			dao.talleta(henkilo);
			
		} catch (Exception e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}
		
		// päivitetään sivu
		response.sendRedirect("lisaa-henkilo");
	}

}
