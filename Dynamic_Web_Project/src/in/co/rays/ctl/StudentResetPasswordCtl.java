package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.StudentFormBean;
import in.co.rays.Bean.UserBean;
import in.co.rays.Model.StudentFormModel;
import in.co.rays.Model.UserModel;

@WebServlet("/StudentResetPasswordCtl")
public class StudentResetPasswordCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("StudentRestPassword.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
       String op = req.getParameter("operation");
		
		if(op.equals("search")) {
			
		
		StudentFormBean bean = new StudentFormBean();
		StudentFormModel model = new StudentFormModel();
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("loginId");
		 try {	
			 bean = model.findByLogin(email);

/*      if (email.equals("")) {

	      RequestDispatcher rd = request.getRequestDispatcher("ResetPass.jsp");
	      request.setAttribute("email", "Username is required");
	      rd.forward(req, resp);
         }
*/			
			 if(bean != null ) {
				 out.println("Your password is :"+bean.getPassword());				
			   } else if ((email.equals(""))) {
				
			RequestDispatcher rd = req.getRequestDispatcher("StudentRestPassword.jsp");
			req.setAttribute("email", "please inter your loginId");
			rd.forward(req, resp);
			
	      }else {
	    	RequestDispatcher rd = req.getRequestDispatcher("StudentRestPassword.jsp");
			req.setAttribute("Pwd", "your loginId is not valid");
			rd.forward(req, resp);
	    	
	    }
			 
		 }
		
		 catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(op.equals("loginPage")) {
			
			resp.sendRedirect("StudentLoginView.jsp");
			
		}
}

}
