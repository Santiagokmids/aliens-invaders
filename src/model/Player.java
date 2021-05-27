package model;

public class Player extends People{
	
	private String nick;
	private int score;
	private int level;
	
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
	
	
}
