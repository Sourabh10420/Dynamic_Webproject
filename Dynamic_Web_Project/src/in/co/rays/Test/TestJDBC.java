package in.co.rays.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.Model.*;
import in.co.rays.Bean.*;
import in.co.rays.util.JDBCDataSource;

	public class TestJDBC {

			public static void main(String[] args) throws Exception {

				for (int i = 1; i <= 50; i++) {

					System.out.println("Connection = " + i);

					//testGet();
					testSearch();
				}

			}

//			private static void testGet() throws Exception {
//
//				Connection conn = JDBCDataSource.getConnection();
//
//				PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = 1");
//
//				ResultSet rs = pstmt.executeQuery();
//
//				while (rs.next()) {
//					System.out.print(rs.getInt(1));
//					System.out.print("\t" + rs.getInt(2));
//					System.out.print("\t" + rs.getString(3));
//					System.out.print("\t" + rs.getInt(4));
//					System.out.print("\t" + rs.getInt(5));
//					System.out.println("\t" + rs.getInt(6));
//				}
//
//				// conn.close();
//
//			}
//
//		public void searchBySimple(MarksheetBean bean) throws Exception {
			private static void testSearch() throws Exception{
				
				Connection conn = JDBCDataSource.getConnection();

			String sql = "select * from Marksheet";

			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getInt(2));
				System.out.print("\t" + rs.getString(3));
				System.out.print("\t" + rs.getInt(4));
				System.out.print("\t" + rs.getInt(5));
				System.out.println("\t" + rs.getInt(6));

			}
		}

}



