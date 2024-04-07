package in.co.rays.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.Bean.CompanyBean;
import in.co.rays.util.JDBCDataSource;

public class CompanyModel {
	
	
	public Integer nextPk() throws Exception{
		
		int pk = 0;
		
		Connection conn = JDBCDataSource.getConnection();
		
		String sql = "select max(id) from companydata";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			CompanyBean bean = new CompanyBean();
			
			pk =rs.getInt(1);
		}
		return pk+1;
		
	}
	
	public void add(CompanyBean bean)throws Exception{
		
		int pk =nextPk();
		
		Connection conn = JDBCDataSource.getConnection();
		
		String sql = "insert into companydata values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps =conn.prepareStatement(sql);
		
		
		ps.setInt(1, pk);
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		
		int i= ps.executeUpdate();
		
		System.out.println("data inserted =" +i);
		
		
	}

}
