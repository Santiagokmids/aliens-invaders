package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Alien;
import model.AliensInvaders;
import model.AttackShip;
import model.Player;
import model.RecognShip;
import model.Spacecraft;
import model.TypeSpacecraft;
import thread.AlienThread;

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

	private Stage window;

	private boolean verify;

	private AliensInvaders aliensInvaders;

	public ObservableList<Player> listPlayer;

	private Spacecraft ship;

	private double positionBallX;

	private double positionBallY;

	private long count;

	private long currentCount;

	public final static int POSTITIONALIENTX = 79;

	public final static int POSTITIONALIENTY = 62;

	public final static int NUMBERALIENS = 2;

	public final static int VELOCITY = 1000;

	public final static int VELOCITYSLOW = 2600;

	public AliensInvadersGUI(AliensInvaders aliensInvaders, Stage stage) {
		this.aliensInvaders = aliensInvaders;
		window = stage;
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

		verify = false;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("startGame.fxml"));

		loader.setController(this);
		Parent load = loader.load();

		Image image = new Image("/images/inico.png");
		paneStart.setImage(image);
		Image image2 = new Image("/images/title.png");
		lblStart.setImage(image2);

		mainPane.getChildren().clear();
		mainPane.setTop(load);
		count = System.nanoTime();
		currentCount = 0;

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

		verify = true;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("game-pane.fxml"));

		loader.setController(this);
		Parent load = loader.load();

		Image image = new Image("images/fondoGame.png");

		imageBackGround.setImage(image);

		Image imageShip = new Image("images/ship1.png");
		mainShip.setImage(imageShip);

		ship = new AttackShip(TypeSpacecraft.ATTACK_SHIP,mainShip.getLayoutX(), VELOCITY);
		mainPane.getChildren().clear();
		mainPane.setTop(load);
		circle.setVisible(false);
		positionBallX = circle.getLayoutX();
		positionBallY = circle.getLayoutY();

		move();
	}

	@FXML
	void bottonShip2(MouseEvent event) throws IOException {

		verify = true;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("game-pane.fxml"));

		loader.setController(this);
		Parent load = loader.load();

		Image image = new Image("images/fondoGame.png");

		imageBackGround.setImage(image);

		Image imageShip = new Image("images/ship2.png");
		mainShip.setImage(imageShip);

		ship = new RecognShip(TypeSpacecraft.RECOGNITION_SHIP,mainShip.getLayoutX(),2);

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

		Image image1 = new Image("images/firstAlien.png");
		Image image2 = new Image("images/secondAlien.png");

		int contX = POSTITIONALIENTX;
		int contY = POSTITIONALIENTY;

		for(int i = 0; i<NUMBERALIENS; i++) {

			Alien alien = new Alien(POSTITIONALIENTX, POSTITIONALIENTY, contX, contY, image1, image2);

			moveAlien(alien);

			contX += 50;
		}

	}

	public void moveAlien(Alien alien) {

		ImageView alienImageView = new ImageView();

		alienImageView.setImage(alien.getImageOne());

		System.out.println(alien.getPositionX());
		System.out.println(alien.getPositionY());

		mainPane.getChildren().add(alienImageView);

		alienImageView.setFitWidth(alien.getX());
		alienImageView.setFitHeight(alien.getY());

		alienImageView.setLayoutX(alien.getPositionX());
		alienImageView.setLayoutY(alien.getPositionY());

		alien.setMax(window.getWidth());

		AlienThread thread = new AlienThread(this, alien, alienImageView, verify);

		thread.start();

		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				verify = false;
			}
		});
	}

	public void moveImageAlien() {

	}

	public void updateAlien(double x, ImageView alienImageView) {
		alienImageView.setLayoutX(x);
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
		count = System.currentTimeMillis();
		if((event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) && ship.getPosX() >= 12) {
			ship.moveLeft();

		}if((event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) && ship.getPosX() <= 462){
			ship.moveRight();

		}if(ship.getShip() == TypeSpacecraft.ATTACK_SHIP) {

			if((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) && currentCount < count-VELOCITY){
				currentCount = count;
				Circle circles = new Circle();
				circles.setLayoutX(positionBallX);
				circles.setLayoutY(positionBallY);
				circles.setRadius(circle.getRadius());
				mainPane.getChildren().add(circles);
				moveBall(circles);
			}

		}else if(ship.getShip() == TypeSpacecraft.RECOGNITION_SHIP) {

			if((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) && currentCount < count-VELOCITYSLOW){
				currentCount = count;
				Circle circles = new Circle();
				circles.setLayoutX(positionBallX);
				circles.setLayoutY(positionBallY);
				circles.setRadius(circle.getRadius());
				mainPane.getChildren().add(circles);
				moveBall(circles);
			}
		}

		mainShip.setLayoutX(ship.getPosX());
	}

	public void moveBall(Circle circles) throws InterruptedException {
		circles.setVisible(true);
		circles.setFill(javafx.scene.paint.Color.RED);
		circles.setLayoutX(ship.getPosX()+40);

		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				verify = false;
			}
		});

		moveBalls(circles);
	}

	public void moveBalls(Circle circles) {

		new Thread() {
			public void run() {
				while(circles.getLayoutY() > -15 && verify) {
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

	@FXML
	public void exportData(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Abrir archivo de recursos");
		File f = fileChooser.showSaveDialog(mainPane.getScene().getWindow());

		if(f != null) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Exportar Jugadores");

			try {
				aliensInvaders.exportData(f.getAbsolutePath());
				alert.setContentText("Los jugadores han sido exportados exitosamente!");
				alert.showAndWait();

			} catch (FileNotFoundException e) {
				alert.setContentText("Los jugadores no han sido exportados");
				alert.showAndWait();
			}
		} 
	}

	@FXML
	public void importData(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Abrir un archivo");
		File f = fileChooser.showOpenDialog(mainPane.getScene().getWindow());

		if(f != null) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Importar Jugadores");

			try {

				aliensInvaders.importData(f.getAbsolutePath());
				alert.setContentText("Los jugadores han sido importados correctamente.");
				alert.showAndWait();

			} catch (IOException e) {
				alert.setContentText("Los jugadores no pudieron ser importados.");
				alert.showAndWait();
			}
		}
	}

	public boolean getVerify() {
		return verify;
	}
}
