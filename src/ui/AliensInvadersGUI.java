package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AliensInvadersGUI {

	@FXML
	private BorderPane mainPane;

	@FXML
	private ImageView lblHall;

	@FXML
	private TableView<?> tvHall;
	
    @FXML
    private ImageView paneStart;
    
    @FXML
    private ImageView paneHall;

    @FXML
    private ImageView lblStart;
    
    @FXML
    private ImageView imageBackGround;
    
    @FXML
    private ImageView backGround;

    @FXML
    private ImageView gameOver;

    @FXML
    private ImageView insertName;

    @FXML
    private TextField nickName;
    
    @FXML
    private ImageView imageBackgroundSelectShip;

    @FXML
    private ImageView imageShip1;

    @FXML
    private ImageView imageShip2;

	public AliensInvadersGUI() {
	}

	@FXML
	public void loadBanner() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("startGame.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		
		Image image = new Image("/images/inico.png");
		paneStart.setImage(image);
		Image image2 = new Image("/images/title.png");
		lblStart.setImage(image2);
		
		mainPane.getChildren().clear();
		mainPane.setTop(load);

	}
	
	@FXML
    public void btnStartGame(ActionEvent event) throws IOException {
    	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("selectShip-pane.fxml"));
    	
    	loader.setController(this);
    	Parent load = loader.load();
    	
    	Image image = new Image("/images/selectNave.png");
		imageBackgroundSelectShip.setImage(image);
		Image image2 = new Image("/images/ship1.png");
		imageShip1.setImage(image2);
		Image image3 = new Image("/images/ship2.png");
		imageShip2.setImage(image3);
    	
    	mainPane.getChildren().clear();
    	mainPane.setTop(load);
    }
	
	@FXML
    void bottonShip1(MouseEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game-pane.fxml"));
    	
    	loader.setController(this);
    	Parent load = loader.load();
    	
    	Image image = new Image("images/backGroundGame.png");
    	
    	imageBackGround.setImage(image);
    	
    	mainPane.getChildren().clear();
    	mainPane.setTop(load);
    }

    @FXML
    void bottonShip2(MouseEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("game-pane.fxml"));
    	
    	loader.setController(this);
    	Parent load = loader.load();
    	
    	Image image = new Image("images/backGroundGame.png");
    	
    	imageBackGround.setImage(image);
    	
    	mainPane.getChildren().clear();
    	mainPane.setTop(load);
    }
    
    @FXML
    public void btnScores(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("hallOfFame.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		
		Image image = new Image("/images/fondos.png");
		paneHall.setImage(image);
		Image image2 = new Image("/images/halll.png");
		lblHall.setImage(image2);
		
		mainPane.getChildren().clear();
		mainPane.setTop(load);

    }
    
    @FXML
    public void acept(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("gameover-pane.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		
		Image image = new Image("/images/insertName.png");
		insertName.setImage(image);
		Image image2 = new Image("/images/gameOver.png");
		gameOver.setImage(image2);
		Image image3 = new Image("/images/backGround.png");
		backGround.setImage(image3);
		
		mainPane.getChildren().clear();
		mainPane.setTop(load);

    }
    
    
}
