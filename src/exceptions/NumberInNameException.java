package exceptions;

public class NumberInNameException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NumberInNameException() {
		super("The name entered has numbers");
	}
}
