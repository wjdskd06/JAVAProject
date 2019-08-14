package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DAO;
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
		String sql = "insert into SUGGESTIONS(SUGGESTIONS_ID, USER_ID, SUGGESTION_DATE,SUGGESTION_VALUE,SUCCESS)"
						+"values(?,'0',sysdate,?,'check')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sug.getSuggestions_Id());//SEQ
		//pstmt.setInt(2, sug.getUser_Id());//??
		pstmt.setString(2, sug.getCONTENT());
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
	
	
	
}
