package Controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.History;
import service.HistoryImpl;

public class HistoryCancelController implements Initializable{
	@FXML
	private TableView<History> myHistorys;
	@FXML
	private TableColumn<History,Integer> locationId;
	@FXML
	private TableColumn<History,String> start_Time;
	@FXML
	private TableColumn<History,String> end_Time;
	
	ObservableList<History> obsList;
	HistoryImpl impl;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		impl = new HistoryImpl();
		refresh();
		
	}
	
	private void refresh() {
		String yyddmmhh = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh"));
		yyddmmhh.replace("-","");
		yyddmmhh.replace(" ","");
		List<History> list= impl.selectCancelAbleDateUser(yyddmmhh, UserRootController.user);
		obsList = FXCollections.observableArrayList(list);
		locationId.setCellValueFactory(cellData ->cellData.getValue().getLocation_IdProperty().asObject()); 
		start_Time.setCellValueFactory(cellData -> cellData.getValue().getStart_Time_Property());
		end_Time.setCellValueFactory(cellData -> cellData.getValue().getEnd_Time_Property());
		myHistorys.setItems(obsList);
	}
	
	@FXML
	public void delete(ActionEvent e) {
		impl.delete(myHistorys.getFocusModel().getFocusedItem().getHistory());
		refresh();
	}
}
