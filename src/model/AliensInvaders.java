package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import exceptions.NumberInNameException;
import exceptions.SpaceInNickException;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class AliensInvaders implements BinarySearch, Calculate, CompareTwoPlayers {

	public final static String SAVE_PATH_FILE_PEOPLE = "data/dataPlayer.txt";

	private Player first;
	private Player firstBest;
	private String realName;

	/**
	 * <b>name:</b> AliensInvaders. <br>
	 * Create an object aliensInvaders. <br>
	 * <b>post:</b> An object aliensInvaders has created.
	 */

	public AliensInvaders() {
	}

	/**
	 * <b>name:</b> addPeople. <br>
	 * Add an object people into the program. <br>
	 * <b>post:</b> An object people has been added into the program. <br>
	 * @param name is the name of the new people. name != "" y name != null.
	 * @return <code>boolean</code> specifying verify is the result of the process.  
	 * @throws NumberInNameException 
	 */

	public void addPeople(String name) throws NumberInNameException {
		isNumeric(name);
		realName = name;
	}

	/**
	 * <b>name:</b> addPlayer. <br>
	 * Add an object player into the program. <br>
	 * <b>post:</b> An object player has been added into the program. <br>
	 * @param nick is the nick name of the player. nick != "" y nick != null.
	 * @param score is the score of a player. score != null.
	 * @param level is the level of the game the player arrived at. level != null.
	 * @return <code><boolean</code> specifying verify is the result of the process.
	 * @throws SpaceInNickException 
	 */

	public void addPlayer(String nick, int score, int level) throws FileNotFoundException, IOException, SpaceInNickException {

		spaceIn(nick);

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
	 * <b>name:</b> spaceIn. <br>
	 * Search a space in the message. <br>
	 * <b>post:</b> The spaces in the message has been searched. <br>
	 * @param message is the string of the nick of a player. message != "" y message != null.
	 * @throws SpaceInNickException <br>
	 *         thrown if a exception produced by a space in the name.      
	 */

	public void spaceIn(String message) throws SpaceInNickException{


		boolean verify = true;

		for (int i = 0; i < message.length() && verify; i++) {

			if(Character.toString(message.charAt(i)).equals(" ")) {
				verify = false;
				throw new SpaceInNickException();
			}
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

	/**
	 * <b>name:</b> searchPlayers. <br>
	 * Create a message with the information of all the players. <br>
	 * <b>post:</b> A message with the information of all the players has been created. <br>
	 * @param player is an object player to find his information.
	 * @return <code>String</code> specifying message is the String with all the information.
	 */

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
	 * <b>name:</b> calculate. <br>
	 * Calculate the score of a player. <br>
	 * <b>post:</b> The score of a player has been calculated. <br>
	 * @return <code>int</code> specifying calculated is the score of the player.
	 */

	@Override
	public int calculate(int score, int level) {

		int scores = score+(level*10);

		return scores;
	}

	/**
	 * <b>name:</b> binarySearch. <br>
	 * Search a player by the nick. <br>
	 * <b>post:</b> A player has been searched by the nick. <br>
	 * @param newList is the list of the players. 
	 * @param nick is the nick of the player to search.
	 * @return <code>String</code> specifying message is the String with the information of the player.
	 */

	@Override
	public String binarySearch(ArrayList<Player> newList, String toSearch) {

		ArrayList<Player> listPlayers = newList;
		Player player = null;

		String message = "";

		int pos = -1;
		int i = 0;
		int j = listPlayers.size()-1;

		while(i <= j && pos < 0) {
			int m = (i+j)/2;

			if(listPlayers.get(m).compareTo(toSearch) == 0) {
				pos = m;

				player = listPlayers.get(pos);

				if(player != null) {
					message += player.toString();
					newList.remove(pos);
					message += binarySearch(newList, toSearch);
				}
			}
			else if(listPlayers.get(m).compareTo(toSearch) > 0) {
				j = m-1;
			}
			else {
				i = m+1;
			}
		}

		return message;
	}

	/**
	 * <b>name:</b> removePlayer. <br>
	 * Search a player by the nick and the score. <br>
	 * <b>post:</b> A player has been searched by the name and the score. <br>
	 * @param nick is the String of the nick of the player to search.
	 * @param score is the String of the score of the player to search.
	 * @return <code>Player</code> specifying player is the player searched.
	 */

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

	/**
	 * <b>name:</b> removePlayer. <br>
	 * Remove a player from the binary tree. <br>
	 * <b>post:</b> A player has been removed from the binary tree. <br>
	 * @param player is the player to eliminate.
	 */

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

	/**
	 * <b>name:</b> min. <br>
	 * Search the minor player in the binary tree. <br>
	 * <b>post:</b> The minor player in the binary tree has been searched. <br>
	 * @param current is the player to compare.
	 * @return <code>Player</code> specifying is the min player.
	 */

	private Player min(Player current){
		if(current.getPrev() != null){
			return min(current.getPrev());

		}else{
			return current;
		}
	}

	public ArrayList<Player> searchPodium() {

		boolean stop = false;
		Player player = null;
		int cont = 2;
		Player current = null;
		int verify = 0;
		
		ArrayList<Player> newlist = new ArrayList<>();

		ArrayList<Player> listPlayer = toArrayList();

		if(!listPlayer.isEmpty() && listPlayer.get(listPlayer.size()-1) != null) {
			firstBest = new Player(listPlayer.get(listPlayer.size()-1).getName(), listPlayer.get(listPlayer.size()-1).getNick(), listPlayer.get(listPlayer.size()-1).getScore(), listPlayer.get(listPlayer.size()-1).getLevel());
			current = firstBest;
			newlist.add(firstBest);
		}

		while(cont <= 5 && !listPlayer.isEmpty()) {

			stop = true;

			while(stop  && listPlayer.size() > (cont-1) && listPlayer.get(listPlayer.size()-cont) != null && verify != cont-1) {
				
				player = new Player(listPlayer.get(listPlayer.size()-cont).getName(), listPlayer.get(listPlayer.size()-cont).getNick(), listPlayer.get(listPlayer.size()-cont).getScore(), listPlayer.get(listPlayer.size()-cont).getLevel());

				verify = cont-1;
				
				newlist.add(player);
				
				if(compareTwoPlayers(player, current) < 0) {

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
			
			cont++;
		}

		return newlist;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public int compareTwoPlayers(Player playerOne, Player playerTwo) {

		int verify = 0;

		if(playerOne.getScore() > playerTwo.getScore()) {
			verify = 1;
		}else if(playerOne.getScore() < playerTwo.getScore()) {
			verify = -1;
		}

		if(verify == 0) {
			if(playerOne.getLevel() == playerTwo.getLevel()) {
				verify = 0;
			}else if(playerOne.getLevel() > playerTwo.getLevel()){
				verify = 1;
			}else if(playerOne.getLevel() < playerTwo.getLevel()) {
				verify = -1;
			}
		}

		return 0;
	}
}
