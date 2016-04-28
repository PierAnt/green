/*Servletti pizzojen listaamiseen.*/

package batch;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Tuntikirjaus;
import dao.TuntikirjausDAO;

@WebServlet("/user-main")
public class MainUserServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		TuntikirjausDAO dao = (TuntikirjausDAO) context.getBean("tuntikirjausDaoLuokka");
		
		int hlo_tunnus = 1;
		ArrayList<Tuntikirjaus> kirjaukset = dao.haeHenkilonKirjaukset(hlo_tunnus);
		request.setAttribute("kirjaukset", kirjaukset);
		
		String jsp = "/view/user-main.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}
	
}
