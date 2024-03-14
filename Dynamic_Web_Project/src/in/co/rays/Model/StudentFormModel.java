package in.co.rays.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
