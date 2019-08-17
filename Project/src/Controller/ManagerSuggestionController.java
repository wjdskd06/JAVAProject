package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.DAO;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Suggestions;
import service.SuggestionDAO;

public class ManagerSuggestionController implements Initializable {
	
	@FXML
	TableView<Suggestions> mytable;
	@FXML
	TableColumn<Suggestions,IntegerProperty> calNum;
	@FXML
	TableColumn<Suggestions,Integer> calUserId;
	@FXML
	TableColumn<Suggestions,String> calContent;
	@FXML
	TableColumn<Suggestions,String> calDate;
	@FXML
	TableColumn<Suggestions,String> calResult;
	Connection conn = DAO.getConnect();
	ObservableList<Suggestions> suggestions = SuggestionDAO.getInstance().selectAll(DAO.getConnect());
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
	
	calNum.setCellValueFactory(cellData -> cellData.getValue().getSuggestions_IdProperty());
	mytable.setItems(suggestions);
}
	
	
	
	
	

}
