package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class History {
	
	int history;  
	String start_Time; 
	String end_Time; 
	int user_code; // need to -database search CONSTRAINT FK_user FOREIGN KEY(USER_CODE) REFERENCES user1(USER_CODE) 
	int location_Id; // need to -databased search CONSTRAINT FK_location FOREIGN KEY(LOCATION_ID)	REFERENCES location(LOCATION_ID )
	boolean sys_Use; // database in  SYS_USE CHAR(1) NOT NULL
	String update_Date; // database in data type;
	
	IntegerProperty history_Property;
	StringProperty start_Time_Property;
	StringProperty end_Time_Property;
	IntegerProperty user_Code_Property;
	IntegerProperty location_Id_Property;
	StringProperty sys_Use_Property;
	StringProperty update_Date_Property;
	
	
	public History() {
		super();
	}


	public History(IntegerProperty history_Property, StringProperty start_Time_Property,
			StringProperty end_Time_Property, IntegerProperty user_Code_Property, IntegerProperty location_Id_Property,
			StringProperty sys_Use_Property, StringProperty update_Date_Property) {

		this.history_Property = history_Property;
		this.start_Time_Property = start_Time_Property;
		this.end_Time_Property = end_Time_Property;
		this.user_Code_Property = user_Code_Property;
		this.location_Id_Property = location_Id_Property;
		this.sys_Use_Property = sys_Use_Property;
		this.update_Date_Property = update_Date_Property;
	}
	
	
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public String getStart_Time() {
		return start_Time;
	}
	public void setStart_Time(String start_Time) {
		this.start_Time = start_Time;
	}
	public String getEnd_Time() {
		return end_Time;
	}
	public void setEnd_Time(String end_Time) {
		this.end_Time = end_Time;
	}
	public int getUser_code() {
		return user_code;
	}
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	public int getLocation_Id() {
		return location_Id;
	}
	public void setLocation_Id(int location_Id) {
		this.location_Id = location_Id;
	}
	public boolean isSys_Use() {
		return sys_Use;
	}
	public void setSys_Use(boolean sys_Use) {
		this.sys_Use = sys_Use;
	}
	public String getUpdate_Date() {
		return update_Date;
	}
	public void setUpdate_Date(String update_Date) {
		this.update_Date = update_Date;
	}
	@Override
	public String toString() {
		return "History [history=" + history + ", start_Time=" + start_Time + ", end_Time=" + end_Time + ", user_code="
				+ user_code + ", location_Id=" + location_Id + ", sys_Use=" + sys_Use + ", update_Date=" + update_Date
				+ "]";
	}
}
