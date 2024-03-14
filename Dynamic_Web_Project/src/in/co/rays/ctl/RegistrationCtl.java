package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserRegistrationModel;

@WebServlet("/RegistrationCtl")
public class RegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Registration doGet");

		resp.sendRedirect("Registration.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Registration doPost");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");
		String dob = req.getParameter("dob");
		
		
		UserRegistrationBean bean = new UserRegistrationBean();
		
		bean.setfName(fName);
		bean.setlName(lName);
		bean.setLoginId(login);
		bean.setPassword(pass);
		bean.setAddress(address);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		UserRegistrationModel model = new UserRegistrationModel();
		
		try {
			model.add(bean);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		resp.sendRedirect("Registration.jsp");
	}

}
