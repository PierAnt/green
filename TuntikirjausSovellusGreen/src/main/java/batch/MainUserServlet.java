/*Servletti pizzojen listaamiseen.*/

package batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tuntikirjaus;
import dao.TuntikirjausDAO;

@WebServlet("/user-main")
public class MainUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private TuntikirjausDAO dao;
	
	public TuntikirjausDAO getDao() {
		return dao;
	}

	public void setDao(TuntikirjausDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * L�hett�� tietoa selaimelle:
	 * 
	 * Tietokannasta haetaan tuntikirjauslista
	 * ja v�litet��n
	 * 
	 * @param request
	 * 		pyynt�
	 * @param response 
	 * 		vastaus
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		int hlo_tunnus = 0;
		// Luodaan tuntikirjausDAO ja k�sket��n hakemaan kaikki kirjaukset
		List<Tuntikirjaus> kirjaukset = dao.haeHenkilonKirjaukset(hlo_tunnus);
		
		// Talletetaan request-olion alle kirjauslista, jotta tiedot ovat k�yt�ss� jsp:ll�
		request.setAttribute("kirjaukset", kirjaukset);
		
		// l�het� selaimelta tullut pyynt� servletilt� edelleen  jsp:lle
		String jsp = "/view/user-main.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}
	
}
