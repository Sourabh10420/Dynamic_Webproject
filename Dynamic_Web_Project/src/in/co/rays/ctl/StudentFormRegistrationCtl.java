package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

@WebServlet("/StudentFormRegistrationCtl")
public class StudentFormRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("StudentRegistrationView.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String first = req.getParameter("firstName");

		String last = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String course = req.getParameter("courseName");
		String enroll = req.getParameter("enrollment");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String semester = req.getParameter("semester");

		String op = req.getParameter("operation");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StudentFormBean bean = new StudentFormBean();

		try {

			StudentFormModel model = new StudentFormModel();

			bean.setFirstName(first);
			bean.setLastName(last);
			bean.setLoginId(login);
			bean.setPassword(pass);
			bean.setCourseName(course);
			bean.setEnrollment(enroll);
			try {
				bean.setDob(sdf.parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			bean.setAddress(address);
			bean.setSemester(semester);

			if (op.equals("save")) {

				if (first.equals("") || last.equals("") || login.equals("") || pass.equals("") || course.equals("")
						|| enroll.equals("") || dob.equals("") || address.equals("") || (semester.equals(""))) {

					if (first.equals("")) {
						req.setAttribute("first", "FirstName is Required");
					}
					if (last.equals("")) {
						req.setAttribute("last", "LastName is Required");
					}
					if (login.equals("")) {
						req.setAttribute("login", "LoginId is Required");
					}
					if (pass.equals("")) {
						req.setAttribute("pass", "Password is Required");
					}
					if (course.equals("")) {
						req.setAttribute("course", "CourseName is Required");
					}
					if (enroll.equals("")) {
						req.setAttribute("enroll", "Enrollment is Required");
					}
					if (dob.equals("")) {
						req.setAttribute("dob", "DOB is Required");
					}
					if (address.equals("")) {
						req.setAttribute("address", "Address is Required");
					}
					if (semester.equals("")) {
						req.setAttribute("semester", "Semester is Required");
					}

					RequestDispatcher rd = req.getRequestDispatcher("StudentRegistrationView.jsp");

					rd.forward(req, resp);

				} else {

					model.add(bean);

					req.setAttribute("msg", "User Data added successfully Pleass Back to LoginPage....!!");

					RequestDispatcher rd = req.getRequestDispatcher("StudentRegistrationView.jsp");
					rd.forward(req, resp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (op.equals("backToLoginPage")) {

			resp.sendRedirect("StudentLoginView.jsp");
		}
	}
}
