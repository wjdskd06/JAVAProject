package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Grade;
import model.User;

public class GradeDAO {
	private static GradeDAO instance = new GradeDAO();

	public static GradeDAO getInstance() {
		return instance;
	}
	
	public void insert(Connection conn, Grade grade) throws SQLException {
//		GRADE	VARCHAR2(20 BYTE)
//		MIN_COUNT	NUMBER
		
		String sql = "insert into grade(GRADE,MIN_COUNT,MAX_COUNT) " + "values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, grade.getGrade());
		pstmt.setInt(2, grade.getMin_Count());
		pstmt.setInt(3, grade.getMax_Count());

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 추가 완료");

	}


	public void update(Connection conn, Grade grade) throws SQLException {
		String sql = "update grade " + "set MIN_COUNT = ?,	MAX_COUNT = ? "
				+ "where GRADE = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, grade.getMin_Count());
		pstmt.setInt(2, grade.getMax_Count());
		pstmt.setString(3, grade.getGrade());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 업데이트 완료");

	}

	public void delete(Connection conn, String grade) throws SQLException {
		String sql = "delete from grade " //
				+ "where GRADE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, grade);

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 삭제 완료");

	}
	
	public String outGrade(Connection conn, int grade_Point) {
		String sql = "select GRADE from grade "
				+"where ? between min_count and max_count";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grade_Point);
			ResultSet rs = pstmt.executeQuery();
			return rs.getString(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
}
