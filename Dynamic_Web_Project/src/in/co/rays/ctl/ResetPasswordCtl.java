package in.co.rays.ctl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserBean;
import in.co.rays.Model.UserModel;
import in.co.rays.util.JDBCDataSource;

@WebServlet("/ResetPasswordCtl")
public class ResetPasswordCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("SearchLoginDob.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			

	
       String op = req.getParameter("operation");
		
		String login = req.getParameter("LoginId");

		if (op.equals("submit")) {
			
			UserModel model = new UserModel();
		
		try {
			UserBean bean = model.findByLogin(login);
			
			if(bean != null) {
				
				req.setAttribute("user", bean);
			}
			else {
				req.setAttribute("msg", "loginId is invalid...!!!");
				RequestDispatcher rd = req.getRequestDispatcher("SearchLoginDob.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
}