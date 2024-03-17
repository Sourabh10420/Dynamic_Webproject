package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserBean;
import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserModel;
import in.co.rays.Model.UserRegistrationModel;

@WebServlet("/RegistrationLoginCtl")
public class RegistrationLoginCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Do get Method");
		
		resp.sendRedirect("RegistrationLoginView.jsp");
	}
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Do Post Method");
		
	String login	=req.getParameter("loginId");
	String pass	=req.getParameter("password");
	
	UserModel model = new UserModel();
	
	try {
		
		UserBean bean = new UserBean();
	
	bean.setLoginId(login);
	bean.setPassword(pass);
	
	
	if(bean != null) {
		
			resp.sendRedirect("Welcome.jsp");
	}
	else {
		
         req.setAttribute("msg", "login id and password invalid");
		

		RequestDispatcher rd = req.getRequestDispatcher("RegistrationLoginView.jsp");
		
		rd.forward(req, resp);
	
	}
	
	}catch(Exception e) {
		
		e.printStackTrace();
	}
		
	}
}