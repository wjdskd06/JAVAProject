package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
		// new DeptFrame();
	}
	

	private Stage primaryStage;
	private AnchorPane rootLayout;

	@Override
	public void start(Stage stage) {
		this.primaryStage = stage;
		initRootLayout();
//		showDeptView();
	}

	public void initRootLayout() {
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("../view/Login1.fxml"));// ../ -> location find
			Scene scene = new Scene(rootLayout, 300, 300);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setScene(scene);
			primaryStage.show();// �쐢�룄�슦 蹂댁뿬二쇨린
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
