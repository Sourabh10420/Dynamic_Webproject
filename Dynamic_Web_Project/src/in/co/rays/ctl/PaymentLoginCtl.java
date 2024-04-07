package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.Bean.PaymentBean;
import in.co.rays.Bean.UserBean;
import in.co.rays.Model.PaymentModel;

@WebServlet("/PaymentLoginCtl")
public class PaymentLoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if (op != null && op.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		resp.sendRedirect("PayementLoginView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri =req.getParameter("uri");
		String email = req.getParameter("emailId");
		String pass = req.getParameter("password");
		String op = req.getParameter("operation");
		
		PaymentModel model = new PaymentModel();
		
		if (op.equals("Login")) {
			

			if (email.equals("") || pass.equals("")) {

				if (email.equals("")) {

					req.setAttribute("login", "emailId is Required");
				}
				if (pass.equals("")) {

					req.setAttribute("pas", "Password is Required");
				}
				
				RequestDispatcher rd = req.getRequestDispatcher("PayementLoginView.jsp");
				
				rd.forward(req, resp);
			
		  }else {
				
				
			try {
			PaymentBean	bean = model.authenticate(email, pass);
	 
				if (bean != null) {
					
					HttpSession session = req.getSession();
					
					session.setAttribute("user", bean);
				
				if (uri.equalsIgnoreCase("null")) {
						resp.sendRedirect("PaymentWelcome.jsp");
				} else {
						resp.sendRedirect(uri);
					}
				
				} else {
					req.setAttribute("msg", "login & password is invalid...!!!");
					RequestDispatcher rd = req.getRequestDispatcher("PayementLoginView.jsp");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		
		
	}
		if (op.equals("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
		}
		if(op.equals("forgottPassword")) {
			
			resp.sendRedirect("ResetPass.jsp");
		}

	}
}
