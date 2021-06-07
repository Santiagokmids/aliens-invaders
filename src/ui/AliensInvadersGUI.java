package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.NumberInNameException;
import exceptions.SpaceInNickException;
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
import javafx.scene.control.Label;
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
import thread.BubbleSearchThread;
import thread.BubbleThread;
import thread.InsertionThread;
import thread.SelectionSearchThread;
import thread.SelectionThread;
import thread.SearchAlienThread;

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
	private TableColumn<Player, String> tcNick;

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
	private TextField searchByScore;

	@FXML
	private ComboBox<String> comboBoxDificult;

	@FXML
	private ComboBox<String> comboBoxSorting;

	@FXML
	private TextField searchByName;

	@FXML
	private Label scoreOver;

	@FXML
	private Label level;

	@FXML
	private Label score;

	private Stage window;

	private boolean verify;

	private int velocityLevel;

	private AliensInvaders aliensInvaders;

	public ObservableList<Player> listPlayer;

	private Spacecraft ship;

	private Alien firstAlien;

	private double positionBallX;

	private double positionBallY;

	private int scores;

	private int levels;

	private double ballInMoveX;

	private double ballInMoveY;

	private int shootAliens;

	private Circle currentCircle;

	private long count;

	private boolean knowShoot;

	private long currentCount;

	public final static int POSTITIONALIENTX = 79;

	public final static int POSTITIONALIENTY = 62;

	public final static int NUMBERALIENS = 5;

	public final static int VELOCITY = 1000;

	public final static int VELOCITYSLOW = 2600;

	public final static String COMBOBOX = "Ordenar por: ";

	public final static String A = "Puntaje";
	public final static String B = "NickName/Puntaje";
	public final static String C = "Nivel/Puntaje";
	public final static String D = "NickName/Nivel";

	public AliensInvadersGUI(AliensInvaders aliensInvaders, Stage stage) {
		this.aliensInvaders = aliensInvaders;
		window = stage;
	}

	public void inicializateTableViewPlayer(ArrayList<Player> arrayListPlayers) { 

		listPlayer = FXCollections.observableArrayList(arrayListPlayers);

		tvHall.setItems(listPlayer);
		tcName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		tcNick.setCellValueFactory(new PropertyValueFactory<Player,String>("nick"));
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
		firstAlien = null;
		ballInMoveX = 0;
		ballInMoveY = 0;
		knowShoot = false;
		scores = 0;
		levels = 1;
		shootAliens = 0;
		velocityLevel = 200;
	}

	@FXML
	public void btnStartGame(ActionEvent event) throws IOException {

		if(txtRealName.getText().isEmpty()) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se puede continuar");
			alert.setContentText("Necesita ingresar un nombre para continuar");
			alert.showAndWait();
		}else {

			String name = txtRealName.getText();

			try {
				aliensInvaders.addPeople(name);

				FXMLLoader loader = new FXMLLoader(getClass().getResource("selectShip-pane.fxml"));

				aliensInvaders.addPeople(txtRealName.getText());

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

				comboBoxDificult.setPromptText("Dificultad");

				comboBoxDificult.getItems().addAll("Novato","Cadete","Leyenda");
				
			} catch (NumberInNameException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se puede continuar");
				alert.setContentText("El nombre no puede contener numeros");
				alert.showAndWait();

				txtRealName.setText("");
			}

		}
	}

	@FXML
	void bottonShip1(MouseEvent event) throws IOException {

		if(comboBoxDificult.getValue() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se puede continuar");
			alert.setContentText("Debe selecionar una dificultad");
			alert.showAndWait();
		}else {

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

			createMatrix(POSTITIONALIENTX, POSTITIONALIENTY);
			level.setText(String.valueOf(levels));
		}
	}

	@FXML
	void bottonShip2(MouseEvent event) throws IOException {

		if(comboBoxDificult.getValue() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se puede continuar");
			alert.setContentText("Debe selecionar una dificultad");
			alert.showAndWait();
		}else {

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

			createMatrix(POSTITIONALIENTX, POSTITIONALIENTY);
			level.setText(String.valueOf(levels));
		}
	}

	public void createMatrix(int x, int y) {

		Image image1 = new Image("images/firstAlien.png");
		Image image2 = new Image("images/secondAlien.png");

		int contX = -79;
		int contY = 62;
		int i = 0;

		if(firstAlien == null) {
			firstAlien = new Alien(x, y, contX, contY, image1, image2);
			moveAlien(firstAlien);
			createMatrix(x, y);
		}else {
			createMatrix(x, y, contX, contY+100, image1, image2, firstAlien, i);
		}
	}

	public void createMatrix(int x, int y, int contX, int contY, Image image1, Image image2, Alien current, int i) {

		Alien alien = new Alien(POSTITIONALIENTX, POSTITIONALIENTY, contX, contY, image1, image2);

		if(current != null && current.getDown() == null && i < NUMBERALIENS-1) {

			moveAlien(alien);
			current.setDown(alien);
			current.getDown().setUp(current);
			createMatrix(x, y, contX+100, contY-100, image1, image2, current, i);

		}else if(current != null && current.getNext() == null && i < NUMBERALIENS){

			moveAlien(alien);
			current.setNext(alien);
			current.getNext().setPrev(current);
			createMatrix(x, y, contX, contY+100, image1, image2, current.getNext(), ++i);

		}
	}

	public void moveAlien(Alien alien) {

		ImageView alienImageView = new ImageView();

		alienImageView.setImage(alien.getImageOne());

		mainPane.getChildren().add(alienImageView);

		alienImageView.setFitWidth(alien.getX());
		alienImageView.setFitHeight(alien.getY());

		alienImageView.setLayoutX(alien.getPositionX());
		alienImageView.setLayoutY(alien.getPositionY());

		AlienThread thread = new AlienThread(this, alien, alienImageView, verify,velocityLevel);

		thread.start();

		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				verify = false;
			}
		});
	}

	public void updateAlien(double y, double x, ImageView alienImageView) {
		alienImageView.setLayoutX(x);
		alienImageView.setLayoutY(y);
	}

	public void validationPosition(Alien alien, ImageView alienImageView) throws IOException {

		if(alien.getPositionY() >= window.getHeight()-105 && alienImageView.isVisible()) {
			verify = false;
			gameOver();
		}
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

		comboBoxSorting.setPromptText(COMBOBOX);

		comboBoxSorting.getItems().addAll(A,B,C,D);

		inicializateTableViewPlayer(aliensInvaders.toArrayList());
	}

	@FXML
	public void gameOver() throws IOException {

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

		scoreOver.setText(String.valueOf(scores));
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

	public void loadPlayers(ActionEvent event) throws IOException{

		if(nickName.getText().isEmpty()) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se puede continuar");
			alert.setContentText("Necesita ingresar un nickname para continuar");
			alert.showAndWait();
			
		}else {
			
			try {
				
				int scores = 0;
				int levels = 0;
				try {
					
					scores = Integer.parseInt(score.getText());
					levels = Integer.parseInt(level.getText());
					
				} catch (NumberFormatException e) {
				}
				
				aliensInvaders.spaceIn(nickName.getText());
				
				aliensInvaders.addPlayer(nickName.getText(), scores, levels);
				loadBanner();
				
			} catch (SpaceInNickException e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se puede continuar");
				alert.setContentText("El nickname no puede contener espacios");
				alert.showAndWait();

				nickName.setText("");
			}
		}
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
				knowShoot = true;
				circles.setLayoutX(positionBallX);
				circles.setLayoutY(positionBallY);
				circles.setRadius(circle.getRadius());
				mainPane.getChildren().add(circles);
				moveBall(circles);
			}

		}else if(ship.getShip() == TypeSpacecraft.RECOGNITION_SHIP) {

			if((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) && currentCount < count-VELOCITYSLOW){
				currentCount = count;
				knowShoot = true;
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
							currentCircle = circles;
							ballInMoveX = circles.getLayoutX();
							ballInMoveY = circles.getLayoutY();
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

	public void searchAlien(double x, double y, ImageView image) {
		SearchAlienThread alien = new SearchAlienThread(this,firstAlien, x, y, ballInMoveX, ballInMoveY, image,verify,knowShoot,currentCircle);
		alien.start();

	}

	public void setScores(int aliens) {
		shootAliens += aliens;
		scores += 5;
		score.setText(String.valueOf(scores));
	}

	public void setLevels() {
		if(shootAliens == 10){
			levels += 1;
			level.setText(String.valueOf(levels));
			createMatrix(POSTITIONALIENTX, POSTITIONALIENTY);
			velocityLevel += 100;
		}
	}

	public int getVelocity() {
		return velocityLevel;
	}

	public void setImage(ImageView image) {
		image.setVisible(false);
	}

	public void setCircle(Circle circ) {
		circ.setVisible(false);
	}

	public double getBallInMoveX() {
		return ballInMoveX;
	}

	public void setBallInMoveX(double ballInMoveX) {
		this.ballInMoveX = ballInMoveX;
	}

	public double getBallInMoveY() {
		return ballInMoveY;
	}

	public void setBallInMoveY(double ballInMoveY) {
		this.ballInMoveY = ballInMoveY;
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
	public void importData(ActionEvent event) throws SpaceInNickException {

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
		inicializateTableViewPlayer(aliensInvaders.toArrayList());
	}

	public void exportData() {

	}

	public void importData() {

	}

	public boolean getVerify() {
		return verify;
	}

	@FXML
	public void searchPlayer(ActionEvent event) throws InterruptedException {

		if(searchByScore.getText().isEmpty() && searchByName.getText().isEmpty()) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("No se pudo eliminar el jugador");
			alert.setContentText("Tiene que ingreasar uno de los dos campos.");
			alert.showAndWait();
			searchByScore.setText("");
		}else if(!searchByScore.getText().isEmpty() && !searchByName.getText().isEmpty()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("No se pudo buscar el jugador");
			alert.setContentText("Ingrese solo unos de los dos campos.");
			alert.showAndWait();
			searchByScore.setText("");
		}else if(!searchByScore.getText().isEmpty() && searchByName.getText().isEmpty()) {

			long start = System.nanoTime();
			String message = selectionSort(searchByScore.getText()).getMessage();
			long end = System.nanoTime();

			if(message.isEmpty()) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("No se encontró el jugador");
				alert.setContentText("El jugador que está buscando no se encuentra en el hall of fame");
				alert.showAndWait();
				searchByName.setText("");
				searchByScore.setText("");
			}
			else {

				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setHeaderText("Búsqueda realizada en "+(end-start)+" nanosegundos");
				alert1.setContentText("Jugador encontrado: \n"+message);
				alert1.showAndWait();

				searchByName.setText("");
				searchByScore.setText("");
			}
		}
		else if(searchByScore.getText().isEmpty() && !searchByName.getText().isEmpty()){

			long start = System.nanoTime();
			String message = bubbleSort(searchByName.getText()).getMessage();
			long end = System.nanoTime();

			if(message.isEmpty()) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("No se encontró el jugador");
				alert.setContentText("El jugador que está buscando no se encuentra en el hall of fame");
				alert.showAndWait();
				searchByName.setText("");
				searchByScore.setText("");
			}
			else {

				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setHeaderText("Búsqueda realizada en "+(end-start)+" nanosegundos");
				alert1.setContentText("Jugador encontrado: \n"+message);
				alert1.showAndWait();

				searchByName.setText("");
				searchByScore.setText("");
			}
		}
	}

	@FXML
	public void removePlayer(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException {

		if(searchByScore.getText().isEmpty() && searchByName.getText().isEmpty() || !searchByScore.getText().isEmpty() && searchByName.getText().isEmpty() || searchByScore.getText().isEmpty() && !searchByName.getText().isEmpty()) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("No se pudo eliminar el jugador");
			alert.setContentText("Tiene que ingresar los dos campos.");
			alert.showAndWait();
			searchByScore.setText("");
		}else if(!searchByScore.getText().isEmpty() && !searchByName.getText().isEmpty()) {

			Player player = aliensInvaders.removePlayer(searchByName.getText(), searchByScore.getText());

			if(player == null) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("No se encontró el jugador");
				alert.setContentText("El jugador que está buscando no se encuentra en el hall of fame");
				alert.showAndWait();
				searchByName.setText("");
				searchByScore.setText("");
			}else {

				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setHeaderText("Se ha eliminado a: ");
				alert1.setContentText(player.toString());
				aliensInvaders.removePlayer(player);
				alert1.showAndWait();

				searchByName.setText("");
				searchByScore.setText("");
			}
		}
	}


	public boolean getKnowShoot() {
		return knowShoot;
	}

	public void setKnowShoot(boolean knowShoot) {
		this.knowShoot = knowShoot;
	}

	public BubbleSearchThread bubbleSort(String nick) throws InterruptedException{

		BubbleSearchThread bubbleThread = new BubbleSearchThread(aliensInvaders, aliensInvaders.toArrayList(), nick);

		bubbleThread.start();

		bubbleThread.join();

		return bubbleThread;
	}

	public SelectionSearchThread selectionSort(String score) throws InterruptedException{

		SelectionSearchThread selectionThread = new SelectionSearchThread(aliensInvaders, aliensInvaders.toArrayList(), score);

		selectionThread.start();

		selectionThread.join();

		return selectionThread;
	}

	@FXML
	void sortComboBox(ActionEvent event) {

		if(comboBoxSorting.getValue() == A) {

			tvHall.refresh();
			inicializateTableViewPlayer(aliensInvaders.toArrayList());

		}else if(comboBoxSorting.getValue() == B) {

			InsertionThread insertionThread = new InsertionThread(this, aliensInvaders.toArrayList());

			insertionThread.start();

		}else if(comboBoxSorting.getValue() == C) {

			SelectionThread selectionThread = new SelectionThread(this, aliensInvaders.toArrayList());

			selectionThread.start();

		}else if(comboBoxSorting.getValue() == D) {

			BubbleThread bubbleThread = new BubbleThread(this, aliensInvaders.toArrayList());

			bubbleThread.start();	
		}
	}
}
