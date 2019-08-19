package Controller;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.History;
import service.HistoryImpl;

public class HistoryController implements Initializable {
	@FXML GridPane gridPane;
	String yyddmm;
	String location_Id;
	String start_Time;
	String end_Time;
	Label[][] labelArray;

	@FXML DatePicker dp;
	

	@FXML
	public void labelClick(MouseEvent e) {
		
		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				if(e.getSource().equals(labelArray[timeset][locationset]))
				{
					location_Id = (String.valueOf(locationset));
					startEndTimeSet(timeset);//start and endTime String Set;
					break;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelArray = new Label[7][3];
		for (int i = 0; i < labelArray.length; i++) {
			for (int j = 0; j < labelArray[i].length; j++) {
				Label thislabel = new Label();
				thislabel.setOnMouseClicked(event -> {
					labelClick(event);
				});
				thislabel.setText(i+""+j );
				labelArray[i][j] = thislabel;
				gridPane.add(thislabel, i, j);
				thislabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

			}

		}
		dp.valueProperty().addListener((ov,oldValue,newValue)
				-> setyyddmm());
		
	}
	
	private void setyyddmm() {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		yyddmm = dp.getValue().format(formatter);
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
		history_Type.setStart_Time(yyddmm+start_Time);
		history_Type.setEnd_Time(yyddmm+end_Time);
		history_Type.setLocation_Id(Integer.parseInt(location_Id));
		history_Type.setSys_Use(false);
		history_Type.setUser_code(UserRootController.user.getUser_Code());
		
		
		HistoryImpl historyImpl = new HistoryImpl();
		historyImpl.insert(history_Type);
		//historyImpl.insert(history);
	}
}
