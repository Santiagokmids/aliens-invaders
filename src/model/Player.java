package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class Player extends People{
	
	private String nick;
	private int score;
	private int level;
	private Player prev;
	private Player next;
	
	/**
	 * <b>name:</b> Player. <br>
	 * Create an object player. <br>
	 * <b>post:</b> An object player has created. <br>
	 * @param name is the name of the player. name != "" y name != null.
	 * @param nick is the nick name of the player in the game. nick != "" y nick != null.
	 * @param score is the score of a player in the game. score != null.
	 * @param level is the level of the game the player arrived at. level != null.
	 */
	
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
	
	/**
	 * <b>name:</b> toString. <br>
	 * Create a message with the specification of the player. <br>
	 * <b>post:</b> A message with the specification of the player has been created.
	 */
	
	public String toString() {
		String message = "";
		
		message = nick+"-"+score+"-"+ level;
		
		return message;
	}
}
