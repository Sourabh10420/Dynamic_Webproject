package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectSecondServlet")
public class RedirectSecondServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Second Servlet doGet");
		
		String str = (String) req.getAttribute("lastName");
		
		System.out.println("LastName =" + str);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Second Servlet doPost");
		
		String str = (String)req.getAttribute("lastName");
		
		System.out.println("LastName =" + str );
		
	}
}