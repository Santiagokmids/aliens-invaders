package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class Figures {
	
	private String color;
	private double posX;
	private double posY;
	
	/**
	 * <b>name:</b> Figures. <br>
	 * Create an object figures. <br>
	 * <b>post:</b> An object figures has created. <br>
	 * @param color is the color of the figures. color != "" y color != null.
	 * @param x is the size of the figure. x != null.
	 * @param y is the size of the figure. y != null.
	 */
	
	public Figures(String color, double x, double y) {
		this.setColor(color);
		setPosX(x);
		setPosY(y);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}
}
