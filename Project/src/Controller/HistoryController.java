package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import model.User;
import service.HistoryImpl;
import service.UserServiceImpl;

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
	History history_Type;

	@FXML
	public void labelClick(MouseEvent e) {

		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				if (e.getSource().equals(labelArray[timeset][locationset])) {
					if (labelArray[timeset][locationset].getStyle().equals("-fx-background-color: red")) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("예약할수 없는 룸입니다.");
						alert.showAndWait();
						break;

					} else {
						location_Id = (String.valueOf(locationset));
						startEndTimeSet(timeset);// start and endTime String Set;
						labelColorChange(timeset, locationset);
						history_Type = new History();
						history_Type.setStart_Time(yyddmm + start_Time);
						history_Type.setEnd_Time(yyddmm + end_Time);
						history_Type.setUser_Code(UserRootController.user.getUser_Code());
						history_Type.setLocation_Id(Integer.parseInt(location_Id));
						history_Type.setSys_Use("false");
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

	private int startTimeReturn(int timeset) {
		switch (timeset) {
		case 0:
			return 10;

		case 1:
			return 12;

		case 2:
			return 14;

		case 3:
			return 16;

		case 4:
			return 18;

		case 5:
			return 20;

		case 6:
			return 22;

		default:

			break;
		}
		return 10000;
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

			}

		}
		dp.valueProperty().addListener((ov, oldValue, newValue) -> setyyddmm());
		dp.setValue(LocalDate.now());
		Refresh();
	}

	private void setyyddmm() {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		yyddmm = dp.getValue().format(formatter);
		selectDate = (yyddmm.substring(0, 8) + "%");
		Refresh();
	}

	private void Refresh() {
		SelectDate();
		labelColorChange();
	}

	private void SelectDate() {
		historys = impl.selectDateAll(selectDate);
	}

	private void ColorBlueSet() {
		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				labelArray[timeset][locationset].setStyle("-fx-background-color: blue");
			}
		}
	}

	private void ColorYellowSet(int timeSet, int locationSet) {
		labelArray[timeSet][locationSet].setStyle("-fx-background-color: yellow");
	}

	private void ColorRedSet(int timeSet, int locationSet) {
		labelArray[timeSet][locationSet].setStyle("-fx-background-color: red");
	}

	private void labelColorChange() {
		LocalDateTime today = LocalDateTime.now();
		int value = dp.getValue().compareTo(today.toLocalDate());
		if (value >= 0) {
			ColorBlueSet();
			if (historys != null) {
				for (History h : historys) {
					String substr = h.getStart_Time().substring(8, 10);
					ColorRedSet(startEndTimeSet(substr), h.getLocation_Id());
				}
			}
			if (value == 0) {
				int todayHour = today.getHour();
				for (int timeset = 0; timeset < labelArray.length; timeset++) {
					for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
						if (todayHour > startTimeReturn(timeset))
							ColorRedSet(timeset, locationset);
					}
				}
			}

		} else
			for (int timeset = 0; timeset < labelArray.length; timeset++) {
				for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
					ColorRedSet(timeset, locationset);
				}

			}
	}

	private void labelColorChange(int _timeSet, int _locationSet) {
		LocalDateTime today = LocalDateTime.now();
		int value = dp.getValue().compareTo(today.toLocalDate());
		if (value >= 0) {
			ColorBlueSet();
			ColorYellowSet(_timeSet, _locationSet);
			if (historys != null) {
				for (History h : historys) {
					String substr = h.getStart_Time().substring(8, 10);
					ColorRedSet(startEndTimeSet(substr), h.getLocation_Id());
					// labelArray[startEndTimeSet(substr)][h.getLocation_Id()].setStyle("-fx-background-color:
					// red");

				}
			}
			if (value == 0) {
				int todayHour = today.getHour();
				for (int timeset = 0; timeset < labelArray.length; timeset++) {
					for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
						if (todayHour > startTimeReturn(timeset))
							ColorRedSet(timeset, locationset);
					}
				}
			}

		} else
			for (int timeset = 0; timeset < labelArray.length; timeset++) {
				for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
					ColorRedSet(timeset, locationset);
				}

			}

	}

	@FXML
	public void InsertHistory() {

		// sysdate -> sql query;
		if (history_Type != null) {
			if (IsInsertAble(history_Type)) {
				if (impl.insert(history_Type)) {
					UserServiceImpl userImpl = new UserServiceImpl();
					User user = UserRootController.user;
					if (user != null) {
						user.setGrade_Point(user.getGrade_Point() + 3000);
						user.setSale_Point(user.getSale_Point() + 3000);
						userImpl.update(user);
					}
					Refresh();
				}
				

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("이미 그시간에 예약을 했습니다.");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("예약할 시간을 선택해주세요.");
			alert.showAndWait();
		}
	}

	private boolean IsInsertAble(History history) {
		try {
			if (impl.selectInsertAbleDateUser(history.getStart_Time(), history.getEnd_Time(),
					UserRootController.user)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
