package in.co.rays.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.co.rays.Bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {
	
		
		public UserBean authenticate(String loginId, String password) throws Exception {
			
			int pk = nextPk();
			
			Connection conn = JDBCDataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ?");

			ps.setString(1, loginId);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			UserBean bean = null;

			while (rs.next()) {
				bean = new UserBean();
				
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			}
			return bean;
		}

		public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn =JDBCDataSource.getConnection(); 
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}
	
		public void add(UserBean bean) throws Exception {

			int pk = nextPk();

			Connection conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getAddress());

			int i = pstmt.executeUpdate();

			System.out.println("Data Inserted = " + i);

		}

		public void update(UserBean bean) throws Exception {

			Connection conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"update user set first_name = ?, last_name = ?, login_id = ?, password = ?, dob = ?, address = ? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getAddress());
			pstmt.setInt(7, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println("Data Updated = " + i);

		}
	
	
	public void delete(int id) throws Exception{
		
		int pk = nextPk();
		
		Connection conn =JDBCDataSource.getConnection(); 
		
		PreparedStatement st=conn.prepareStatement("delete from User where id =?");
		
		st.setInt(1, id);
		
		int i =  st.executeUpdate();
		
		System.out.println("deleted data successfully = "  + i);
}
	
	public void searchByNormal(UserBean bean) throws Exception{
		
		int pk = nextPk();
		
		
		Connection conn =JDBCDataSource.getConnection(); 
		
		PreparedStatement st=conn.prepareStatement("select * from User");
		
		ResultSet rs =st.executeQuery();
			
			while (rs.next()) {
				
				bean =  new UserBean();
				
				System.out.print("\t"+ rs.getInt(1));
					System.out.print("\t"+ rs.getString(2));
						System.out.print("\t"+ rs.getString(3));
							System.out.print("\t"+ rs.getString(4));
						System.out.print("\t"+ rs.getString(5));
					System.out.print("\t"+ rs.getDate(6));
				System.out.println("\t"+ rs.getString(7));
			
			}
		
	}
	
	public UserBean findByPk(int id) throws Exception{
		
		Connection conn =JDBCDataSource.getConnection(); 
		
		PreparedStatement st=conn.prepareStatement("select * from User where id =?");
			
			st.setInt(1, id);
		
		ResultSet rs =st.executeQuery();
		
			UserBean bean = null;
				
			while(rs.next()) {
				bean = new UserBean();
						
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			}
			return bean;
	}
	
	public List search(UserBean bean) throws Exception{
		
			int pk = nextPk();
		
			Connection conn =JDBCDataSource.getConnection(); 
			
		PreparedStatement st=conn.prepareStatement("select * from User");
			
		ResultSet rs =st.executeQuery();
		
		List list = new ArrayList();
		  bean = new UserBean();
		
		  	
		  while(rs.next()) {
			
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
	}
	
		return list;
	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");
			}

			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql ==>> " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
	}
	
	public UserBean findByLogin(String LoginId) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where Login_Id = ?");
		
		
		pstmt.setString(1, LoginId);
		

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}
		return bean;
	}
}


