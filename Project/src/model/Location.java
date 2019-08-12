package model;

public class Location {
	int location_Id; 
	boolean user_Able; //database char(1) type  
	String location_name; 
	int access_Count; // room access count;
	public int getLocation_Id() {
		return location_Id;
	}
	public void setLocation_Id(int location_Id) {
		this.location_Id = location_Id;
	}
	public boolean isUser_Able() {
		return user_Able;
	}
	public void setUser_Able(boolean user_Able) {
		this.user_Able = user_Able;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public int getAccess_Count() {
		return access_Count;
	}
	public void setAccess_Count(int access_Count) {
		this.access_Count = access_Count;
	}
	
	
}
