package in.co.rays.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.util.JDBCDataSource;

public class UserRegistrationModel {
	
	public Integer nextPk() throws Exception{
		
		Connection conn =JDBCDataSource.getConnection();
		
		int pk = 0;
		
		String str = "select max(id) from UserRegistration";
		
		PreparedStatement ps =conn.prepareStatement(str);
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()){
			
			 pk =rs.getInt(1);
		}
		
	
	return pk+1;

} 
	public void add(UserRegistrationBean bean) throws Exception{
	
	int pk = nextPk();
	
	Connection conn =JDBCDataSource.getConnection();
	
	String str = "insert into UserRegistration values(?,?,?,?,?,?,?)";
	
	PreparedStatement ps = conn.prepareStatement(str);
	
	ps.setInt(1, pk);
	ps.setString(2, bean.getfName());
	ps.setString(3, bean.getlName());
	ps.setString(4, bean.getLoginId());
	ps.setString(5, bean.getPassword());
	ps.setString(6, bean.getAddress());
	ps.setDate(7, new java.sql.Date(bean.getDob().getTime()));
	
	
	int i =ps.executeUpdate();
	
	System.out.println("insert Data Successfully" + i);
}
	
	public void update(UserRegistrationBean bean) throws Exception{

		int pk = nextPk();
		
		Connection conn =JDBCDataSource.getConnection();
		
		String str = "update  UserRegistration set F_Name=?,L_Name=?,Login_Id=?,Password=?,Address=?,Dob=? where Id=?";
		
		PreparedStatement ps = conn.prepareStatement(str);
		
		
		ps.setString(1, bean.getfName());
		ps.setString(2, bean.getlName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAddress());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setInt(7,bean.getId());
		
		int i =ps.executeUpdate();
		
		System.out.println("Update Data Successfully" + i);
		
	}
	
	public void delete(UserRegistrationBean bean, String F_Name) throws Exception{
		
Connection conn =JDBCDataSource.getConnection();
		
		String str = "delete from UserRegistration where F_Name=?";
		
		PreparedStatement ps = conn.prepareStatement(str);
		
		ps.setString(1, F_Name);
		
		 int i =ps.executeUpdate();
		 
		 System.out.println("delete data Succ"+i);
		
	}
	public UserRegistrationBean findByPk(int id) throws Exception{
		
		
Connection conn =JDBCDataSource.getConnection();
		
	String str = "select * from UserRegistration where id=?";
	
	PreparedStatement ps = conn.prepareStatement(str);
	
	ps.setInt(1, id);
	
	ResultSet rs =ps.executeQuery();
	
		UserRegistrationBean bean = null;
		
		while(rs.next()) {
			
			bean = new UserRegistrationBean();
			
			bean.setId(rs.getInt(1));
			bean.setfName(rs.getString(2));
			bean.setlName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));
			
		}
		return bean;
	}
	
	public UserRegistrationBean authenticate(String Login_Id,String Password) throws Exception{
		
		Connection conn =JDBCDataSource.getConnection();
		
		String str = "select * from UserRegistration where Login_Id=? and Password=?";
		
		PreparedStatement ps = conn.prepareStatement(str);
		
		ps.setString(1, Login_Id);
		ps.setString(2, Password);
		
		ResultSet rs =ps.executeQuery();
		
		UserRegistrationBean bean = null;
		
		while(rs.next()) {
				bean =  new UserRegistrationBean();
				
				bean.setId(rs.getInt(1));
				bean.setfName(rs.getString(2));
				bean.setlName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setDob(rs.getDate(7));
				
		}return bean;
	}
	
	public List search() throws Exception{
		
		Connection conn =JDBCDataSource.getConnection();
		
		String str = "select * from UserRegistration";
		
		PreparedStatement ps = conn.prepareStatement(str);
		
		ResultSet rs =ps.executeQuery();
		
		List list = new ArrayList();
		
		UserRegistrationBean bean = null;
		
		while (rs.next()) {
			
			bean = new UserRegistrationBean();
			
			
			bean.setId(rs.getInt(1));
			bean.setfName(rs.getString(2));
			bean.setlName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));
			
			list.add(bean);
		}
		
		return list;
		
		
	}
	public List search(UserRegistrationBean bean,int pageNo,int pageSize) throws Exception{
		
		
		Connection conn =JDBCDataSource.getConnection();
		
		StringBuffer sb = new StringBuffer("select * from UserRegistration where 1=1");
		
		if(bean != null) {
			
			if(bean.getId()>0) {
				sb.append(" and id = " + bean.getId());
			}
			if(bean.getlName() != null && bean.getlName().length()>0) {
				sb.append(" and L_Name like '" + bean.getlName() + "%'");
			}
//			if(bean.getDob() != null && bean.getDob().getTime()>0) {
//				sb.append(" and Dob " + new java.sql.Date(bean.getDob().getTime()));
//			}
			
		}
		if(pageSize>0) {
			
			pageNo = (pageNo - 1) * pageSize;
			sb.append(" limit " + pageNo + ", " + pageSize);
		}
		
		System.out.println("sql->" + sb);
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			
			bean = new UserRegistrationBean();
			
			
			bean.setId(rs.getInt(1));
			bean.setfName(rs.getString(2));
			bean.setlName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));
			
			list.add(bean);
		}
		return list;
		
	}

}