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

public class AliensInvaders implements SearchP, CompareTo, Calculate {

	public final static String SAVE_PATH_FILE_PEOPLE = "data/dataPlayer.txt";

	private Player first;
	private Level normalLevel;
	private Level easyLevel;
	private Level hardLevel;
	private Figures circle;
	private Figures rectangle;

	private static String realName; 

	public AliensInvaders() {
	}

	public Player searchPlayers(String name) {
		return null;
	}

	public boolean addPeople(String name) {
		realName = name;
		return true;
	}

	public boolean addPlayer(String nick, int score, int level) throws FileNotFoundException, IOException {
		loadData();
		realName = "chupapo";
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
						stop = false;

					}else {
						current = current.getPrev();
					}

				}else {
					if(current.getNext() == null) {
						current.setNext(player);
						stop = false;
					}
					else {
						current = current.getNext();
					}
				}
			}
		}
		saveData();
		return false;
	}

	public void isNumeric(String message) throws NumberInNameException {

		boolean verify = true;

		for (int i = 0; i < message.length() && verify; i++) {
			verify = charOneByOne(Character.toString(message.charAt(i)));
		}

		if(!verify) {
			throw new NumberInNameException();
		}
	}

	public boolean charOneByOne(String message) {

		boolean verify = true;

		try {
			Integer.parseInt(message);
			verify = false;
		} catch (NumberFormatException nfe) {
		}

		return verify;
	}

	public Player searchScore(int score) {
		return null;
	}

	public boolean removePlayer(String name, int score) {
		return true;
	}

	public int calculateScore(int score, int level) {
		return 0;
	}

	public boolean verifyName(String name) {
		return true;
	}

	public boolean verifyScores(int score) {
		return true;
	}

	public Player getFirst() {
		return first;
	}

	public void setFirst(Player first) {
		this.first = first;
	}

	public ArrayList<Player> toArrayList() {

		ArrayList<Player> arrayPlayer = new ArrayList<>();

		if(first != null) {

			Player current = first;

			searchPlayers(current, arrayPlayer);

		}
		return arrayPlayer;
	}

	public boolean loadData() {
		boolean verify = true;

		File players = new File(SAVE_PATH_FILE_PEOPLE);

		if(players.exists()){
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(players));
				first = (Player) ois.readObject();

				ois.close();
			}catch(ClassNotFoundException | IOException r) {
				r.printStackTrace();
				verify = false;
			}
		}
		return verify;
	}

	public void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PEOPLE));
		oos.writeObject(first);

		oos.close();
	}

	public void exportData(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName+".txt");
		String message = searchPlayers(first);
		pw.println(message);
		pw.close();
	}

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

	public void importData(String fileName) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();

		while(line != null) {

			String[] parts = line.split(",");

			try {
				int score = Integer.parseInt(parts[1]);
				int level = Integer.parseInt(parts[2]);
				addPlayer(parts[0], score, level);
				line = br.readLine();

			}catch (NumberFormatException nfe) {
				line = br.readLine();
			}
		}
		br.close();
	}

	@Override
	public int calculate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public People searchP() {
		// TODO Auto-generated method stub
		return null;
	}
}
