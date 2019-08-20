package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.DAO;
import model.User;

public class UserDAO {
	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public void insert(Connection conn, User user) throws SQLException {
		// 1 connect,2 query,3 parametersetting, 4 execute, 5 disconnect
//		USER_CODE	NUMBER
//		USER_ID	VARCHAR2(20 BYTE)
//		USER_PW	VARCHAR2(20 BYTE)
//		GRADE_POINT	NUMBER
//		SALE_POINT	NUMBER
//		USER_TYPE	VARCHAR2(20 BYTE)
//		HIRE_DATE	DATE

		String sql = "insert into user1(USER_CODE, USER_ID,USER_PW,GRADE_POINT,SALE_POINT,USER_TYPE,HIRE_DATE) "
				+ "values(?,?,?,?,?,?,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, returnMaxUserCode(conn) + 1);
		pstmt.setString(2, user.getUser_Id());
		pstmt.setString(3, user.getUser_Pw());
		pstmt.setInt(4, 0);
		pstmt.setInt(5, 0);
		pstmt.setString(6, user.getUser_Type());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 추가 완료");
		

	}

	public int returnMaxUserCode(Connection conn) {
		String sql = "select max(user_code) from user1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt("max(user_code)");	
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 1; // error
	}

	public void update(Connection conn, User user) throws SQLException {
		String sql = "update user1 set user_id = ?,	user_pw = ?, grade_point =?, sale_point =?,	user_type =?"
				+ "where user_code = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUser_Id());
		pstmt.setString(2, user.getUser_Pw());
		pstmt.setInt(3, user.getGrade_Point());
		pstmt.setInt(4, user.getSale_Point());
		pstmt.setString(5, user.getUser_Type());
		pstmt.setInt(6, user.getUser_Code());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 업데이트 완료");

	}

	public void delete(Connection conn, int user_code) throws SQLException {
		String sql = "delete from user1 " //
				+ "where user_code = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user_code);

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 삭제 완료");

	}

	public User selectOne(Connection conn, String user_id) throws SQLException {// user id != user code but please
																				// primary key
		User user = null;
		String sql = "select * from user1 where user_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setUser_Code(rs.getInt("USER_CODE"));
			user.setUser_Id(rs.getString("USER_ID"));
			user.setUser_Pw(rs.getString("USER_PW"));
			user.setGrade_Point(rs.getInt("GRADE_POINT"));
			user.setSale_Point(rs.getInt("SALE_POINT"));
			user.setUser_Type(rs.getString("USER_TYPE"));
			user.setHire_Date(rs.getString("HIRE_DATE"));
			
		}
		return user;
	}

	public List<User> selectAll(Connection conn) throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "select department_id,department_name,manager_id,location_id " + "from departments";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();

//			USER_CODE	NUMBER
//			USER_ID	VARCHAR2(20 BYTE)
//			USER_PW	VARCHAR2(20 BYTE)
//			GRADE_POINT	NUMBER
//			SALE_POINT	NUMBER
//			USER_TYPE	VARCHAR2(20 BYTE)
//			HIRE_DATE	DATE
			user.setUser_Code(rs.getInt("USER_CODE"));
			user.setUser_Id(rs.getString("USER_ID"));
			user.setUser_Pw(rs.getString("USER_PW"));
			user.setGrade_Point(rs.getInt("GRADE_POINT"));
			user.setSale_Point(rs.getInt("SALE_POINT"));
			user.setUser_Type(rs.getString("USER_TYPE"));
			user.setHire_Date(rs.getString("HIRE_DATE"));
			users.add(user);
			System.out.println(user);

		}
		return users;
	}

	public List<User> selectAllTable(Connection conn) throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "select department_id,department_name,manager_id,location_id " + "from departments";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setUser_Code(rs.getInt("USER_CODE"));
			user.setUser_Id(rs.getString("USER_ID"));
			user.setUser_Pw(rs.getString("USER_PW"));
			user.setGrade_Point(rs.getInt("GRADE_POINT"));
			user.setSale_Point(rs.getInt("SALE_POINT"));
			user.setUser_Type(rs.getString("USER_TYPE"));
			user.setHire_Date(rs.getString("HIRE_DATE"));
			users.add(user);

		}
		return users;
	} // need Test.

	public boolean Login(String UserId, String UserPw) {
		Connection conn = DAO.getConnect();
		String sql = "select USER_ID, USER_PW from user1 " + "where user_id = ? " + "and user_pw = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserId);
			pstmt.setString(2, UserPw);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
		
	}

//	public List<DepartmentsTable> selectPage(Connection conn, int startuserid, int enddepartmentid)
//			throws SQLException {
//
//		List<DepartmentsTable> users = new ArrayList<DepartmentsTable>();
//		String sql = "select department_id,department_name,manager_id,location_id " + "from departments"
//				+ "where department_id > ?" + "and department_id <?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, startuserid);
//		pstmt.setInt(2, enddepartmentid);
//		ResultSet rs = pstmt.executeQuery();
//		if (rs.next()) {
//			DepartmentsTable user = new DepartmentsTable();
//			user.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
//			user.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
//			user.setManagerId(rs.getInt("MANAGER_ID"));
//			user.setLocationId(rs.getInt("LOCATION_ID"));
//			users.add(user);
//		}
//
//		for (DepartmentsTable d : users) {
//			System.out.println(d);
//		}
//
//		return users;
//
//	}

}
