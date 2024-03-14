package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectFirstServlet")
public class RedirectFirstServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		System.out.println("First Servlet doGet");
		
		resp.sendRedirect("RedirectSecondServlet");
		
		String FirstName =req.getParameter("firstName");
		
		System.out.println("FirstName = " + FirstName);
		
		req.setAttribute("lastName", "Mandloi");
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("First Servlet doPost");
		
		resp.sendRedirect("RedirectSecondServlet");
		
		String FirstName = req.getParameter("firstName");
		
		System.out.println("FirstName =" + FirstName);
		
		req.setAttribute("lastName", "Gurjar" );
		
	}

}
