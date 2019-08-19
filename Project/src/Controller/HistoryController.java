package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.History;
import model.HistoryService;
import service.HistoryImpl;

public class HistoryController implements Initializable {
	@FXML
	GridPane gridPane;
	String yyddmm;
	String selectDate;
	String location_Id;
	String start_Time;
	String end_Time;
	Label[][] labelArray;

	@FXML
	DatePicker dp;
	List<History> historys;
	HistoryService impl;

	@FXML
	public void labelClick(MouseEvent e) {

		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				if (e.getSource().equals(labelArray[timeset][locationset])) {
					if (labelArray[timeset][locationset].getStyle().equals("-fx-background-color: red")) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("이미 예약된 룸입니다.");
						alert.showAndWait();
						break;

					} else {
						location_Id = (String.valueOf(locationset));
						startEndTimeSet(timeset);// start and endTime String Set;
						labelColorChange(timeset, locationset);
						break;
					}
				}

			}
		}
	}

	private void startEndTimeSet(int value) {
		switch (value) {
		case 0:
			start_Time = "10";
			end_Time = "12";
			break;
		case 1:
			start_Time = "12";
			end_Time = "14";
			break;
		case 2:
			start_Time = "14";
			end_Time = "16";
			break;
		case 3:
			start_Time = "16";
			end_Time = "18";
			break;
		case 4:
			start_Time = "18";
			end_Time = "20";
			break;
		case 5:
			start_Time = "20";
			end_Time = "22";
			break;
		case 6:
			start_Time = "22";
			end_Time = "24";
			break;
		default:
			start_Time = "";
			end_Time = "";
			break;
		}
	}

	private int startEndTimeSet(String start_Time) {
		switch (start_Time) {
		case "10":
			return 0;

		case "12":
			return 1;
		case "14":
			return 2;
		case "16":
			return 3;
		case "18":
			return 4;
		case "20":
			return 5;
		case "22":
			return 6;
		default:
			return 7;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		impl = new HistoryImpl();
		labelArray = new Label[7][3];
		for (int i = 0; i < labelArray.length; i++) {
			for (int j = 0; j < labelArray[i].length; j++) {
				Label thislabel = new Label();
				thislabel.setPrefWidth(60);
				thislabel.setOnMouseClicked(event -> {
					labelClick(event);
				});
				thislabel.setText(i + "" + j);
				labelArray[i][j] = thislabel;
				gridPane.add(thislabel, i, j);
//				thislabel.setStyle("-fx-background-color: blue");

			}

		}
		dp.valueProperty().addListener((ov, oldValue, newValue) -> setyyddmm());
		dp.setValue(LocalDate.now());
		SelectDate();
		labelColorChange();
	}

	private void setyyddmm() {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		yyddmm = dp.getValue().format(formatter);
		selectDate = (yyddmm.substring(0, 8) + "%");
		SelectDate();
		labelColorChange();

	}

	private void SelectDate() {
		historys = impl.selectDateAll(selectDate);
		for (History h : historys) {
			System.out.println(h);
		}
	}

	private void labelColorChange() {

		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				labelArray[timeset][locationset].setStyle("-fx-background-color: blue");
			}

		}

		if (historys != null) {
			for (History h : historys) {
				String substr = h.getStart_Time().substring(8, 10);
				labelArray[startEndTimeSet(substr)][h.getLocation_Id()].setStyle("-fx-background-color: red");

			}
		}

	}

	private void labelColorChange(int _timeSet, int _locationSet) {

		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				if (timeset == _timeSet && locationset == _locationSet) {
					labelArray[timeset][locationset].setStyle("-fx-background-color: yellow");
				} else

					labelArray[timeset][locationset].setStyle("-fx-background-color: blue");
			}

		}

		if (historys != null) {
			for (History h : historys) {
				String substr = h.getStart_Time().substring(8, 10);
				labelArray[startEndTimeSet(substr)][h.getLocation_Id()].setStyle("-fx-background-color: red");

			}
		}

	}

	@FXML
	public void InsertHistory() {
//		int history;  
//		String start_Time; 
//		String end_Time; 
//		int user_code; // need to -database search CONSTRAINT FK_user FOREIGN KEY(USER_CODE) REFERENCES user1(USER_CODE) 
//		int location_Id; // need to -databased search CONSTRAINT FK_location FOREIGN KEY(LOCATION_ID)	REFERENCES location(LOCATION_ID )
//		boolean sys_Use; // database in  SYS_USE CHAR(1) NOT NULL
//		String update_Date; // database in data type;
		History history_Type = new History();
		history_Type.setStart_Time(yyddmm + start_Time);
		history_Type.setEnd_Time(yyddmm + end_Time);
		history_Type.setLocation_Id(Integer.parseInt(location_Id));
		history_Type.setSys_Use("false");
		history_Type.setUser_Code(UserRootController.user.getUser_Code());

		impl.insert(history_Type);
		SelectDate();
		
		//fuckyou;
		
		labelColorChange();
	}
}
