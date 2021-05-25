package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class AliensInvadersGUI {

	@FXML
	private BorderPane mainPane;
	
    public AliensInvadersGUI() {
    	
    }
    
    @FXML
	public void loadBanner() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("startGame.fxml"));
		
		loader.setController(this);
		Parent load = loader.load();  

		mainPane.getChildren().clear();
		mainPane.setTop(load);

	} 
    
    @FXML
    void btnScores(ActionEvent event) {

    }

    @FXML
    void btnStartGame(ActionEvent event) {
    	
    	
    }
}
