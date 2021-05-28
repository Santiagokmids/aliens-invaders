package model;

import java.util.ArrayList;

public class AliensInvaders {
	
	private Player first;
	
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
			player = first;
			
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
		return null;
	}
}
