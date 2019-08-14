package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.javafx.css.CssError.StringParsingError;

import model.Location;

public class LocationDAO {

	private static LocationDAO instance = new LocationDAO();

	public static LocationDAO getInstance() {
		return instance;
	}

	public void insert(Connection conn, Location location) throws SQLException {
//		LOCATION_ID	NUMBER(38,0)
//		USER_ABLE	CHAR(1 BYTE)
//		LOCATION_NAME	VARCHAR2(20 BYTE)
//		ACCESS_COUNT	NUMBER

		String sql = "insert into location(LOCATION_ID, USER_ABLE,LOCATION_NAME,ACCESS_COUNT) " + "values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, returnMaxLocation_ID(conn) + 1);
		pstmt.setString(2, String.valueOf(location.isUser_Able()));
		pstmt.setString(3, location.getLocation_name());
		pstmt.setInt(4, location.getAccess_Count());

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 추가 완료");

	}

	public int returnMaxLocation_ID(Connection conn) {
		String sql = "select max(location_code) from location";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt(0);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 99999; // error
	}

	public void update(Connection conn, Location location) throws SQLException {
		String sql = "update location " + "set USER_ABLE = ?,	LOCATION_NAME = ?, ACCESS_COUNT =? "
				+ "where LOCATION_ID = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(location.isUser_Able()));
		pstmt.setString(2, location.getLocation_name());
		pstmt.setInt(3, location.getAccess_Count());
		pstmt.setInt(4, location.getLocation_Id());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 업데이트 완료");

	}

	public void delete(Connection conn, int location_Id) throws SQLException {
		String sql = "delete from location " //
				+ "where LOCATION_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, location_Id);

		int r = pstmt.executeUpdate();
		System.out.println(r + "건 삭제 완료");

	}

	public Location selectOne(Connection conn, String location_Name) throws SQLException {// user id != user code but
																							// please
		// primary key
		Location location = new Location();
		String sql = "select * from location where location_Id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, location_Name);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			location.setLocation_Id(rs.getInt("LOCATION_ID"));
			location.setUser_Able(Boolean.parseBoolean(rs.getString("USER_ABLE")));
			location.setLocation_name(rs.getString("LOCATION_NAME"));
			location.setAccess_Count(rs.getInt("ACCESS_COUNT"));

		}
		return location;
	}

	public Location selectOne(Connection conn, int location_Id) throws SQLException {// user id != user code but please
		// primary key
		Location location = new Location();
		String sql = "select * from location where location_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, location_Id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			location.setLocation_Id(rs.getInt("LOCATION_ID"));
			location.setUser_Able(Boolean.parseBoolean(rs.getString("USER_ABLE")));
			location.setLocation_name(rs.getString("LOCATION_NAME"));
			location.setAccess_Count(rs.getInt("ACCESS_COUNT"));

		}
		return location;
	}

	public List<Location> selectAll(Connection conn) throws SQLException {
		List<Location> locations = new ArrayList<Location>();
		String sql = "select * " + "from locations";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Location location = new Location();
			location.setLocation_Id(rs.getInt("LOCATION_ID"));
			location.setUser_Able(Boolean.parseBoolean(rs.getString("USER_ABLE")));
			location.setLocation_name(rs.getString("LOCATION_NAME"));
			location.setAccess_Count(rs.getInt("ACCESS_COUNT"));
			locations.add(location);

		}
		return locations;
	}

}
