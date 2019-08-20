package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.History;
import model.User;

public class HistoryDAO {
	private static HistoryDAO instance = new HistoryDAO();

	public static HistoryDAO getInstance() {
		return instance;
	}

	public void insert(Connection conn, History history) throws SQLException {
		// 1 connect,2 query,3 parametersetting, 4 execute, 5 disconnect

//			HISTORY	NUMBER
//			START_TIME	VARCHAR2(20 BYTE)
//			END_TIME	VARCHAR2(20 BYTE)
//			USER_CODE	NUMBER(38,0)
//			LOCATION_ID	NUMBER(38,0)
//			SYS_USE	CHAR(1 BYTE)
//			UPDATE_DATE	DATE

		String sql = "insert into HISTORY(HISTORY,START_TIME,END_TIME," + "USER_CODE,LOCATION_ID,SYS_USE,"
				+ "UPDATE_DATE) " + "values(?,?,?,?,?,?,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, returnMaxHistory(conn) + 1);
		pstmt.setString(2, history.getStart_Time());
		pstmt.setString(3, history.getEnd_Time());
		pstmt.setInt(4, history.getUser_Code());
		pstmt.setInt(5, history.getLocation_Id());
		pstmt.setString(6, history.getSys_Use());
		System.out.println(history.getLocation_Id());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건  삽입 완료");

	}

	public int returnMaxHistory(Connection conn) {
		String sql = "select max(HISTORY) from HISTORY";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("max(HISTORY)");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 99999; // error
	}

	public void update(Connection conn, History history) throws SQLException {

		String sql = "update HISTORY" + "set START_TIME = ? ," + "END_TIME = ? ," + "USER_CODE = ? ,"
				+ "LOCATION_ID = ? ," + "SYS_USE = ? ," + "UPDATE_DATE = sysdate) " + "where history = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, history.getStart_Time());
		pstmt.setString(2, history.getEnd_Time());
		pstmt.setInt(3, history.getUser_Code());
		pstmt.setInt(4, history.getLocation_Id());
		pstmt.setString(5, history.getSys_Use());
		pstmt.setInt(6, history.getHistory());

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 업데이트 완료");
		// 안쓸예정

	}

	public void delete(Connection conn, int histotry) throws SQLException {
		String sql = "delete from HISTORY " //
				+ "where HISTORY = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, histotry);

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 삭제 완료");

	}

	public List<History> selectDateAll(Connection conn, String date) {
		List<History> historys = new ArrayList<History>();
		String sql = "select * from HISTORY " + "where start_time like ? " + "and end_time like ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setString(2, date);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				History history = new History();
				history.setHistory(rs.getInt("HISTORY"));
				history.setStart_Time(rs.getString("START_TIME"));
				history.setEnd_Time(rs.getString("END_TIME"));
				history.setUser_Code(rs.getInt("USER_CODE"));
				history.setLocation_Id(rs.getInt("LOCATION_ID"));
				history.setSys_Use(rs.getString("SYS_USE"));
				history.setUpdate_Date(rs.getString("UPDATE_DATE"));

				historys.add(history);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return historys;
	}

	public List<History> selectCancelAbleDateUser(Connection conn, String date, User user) {
		List<History> historys = new ArrayList<History>();
		String subStr = date.substring(0, 8);
		String sql = "select * from history where start_Time > ? and user_code = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subStr);
			pstmt.setInt(2, user.getUser_Code());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				History history = new History();
				history.setHistory(rs.getInt("HISTORY"));
				history.setStart_Time(rs.getString("START_TIME"));
				history.setEnd_Time(rs.getString("END_TIME"));
				history.setUser_Code(rs.getInt("USER_CODE"));
				history.setLocation_Id(rs.getInt("LOCATION_ID"));
				history.setSys_Use(rs.getString("SYS_USE"));
				history.setUpdate_Date(rs.getString("UPDATE_DATE"));

//						new History(new SimpleIntegerProperty(rs.getInt("HISTORY")),
//						new SimpleStringProperty(rs.getString("START_TIME")),
//						new SimpleStringProperty(rs.getString("END_TIME")),
//						new SimpleIntegerProperty(rs.getInt("USER_CODE")),
//						new SimpleIntegerProperty(rs.getInt("LOCATION_ID")),
//						new SimpleStringProperty(rs.getString("SYS_USE")),
//						new SimpleStringProperty(rs.getString("UPDATE_DATE"))

				historys.add(history);
			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return historys;
	}
	
	public boolean selectInsertAbleDateUser(Connection conn, String start_Time,String end_Time, User user) {
		
		try {

			String sql = "select * from history where start_Time >= ? and end_Time <= ? and user_code = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start_Time);
			pstmt.setString(2, end_Time);
			pstmt.setInt(3, user.getUser_Code());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
