package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	AliensInvadersGUI aiGUI = new AliensInvadersGUI();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Main() {
		aiGUI = new AliensInvadersGUI();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(aiGUI);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Aliens Invaders");
		//primaryStage.setResizable(false);
		primaryStage.show();
	}

}
