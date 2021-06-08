package thread;

import java.util.ArrayList;

import model.CompareTwoPlayers;
import model.Player;
import ui.AliensInvadersGUI;

public class InsertionThread extends Sorting implements CompareTwoPlayers{
	
	private AliensInvadersGUI aliensInvadersGUI;
	
	public InsertionThread(AliensInvadersGUI aliensInvadersGUI, ArrayList<Player> listPlayers) {
		super(listPlayers);
		this.aliensInvadersGUI = aliensInvadersGUI;
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i < getListPlayers().size(); i++) {
			for (int j = i; j > 0 && compareTwoPlayers(getListPlayers().get(j-1), getListPlayers().get(j)) > 0; j--) {
				
				Player temp = getListPlayers().get(j);
				
				getListPlayers().set(j, getListPlayers().get(j-1));
				getListPlayers().set(j-1, temp);
			}
		}
		aliensInvadersGUI.inicializateTableViewPlayer(getListPlayers());
	}
	
	@Override
	public int compareTwoPlayers(Player playerOne, Player playerTwo) {

		int verify = playerOne.getNick().compareTo(playerTwo.getNick());
		
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
