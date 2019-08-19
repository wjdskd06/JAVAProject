package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class History {

	IntegerProperty history;
	StringProperty start_Time;
	StringProperty end_Time;
	IntegerProperty user_Code;// need to -database search CONSTRAINT FK_user FOREIGN KEY(USER_CODE) REFERENCES
								// user1(USER_CODE)
	IntegerProperty location_Id;// need to -databased search CONSTRAINT FK_location FOREIGN KEY(LOCATION_ID)
								// REFERENCES location(LOCATION_ID )
	StringProperty sys_Use; // database in SYS_USE CHAR(1) NOT NULL
	StringProperty update_Date;// database in data type;

	public History() {
		this.history = new SimpleIntegerProperty();
		this.start_Time = new SimpleStringProperty();
		this.end_Time = new SimpleStringProperty();
		this.user_Code = new SimpleIntegerProperty();
		this.location_Id = new SimpleIntegerProperty();
		this.sys_Use = new SimpleStringProperty();
		this.update_Date = new SimpleStringProperty();

	}

	public History(IntegerProperty history, StringProperty start_Time, StringProperty end_Time,
			IntegerProperty user_Code, IntegerProperty location_Id, StringProperty sys_Use,
			StringProperty update_Date) {

		this.history = history;
		this.start_Time = start_Time;
		this.end_Time = end_Time;
		this.user_Code = user_Code;
		this.location_Id = location_Id;
		this.sys_Use = sys_Use;
		this.update_Date = update_Date;
	}

	public Integer getHistory() {
		return history.get();
	}

	public void setHistory(Integer history) {
		this.history.set(history);
	}

	public String getStart_Time() {
		return start_Time.get();
	}

	public void setStart_Time(String start_Time) {
		this.start_Time.set(start_Time);
	}

	public String getEnd_Time() {
		return end_Time.get();
	}

	public void setEnd_Time(String end_Time) {
		this.end_Time.set(end_Time);
	}

	public Integer getUser_Code() {
		return user_Code.get();
	}

	public void setUser_Code(Integer user_Code) {
		this.user_Code.set(user_Code);
		;
	}

	public Integer getLocation_Id() {
		return location_Id.get();
	}

	public void setLocation_Id(Integer location_Id) {
		this.location_Id.set(location_Id);
		;
	}

	public String getSys_Use() {
		return sys_Use.get();
	}

	public void setSys_Use(String sys_Use) {
		this.sys_Use.set(sys_Use);
	}

	public String getUpdate_Date() {
		return update_Date.get();
	}
	public void setUpdate_Date(String update_Date) {
		this.update_Date.set(update_Date);
	}

	@Override
	public String toString() {
		return "History [history=" + history + ", start_Time=" + start_Time + ", end_Time=" + end_Time + ", user_Code="
				+ user_Code + ", location_Id=" + location_Id + ", sys_Use=" + sys_Use + ", update_Date=" + update_Date
				+ "]";
	}

	public IntegerProperty getLocation_IdProperty() {
		return location_Id;
	}
	public StringProperty getStart_Time_Property() {
		return start_Time;
	}
	public StringProperty getEnd_Time_Property() {
		return end_Time;
	}


}
