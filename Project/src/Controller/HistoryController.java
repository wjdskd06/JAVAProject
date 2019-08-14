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

public class HistoryController implements Initializable {
	@FXML GridPane gridPane;
	String yyddmm;
	String location;
	String startTime;
	String endTime;
	Label[][] labelArray;

	@FXML DatePicker dp;
	

	@FXML
	public void labelClick(MouseEvent e) {
		
		for (int timeset = 0; timeset < labelArray.length; timeset++) {
			for (int locationset = 0; locationset < labelArray[timeset].length; locationset++) {
				if(e.getSource().equals(labelArray[timeset][locationset]))
				{
					location = String.valueOf(locationset);
					startEndTimeSet(timeset);//start and endTime String Set;
					System.out.println(location + "  " + startTime + endTime);
					break;
				}

			}
			
		}
	}
	
	private void startEndTimeSet(int value) {
		switch (value) {
		case 0:
			startTime = "10";
			endTime = "12";
			break;
		case 1:
			startTime = "12";
			endTime = "14";
			break;
		case 2:
			startTime = "14";
			endTime = "16";
			break;
		case 3:
			startTime = "16";
			endTime = "18";
			break;
		case 4:
			startTime = "18";
			endTime = "20";
			break;
		case 5:
			startTime = "20";
			endTime = "22";
			break;
		case 6:
			startTime = "22";
			endTime = "24";
			break;
		default:
			startTime = "";
			endTime = "";
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
}
