package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("this is servlet doGet");
		
	//	resp.sendRedirect("SecondServlet");
		
		RequestDispatcher rd =req.getRequestDispatcher("SecondServlet");
		
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("this is sevlet dopost");
			
	//	resp.sendRedirect("SecondServlet");
		
		System.out.println("Servlet FirstName =" + req.getParameter("firstName"));
		
		req.setAttribute("lastName", "Mandloi");
		
		RequestDispatcher rd =req.getRequestDispatcher("SecondServlet");
		
		rd.forward(req, resp);
		
	}
}
