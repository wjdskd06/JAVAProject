package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import common.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import model.Suggestions;
import service.SuggestionDAO;

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
	
	List<Suggestions> suggestions;
	
public void ManagerSuggestion(ActionEvent event) {
	Connection conn = DAO.getConnect();
	try {
		suggestions = SuggestionDAO.getInstance().selectAll(DAO.getConnect());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	Suggestion.setText(suggestions.getCONTENT());
//	UserId.setText(String.valueOf(suggestions.getUser_Id()));
	
	
	
}



@Override
public void initialize(URL location, ResourceBundle resources) {
	Connection conn = DAO.getConnect();
	try {
		suggestions = SuggestionDAO.getInstance().selectAll(DAO.getConnect());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(suggestions.get(0).getCONTENT());
}
	
	
	
	
	

}
