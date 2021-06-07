package thread;

import java.util.ArrayList;

import model.Player;
import ui.AliensInvadersGUI;

public class InsertionThread extends Sorting{
	
	private AliensInvadersGUI aliensInvadersGUI;
	private ArrayList<Player> listPlayers;
	
	public InsertionThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		
		super(listPlayers);
		this.listPlayers = listPlayers;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i < listPlayers.size(); i++) {
			for (int j = i; j > 0 && listPlayers.get(j-1).compareByNickScore(listPlayers.get(j)) > 0; j--) {
				
				Player temp = listPlayers.get(j);
				
				listPlayers.set(j, listPlayers.get(j-1));
				listPlayers.set(j-1, temp);
			}
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(listPlayers);
	}
}
