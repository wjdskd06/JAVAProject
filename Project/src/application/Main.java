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
			rootLayout = FXMLLoader.load(getClass().getResource("../view/UserGUI.fxml"));// ../ -> location find
			Scene scene = new Scene(rootLayout, 350, 100);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("scene");
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setScene(scene);
			primaryStage.show();// 윈도우 보여주기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
