package in.co.rays.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.Bean.PaymentBean;

public class PaymentModel {
	
	public PaymentBean authenticate(String EmailId, String Password) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "(select * from Payment where EmailId=? and Password=?)";

		PreparedStatement ps = conn.prepareStatement(str);
		
		ps.setString(1, EmailId);
		ps.setString(2, Password);

		ResultSet rs = ps.executeQuery();
		
    	PaymentBean	bean = new PaymentBean();
		
		while (rs.next()) {

			bean.setId(rs.getInt(1));
			bean.setPayementDate(rs.getDate(2));
			bean.setDescription(rs.getString(3));
			bean.setAmmount(rs.getInt(4));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setPayer(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setPassword(rs.getString(9));

		}

			
		return bean;
	}

	public Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "select max(id) from Payment";

		PreparedStatement ps = conn.prepareStatement(str);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public void add(PaymentBean bean) throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "insert into Payment values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(str);

		ps.setInt(1, pk);
		ps.setDate(2, new java.sql.Date(bean.getPayementDate().getTime()));
		ps.setString(3, bean.getDescription());
		ps.setInt(4, bean.getAmmount());
		ps.setString(5, bean.getPaymentMethod());
		ps.setString(6, bean.getStatus());
		ps.setString(7, bean.getPayer());
		ps.setString(8, bean.getEmailId());
		ps.setString(9, bean.getPassword());

		int i = ps.executeUpdate();

		System.out.println("data inserted =" + i);

	}

	public void update(PaymentBean bean) throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "update Payment set Payment_Date=?,Description=?,Amount=?,Payment_Method=?,Status=?,Payer=?,EmailId=?,Password=? where id =?";

		PreparedStatement ps = conn.prepareStatement(str);

		ps.setDate(1, new java.sql.Date(bean.getPayementDate().getTime()));
		ps.setString(2, bean.getDescription());
		ps.setInt(3, bean.getAmmount());
		ps.setString(4, bean.getPaymentMethod());
		ps.setString(5, bean.getStatus());
		ps.setString(6, bean.getPayer());
		ps.setString(7, bean.getEmailId());
		ps.setString(8, bean.getPassword());
		ps.setInt(9, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("Update Successfull =" + i);

	}

	public PaymentBean findByPk(int id) throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "select * from Payment where id = ?";

		PreparedStatement ps = conn.prepareStatement(str);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		PaymentBean bean = new PaymentBean();

		while (rs.next()) {

			bean.setId(rs.getInt(1));
			bean.setPayementDate(rs.getDate(2));
			bean.setDescription(rs.getString(3));
			bean.setAmmount(rs.getInt(4));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setPayer(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setPassword(rs.getString(9));

		}
		return bean;

	}
	public PaymentBean findByLogin(String EmailId) throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "select * from Payment where EmailId = ?";

		PreparedStatement ps = conn.prepareStatement(str);

		ps.setString(1, EmailId);

		ResultSet rs = ps.executeQuery();

		PaymentBean bean = new PaymentBean();

		while (rs.next()) {

			bean.setId(rs.getInt(1));
			bean.setPayementDate(rs.getDate(2));
			bean.setDescription(rs.getString(3));
			bean.setAmmount(rs.getInt(4));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setPayer(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setPassword(rs.getString(9));

		}
		return bean;

	}

	public List search() throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "select * from Payment";

		PreparedStatement ps = conn.prepareStatement(str);

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			PaymentBean bean = new PaymentBean();

			bean.setId(rs.getInt(1));
			bean.setPayementDate(rs.getDate(2));
			bean.setDescription(rs.getString(3));
			bean.setAmmount(rs.getInt(4));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setPayer(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setPassword(rs.getString(9));
			
			list.add(bean);
		}
		return list;

	}

	public List search(PaymentBean bean, int pageNo, int pageSize) throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		StringBuilder bd = new StringBuilder("select * from Payment where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {

				bd.append(" and id =" + bean.getId());
			}
			if (bean.getPayer() != null && bean.getPayer().length() > 0) {
				bd.append(" and payer like '" + bean.getPayer() + "%'");

			}
			if(bean.getPayementDate()!=null && bean.getPayementDate().getTime()>0) {
				
				bd.append(" and Payment_Date like '" + new java.sql.Date(bean.getPayementDate().getTime()) + "%'" );
				
			}
		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			bd.append(" limit " + pageNo + "," + pageSize);
		}

		System.out.println("sql->" + bd);

		PreparedStatement ps = conn.prepareStatement(bd.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new PaymentBean();

			bean.setId(rs.getInt(1));
			bean.setPayementDate(rs.getDate(2));
			bean.setDescription(rs.getString(3));
			bean.setAmmount(rs.getInt(4));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setPayer(rs.getString(7));
			bean.setEmailId(rs.getString(8));
			bean.setPassword(rs.getString(9));
			
			list.add(bean);

		}
		return list;

	}

	public void delete(int id) throws Exception {

		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourabh", "root", "root");

		String str = "delete from Payment where id =?";

		PreparedStatement ps = conn.prepareStatement(str);

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println("delete successfully =" + i);
	}

}
