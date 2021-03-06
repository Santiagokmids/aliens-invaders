package model;

import java.util.ArrayList;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public interface BinarySearch {
	
	/**
	 * <b>name:</b> searchP. <br>
	 * Search a player. <br>
	 * <b>post:</b> A player has searched. <br>
	 * @return <code>People</code> specifying people is the player that has searched.
	 */
	
	public String binarySearch(ArrayList<Player> newList, String toSearch);
}
