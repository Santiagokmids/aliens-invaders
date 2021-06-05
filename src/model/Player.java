package model;

import java.io.Serializable;

public class Player extends People implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	private String nick;
	private int score;
	private int level;
	private Player prev;
	private Player next;
	
	public Player(String name, String nick,int score, int level) {
		super(name);
		this.setNick(nick);
		this.setScore(score);
		this.setLevel(level);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}

	public Player getPrev() {
		return prev;
	}

	public void setPrev(Player prev) {
		this.prev = prev;
	}
	
	public String toString() {
		String message = "";
		
		message = "Nickname: "+nick+" | Score : "+score+" | Level "+ level+"\n";
		
		return message;
	}
}
