package model;

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

	//Character.toString(name.charAt(i)

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

	public void exportData() {

	}

	public void importData() {

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
