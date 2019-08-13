package Controller;

import java.sql.Connection;

import common.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import model.Suggestions;
import service.SuggestionDAO;

public class UserRootController {
	@FXML
	Button btnReservation;
	@FXML
	Button btnResservationCencle;
	@FXML
	Button btnMemberInfo;
	@FXML
	Button btnSuggestionMenu;



	@FXML
	public void Reservation(ActionEvent actionevent) { // open window
		try {
			AnchorPane Reservation = FXMLLoader.load(getClass().getResource("../view/Reservation.fxml"));
			Stage primarystage = (Stage) btnReservation.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(Reservation);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@FXML
	public void ReservationCencle(ActionEvent actionevent) { // open window
		try {
			AnchorPane ReservationCencleView = FXMLLoader.load(getClass().getResource("../view/Cencle.fxml"));
			Stage primarystage = (Stage) btnResservationCencle.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(ReservationCencleView);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@FXML
	public void MemberInfo(ActionEvent actionevent) { // open window
		try {
			AnchorPane memberinfo = FXMLLoader.load(getClass().getResource("../view/MemberInfo.fxml"));
			Stage primarystage = (Stage) btnMemberInfo.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(memberinfo);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@FXML
	public void SuggestionMenu(ActionEvent actionevent) { // open window
		try {
			AnchorPane Suggestionmenu = FXMLLoader.load(getClass().getResource("../view/SuggestionMenu.fxml"));
			Stage primarystage = (Stage) btnSuggestionMenu.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(Suggestionmenu);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
}
