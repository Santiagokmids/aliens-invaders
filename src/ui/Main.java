package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AliensInvaders;

public class Main extends Application{
	
	private AliensInvaders aliensInvaders;
	private AliensInvadersGUI aliensInvadersGUI;
	
	public Main() {
		aliensInvaders = new AliensInvaders();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		aliensInvadersGUI = new AliensInvadersGUI(aliensInvaders, primaryStage);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(aliensInvadersGUI);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Aliens Invaders");
		primaryStage.setResizable(false);
		primaryStage.show();
		aliensInvadersGUI.loadBanner();
	}
	
}
