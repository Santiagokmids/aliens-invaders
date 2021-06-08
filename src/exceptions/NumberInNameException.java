package exceptions;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class NumberInNameException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NumberInNameException() {
		super("The name entered has numbers");
	}
}
