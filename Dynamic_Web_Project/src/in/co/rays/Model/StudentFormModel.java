package in.co.rays.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import in.co.rays.Bean.StudentFormBean;
import in.co.rays.Bean.UserBean;
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
		
		PreparedStatement ps=conn.prepareStatement("update StudentForm set first_name=?, last_name=?, loginId=?, password=?, course_name=?, enrollment=?, dob=?, address=?, semester=? where id =?");
		
		
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
	
	public StudentFormBean findByPk(int id) throws Exception{
		
       Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("select * from StudentForm where id=?");
		
		ps.setInt(1, id);
		ResultSet rs =ps.executeQuery();
		
		StudentFormBean  bean = null;
		
		while (rs.next()) {
			
			bean = new StudentFormBean();
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
	
	public StudentFormBean findByLogin(String LoginId) throws Exception{
		
	       Connection conn=JDBCDataSource.getConnection();
			
			PreparedStatement ps=conn.prepareStatement("select * from StudentForm where LoginId = ?");
			
			ps.setString(1, LoginId);
			
			ResultSet rs =ps.executeQuery();
			
			StudentFormBean  bean = null;
			
			while (rs.next()) {
				
				bean = new StudentFormBean();
				
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
	
	public List search() throws Exception{
		
		  Connection conn=JDBCDataSource.getConnection();
			
			PreparedStatement ps=conn.prepareStatement("select * from StudentForm");
			
			ResultSet rs = ps.executeQuery();
		
			List list = new ArrayList();
			
			StudentFormBean bean = new StudentFormBean();
			
			
			while(rs.next()) {
				
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
				
				list.add(bean);
			
			}
		
		return list;
		
	}
	
	public List search(StudentFormBean bean, int pageNo, int pageSize) throws Exception{
		
		  Connection conn=JDBCDataSource.getConnection();
		  
		  StringBuffer bf = new StringBuffer("select * from studentform where 1=1");
		
		  if(bean != null) {
			  
			  if(bean.getId()>0) {
				  
				  bf.append(" and Id = " + bean.getId());
			  }
			  if(bean.getFirstName() != null && bean.getFirstName().length()> 0 ) {
				  
				  bf.append(" and First_Name like '" + bean.getFirstName() + "%'");
			  }
			  if(bean.getLastName() !=null && bean.getLastName().length()>0) {
				  
				  bf.append(" and Last_Name like '" + bean.getLastName() + "%'");
			  }
			  if(bean.getLoginId() != null && bean.getLoginId().length()>0) {
				  
				  bf.append(" and LoginId like '" + bean.getLoginId() + "%'");
			  }
			  if(bean.getPassword() != null && bean.getPassword().length()>0 ){
				  
				  bf.append(" and Password like '"  + bean.getPassword() + "%'");
			  }
			  if(bean.getCourseName() != null && bean.getCourseName().length()>0) {
				  
				  bf.append(" and Course_Name like '" + bean.getCourseName() +"%'" );
			  }
			  if(bean.getEnrollment() != null && bean.getEnrollment().length()>0) {
				  
				  bf.append(" and Enrollment '" + bean.getEnrollment() + "%'");
			  }
			  if(bean.getDob() != null && bean.getDob().getTime()>0) {
				  
				  bf.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime())+ "%'");
			  }
			  if(bean.getAddress() != null && bean.getAddress().length()>0) {
				  
				  bf.append(" and Address like '" + bean.getAddress() + "%'");
			  }
			  if(bean.getSemester() != null && bean.getSemester().length()>0) {
				  
				  bf.append(" and Semester like '" + bean.getSemester() + "%'");
			  }
		  }
		  
		  if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				bf.append(" limit " + pageNo + ", " + pageSize);
			}
		  
		  System.out.println("sql=>" + bf);
		   
		PreparedStatement ps =  conn.prepareStatement(bf.toString());
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while (rs.next()) {
			
			bean = new StudentFormBean();
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
			
			list.add(bean);
			
		}
		  
		return list;
			  
	  }
	public StudentFormBean authenticate(String LoginId, String Password) throws Exception {
		
		int pk = nextPk();
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from StudentForm where LoginId = ? and Password = ?");

		ps.setString(1, LoginId);
		ps.setString(2, Password);

		ResultSet rs = ps.executeQuery();
		
        StudentFormBean bean = null;

		while (rs.next()) {
			bean = new StudentFormBean();
			
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