package Controller;

import java.sql.Connection;

import common.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.User;
import service.UserDAO;

public class SignUpController {

	@FXML
	Button btnSummit;
    @FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;


	
/*	@FXML
	public void Login(ActionEvent actionevent) { // open window
		try {
			AnchorPane login = FXMLLoader.load(getClass().getResource("../view/UserGUI.fxml"));
			Stage primarystage = (Stage) btnLogin.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primarystage);

			Scene scene = new Scene(login);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
*/
    public void SignUp(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/Login1.fxml"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        Connection conn = DAO.getConnect();
        User user = new User();
        user.setUser_Id(txtUserName.getText());
        user.setUser_Pw(txtPassword.getText());
        UserDAO.getInstance().insert(conn, user);
    }
}



	
	
	
	
