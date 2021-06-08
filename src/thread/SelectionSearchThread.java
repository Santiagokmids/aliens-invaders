package thread;

import java.util.ArrayList;

import model.BinarySearch;
import model.Player;

public class SelectionSearchThread extends Sorting implements BinarySearch{

	private String score;
	private String message;

	public SelectionSearchThread(ArrayList<Player> listPlayers, String score) {
		
		super(listPlayers);
		this.score = score;
	}
	
	@Override
	public void run() {

		for (int i = 0; i < getListPlayers().size(); i++) {

			Player min = getListPlayers().get(i);

			for (int j = i+1; j < getListPlayers().size(); j++) {

				if(getListPlayers().get(j).compare(String.valueOf(min.getScore())) < 0){

					Player temp = getListPlayers().get(j);
					getListPlayers().set(j, min);
					min = temp;
				}
			}
			getListPlayers().set(i, min);
		}

		message = binarySearch(getListPlayers(), score);
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String binarySearch(ArrayList<Player> newList, String toSearch) {
		
		ArrayList<Player> listPlayers = newList;

		String message = "";

		int pos = -1;
		int i = 0;
		int j = listPlayers.size()-1;
		Player player = null;

		while(i <= j && pos < 0) {
			int m = (i+j)/2;

			if(listPlayers.get(m).compare(toSearch) == 0) {
				pos = m;

				player = listPlayers.get(pos);

				if(player != null) {
					message += player.toString();
					newList.remove(pos);
					message += binarySearch(newList, toSearch);
				}
			}
			else if(listPlayers.get(m).compare(toSearch) > 0) {
				j = m-1;
			}
			else {
				i = m+1;
			}
		}
		
		return message;
	}
}
