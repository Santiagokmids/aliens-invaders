package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class Rectangle extends Figures{
	
	private int weidth;
	private int high;
	
	/**
	 * <b>name:</b> Rectangle. <br>
	 * Create an object rectangle. <br>
	 * <b>post:</b> An object rectangle has created. <br>
	 * @param width is the width of the rectangle. width != null.
	 * @param high is the high of the rectangle. high != null.
	 * @param color is the color of the rectangle. color != "" y color != null.
	 * @param x is the size of the rectangle. x != null.
	 * @param y is the size of the rectangle. y != null.
	 */

	public Rectangle(int width, int high, String color, double x, double y) {
		
		super(color,x,y);
		this.setWeidth(width);
		this.setHigh(high);
	}

	public int getWeidth() {
		return weidth;
	}

	public void setWeidth(int width) {
		this.weidth = width;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}
}
