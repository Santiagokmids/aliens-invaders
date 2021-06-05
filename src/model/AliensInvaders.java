package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import exceptions.NumberInNameException;

public class AliensInvaders implements SearchP, CompareTo, Calculate {

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

	public boolean addPlayer(String nick, int score, int level) {
		Player player = new Player(realName, nick,score,level);

		if(first == null) {
			first = player;

		}else {
			boolean stop = true;
			Player current = first;

			while(stop) {
				if(current.getNext() != null) {
					current.getNext();

				}else {
					current.setNext(player);
					stop = false;
				}
			}
		}
		return true;
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

		boolean verify = true;

		ArrayList<Player> arrayPlayer = new ArrayList<>();

		if(first != null) {

			arrayPlayer.add(first);

			Player current = first;

			while(verify) {

				if(current.getNext() != null) {
					arrayPlayer.add(current.getNext());
					current = current.getNext();
				}else {
					verify = false;
				}
			}
		}
		return arrayPlayer;
	}

	public boolean loadData() {
		return true;
	}

	public void saveData() {

	}

	public void exportData(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		String message = searchPlayers(first);
		pw.println(message);
		pw.close();
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
			} catch (NumberFormatException nfe) {
				
			}

			br.close();
		}
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
