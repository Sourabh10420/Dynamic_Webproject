package in.co.rays.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.Bean.FoodOrderBean;
import in.co.rays.util.JDBCDataSource;

public class FoodOrderModel {
	
	
	public Integer nextPk() throws Exception{
		
		int pk = 0;
		
		Connection conn = JDBCDataSource.getConnection();
		
		String sql = "select max(SN) from FoodOrder";
		
		PreparedStatement ps =conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			FoodOrderBean bean = new FoodOrderBean();
			
			bean.setSn(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setFoodName(rs.getString(3));
			bean.setFoodPrice(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setOrderMod(rs.getString(6));
			bean.setOrderDate(rs.getDate(7));
			bean.setEmailId(rs.getString(8));
			
			
		}
		return pk+1;
		
	}
	
	public void add() throws Exception{
		
		int pk = nextPk();
		
		Connection conn = JDBCDataSource.getConnection();
			
			String sql = "insert into FoodOrder values(?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement ps =conn.prepareStatement(sql);
		
			FoodOrderBean bean = new FoodOrderBean();
			
			ps.setInt(1, pk);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getFoodName());
			ps.setString(4, bean.getFoodPrice());
			ps.setString(5, bean.getAddress());
			ps.setString(6, bean.getOrderMod());
			ps.setDate(7, new java.sql.Date(bean.getOrderDate().getTime()));
			ps.setString(8, bean.getEmailId());
			ps.setString(9, bean.getPassword());
			
			int i =ps.executeUpdate();
			
			System.out.println("Data Inserted =" + 1);
			
	}
	
	public void update() throws Exception{
		
		
		int pk = nextPk();
		
		Connection conn = JDBCDataSource.getConnection();
			
			String sql = "update FoodOrder set name=?,Food_Name=?,Food_Price=?,Address=?,Order_Mod=?,Order_Date=?,Email_Id=?,Password=? where SN=?  ";
		
			PreparedStatement ps =conn.prepareStatement(sql);
		
			FoodOrderBean bean = new FoodOrderBean();
			
			
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getFoodName());
			ps.setString(3, bean.getFoodPrice());
			ps.setString(4, bean.getAddress());
			ps.setString(5, bean.getOrderMod());
			ps.setDate(6, new java.sql.Date(bean.getOrderDate().getTime()));
			ps.setString(7, bean.getEmailId());
			ps.setString(8, bean.getPassword());
			ps.setInt(9, bean.getSn());
			
			
			int i =ps.executeUpdate();
			
			System.out.println("Data updated =" + 1);
			
	}
	public void delete(int sn) throws Exception{
		
       int pk = nextPk();
		
		Connection conn = JDBCDataSource.getConnection();
			
			String sql = "delete from FoodOrder where sn=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setInt(1, sn);
			
			int i =ps.executeUpdate();
			
			System.out.println("delete succsessfully =" + i);
		
		
		
	}
}
