package thread;

import java.util.ArrayList;

import model.AliensInvaders;
import model.Player;

public class BubbleSearchThread extends Sorting{

	private AliensInvaders aliensInvaders;
	private String nick;
	private String message;

	public BubbleSearchThread(AliensInvaders aliensInvaders, ArrayList<Player> listPlayers, String nick) {

		super(listPlayers);
		this.aliensInvaders = aliensInvaders;
		this.nick = nick;
	}
	
	@Override
	public void run() {

		int changes = 1;

		for(int i=1;i<getListPlayers().size() && changes > 0;i++) {

			changes = 0;

			for(int j=0;j<getListPlayers().size()-i;j++) {

				if(getListPlayers().get(j).compareTo(getListPlayers().get(j+1).getNick()) > 0) {
					Player tem = getListPlayers().get(j);
					getListPlayers().set(j,getListPlayers().get(j+1));
					getListPlayers().set(j+1,tem);
					changes++;
				}
			}
		}
		
		message = aliensInvaders.binarySearch(getListPlayers(), nick);
	}

	public String getMessage() {
		return message;
	}
}
