package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstSession")
public class FirstSession extends HttpServlet{
	
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		
				HttpSession session = req.getSession(true);
				
				System.out.println("firstsession =" + session.getId());
				
				
				
	}

}
