package ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Alien;
import model.AliensInvaders;
import model.Player;
import model.Spacecraft;

public class AliensInvadersGUI {

	@FXML
	private BorderPane mainPane;
	
	@FXML
	private Circle circle;

	@FXML
	private ImageView lblHall;

	@FXML
	private TableView<Player> tvHall;
	
	@FXML
    private TableColumn<Player, String> tcName;

    @FXML
    private TableColumn<Player, Integer> tcScore;

    @FXML
    private TableColumn<Player, Integer> tcLevel;
	
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
    
    @FXML
    private ImageView paneSearch;

    @FXML
    private ImageView titleSearch;

    @FXML
    private ImageView addNIck;

    @FXML
    private ImageView addScore;
    
    @FXML
    private ImageView paneRealName;

    @FXML
    private ImageView addRealName;

    @FXML
    private ImageView titleRealName;
    
    @FXML
    private TextField txtRealName;
    
    @FXML
    private ImageView mainShip;
    
    @FXML
    private ComboBox<String> comboBoxDificult;
    
    @FXML
    private ImageView alien1;
    
    private Stage window;
    
    private boolean bouncing;
    
    private AliensInvaders aliensInvaders;
    
    public ObservableList<Player> listPlayer;
    
    private Alien alien;
    
    private Spacecraft ship;
    
    private double positionBallX;
    
    private double positionBallY;

	public AliensInvadersGUI(AliensInvaders aliensInvaders, Stage stage) {
		this.aliensInvaders = aliensInvaders;
		window = stage;
		bouncing = true;
	}
	
	public void inicializateTableViewPlayer() {
		
		listPlayer = FXCollections.observableArrayList(aliensInvaders.toArrayList());
		
		tvHall.setItems(listPlayer);
		tcName.setCellValueFactory(new PropertyValueFactory<Player,String>("nick"));
		tcScore.setCellValueFactory(new PropertyValueFactory<Player,Integer>("score"));
		tcLevel.setCellValueFactory(new PropertyValueFactory<Player,Integer>("level"));
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
    	addName();
    	
    	comboBoxDificult.setPromptText("Dificultad");
    	
    	comboBoxDificult.getItems().addAll("Novato","Cadete","Leyenda");
    }
	
	@FXML
    void bottonShip1(MouseEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game-pane.fxml"));
    	
    	loader.setController(this);
    	Parent load = loader.load();
    	
    	Image image = new Image("images/fondoGame.png");
    	
    	Image image2 = new Image("images/firstAlien.png");
    	
    	imageBackGround.setImage(image);
    	alien1.setImage(image2);
    	
    	Image imageShip = new Image("images/ship1.png");
    	mainShip.setImage(imageShip);
    	
    	ship = new Spacecraft(null,mainShip.getLayoutX());
    	
    	mainPane.getChildren().clear();
    	mainPane.setTop(load);
    	circle.setVisible(false);
    	positionBallX = circle.getLayoutX();
    	positionBallY = circle.getLayoutY();
    	move();
    }

    @FXML
    void bottonShip2(MouseEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("game-pane.fxml"));
    	
    	loader.setController(this);
    	Parent load = loader.load();
    	
    	Image image = new Image("images/fondoGame.png");
    	
    	Image image2 = new Image("images/firstAlien.png");
    	
    	imageBackGround.setImage(image);
    	alien1.setImage(image2);
    	
    	Image imageShip = new Image("images/ship2.png");
    	mainShip.setImage(imageShip);
    	
    	ship = new Spacecraft(null,mainShip.getLayoutX());
    	
    	mainPane.getChildren().clear();
    	mainPane.setTop(load);
    	circle.setVisible(false);
    	positionBallX = circle.getLayoutX();
    	positionBallY = circle.getLayoutY();
    	
    	mainPane.getChildren().clear();
    	mainPane.setTop(load);
    	circle.setVisible(false);
    	
