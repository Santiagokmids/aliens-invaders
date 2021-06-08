package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public interface Calculate {
	
	/**
	 * <b>name:</b> calculate. <br>
	 * Calculate the score of a player. <br>
	 * <b>post:</b> The score of a player has been calculated. <br>
	 * @return <code>int</code> specifying calculated is the score of the player.
	 */
	
	public int calculate(int score, int level);
}
