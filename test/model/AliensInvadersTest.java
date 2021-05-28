package model;

import org.junit.jupiter.api.Test;

public class AliensInvadersTest {
	
	private AliensInvaders aliensInvaders;
	
	public void setupScenary1() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary2() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary3() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary4() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary5() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary6() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary7() {
		aliensInvaders = new AliensInvaders();
	}
	
	public void setupScenary8() {
		aliensInvaders = new AliensInvaders();
	}
	
	@Test
	public Player searchPlayers(String name) {
		return null;
	}
	
	@Test
	public boolean addPeople(String name) {
		return true;
	}
	
	@Test
	public boolean addPlayer(String nick, int score, int level) {
		return true;
	}
	
	@Test
	public Player searchScore(int score) {
		return null;
	}
	
	@Test
	public boolean removePlayer(String name, int score) {
		return false;
	}
	
	@Test
	public int calculateScore(int score, int level) {
		return 0;
	}
	
	@Test
	public boolean verifyName(String name) {
		return true;
	}
	
	@Test
	public boolean verifyScores(int score) {
		return true;
	}
}
