package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserBean;
import in.co.rays.Model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet{
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("LoginView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login=req.getParameter("loginId");
		String pass =req.getParameter("password");
		
		UserModel model = new UserModel();
		
		try {
		
		UserBean bean = model.authenticate(login, pass);
		
		if(bean != null) {
			
			resp.sendRedirect("Welcome.jsp");
		}else {
			resp.sendRedirect("LoginView.jsp");
		}
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
