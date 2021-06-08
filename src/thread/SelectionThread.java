package thread;

import java.util.ArrayList;

import model.CompareTwoPlayers;
import model.Player;
import ui.AliensInvadersGUI;

public class SelectionThread extends Sorting implements CompareTwoPlayers{
	
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

				if(compareTwoPlayers(getListPlayers().get(j), min) < 0){

					Player temp = getListPlayers().get(j);
					getListPlayers().set(j, min);
					min = temp;
				}
			}
			getListPlayers().set(i, min);
		}
		
		aliensInvadersGUI.inicializateTableViewPlayer(getListPlayers());
	}
	
	@Override
	public int compareTwoPlayers(Player playerOne, Player playerTwo) {
		
		int verify = 0;
		
		if(playerOne.getLevel() > playerTwo.getLevel()) {
			verify = 1;
		}else if(playerOne.getLevel() < playerTwo.getLevel()) {
			verify = -1;
		}

		if(verify == 0) {
			if(playerOne.getScore() == playerTwo.getScore()) {
				verify = 0;
			}else if(playerOne.getScore() > playerTwo.getScore()){
				verify = 1;
			}else if(playerOne.getScore() < playerTwo.getScore()) {
				verify = -1;
			}
		}
		return verify;
	}
}
