package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.HighScoreException;
import exceptions.NumberInNameException;
import exceptions.SpaceInNickException;

public class AliensInvadersTest {
	
	private AliensInvaders aliensInvaders;
	
	public void setupScenary1() {
		aliensInvaders = new AliensInvaders();
	}
	
	
	public void setupScenary2() throws NumberInNameException {
		
		aliensInvaders = new AliensInvaders();
		
		String realName = "Santiago";
		
		aliensInvaders.addPeople(realName);
	}
	
	public void setupScenary3() throws FileNotFoundException, IOException, SpaceInNickException {
		
		aliensInvaders = new AliensInvaders();
		
		String nick1 = "Rubencito1";
		int score1 = 74;
		int level1 = 9;
		
		String nick2 = "Alondre";
		int score2 = 33;
		int level2 = 2;
		
		aliensInvaders.addPlayer(nick1, score1, level1);
		aliensInvaders.addPlayer(nick2, score2, level2);
	}
	
	public void setupScenary4() throws FileNotFoundException, IOException, SpaceInNickException {
		aliensInvaders = new AliensInvaders();
		
		String nick1 = "lolito";
		int score1 = 65;
		int level1 = 3;
		
		String nick2 = "TheGrf";
		int score2 = 172;
		int level2 = 14;
		
		String nick3 = "Papoc";
		int score3 = 130;
		int level3 = 14;
		
		aliensInvaders.addPlayer(nick1, score1, level1);
		aliensInvaders.addPlayer(nick2, score2, level2);
		aliensInvaders.addPlayer(nick3, score3, level3);
	}
	
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
		
		assertEquals(1, players.size());
		
		Player playerTest = players.get(0);
		
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
		
		assertEquals(0, players.size());
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
		
		assertEquals(0, players.size());
	}
	
	@Test
	public void testBinarySearchByScore2() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary3();
		
		String scores = "66";
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		for (int i = 0; i < listPlayers.size(); i++) {

			Player min = listPlayers.get(i);

			for (int j = i+1; j < listPlayers.size(); j++) {

				if(listPlayers.get(j).compare(String.valueOf(min.getScore())) < 0){

					Player temp = listPlayers.get(j);
					listPlayers.set(j, min);
					min = temp;
				}
			}
			listPlayers.set(i, min);
		}
		
		String messageSearch = aliensInvaders.binarySearch(listPlayers, scores);
		
		String messagePlayer = "";
		
		assertEquals(messagePlayer, messageSearch);
	}
	
	@Test 
	public void binarySearchByName() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary3();
		
		String nick = "Alondre";
		int score = 33;
		int level = 2;
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		int changes = 1;

		for(int i=1;i<listPlayers.size()-1 && changes > 0;i++) {

			changes = 0;

			for(int j=0;j<listPlayers.size()-i;j++) {

				if(listPlayers.get(j).compareTo(listPlayers.get(j+1).getNick()) > 0) {
					Player tem = listPlayers.get(j);
					listPlayers.set(j,listPlayers.get(j+1));
					listPlayers.set(j+1,tem);
					changes++;
				}
			}
		}
		
		String messageSearch = aliensInvaders.binarySearch(listPlayers, nick);
		String messagePlayer = "Nickname: "+nick+" | Score : "+score+" | Level "+ level+"\n";
		
		assertEquals(messagePlayer, messageSearch);
	}
	
	@Test 
	public void binarySearchByName2() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary3();
		
		String nick = "Carlos";
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		int changes = 1;

		for(int i=1;i<listPlayers.size()-1 && changes > 0;i++) {

			changes = 0;

			for(int j=0;j<listPlayers.size()-i;j++) {

				if(listPlayers.get(j).compareTo(listPlayers.get(j+1).getNick()) > 0) {
					Player tem = listPlayers.get(j);
					listPlayers.set(j,listPlayers.get(j+1));
					listPlayers.set(j+1,tem);
					changes++;
				}
			}
		}
		
		String messageSearch = aliensInvaders.binarySearch(listPlayers, nick);
		String messagePlayer = "";
		
		assertEquals(messagePlayer, messageSearch);
	}
	
	@Test
	public void testRemovePlayer() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary4();
		
		String nick = "Papoc";
		String score = "130";
		String level = "14";
		
		Player playerToRemove = aliensInvaders.removePlayer(nick, score);
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		assertEquals(3, listPlayers.size());
		assertEquals(nick, playerToRemove.getNick());
		assertEquals(Integer.parseInt(score), playerToRemove.getScore());
		assertEquals(Integer.parseInt(level), playerToRemove.getLevel());
	}
	
	@Test
	public void testRemovePlayer2() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary4();
		
		String nick = "lolito";
		String score = "65";
		String level = "3";
		
		Player playerToRemove = aliensInvaders.removePlayer(nick, score);
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		assertEquals(3, listPlayers.size());
		assertEquals(nick, playerToRemove.getNick());
		assertEquals(Integer.parseInt(score), playerToRemove.getScore());
		assertEquals(Integer.parseInt(level), playerToRemove.getLevel());
	}
	
	@Test
	public void testRemove() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary4();
		
		String nick = "lolito";
		String score = "65";
		String level = "3";
		
		Player playerToRemove = aliensInvaders.removePlayer(nick, score);
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		assertEquals(3, listPlayers.size());
		assertEquals(nick, playerToRemove.getNick());
		assertEquals(Integer.parseInt(score), playerToRemove.getScore());
		assertEquals(Integer.parseInt(level), playerToRemove.getLevel());
		
		aliensInvaders.removePlayer(playerToRemove);
		
		ArrayList<Player> listPlayers2 = aliensInvaders.toArrayList();
		
		assertEquals(2, listPlayers2.size());
	}
	
	@Test
	public void testRemove2() throws FileNotFoundException, IOException, SpaceInNickException {
		
		setupScenary4();
		
		String nick = "Papoc";
		String score = "130";
		String level = "14";
		
		Player playerToRemove = aliensInvaders.removePlayer(nick, score);
		
		ArrayList<Player> listPlayers = aliensInvaders.toArrayList();
		
		assertEquals(3, listPlayers.size());
		assertEquals(nick, playerToRemove.getNick());
		assertEquals(Integer.parseInt(score), playerToRemove.getScore());
		assertEquals(Integer.parseInt(level), playerToRemove.getLevel());
		
		aliensInvaders.removePlayer(playerToRemove);
		
		ArrayList<Player> listPlayers2 = aliensInvaders.toArrayList();
		
		assertEquals(2, listPlayers2.size());
	}
	
	@Test
	public void testCalculate() {
		
		boolean verify = false;
		
		setupScenary1();
		
		try {
			aliensInvaders.calculate(920, 80);
		} catch (HighScoreException e) {
			verify = true;
		}
		
		assertTrue(verify);
	}
}
