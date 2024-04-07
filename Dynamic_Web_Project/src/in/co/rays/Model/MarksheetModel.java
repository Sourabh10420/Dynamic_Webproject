package in.co.rays.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.Bean.MarksheetBean;
import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws Exception {

		int pk = nextPk();

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement st = conn.prepareStatement("insert into Marksheet values(?,?,?,?,?,?,?,?,?) ");

		st.setInt(1, pk);

		st.setInt(2, bean.getRollNo());

		st.setString(3, bean.getName());

		st.setInt(4, bean.getPhysics());

		st.setInt(5, bean.getChemistry());

		st.setInt(6, bean.getMaths());
		
		st.setString(7, bean.getEmailId());

		st.setString(8, bean.getPassword());
		
		st.setDate(9, new java.sql.Date(bean.getDob().getTime()));

		int i = st.executeUpdate();

		System.out.println("Insert values Successfully" + "=" + i);

	}

	public void update(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		String sql = "update Marksheet set Roll_No=?,Name=?,physics=?,chemistry=?,maths=?,EmailId=?,Password=?,Dob=? where id=?";

		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, bean.getRollNo());

		st.setString(2, bean.getName());

		st.setInt(3, bean.getPhysics());

		st.setInt(4, bean.getChemistry());

		st.setInt(5, bean.getMaths());

		st.setString(6, bean.getEmailId());

		st.setString(7, bean.getPassword());
		
		st.setDate(8, new java.sql.Date(bean.getDob().getTime()));

		st.setInt(9, bean.getId());

		int j = st.executeUpdate();

		System.out.println("Update Successfully" + "=" + j);

	}

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		String sql = "delete  from Marksheet where id=?";

		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, id);

		int i = st.executeUpdate();

		System.out.println("Delete Data Successfully" + "=" + i);
	}

	public void searchBySimple(MarksheetBean bean) throws Exception {

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
			System.out.println("\t" + rs.getString(7));
			System.out.println("\t" + rs.getString(8));

		}
	}

	public List searchByOneByOne() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		String sql = "select * from Marksheet ";

		PreparedStatement st = conn.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			MarksheetBean bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			bean.setEmailId(rs.getString(7));
			bean.setPassword(rs.getString(8));

			list.add(bean);
		}

		return list;
	}

	public MarksheetBean findByPK(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		String sql = "select * from Marksheet where id = ?";

		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		MarksheetBean bean = new MarksheetBean();

		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			bean.setEmailId(rs.getString(7));
			bean.setPassword(rs.getString(8));

		}

		return bean;
	}

	public List searchByDynamic(MarksheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuilder sb = new StringBuilder("select * from marksheet where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sb.append(" and id = " + bean.getId());
			}

			if (bean.getRollNo() > 0) {
				sb.append(" and Roll_No = " + bean.getRollNo());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sb.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getPhysics() > 0) {
				sb.append(" and physics = " + bean.getPhysics());
			}

			if (bean.getChemistry() > 0) {
				sb.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sb.append(" and maths = " + bean.getMaths());
			}

		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sb.append(" limit " + pageNo + ", " + pageSize);

		}

		System.out.println("Sql -> " + sb);

		PreparedStatement st = conn.prepareStatement(sb.toString());

		ResultSet rs = st.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}
		return list;

	}

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		String sb = "select max(id) from Marksheet";

		PreparedStatement st = conn.prepareStatement(sb);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
		}

		return pk + 1;

	}
}
