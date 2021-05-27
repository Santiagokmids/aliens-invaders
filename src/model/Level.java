package model;

public class Level {
	
	private int aliens;
	
	public Level(int aliens) {
		this.aliens = aliens;
	}
	
	public int getAttackSpeed() {
		return aliens;
	}
	public void setAttackSpeed(int aliens) {
		this.aliens = aliens;
	}
	
}
