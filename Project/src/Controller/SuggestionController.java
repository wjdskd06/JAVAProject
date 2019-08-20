package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Suggestions;
import service.SuggestionDAO;

public class SuggestionController {

	@FXML
	Button btnSummit;

	@FXML
	private TextArea sugtext;

	@FXML
	protected void SuggestionSummit(ActionEvent event) {
		Stage primaryStage = new Stage();
		Suggestions sug = new Suggestions();
		sug.setCONTENT(sugtext.getText());
		sug.setUser_Id(UserRootController.user.getUser_Code());
		sug.setSuggestions_Id(sug.getSuggestions_Id());
		if (sug.getCONTENT().equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("경고");
			alert.setContentText("정보를 입력하지 않았습니다.");
			alert.show();
		} else {
			try {
				SuggestionDAO.getInstance().insertSug(sug);
				primaryStage = (Stage) btnSummit.getScene().getWindow();
				primaryStage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			sugtext.setText("");
		}
	}

}
