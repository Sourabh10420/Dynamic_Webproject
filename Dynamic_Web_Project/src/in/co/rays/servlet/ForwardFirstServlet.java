package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardFirstServlet")
public class ForwardFirstServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			System.out.println("first servlet doGet");
			
			String firstName = req.getParameter("firstName");
			
			System.out.println("FirstName =" + firstName);
			
			RequestDispatcher rd = req.getRequestDispatcher("ForwardSecondServlet");
			
			req.setAttribute("lastName", "Mandloi");
			
			rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("first servlet doPost");
		
		String firstName = req.getParameter("firstName");
		
		System.out.println("FirstName =" + firstName);
		
		RequestDispatcher rd = req.getRequestDispatcher("ForwardSecondServlet");
		
		req.setAttribute("lastName", "Mandloi");
		
		rd.forward(req, resp);
	}
}
