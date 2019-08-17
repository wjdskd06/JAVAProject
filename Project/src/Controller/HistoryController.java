
package Controller;

 

import java.net.URL;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.List;

import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;

import model.History;

import service.HistoryImpl;

 

public class HistoryController implements Initializable {

	@FXML DatePicker dp;

 

	@FXML GridPane gridPane;

	@FXML

	Label[][] labelList;

	String date;

 

	int room;

 

	String start_Time;

	String end_Time;

 

	List<History> historys;

 

	@Override

	public void initialize(URL location, ResourceBundle resources) {


		labelList = new Label[7][3];

		for (int i = 0; i < labelList.length; i++) {

			for (int j = 0; j < labelList[i].length; j++) {

				Label label = new Label();

				label.setOnMouseClicked(event -> fuck(event,label));

				label.setText("test" + i + j);

				labelList[i][j] = label;

				gridPane.add(label, i, j);

 

			}

		}

		dp.valueProperty().addListener((ov, oldValue, newValue) -> {

			fuck2();

		});

 

		showHistory();

	}

 

	private void fuck2() {

		LocalDate ld = dp.getValue();

		DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;

		date = df.format(ld);
		System.out.println(date);

	}

 

	private void fuck(MouseEvent event,Label label) {

 

		for (int i = 0; i < labelList.length; i++) {

			for (int j = 0; j < labelList[i].length; j++) {

				if (label.equals(labelList[i][j])) {

					room = j;

					setStartEndTime(i);
					System.out.println(i+"\t"+start_Time+"\t" + end_Time);

				}

 

			}

		}

 

	}

 

	public void addHistory() {

		History history = new History();

		history.setUser_code(UserRootController.user.getUser_Code());

		history.setLocation_Id(room);

		history.setStart_Time(start_Time);

		history.setEnd_Time(end_Time);

 

		HistoryImpl hi = new HistoryImpl();

		hi.insert(history);

	}

 

	private void setStartEndTime(int value) {

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

 

	public void showHistory() {

		HistoryImpl hi = new HistoryImpl();

		historys = hi.selectAll();
		System.out.println(historys);

		// HistoryDAO.getInstance().selectDateAll(conn, date);

	}

 

}
