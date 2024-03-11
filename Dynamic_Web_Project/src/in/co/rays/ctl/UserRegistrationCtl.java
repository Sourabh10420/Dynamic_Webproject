package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserBean;
import in.co.rays.Model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("UserRegistration.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String fname = req.getParameter("mukesh");
		String lname = req.getParameter("mandloi");
		String login = req.getParameter("mukesh@gmail.com");
		String pass = req.getParameter("mukesh@143");
		String dob = req.getParameter("11/12/1997");
		String address = req.getParameter("indore");
		
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
		
		try {
			model.add(bean);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		resp.sendRedirect("UserRegistration.jsp");

}
}