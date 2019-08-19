package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Suggestions;


public class SuggestionDAO  {
	private static SuggestionDAO instance = new SuggestionDAO();
	public Connection conn;
	public static SuggestionDAO getInstance()
	{
		return instance;
	}
	
	public void insertSug(Suggestions sug) {
		Connection conn = null;
		try {
		 conn = DAO.getConnect();
		String sql = "insert into SUGGESTIONS(SUGGESTIONS_ID, USER_ID, SUGGESTION_DATE,SUGGESTION_CONTENT,SUCCESS)"
						+"values(?,?,sysdate,?,'check')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, returnMaxSuggestion(conn)+1);//SEQ
		pstmt.setInt(2, sug.getUser_Id());//??
		pstmt.setString(3, sug.getCONTENT());
		pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
			if(rs.next()) {
				return rs.getInt("max(SUGGESTIONS_ID)");	
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 99999; // error
	}
	
	
	public ObservableList<Suggestions> selectAll(Connection conn) throws SQLException {
		ObservableList<Suggestions> suggestions = null;
		String sql = "select * " + "from Suggestions";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			//Suggestions sug = new Suggestions();
			suggestions = FXCollections.observableArrayList(
					new Suggestions(new SimpleIntegerProperty(rs.getInt("SUSSESTIONS_ID")),new SimpleIntegerProperty(rs.getInt("USER_ID")),
							new SimpleStringProperty(rs.getString("SUGGESTION_DATE")),new SimpleStringProperty(rs.getString("SUGGESTION_CONTENT")),
							new SimpleStringProperty(rs.getString("SUCCESS"))));

			//sug.setCONTENT(rs.getString("SUGGESTION_CONTENT"));
			//sug.setSuggestions_Id(rs.getInt("USER_ID"));
			
			//suggestions.add(sug);

		}
		return suggestions;
	}
	
	
	
}
