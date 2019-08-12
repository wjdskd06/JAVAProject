package model;

public class User {
	int user_Code;
	String user_Id; 
	String user_Pw; 
	int grade_Point; 
	int sale_Point; 
	String user_Type; 
	String hire_Date; //database in data type
	
	public int getUser_Code() {
		return user_Code;
	}
	public void setUser_Code(int user_Code) {
		this.user_Code = user_Code;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Pw() {
		return user_Pw;
	}
	public void setUser_Pw(String user_Pw) {
		this.user_Pw = user_Pw;
	}
	public int getGrade_Point() {
		return grade_Point;
	}
	public void setGrade_Point(int grade_Point) {
		this.grade_Point = grade_Point;
	}
	public int getSale_Point() {
		return sale_Point;
	}
	public void setSale_Point(int sale_Point) {
		this.sale_Point = sale_Point;
	}
	public String getUser_Type() {
		return user_Type;
	}
	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
	}
	public String getHire_Date() {
		return hire_Date;
	}
	public void setHire_Date(String hire_Date) {
		this.hire_Date = hire_Date;
	}

}