    	move();
    }
    
    public void move() {
    	alien = new Alien(alien1.getLayoutX(), alien1.getLayoutY());
    	
    	window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				bouncing = false;
			}
		});
		
		moveAlien();
    }
    
    public void moveAlien() {
    	
    	Image image1 = new Image("images/firstAlien.png");
    	Image image2 = new Image("images/secondAlien.png");
    	
    	ImageView alien3 = new ImageView();
    	
    	alien3.setImage(image2);
    	
    	mainPane.getChildren().add(alien3);
    	
    	alien3.setFitWidth(79);
    	alien3.setFitHeight(62);
    	
    	alien3.setLayoutX(120);
    	alien3.setLayoutY(72);
    	
    	alien.setMax(window.getWidth()-alien1.getLayoutX());
    	
    	new Thread() {
    		public void run() {
    			
    			while(bouncing) {
    				
    				alien.moveAlien();
    				
    				Platform.runLater(new Thread(){
    					public void run() {
    						updateAlien(alien.getX());
    						if(alien1.getImage() == image1) {
    							alien1.setImage(image2);
    						}else {
    							alien1.setImage(image1);
    						}
    					}
    				});
    				
    				try{
    					Thread.sleep(200);
    				}catch(InterruptedException e) {
    					
    				}
    			}
    		}
    	}.start();
    }
    
    public void moveImageAlien() {
    	
    }
    
    public void updateAlien(double x) {
    	alien1.setLayoutX(x);
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
		
		inicializateTableViewPlayer();
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
    
    @FXML
    public void searchPlayers(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPlayers.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		
		Image image = new Image("/images/Buscar.png");
		paneSearch.setImage(image);
		Image image2 = new Image("/images/tituloBuscar.png");
		titleSearch.setImage(image2);
		Image image3 = new Image("/images/nickPlayer.png");
		addNIck.setImage(image3);
		Image image4 = new Image("/images/puntaje.png");
		addScore.setImage(image4);
		
		mainPane.getChildren().clear();
		mainPane.setTop(load);

    }
    
    @FXML
    public void addRealName(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("real-name.fxml"));

		loader.setController(this);
		Parent load = loader.load();
		
		Image image = new Image("/images/nombreReal.png");
		paneRealName.setImage(image);
		Image image2 = new Image("/images/title.png");
		titleRealName.setImage(image2);
		Image image3 = new Image("/images/ingrese Nombre.png");
		addRealName.setImage(image3);
		
		mainPane.getChildren().clear();
		mainPane.setTop(load);

    }
    
    public void addName() {
    	aliensInvaders.addPeople(txtRealName.getText());
    }
    
    public void loadPlayers(ActionEvent event) throws IOException{
    	addPlayer();
    	loadBanner();
    }
    
    public void addPlayer(){
    	int score = (int)Math.floor(Math.random()*999);
    	int level = (int)Math.floor(Math.random()*60);
    	aliensInvaders.addPlayer(nickName.getText(), score, level);
    }
    
    @FXML
    public void moveShip(KeyEvent event) throws InterruptedException {
    	
    	if((event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) && ship.getPosX() >= 12) {
    		ship.moveLeft();
    		
    	}if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W ){
    		Circle circles = new Circle();
    		circles.setLayoutX(positionBallX);
    		circles.setLayoutY(positionBallY);
    		circles.setRadius(circle.getRadius());
    		mainPane.getChildren().add(circles);
    		moveBall(circles);
    		
    	}else if((event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) && ship.getPosX() <= 462){
    		ship.moveRight();
    		
    	}
    	mainShip.setLayoutX(ship.getPosX());
    }
    
    public void moveBall(Circle circles) {
    	circles.setVisible(true);
    	circles.setFill(javafx.scene.paint.Color.RED);
    	circles.setLayoutX(ship.getPosX()+40);
    	
		moveBalls(circles);
    }
    
    public void moveBalls(Circle circles) {
    	
    	new Thread() {
    		public void run() {
    			
    			while(circles.getLayoutY() > -15) {
    				Platform.runLater(new Thread(){
    					public void run() {
    						circles.setLayoutY(circles.getLayoutY()-5);
    					}
    				});
    				try{
    					Thread.sleep(20);
    				}catch(InterruptedException e) {
    					
    				}
    			}
    		}
    	}.start();
    	
    }
    
    public void searchScore() {
    	
    }
    
    public void removePlayer() {
    	
    }
    
    public void loadData() {
    	
	}
	
	public void saveData() {
		
	}
	
	public void exportData() {
		
	}
	
	public void importData() {
		
	}
}
