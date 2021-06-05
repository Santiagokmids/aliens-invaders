package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class Circle extends Figures{
	
	private int radio;
	
	/**
	 * <b>name:</b> Circle. <br>
	 * Create an object circle. <br>
	 * <b>post:</b> An object circle has created. <br>
	 * @param radio is the radio of the circle. radio != null. 
	 * @param color is the color of the circle. color != "" y color != null.
	 * @param x is the size of the circle. x != null.
	 * @param y is the size of the circle. y != null.
	 */

	public Circle(int radio, String color, double x, double y) {
		super(color,x,y);
		this.setRadio(radio);
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
}
