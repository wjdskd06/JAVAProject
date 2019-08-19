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
	private TableColumn<Suggestions,Integer> calUserId;
	@FXML
	private TableColumn<Suggestions,String> calContent;
	@FXML
	private TableColumn<Suggestions,String> calDate;
	@FXML
	private TableColumn<Suggestions,String> calResult;
	int a;
	ObservableList<Suggestions> suggestions = null;
	
public void ManagerSuggestion(ActionEvent event) {

//	Suggestion.setText(suggestions.getCONTENT());
//	UserId.setText(String.valueOf(suggestions.getUser_Id()));
	
	
	
}



@Override
public void initialize(URL location, ResourceBundle resources) {

	calNum.setCellValueFactory(cellData -> cellData.getValue().getSuggestions_IdProperty().asObject()); //번호
	calUserId.setCellValueFactory(cellData -> cellData.getValue().getUser_IdProperty().asObject()); //유저 ID
	calResult.setCellValueFactory(cellData -> cellData.getValue().getCONTENTProperty()); //건의 내용
	calDate.setCellValueFactory(cellData -> cellData.getValue().getSuggestion_DateProperty()); // 날짜
	calContent.setCellValueFactory(cellData -> cellData.getValue().getSuccessProperty()); // 처리 여부
	
	Connection conn = DAO.getConnect();
	try {
		suggestions = SuggestionDAO.getInstance().selectAll(DAO.getConnect());
		
		
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		

	mytable.setItems(suggestions);
}
	
	
	
	
	

}
