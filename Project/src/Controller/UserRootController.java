package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.History;

public class UserRootController {
	@FXML
	Button btnReservation;
	@FXML
	Button btnResservationCencle;
	@FXML
	Button btnMemberInfo;
	@FXML
	Button btnSuggesion;
	@FXML
	AnchorPane anchorPane;
	@FXML
	DatePicker datepicker;
	
	
	
	
	
	@FXML
	private void Reservation(ActionEvent actionEvent) {
		//datepicker.getDayCellFactory().
		//History history = new History();
		//history.set
	}
	
	
	
	
	
	
	@FXML
	public void handleDialog(ActionEvent actionevent) { //open window
		try {
			AnchorPane ReservationView = FXMLLoader.load(getClass().getResource("view/Reservation.fxml"));
			Stage primarystage = (Stage) btnReservation.getScene().getWindow();
			
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(ReservationView);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
