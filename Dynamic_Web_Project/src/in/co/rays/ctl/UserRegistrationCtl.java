package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("UserRegistration.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String op =req.getParameter("operation");
		
		
		
		String fname  = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String  dob= req.getParameter("dob");
		String address = req.getParameter("address");
		
		UserBean bean = new UserBean();
		
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(login);
		bean.setPassword(pass);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		bean.setAddress(address);
	
	UserModel model = new UserModel();
		

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User singUp successfully Pleass Login ...!!!");
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		resp.sendRedirect("LoginView.jsp");
	}

}