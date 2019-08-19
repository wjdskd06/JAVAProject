package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextArea;

import model.Suggestions;
import service.SuggestionDAO;

public class SuggestionController {

	@FXML
	Button btnSummit;

	@FXML
	private TextArea sugtext;

	@FXML
	protected void SuggestionSummit(ActionEvent event) {

		Suggestions sug = new Suggestions();
		sug.setCONTENT(sugtext.getText());
		sug.setUser_Id(UserRootController.user.getUser_Code());
		sug.setSuggestions_Id(sug.getSuggestions_Id());
		SuggestionDAO.getInstance().insertSug(sug);

		sugtext.setText("");

	}

}
