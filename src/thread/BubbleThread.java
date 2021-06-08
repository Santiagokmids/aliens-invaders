package thread;

import java.util.ArrayList;

import model.Player;
import ui.AliensInvadersGUI;

public class BubbleThread extends Sorting{
	
	private AliensInvadersGUI aliensInvadersGUI;
	
	public BubbleThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		
		super(listPlayers);
		this.aliensInvadersGUI = aliensInvadersGUI;
	}
	
	@Override
	public void run() {
		
		int changes = 1;

		for(int i=1;i<getListPlayers().size()-1 && changes > 0;i++) {

			changes = 0;

			for(int j=0;j<getListPlayers().size()-i;j++) {

				if(getListPlayers().get(j).compareByNameLevel(getListPlayers().get(j+1)) > 0) {
					Player tem = getListPlayers().get(j);
					getListPlayers().set(j,getListPlayers().get(j+1));
					getListPlayers().set(j+1,tem);
					changes++;
				}
			}
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(getListPlayers());
	}
}
