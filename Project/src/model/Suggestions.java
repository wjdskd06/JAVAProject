package model;

public class Suggestions {
	int suggestions_Id; 
	int user_Id; // database foreign key user1;
	String suggestion_Date; // data type date; 
	String success; //administrater clear,confirm, not confirm, clearing   
	String CONTENT;
	public int getSuggestions_Id() {
		return suggestions_Id;
	}
	public void setSuggestions_Id(int suggestions_Id) {
		this.suggestions_Id = suggestions_Id;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getSuggestion_Date() {
		return suggestion_Date;
	}
	public void setSuggestion_Date(String suggestion_Date) {
		this.suggestion_Date = suggestion_Date;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}


}
