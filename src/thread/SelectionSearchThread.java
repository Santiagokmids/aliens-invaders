package thread;

import java.util.ArrayList;

import model.AliensInvaders;
import model.Player;

public class SelectionSearchThread extends Sorting{

	private AliensInvaders aliensInvaders;
	private ArrayList<Player> listPlayers;
	private String score;
	private String message;

	public SelectionSearchThread(AliensInvaders aliensInvaders, ArrayList<Player> listPlayers, String score) {
		
		super(listPlayers);
		this.aliensInvaders = aliensInvaders;
		this.score = score;
	}
	
	@Override
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

		message = aliensInvaders.binarySearchByScore(listPlayers, score);
	}

	public String getMessage() {
		return message;
	}
}
