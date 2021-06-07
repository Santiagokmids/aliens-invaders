package thread;

import java.util.ArrayList;

import model.AliensInvaders;
import model.Player;

public class SelectionThread extends Thread{

	private AliensInvaders aliensInvaders;
	private ArrayList<Player> listPlayers;
	private String score;
	private Player player;
	private String message;

	public SelectionThread(AliensInvaders aliensInvaders, ArrayList<Player> listPlayers, String score) {

		this.aliensInvaders = aliensInvaders;
		this.listPlayers = listPlayers;
		this.score = score;
	}

	public void run() {

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

		player = aliensInvaders.binarySearchByScoreRemove(listPlayers, score);
		message = aliensInvaders.binarySearchByScore(listPlayers, score);
	}

	public ArrayList<Player> getListPlayers() {
		return listPlayers;
	}

	public Player getPlayer() {
		return player;
	}

	public String getMessage() {
		return message;
	}
}
