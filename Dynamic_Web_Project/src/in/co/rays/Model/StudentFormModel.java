package in.co.rays.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.Bean.StudentFormBean;
import in.co.rays.util.JDBCDataSource;

public class StudentFormModel  {
	
	
	public Integer nextPk() throws Exception{
		
		int pk = 0;
		
		Connection conn =JDBCDataSource.getConnection();
		
		PreparedStatement ps =conn.prepareStatement("select max(id) from StudentForm");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			pk = rs.getInt(1);
		}
	return pk+1;
	
	}
	
	public void add(StudentFormBean bean) throws Exception{
		
		int pk = nextPk();
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("insert into StudentForm values(?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, pk);
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getCourseName());
		ps.setString(7, bean.getEnrollment());
		ps.setDate(8, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(9, bean.getAddress());
		ps.setString(10, bean.getSemester());
		
		
		int i = ps.executeUpdate();
		
		System.out.println("Data Inserted =" + i);
	}
	
	
	public void update(StudentFormBean bean ) throws Exception{
		
       int pk = nextPk();
		
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("update StudentForm set First_Name=?,Last_Name=?,LoginId=?,Password=?,Course_Name=?,Enrollment=?,Dob=?,");
		
		
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getCourseName());
		ps.setString(6, bean.getEnrollment());
		ps.setDate(7,new java.sql.Date(bean.getDob().getTime()));
		ps.setString(8, bean.getAddress());
		ps.setString(9, bean.getSemester());
		ps.setInt(10, bean.getId());
		
		int i = ps.executeUpdate();
		
		System.out.println("Data Updated =" + i);
}
	public void delete(int id) throws Exception{
		
	Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("delete from StudentForm where id = ?");
		
		
		ps.setInt(1, id);
		
		int i =ps.executeUpdate();
		
		System.out.println("delete data" + i);
		
		
	}
	
	public StudentFormBean findByPk(StudentFormBean bean) throws Exception{
		
       Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("select * from StudentForm where id=? ,First_Name=?");
		
		ResultSet rs =ps.executeQuery();
		
		while (rs.next()) {
			
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setCourseName(rs.getString(6));
			bean.setEnrollment(rs.getString(7));
			bean.setDob(rs.getDate(8));
			bean.setAddress(rs.getString(9));
			bean.setSemester(rs.getString(10));
			
		}
	
		return bean;
	}
	
	
}