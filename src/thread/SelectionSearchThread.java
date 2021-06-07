package thread;

import java.util.ArrayList;

import model.AliensInvaders;
import model.Player;

public class SelectionSearchThread extends Sorting{

	private AliensInvaders aliensInvaders;
	private String score;
	private String message;

	public SelectionSearchThread(AliensInvaders aliensInvaders, ArrayList<Player> listPlayers, String score) {
		
		super(listPlayers);
		this.aliensInvaders = aliensInvaders;
		this.score = score;
	}
	
	@Override
	public void run() {

		for (int i = 0; i < getListPlayers().size(); i++) {

			Player min = getListPlayers().get(i);

			for (int j = i+1; j < getListPlayers().size(); j++) {

				if(getListPlayers().get(j).compare(String.valueOf(min.getScore())) < 0){

					Player temp = getListPlayers().get(j);
					getListPlayers().set(j, min);
					min = temp;
				}
			}
			getListPlayers().set(i, min);
		}

		message = aliensInvaders.binarySearchByScore(getListPlayers(), score);
	}

	public String getMessage() {
		return message;
	}
}
