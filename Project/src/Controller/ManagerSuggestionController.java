package Controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import common.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import model.Suggestions;

public class ManagerSuggestionController implements Initializable {
	
	@FXML
	TableColumn Number;
	@FXML
	TableColumn UserId;
	@FXML
	TableColumn Suggestion;
	@FXML
	TableColumn Date;
	@FXML
	TableColumn Result;
	
	Suggestions suggestions;
	
public void ManagerSuggestion(ActionEvent event) {
	Connection conn = DAO.getConnect();
	
	Suggestion.setText(suggestions.getCONTENT());
	UserId.setText(String.valueOf(suggestions.getUser_Id()));
	
	
	
}



@Override
public void initialize(URL location, ResourceBundle resources) {

}
	
	
	
	
	

}
