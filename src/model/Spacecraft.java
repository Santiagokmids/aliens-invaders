package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class Spacecraft {
	
	private TypeSpacecraft ship;
	private Double posX;
	private Double posY;
	
	/**
	 * <b>name:</b> Spacecraft. <br>
	 * Create a object Spacecraft. <br>
	 * <b>post:</b> An object Spacecraft has created. <br>
	 * @param ship is the enum of the type of spacecraft. ship != null.
	 * @param x is the initial position of the spacecraft. x != null.
	 */
	
	public Spacecraft(TypeSpacecraft ship, double x) {
		this.ship = ship;
		setPosX(x);
	}

	public TypeSpacecraft getShip() {
		return ship;
	}

	public Double getPosX() {
		return posX;
	}

	public void setPosX(Double posX) {
		this.posX = posX;
	}
	
	/**
	 * <b>name:</b> moveLeft. <br>
	 * Move the spacecraft to the left. <br>
	 * <b>post:</b> The spacecraft has been moved to the left. <br>
	 */
	
	public void moveLeft() {
		posX = posX - 10;
	}
	
	/**
	 * <b>name:</b> moveRight. <br>
	 * Move the spacecraft to the right. <br>
	 * <b>post:</b> The spacecraft has been moved to the right.
	 */
	
	public void moveRight() {
		posX = posX + 10;
	}

	public Double getPosY() {
		return posY;
	}

	public void setPosY(Double posY) {
		this.posY = posY;
	}
}
