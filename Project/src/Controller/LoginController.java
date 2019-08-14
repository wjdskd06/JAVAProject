package Controller;

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

public class LoginController {

	@FXML
	Button btnLogin;
    @FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword;
    
    @FXML
    Button btnSignUp;
    

    


	
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
    public void Login(ActionEvent event) throws Exception{
    if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){
        lblStatus.setText("Login Success");
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/UserGUI.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }else{
        lblStatus.setText("Login Failed");
    }
}
    
    public void SignUp(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/Signup.fxml"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          primaryStage.setScene(scene);
          primaryStage.show();
    }
}



	
	
	
	

