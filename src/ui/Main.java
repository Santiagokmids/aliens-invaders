package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private AliensInvadersGUI aliendsInvadersGUI;
	
	public Main() {
		aliendsInvadersGUI = new AliensInvadersGUI();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(aliendsInvadersGUI);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Aliens Invaders");
		primaryStage.setResizable(false);
		primaryStage.show();
		aliendsInvadersGUI.loadBanner();
	}
	
}