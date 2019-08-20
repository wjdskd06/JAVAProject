package Controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import common.DAO;
import javafx.beans.binding.SetExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn.CellEditEvent;
import model.Suggestions;
import service.SuggestionDAO;

public class ManagerSuggestionController implements Initializable {

	@FXML
	private TableView<Suggestions> mytable;
	@FXML
	private TableColumn<Suggestions, Integer> calNum;
	@FXML
	private TableColumn<Suggestions, Integer> calUserId;
	@FXML
	private TableColumn<Suggestions, String> calContent;
	@FXML
	private TableColumn<Suggestions, String> calDate;
	@FXML
	private TableColumn<Suggestions, String> calResult;
	@FXML
	TextField TextCheck;
	@FXML
	TextArea contentCheck;
	
	@FXML
	Button btncheck;
	
	ObservableList<Suggestions> suggestions = null;

	public void Update(ActionEvent event) {
		Suggestions s = new Suggestions();
		s.setSuccess(TextCheck.getText());
		s.setSuggestions_Id(mytable.getSelectionModel().getSelectedItem().getSuggestions_IdProperty().get());
		Connection conn = DAO.getConnect();
		try {
			System.out.println(s);
			SuggestionDAO.getInstance().Update(s);
			mytable.getSelectionModel().getSelectedItem().setSuccess(TextCheck.getText());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		calNum.setCellValueFactory(cellData -> cellData.getValue().getSuggestions_IdProperty().asObject()); // 번호
		calUserId.setCellValueFactory(cellData -> cellData.getValue().getUser_IdProperty().asObject()); // 유저 ID
		calResult.setCellValueFactory(cellData -> cellData.getValue().getSuccessProperty()); // 건의 내용
		calDate.setCellValueFactory(cellData -> cellData.getValue().getSuggestion_DateProperty()); // 날짜
		calContent.setCellValueFactory(cellData -> cellData.getValue().getCONTENTProperty()); // 처리 여부
//		calContent.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Suggestions, String>>() {
//
//			@Override
//			public void handle(CellEditEvent<Suggestions, String> event) {
//				((Suggestions) event.getTableView().getItems().get(event.getTablePosition().getRow()))
//						.setSuccess(event.getNewValue());
//			}
//		});
//
		Connection conn = DAO.getConnect();
		try {
		suggestions = SuggestionDAO.getInstance().selectAll(DAO.getConnect());

		} catch (SQLException e) {

			e.printStackTrace();
		}

		mytable.setItems(suggestions);
	}
	@FXML
	protected void check(MouseEvent event) {
		contentCheck.setText(mytable.getSelectionModel().getSelectedItem().getCONTENTProperty().get());
		
	}
	
	
	
	
	
	

}
