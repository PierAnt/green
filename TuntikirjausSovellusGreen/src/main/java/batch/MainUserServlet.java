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
	 * Lähettää tietoa selaimelle:
	 * 
	 * Tietokannasta haetaan tuntikirjauslista
	 * ja välitetään
	 * 
	 * @param request
	 * 		pyyntö
	 * @param response 
	 * 		vastaus
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		int hlo_tunnus = 0;
		// Luodaan tuntikirjausDAO ja käsketään hakemaan kaikki kirjaukset
		List<Tuntikirjaus> kirjaukset = dao.haeHenkilonKirjaukset(hlo_tunnus);
		
		// Talletetaan request-olion alle kirjauslista, jotta tiedot ovat käytössä jsp:llä
		request.setAttribute("kirjaukset", kirjaukset);
		
		// lähetä selaimelta tullut pyyntö servletiltä edelleen  jsp:lle
		String jsp = "/view/user-main.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}
	
}
