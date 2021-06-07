package thread;

import java.util.ArrayList;

import model.Player;
import ui.AliensInvadersGUI;

public class InsertionThread extends Sorting{
	
	private AliensInvadersGUI aliensInvadersGUI;
	
	public InsertionThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		
		super(listPlayers);
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i < getListPlayers().size(); i++) {
			for (int j = i; j > 0 && getListPlayers().get(j-1).compareByNickScore(getListPlayers().get(j)) > 0; j--) {
				
				Player temp = getListPlayers().get(j);
				
				getListPlayers().set(j, getListPlayers().get(j-1));
				getListPlayers().set(j-1, temp);
			}
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(getListPlayers());
	}
}
