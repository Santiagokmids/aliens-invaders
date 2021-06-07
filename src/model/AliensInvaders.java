package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import exceptions.NumberInNameException;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class AliensInvaders implements SearchP, Calculate {

	public final static String SAVE_PATH_FILE_PEOPLE = "data/dataPlayer.txt";

	private Player first;
	//private Level normalLevel;
	//private Level easyLevel;
	//private Level hardLevel;

	private static String realName; 

	/**
	 * <b>name:</b> AliensInvaders. <br>
	 * Create an object aliensInvaders. <br>
	 * <b>post:</b> An object aliensInvaders has created.
	 */

	public AliensInvaders() {
	}

	/**
	 * <b>name:</b> searchPlayers. <br>
	 * Search a player. <br>
	 * <b>post:</b> A player has searched. <br>
	 * @param name is the name of the player to search. name != "" y name. != null.
	 * @return <code>Player</code> specifying player is the player that has searched.
	 */

	public Player searchPlayers(String name) {
		return null;
	}

	/**
	 * <b>name:</b> addPeople. <br>
	 * Add an object people into the program. <br>
	 * <b>post:</b> An object people has been added into the program. <br>
	 * @param name is the name of the new people. name != "" y name != null.
	 * @return <code>boolean</code> specifying verify is the result of the process.  
	 */

	public boolean addPeople(String name) {
		boolean good = false;
		
		try {
			isNumeric(name);
			realName = name;
			good = true;
			
		} catch (NumberInNameException e) {

		}
		
		return good;
	}

	/**
	 * <b>name:</b> addPlayer. <br>
	 * Add an object player into the program. <br>
	 * <b>post:</b> An object player has been added into the program. <br>
	 * @param nick is the nick name of the player. nick != "" y nick != null.
	 * @param score is the score of a player. score != null.
	 * @param level is the level of the game the player arrived at. level != null.
	 * @return <code><boolean</code> specifying verify is the result of the process.
	 */

	public void addPlayer(String nick, int score, int level) throws FileNotFoundException, IOException {
		loadData();

		Player player = new Player(realName, nick,score,level);

		if(first == null) {
			first = player;

		}else {
			boolean stop = true;
			Player current = first;

			while(stop) {

				if(player.getScore() < current.getScore()) {

					if(current.getPrev() == null) {
						current.setPrev(player);
						player.setParent(current);
						stop = false;

					}else {
						current = current.getPrev();
					}

				}else {
					if(current.getNext() == null) {
						current.setNext(player);
						player.setParent(current);
						stop = false;
					}
					else {
						current = current.getNext();
					}
				}
			}
		}
		saveData();
	}

	/**
	 * <b>name:</b> isNumeric. <br>
	 * Convert all the parts of the string into a single char. <br>
	 * <b>post:</b> The string has been converted into a single char. <br> 
	 * @param message is the message to convert. message != "" y message != null.
	 * @throws NumberInNameException <br>
	 *         thrown if an exception produced by convert a string in integer.			
	 */

	public void isNumeric(String message) throws NumberInNameException {

		boolean verify = true;

		for (int i = 0; i < message.length() && verify; i++) {
			verify = charOneByOne(Character.toString(message.charAt(i)));
		}

		if(!verify) {
			throw new NumberInNameException();
		}
	}

	/**
	 * <b>name:</b> charOneByOne. <br>
	 * Verify if a string is a number. <br>
	 * <b>post:</b> The verification if a string is a number has made. <br>
	 * @param message is the string to verify. message != null.
	 * @return <code>boolean</code> specifying verify is the result of the process.
	 */

	public boolean charOneByOne(String message) {

		boolean verify = true;

		try {
			Integer.parseInt(message);
			verify = false;
		} catch (NumberFormatException nfe) {
		}

		return verify;
	}

	/**
	 * <b>name:</b> calculateScore. <br>
	 * Calculate the score of a player. <br>
	 * <b>post:</b> The score of a player has been calculated. <br>
	 * @param score is the initial score of a player. score != null.
	 * @param level is the level of a player arrive. level != null.
	 * @return <code>int</code> specifying score is the final score. 
	 */

	public int calculateScore(int score, int level) {
		return 0;
	}

	/**
	 * <b>name:</b> verifyScores. <br>
	 * Verify the score of a player. <br>
	 * <b>post:</b> The score of a player has been check. <br>
	 * @param score is the score of a player. score != null.
	 * @return <code>boolean</code> specifying verify is the result of the process.
	 */

	public boolean verifyScores(int score) {
		return true;
	}

	public Player getFirst() {
		return first;
	}

	public void setFirst(Player first) {
		this.first = first;
	}

	/**
	 * <b>name:</b> toArrayList. <br>
	 * Convert the players into an arraylist. <br>
	 * <b>post:</b> The player has converted. <br>
	 * @return <code>ArrayList<Player> </code> specifying arrayPLayer is the arraylist of players.
	 */

	public ArrayList<Player> toArrayList() {

		ArrayList<Player> arrayPlayer = new ArrayList<>();

		if(first != null) {

			Player current = first;

			searchPlayers(current, arrayPlayer);

		}
		return arrayPlayer;
	}

	/**
	 * <b>name:</b> loadData. <br>
	 * Load the information of a player from a file. <br>
	 * <b>post:</b> The information of a player from a file has loaded.
	 * @return <code>boolean</code> specifying verify is the result of the process.
	 */

	public boolean loadData() {
		boolean verify = true;

		File players = new File(SAVE_PATH_FILE_PEOPLE);

		if(players.exists()){

			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(players));
				first = (Player) ois.readObject();

				ois.close();
			}catch(ClassNotFoundException | IOException r) {
				verify = false;
			}
		}
		return verify;
	}

	/**
	 * <b>name:</b> saveData. <br>
	 * Save the information of the program. <br>
	 * <b>post:</b> The information of the program has saved. <br>
	 */

	public void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PEOPLE));
		oos.writeObject(first);

		oos.close();
	}

	/**
	 * <b>name:</b> exportData. <br>
	 * Export the information of the players. <br>
	 * <b>post:</b> The information of the players has been exported. <br>
	 * @param fileName is the name of the URL for the file. fileName != "" y fileName != null. 
	 * @throws FileNotFoundException <br>
	 *         thrown if exception produced by not found the file.
	 */

	public void exportData(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName+".txt");
		String message = searchPlayers(first);
		pw.println(message);
		pw.close();
	}

	/**
	 * <b>name:</b> searchPlayers. <br>
	 * Convert the information of the players into a message. <br>
	 * <b>post:</b> The information of the players has converted into a message. <br>
	 * @param player is the name of the root player. player != null.  
	 * @return <code>String</code> specifying message is the message with the information of the players.
	 */

	public void searchPlayers(Player player, ArrayList<Player> arrayPlayer) {

		if(player != null) {
			searchPlayers(player.getPrev(),arrayPlayer);
			arrayPlayer.add(player);
			searchPlayers(player.getNext(),arrayPlayer);
		}
	}

	public String searchPlayers(Player player) {
		String message = "";

		if(player != null) {
			message += searchPlayers(player.getPrev());
			message += player.toString();
			message += searchPlayers(player.getNext());
		}
		return message;
	}

	/**
	 * <b>name:</b> importData. <br>
	 * Import the information of players. <br>
	 * <b>post:</b> The information of the players has been imported. <br>
	 * @param fileName is the name of the URL for the file. fileName != "" y fileName != null.
	 * @throws IOException <br>
	 *         thrown if an exceptions produced by failed or interrupted I/O operations.
	 */

	public void importData(String fileName) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();

		while(line != null) {

			String[] parts = line.split(",");
			
			try {
				int score = Integer.parseInt(parts[2]);
				int level = Integer.parseInt(parts[3]);
				realName = parts[0];
				addPlayer(parts[1], score, level);
				line = br.readLine();

			}catch (NumberFormatException nfe) {
				line = br.readLine();
			}
		}
		br.close();
	}


	/**
	 * <b>name:</b> calculate. <br>
	 * Calculate the score of a player. <br>
	 * <b>post:</b> The score of a player has been calculated. <br>
	 * @return <code>int</code> specifying calculated is the score of the player.
	 */

	@Override
	public int calculate() {
		return 0;
	}



	/**
	 * <b>name:</b> searchP. <br>
	 * Search a player. <br>
	 * <b>post:</b> A player has searched. <br>
	 * @return <code>People</code> specifying people is the player that has searched.
	 */

	public String binarySearchByScore(ArrayList<Player> newList, String toSearch) {

		ArrayList<Player> listPlayers = newList;
		Player player = null;

		String message = "";

		int pos = -1;
		int i = 0;
		int j = listPlayers.size()-1;

		while(i <= j && pos < 0) {
			int m = (i+j)/2;

			if(listPlayers.get(m).compare(toSearch) == 0) {
				pos = m;

				player = listPlayers.get(pos);
				
				if(player != null) {
					message += player.toString();
					newList.remove(pos);
					message += binarySearchByScore(newList, toSearch);
				}
			}
			else if(listPlayers.get(m).compare(toSearch) > 0) {
				j = m-1;
			}
			else {
				i = m+1;
			}
		}
		return message;
	}

	public String binarySearchByName(ArrayList<Player> newList, String nick) {

		ArrayList<Player> listPlayers = newList;

		String message = "";

		int pos = -1;
		int i = 0;
		int j = listPlayers.size()-1;
		Player player = null;

		while(i <= j && pos < 0) {
			int m = (i+j)/2;

			if(listPlayers.get(m).compareTo(nick) == 0) {
				pos = m;

				player = listPlayers.get(pos);
				message += player.toString();

				if(player != null) {
					message += binarySearchByScore(newList, nick);
				}
			}
			else if(listPlayers.get(m).compareTo(nick) > 0) {
				j = m-1;
			}
			else {
				i = m+1;
			}
		}
		return message;
	}

	@Override
	public Player searchP(String toSearch) {
		return null;
	}
	
	public Player removePlayer(String nick, String score) {
		
		ArrayList<Player> listPlayer = toArrayList();
		boolean verify = false;
		int playerScore = 0;
		Player player = null;
		
		try {
			playerScore = Integer.parseInt(score);
		} catch (NumberFormatException e) {
		}
		
		for (int i = 0; i < listPlayer.size() && !verify; i++) {
			
			if(listPlayer.get(i).getNick().equals(nick) && listPlayer.get(i).getScore() == playerScore) {
				verify = true;
				player = listPlayer.get(i); 
			}
		}
		
		return player;
	}

	public void removePlayer(Player player){

		if(player.getPrev() == null && player.getNext() == null){

			if(player == first){
				first = null;

			}else if(player.getParent() != null && player == player.getParent().getPrev()) {
				player.getParent().setPrev(null);

			}else{
				player.getParent().setNext(null);    		
			}
			player.setParent(null);

		}else if(player.getPrev() == null || player.getNext() == null){

			Player onlyChild;

			if(player.getPrev()!=null){
				onlyChild = player.getPrev();
				player.setNext(null);

			}else{
				onlyChild = player.getNext();
				player.setNext(null);
			}

			onlyChild.setParent(player.getParent());

			if(player == first){
				first = onlyChild;

			}else if(player == player.getParent().getPrev()){
				player.getParent().setPrev(onlyChild);

			}else{
				player.getParent().setNext(onlyChild);    		
			}
			player.setParent(null);

		}else{ 
			Player successor = min(player.getNext());

			player.setName(successor.getName());
			player.setNick(successor.getNick());
			player.setScore(successor.getScore());
			player.setLevel(successor.getLevel());

			removePlayer(successor);
		}
	}

	private Player min(Player current){
		if(current.getPrev() != null){
			return min(current.getPrev());

		}else{
			return current;
		}
	}

	public void shootMonster(){

	}
}
