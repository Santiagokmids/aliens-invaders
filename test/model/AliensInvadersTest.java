package model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.NumberInNameException;
import exceptions.SpaceInNickException;
import thread.SelectionSearchThread;
import ui.AliensInvadersGUI;

public class AliensInvadersTest {
	
	private static AliensInvaders aliensInvaders;
	
	public void setupScenary1() {
		aliensInvaders = new AliensInvaders();
	}
	
	
	public void setupScenary2() throws NumberInNameException {
		
		aliensInvaders = new AliensInvaders();
		
		String realName = "Santiago";
		
		aliensInvaders.addPeople(realName);
	}
	
	public void setupScenary3() {
		
		aliensInvaders = new AliensInvaders();
		
		String score = "33";
		
		SelectionSearchThread newThread = SelectionSearchThread(aliensInvaders, aliensInvaders.toArrayList(), score);
	}
	
	/*
	@Test
	public void searchPlayers(String name) {
	}
	*/
	
	@Test
	public void testAddPeople() throws NumberInNameException {
		
		setupScenary1();
		
		String name = "Carlos Jose";
		
		String beforeName = aliensInvaders.getRealName();
		
		aliensInvaders.addPeople(name);
		
		String afterName = aliensInvaders.getRealName();
		
		assertNotEquals(beforeName, afterName);
	}
	
	@Test
	public void testAddPeople2() throws NumberInNameException {
		
		setupScenary1();
		
		String name = "Santiago";
		
		String beforeName = aliensInvaders.getRealName();
		
		aliensInvaders.addPeople(name);
		
		String afterName = aliensInvaders.getRealName();
		
		assertNotEquals(beforeName, afterName);
	}
	
	@Test
	public void testAddPeople3() {
		
		setupScenary1();
		
		boolean verify = true;
		
		String name = "Jesus666";
		
		try {
			aliensInvaders.addPeople(name);
		} catch (NumberInNameException e) {
			verify = false;
		}
		
		assertFalse(verify);
	}
	
	@Test
	public void testAddPeople4() {
		
		setupScenary1();
		
		boolean verify = true;
		
		String name = "Ana 2";
		
		try {
			aliensInvaders.addPeople(name);
		} catch (NumberInNameException e) {
			verify = false;
		}
		
		assertFalse(verify);
	}
	
	@Test
	public void testAddPlayer() throws FileNotFoundException, IOException, SpaceInNickException, NumberInNameException {
		
		setupScenary2();
		
		String nick = "Jesus666";
		int score = 62;
		int level = 4;
		
		aliensInvaders.addPlayer(nick, score, level);
		
		ArrayList<Player> players = aliensInvaders.toArrayList();
		
		assertEquals(1, players.size());
		
		Player playerTest = players.get(0);
		
		assertEquals(aliensInvaders.getRealName(), playerTest.getName());
		assertEquals(nick, playerTest.getNick());
		assertEquals(score, playerTest.getScore());
		assertEquals(level, playerTest.getLevel());
	}
	
	@Test
	public void testAddPlayer2() throws FileNotFoundException, IOException, NumberInNameException, SpaceInNickException {
		
		setupScenary2();
		
		String nick = "Ana2";
		int score = 89;
		int level = 6;
		
		aliensInvaders.addPlayer(nick, score, level);
		
		ArrayList<Player> players = aliensInvaders.toArrayList();
		
		assertEquals(2, players.size());
		
		Player playerTest = players.get(1);
		
		assertEquals(aliensInvaders.getRealName(), playerTest.getName());
		assertEquals(nick, playerTest.getNick());
		assertEquals(score, playerTest.getScore());
		assertEquals(level, playerTest.getLevel());
	}
	
	@Test
	public void testAddPlayer3() throws FileNotFoundException, IOException, NumberInNameException {
		
		setupScenary2();
		
		String nick = "Aloha 74";
		int score = 89;
		int level = 6;
		
		try {
			aliensInvaders.addPlayer(nick, score, level);
		} catch (SpaceInNickException e) {
		}
		
		ArrayList<Player> players = aliensInvaders.toArrayList();
		
		assertEquals(2, players.size());
	}
	
	@Test
	public void testAddPlayer4() throws FileNotFoundException, IOException, NumberInNameException {
		
		setupScenary2();
		
		String nick = "michi xd";
		int score = 89;
		int level = 6;
		
		try {
			aliensInvaders.addPlayer(nick, score, level);
		} catch (SpaceInNickException e) {
		}
		
		ArrayList<Player> players = aliensInvaders.toArrayList();
		
		assertEquals(2, players.size());
	}
	
	/*
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
	*/
}
