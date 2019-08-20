package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SuggestionMenuController {
	@FXML
	Button btnSuggestionResult;
	@FXML
	Button btnSuggestion;

	@FXML
	public void Suggestion(ActionEvent actionevent) { // open window
		try {
			AnchorPane Suggestion = FXMLLoader.load(getClass().getResource("../view/Suggestion.fxml"));
			Stage primarystage = (Stage) btnSuggestion.getScene().getWindow();
			primarystage.close();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(Suggestion);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@FXML
	public void SuggestionResult(ActionEvent actionevent) { // open window
		try {
			AnchorPane SuggestionResult = FXMLLoader.load(getClass().getResource("../view/SuggestionResult.fxml"));
			Stage primarystage = (Stage) btnSuggestionResult.getScene().getWindow();
			primarystage.close();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(SuggestionResult);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}


	
}
