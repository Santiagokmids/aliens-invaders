package thread;

import java.util.ArrayList;

import model.Player;
import ui.AliensInvadersGUI;

public class SelectionThread extends Thread{
	
	private AliensInvadersGUI aliensInvadersGUI;
	private ArrayList<Player> listPlayers;

	public SelectionThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.listPlayers = listPlayers;
	}
	
	public void run() {
		
		for (int i = 0; i < listPlayers.size(); i++) {

			Player min = listPlayers.get(i);

			for (int j = i+1; j < listPlayers.size(); j++) {

				if(listPlayers.get(j).compareByLevelScore(min) < 0){

					Player temp = listPlayers.get(j);
					listPlayers.set(j, min);
					min = temp;
				}
			}
			listPlayers.set(i, min);
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(listPlayers);
	}
}
