package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.AliensInvaders;

public class Main extends Application{
	
	private AliensInvaders aliensInvaders;
	private AliensInvadersGUI aliensInvadersGUI;
	
	public Main() {
		aliensInvaders = new AliensInvaders();
		boolean loadInformation = aliensInvaders.loadData();
		if(!loadInformation) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			
		    alert.setTitle("Aliens Invaders");
		    alert.setContentText("Error cargando el archivo");
		    alert.showAndWait();
		}
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
