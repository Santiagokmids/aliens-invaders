package thread;

import java.util.ArrayList;

import model.Player;

public class Sorting extends Thread{
	
	private ArrayList<Player> listPlayers;
	
	public Sorting(ArrayList<Player> lisPlayers) {
		
		this.listPlayers = lisPlayers;
	}
	
	public void run() {
		
	}

	public ArrayList<Player> getListPlayers() {
		return listPlayers;
	}
}
