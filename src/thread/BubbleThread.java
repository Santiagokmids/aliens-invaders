package thread;

import java.util.ArrayList;

import model.Player;
import ui.AliensInvadersGUI;

public class BubbleThread extends Sorting{
	
	private AliensInvadersGUI aliensInvadersGUI;
	private ArrayList<Player> listPlayers;
	
	public BubbleThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		
		super(listPlayers);
		this.aliensInvadersGUI = aliensInvadersGUI;
	}
	
	@Override
	public void run() {
		
		int changes = 1;

		for(int i=1;i<listPlayers.size()-1 && changes > 0;i++) {

			changes = 0;

			for(int j=0;j<listPlayers.size()-i;j++) {

				if(listPlayers.get(j).compareByNameLevel(listPlayers.get(j+1)) > 0) {
					Player tem = listPlayers.get(j);
					listPlayers.set(j,listPlayers.get(j+1));
					listPlayers.set(j+1,tem);
					changes++;
				}
			}
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(listPlayers);
	}
}
