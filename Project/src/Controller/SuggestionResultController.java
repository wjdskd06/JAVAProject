package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.DAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import model.Suggestions;
import service.SuggestionDAO;

public class SuggestionResultController implements Initializable {
	
	
	
	@FXML
	private TableView<Suggestions> table;
	@FXML
	private TableColumn<Suggestions,Integer> Num;
	@FXML
	private TableColumn<Suggestions,String> Content;
	@FXML
	private TableColumn<Suggestions,String> Result;
	
	ObservableList<Suggestions> suggestions = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Num.setCellValueFactory(cellData -> cellData.getValue().getSuggestions_IdProperty().asObject()); //번호	
		Result.setCellValueFactory(cellData -> cellData.getValue().getCONTENTProperty()); //건의 내용
		Content.setCellValueFactory(cellData -> cellData.getValue().getSuccessProperty()); // 처리 여부
		
		Connection conn = DAO.getConnect();
		try {
			suggestions = SuggestionDAO.getInstance().select(DAO.getConnect());
			table.setItems(suggestions);
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			

//		table.setItems(suggestions);
	}

}
