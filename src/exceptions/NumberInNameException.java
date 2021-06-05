package exceptions;

public class NumberInNameException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NumberInNameException() {
		super("El nombre ingresado contiene numeros");
	}
}
