package in.co.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in FirstServlet doGet");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1>My First Servlet...!!!!</h1>");

		out.close();
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in FirstServlet doPost");

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1>My First Servlet...!!!!</h1>");

		out.println("\n"+"fname = " + fname);

		out.println("\n"+"lname = " + lname);

		out.println("\n"+"login = " + login);

		out.println("\n"+"pass = " + pass);

		out.println("\n"+"dob = " + dob);

		out.println("\n"+"address = " + address);

		out.close();
	}


	}
	


