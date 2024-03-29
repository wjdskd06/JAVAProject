package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Suggestions {
	IntegerProperty suggestions_IdProperty;
	IntegerProperty user_IdProperty;
	StringProperty suggestion_DateProperty;
	StringProperty successProperty;
	StringProperty CONTENTProperty;
	
	public Suggestions() {
		successProperty = new SimpleStringProperty();
		CONTENTProperty = new SimpleStringProperty();
	}
	
	public Suggestions(int suggestions_Id, int user_Id, String suggestion_Date, String cONTENT, String success) {
		super();
		this.suggestions_Id = suggestions_Id;
		this.user_Id = user_Id;
		this.suggestion_Date = suggestion_Date;
		this.CONTENT = cONTENT;
		this.success = success;
	}

	public Suggestions(IntegerProperty suggestions_IdProperty,IntegerProperty user_IdProperty,StringProperty suggestion_DateProperty,StringProperty CONTENTProperty,StringProperty successProperty) {
		this.suggestions_IdProperty = suggestions_IdProperty;
		this.user_IdProperty = user_IdProperty;
		this.suggestion_DateProperty = suggestion_DateProperty;
		this.successProperty = successProperty;
		this.CONTENTProperty = CONTENTProperty;
	}
	

	public IntegerProperty getSuggestions_IdProperty() {
		return suggestions_IdProperty;
	}
	public void setSuggestions_IdProperty(IntegerProperty suggestions_IdProperty) {
		this.suggestions_IdProperty = suggestions_IdProperty;
	}
	public IntegerProperty getUser_IdProperty() {
		return user_IdProperty;
	}
	public void setUser_IdProperty(IntegerProperty user_IdProperty) {
		this.user_IdProperty = user_IdProperty;
	}
	public StringProperty getSuggestion_DateProperty() {
		return suggestion_DateProperty;
	}
	public void setSuggestion_DateProperty(StringProperty suggestion_DateProperty) {
		this.suggestion_DateProperty = suggestion_DateProperty;
	}
	public StringProperty getSuccessProperty() {
		return successProperty;
	}
	public void setSuccessProperty(StringProperty successProperty) {
		this.successProperty = successProperty;
	}
	public StringProperty getCONTENTProperty() {
		return CONTENTProperty;
	}
	public void setCONTENTProperty(StringProperty cONTENTProperty) {
		this.CONTENTProperty = cONTENTProperty;
	}
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
		this.successProperty.set(success);
		this.success = success;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		this.CONTENT = cONTENT;
		this.CONTENTProperty.set(cONTENT);
	}

	@Override
	public String toString() {
		return "Suggestions [suggestions_Id=" + suggestions_Id + ", user_Id=" + user_Id + ", suggestion_Date="
				+ suggestion_Date + ", success=" + success + ", CONTENT=" + CONTENT + "]";
	}


}
