package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import common.DAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
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
	private TableView<Suggestions> mytable;
	@FXML
	private TableColumn<Suggestions,Integer> calNum;
	@FXML
	private TableColumn<Suggestions,IntegerProperty> calUserId;
	@FXML
	private TableColumn<Suggestions,StringProperty> calContent;
	@FXML
	private TableColumn<Suggestions,StringProperty> calDate;
	@FXML
	private TableColumn<Suggestions,StringProperty> calResult;
	
	int a; 
	ObservableList<Suggestions> suggestions = null;
	
public void ManagerSuggestion(ActionEvent event) {

//	Suggestion.setText(suggestions.getCONTENT());
//	UserId.setText(String.valueOf(suggestions.getUser_Id()));
	
	
	
}



@Override
public void initialize(URL location, ResourceBundle resources) {

	calNum.setCellValueFactory(cellData -> cellData.getValue().getSuggestions_IdProperty().asObject());
	
	Connection conn = DAO.getConnect();
	try {
		suggestions = SuggestionDAO.getInstance().selectAll(DAO.getConnect());
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	mytable.setItems(suggestions);
}
	
	
	
	
	

}
