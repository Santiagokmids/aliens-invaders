package thread;

import java.util.ArrayList;

import model.AliensInvaders;
import model.Player;

public class BubbleThread extends Thread{

	private AliensInvaders aliensInvaders;
	private ArrayList<Player> listPlayers;
	private String nick;
	private Player player;
	private String message;

	public BubbleThread(AliensInvaders aliensInvaders, ArrayList<Player> listPlayers, String nick) {

		this.aliensInvaders = aliensInvaders;
		this.listPlayers = listPlayers;
		this.nick = nick;
	}

	public void run() {

		int changes = 1;

		for(int i=1;i<listPlayers.size()-1 && changes > 0;i++) {

			changes = 0;

			for(int j=0;j<listPlayers.size()-i;j++) {

				if(listPlayers.get(j).compareTo(listPlayers.get(j+1).getNick()) > 0) {
					Player tem = listPlayers.get(j);
					listPlayers.set(j,listPlayers.get(j+1));
					listPlayers.set(j+1,tem);
					changes++;
				}
			}
		}
		
		player = aliensInvaders.binarySearchByNameRemove(listPlayers, nick);
		message = aliensInvaders.binarySearchByName(listPlayers, nick);
	}

	public ArrayList<Player> getListPlayers() {
		return listPlayers;
	}

	public Player getPlayer() {
		return player;
	}

	public String getMessage() {
		return message;
	}
}
