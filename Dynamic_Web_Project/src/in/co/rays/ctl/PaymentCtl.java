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

import in.co.rays.Bean.PaymentBean;
import in.co.rays.Bean.UserBean;
import in.co.rays.Model.PaymentModel;
import in.co.rays.Model.UserModel;

@WebServlet("/PaymentCtl.dm")
public class PaymentCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			PaymentModel model = new PaymentModel();
			try {
				PaymentBean bean = model.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("PaymentView.jsp");
		rd.forward(req, resp);
		

	}

	//	resp.sendRedirect("PaymentView.jsp");
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String id =req.getParameter("id");
		String pay = req.getParameter("payementDate");
		String des = req.getParameter("description");
		String ammount =  req.getParameter("ammount");
		String paymentmethod = req.getParameter("paymentMethod");
		String status = req.getParameter("status");
		String payer = req.getParameter("payer");
		String email = req.getParameter("emailId");
		String pass = req.getParameter("password");
		String op = req.getParameter("operation");

		PaymentBean bean = new PaymentBean();

		try {
			bean.setPayementDate(sdf.parse(pay));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		bean.setDescription(des);
		bean.setAmmount(Integer.parseInt(ammount));
		bean.setPaymentMethod(paymentmethod);
		bean.setStatus(status);
		bean.setPayer(payer);
		bean.setEmailId(email);
		bean.setPassword(pass);
		
		PaymentModel model = new PaymentModel();
		
	if(op.equals("save")) {
			
			
			try {
				model.add(bean);
				req.setAttribute("msg", "User Data added successfully...!!");
				RequestDispatcher rd = req.getRequestDispatcher("PaymentView.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
			
	if (op.equals("update")) {
		try {
			bean.setId(Integer.parseInt(id));
			model.update(bean);
//			bean = model.findByPk(bean.getId());
		PaymentBean existBean = model.findByPk(bean.getId());
		
			req.setAttribute("bean", existBean);
			req.setAttribute("msg", "User Data updated successfully...!!");
			RequestDispatcher rd = req.getRequestDispatcher("PaymentView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	if (op.equals("list")) {
		
		resp.sendRedirect("PaymentListCtl.dm");
	}
		
	
	}

}
