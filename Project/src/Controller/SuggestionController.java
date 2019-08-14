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

public class SuggestionController {


	@FXML
	Button btnSummit;
	
	@FXML
	private TextArea sugtext;

	

	@FXML
	protected void SuggestionSummit(ActionEvent event) {

		Suggestions sug = new Suggestions();
		sug.setCONTENT(sugtext.getText());
		sug.setUser_Id(1);
		sug.setSuggestions_Id(1);
		SuggestionDAO.getInstance().insertSug(sug);

		sugtext.setText("");

	}

}
