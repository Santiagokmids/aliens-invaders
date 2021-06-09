package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class RecognShip extends Spacecraft{
	
	private int speed;
	
	/**
	 * <b>name:</b> RecognShip. <br>
	 * Create an object recogn ship. <br>
	 * <b>post:</b> An object recogn ship has created. <br>
	 * @param ship
	 * @param x
	 * @param live
	 */
	
	public RecognShip(TypeSpacecraft ship, double x, int speed) {
		super(ship,x);
		setVelocityMovement(speed);;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
