package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.UserRootController;
import common.DAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.Suggestions;

public class SuggestionDAO {

	public Connection conn;

	private static SuggestionDAO instance = new SuggestionDAO();

	public static SuggestionDAO getInstance() {
		return instance;
	}

	public void insertSug(Suggestions sug) {
		Connection conn = null;
		try {
			conn = DAO.getConnect();
			String sql = "insert into SUGGESTIONS(SUGGESTIONS_ID, USER_ID, SUGGESTION_DATE,SUGGESTION_VALUE,SUCCESS)"
					+ "values(?,?,sysdate,?,'Un')";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, returnMaxSuggestion(conn) + 1);// SEQ
			pstmt.setInt(2, sug.getUser_Id());// ??
			pstmt.setString(3, sug.getCONTENT());
			//pstmt.setString(4, sug.getSuccess());
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public int returnMaxSuggestion(Connection conn) {
		String sql = "select max(SUGGESTIONS_ID) from SUGGESTIONS";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("max(SUGGESTIONS_ID)");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 99999; // error
	}

	public ObservableList<Suggestions> selectAll(Connection conn) throws SQLException {
		ObservableList<Suggestions> suggestions = FXCollections.observableArrayList();
		String sql = "select * " + "from Suggestions";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Suggestions a = new Suggestions(new SimpleIntegerProperty(rs.getInt("SUGGESTIONS_ID")),
					new SimpleIntegerProperty(rs.getInt("USER_ID")),
					new SimpleStringProperty(rs.getString("SUGGESTION_DATE")),
					new SimpleStringProperty(rs.getString("SUGGESTION_VALUE")),
					new SimpleStringProperty(rs.getString("SUCCESS")));
			suggestions.add(a);
//			suggestions.add(a);
//			//Suggestions sug = new Suggestions();
//			suggestions = FXCollections.observableArrayList(
//					new Suggestions(new SimpleIntegerProperty(rs.getInt("SUGGESTIONS_ID")),
//							new SimpleIntegerProperty(rs.getInt("USER_ID")),
//							new SimpleStringProperty(rs.getString("SUGGESTION_DATE")),
//							new SimpleStringProperty(rs.getString("SUGGESTION_VALUE")),
//							new SimpleStringProperty(rs.getString("SUCCESS"))));

			// sug.setCONTENT(rs.getString("SUGGESTION_CONTENT"));
			// sug.setSuggestions_Id(rs.getInt("USER_ID"));

			// suggestions.add(sug);

		}
		return suggestions;
	}

	public ObservableList<Suggestions> select(Connection conn) throws SQLException {
		ObservableList<Suggestions> suggestions = FXCollections.observableArrayList();
		String sql =  "select * " + "from Suggestions where user_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserRootController.user.getUser_Code());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Suggestions a = new Suggestions(new SimpleIntegerProperty(rs.getInt("SUGGESTIONS_ID")),
					new SimpleIntegerProperty(rs.getInt("USER_ID")),
					new SimpleStringProperty(rs.getString("SUGGESTION_DATE")),
					new SimpleStringProperty(rs.getString("SUGGESTION_VALUE")),
					new SimpleStringProperty(rs.getString("SUCCESS")));
			suggestions.add(a);
//			suggestions.add(a);
//			//Suggestions sug = new Suggestions();
//			suggestions = FXCollections.observableArrayList(
//					new Suggestions(new SimpleIntegerProperty(rs.getInt("SUGGESTIONS_ID")),
//							new SimpleIntegerProperty(rs.getInt("USER_ID")),
//							new SimpleStringProperty(rs.getString("SUGGESTION_DATE")),
//							new SimpleStringProperty(rs.getString("SUGGESTION_VALUE")),
//							new SimpleStringProperty(rs.getString("SUCCESS"))));

			// sug.setCONTENT(rs.getString("SUGGESTION_CONTENT"));
			// sug.setSuggestions_Id(rs.getInt("USER_ID"));

			// suggestions.add(sug);

		}
		return suggestions;
	}
	public void Update(Suggestions sug) {
		Connection conn = null;
		try {
			conn = DAO.getConnect();
			String sql = "update suggestions set Success = ? where suggestions_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sug.getSuccess());
			pstmt.setInt(2, sug.getSuggestions_Id());
			pstmt.executeUpdate();
			System.out.println("확인 되었습니다."+ sug);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
	

}
