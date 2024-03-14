package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardSecondServlet")
public class ForwardSecondServlet extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Second servlet doGet");
		
		String firstName =req.getParameter("firstName");
		
		System.out.println("FirstName =" + firstName);
		
		String str = (String)req.getAttribute("lastName");
		
		 System.out.println("LastName = " + str);
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Second servlet doPost");
		
		String firstName = req.getParameter("firstName");
		
		System.out.println("FirstName =" + firstName);

		String str = (String)req.getAttribute("lastName");
		
		 System.out.println("LastName = " + str);
}

	}

