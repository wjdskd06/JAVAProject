package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.History;

public class HistoryDAO {
		private static HistoryDAO instance = new HistoryDAO();

		public static HistoryDAO getInstance() {
			return instance;
		}

		public void insert(Connection conn, History dept) throws SQLException {
			// 1 connect,2 query,3 parametersetting, 4 execute, 5 disconnect
			
//			int history;  
//			String start_Time; 
//			String end_Time; 
//			int user_code; // need to -database search CONSTRAINT FK_user FOREIGN KEY(USER_CODE) REFERENCES user1(USER_CODE) 
//			int location_Id; // need to -databased search CONSTRAINT FK_location FOREIGN KEY(LOCATION_ID)	REFERENCES location(LOCATION_ID )
//			boolean sys_Use; // database in  SYS_USE CHAR(1) NOT NULL
//			String update_Date; // database in data type;
			
			
			String sql = "insert into HISTORY(history,) "
					+ "values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, dept.getDepartmentId());
//			pstmt.setString(2, dept.getDepartmentName());
//			pstmt.setInt(3, dept.getManagerId());
//			pstmt.setInt(4, dept.getLocationId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 완료");

		}

		public void update(Connection conn, History dept) throws SQLException {
			String sql = "update departments" + " set department_name = ? ," + "manager_id = ? ," + "location_id = ?"
					+ " where department_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dept.getDepartmentName());
//			pstmt.setInt(2, dept.getManagerId());
//			pstmt.setInt(3, dept.getLocationId());
//			pstmt.setInt(4, dept.getDepartmentId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트 완료");

		}

		public void delete(Connection conn, int hisotry) throws SQLException {
			String sql = "delete from departments " //
					+ "where department_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hisotry);

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트 완료");

		}

//		public Departments selectOne(Connection conn, int dept_id) throws SQLException {
//			Departments dept = null;
//			String sql = "select * from departments where department_id = ?";
//			PreparedStatement pstmt  = conn.prepareStatement(sql);
//				
//				pstmt.setInt(1, dept_id);
//				ResultSet rs = pstmt.executeQuery();
//				if (rs.next()) {
//					dept = new Departments();
//					dept.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
//					dept.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
//					dept.setManagerId(rs.getInt("MANAGER_ID"));
//					dept.setLocationId(rs.getInt("LOCATION_ID"));
//			
//				}
//			return dept;
//		}
//
//		public List<Departments> selectAll(Connection conn) throws SQLException {
//			List<Departments> depts = new ArrayList<Departments>();
//			String sql = "select department_id,department_name,manager_id,location_id " + "from departments";
//						PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				while (rs.next()) {
//					Departments dept = new Departments();
//					dept.setDepartmentId(rs.getInt("department_id"));
//					dept.setDepartmentName(rs.getString("department_name"));
//					dept.setManagerId(rs.getInt("manager_id"));
//					dept.setLocationId(rs.getInt("location_id"));
//					depts.add(dept);
//					System.out.println(dept);
//			
//				}
//			return depts;
//		}
//		
//		public List<DepartmentsTable> selectAllTable(Connection conn) throws SQLException {
//			List<DepartmentsTable> depts = new ArrayList<DepartmentsTable>();
//			String sql = "select department_id,department_name,manager_id,location_id " + "from departments";
//						PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				while (rs.next()) {
//					DepartmentsTable dept = new DepartmentsTable();
//					dept.setDepartmentId(rs.getInt("department_id"));
//					dept.setDepartmentName(rs.getString("department_name"));
//					dept.setManagerId(rs.getInt("manager_id"));
//					dept.setLocationId(rs.getInt("location_id"));
//					depts.add(dept);
//					System.out.println(dept);
//			
//				}
//			return depts;
//		}
//
//		public List<DepartmentsTable> selectPage(Connection conn, int startdeptid, int enddepartmentid) throws SQLException {
//
//			List<DepartmentsTable> depts = new ArrayList<DepartmentsTable>();
//			String sql = "select department_id,department_name,manager_id,location_id " + "from departments"
//					+ "where department_id > ?" + "and department_id <?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, startdeptid);
//				pstmt.setInt(2, enddepartmentid);
//				ResultSet rs = pstmt.executeQuery();
//				if (rs.next()) {
//					DepartmentsTable dept = new DepartmentsTable();
//					dept.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
//					dept.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
//					dept.setManagerId(rs.getInt("MANAGER_ID"));
//					dept.setLocationId(rs.getInt("LOCATION_ID"));
//					depts.add(dept);
//				}
//
//				for (DepartmentsTable d : depts) {
//					System.out.println(d);
//				}
//
//			
//
//			return depts;
//
//		}

}
