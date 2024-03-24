package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.Bean.StudentFormBean;
import in.co.rays.Model.StudentFormModel;

@WebServlet("/StudentLoginCtl")
public class StudentLoginCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = req.getParameter("operation");
		
		if (op != null && op.equals("logout")) {
			
			HttpSession session = req.getSession();
			
			session.invalidate();
		}
		resp.sendRedirect("StudentLoginView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getParameter("uri");
		String login =req.getParameter("loginId");
	String pass  =	req.getParameter("password");
		String op =req.getParameter("operation");
		
		
		if(op.equals("singIn")) {
			
			if(login.equals("") || pass.equals("")) {
				
				if(login.equals("")) {
					
					req.setAttribute("login", "LoginId is Required");
				}
				if(pass.equals("")) {
					req.setAttribute("pass", "Password is Required");
				}
				
				RequestDispatcher rd = req.getRequestDispatcher("StudentLoginView.jsp");
				
				rd.forward(req, resp);
			}
			
			else {
			StudentFormModel model = new StudentFormModel();
		
		try {
			StudentFormBean bean = model.authenticate(login, pass);
			
			if(bean != null) {
				
				HttpSession session = req.getSession();
			
					session.setAttribute("admin", bean);
					
					if (uri.equalsIgnoreCase("null")) {
							resp.sendRedirect("StudentWelcome.jsp");
					} else {
							resp.sendRedirect(uri);
						}
//					
//					RequestDispatcher rd = req.getRequestDispatcher("StudentWelcome.jsp");
//					
//					rd.forward(req, resp);
//					
//					resp.sendRedirect("StudentWelcome.jsp");
//					
			}else {
				
				req.setAttribute("error", "Invalid LoginId & Password Pleass Enter Correct One");
				
				RequestDispatcher rd = req.getRequestDispatcher("StudentLoginView.jsp");
				
				rd.forward(req, resp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		}
		
	if(op.equals("singUp")) {
		
		resp.sendRedirect("StudentFormRegistrationCtl");
	}
	if(op.equals("forgotPassword")) {
		
		resp.sendRedirect("StudentResetPasswordCtl");
	}

}
}
