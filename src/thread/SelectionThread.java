package thread;

import java.util.ArrayList;

import model.Player;
import ui.AliensInvadersGUI;

public class SelectionThread extends Sorting{
	
	private AliensInvadersGUI aliensInvadersGUI;

	public SelectionThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		
		super(listPlayers);
		this.aliensInvadersGUI = aliensInvadersGUI;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < getListPlayers().size(); i++) {

			Player min = getListPlayers().get(i);

			for (int j = i+1; j < getListPlayers().size(); j++) {

				if(getListPlayers().get(j).compareByLevelScore(min) < 0){

					Player temp = getListPlayers().get(j);
					getListPlayers().set(j, min);
					min = temp;
				}
			}
			getListPlayers().set(i, min);
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(getListPlayers());
	}
}
