package model;

public class History {
	int history;  
	String start_Time; 
	String end_Time; 
	int user_code; // need to -database search CONSTRAINT FK_user FOREIGN KEY(USER_CODE) REFERENCES user1(USER_CODE) 
	int location_Id; // need to -databased search CONSTRAINT FK_location FOREIGN KEY(LOCATION_ID)	REFERENCES location(LOCATION_ID )
	boolean sys_Use; // database in  SYS_USE CHAR(1) NOT NULL
	String update_Date; // database in data type;
	
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
	
}
