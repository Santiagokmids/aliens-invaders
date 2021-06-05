package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class AttackShip extends Spacecraft{
	
	private int attackSpeed;
	
	/**
	 * <b>name:</b> AttackShip. <br>
	 * Create an object attackship. <br>
	 * <b>post:</b> An object attackship has created. <br>
	 * @param ship is the type of the ship. ship != null.
	 * @param x is the initial position of the ship. x != null. 
	 * @param attackSpeed is the attack speed of the ship. attackSpeed != null.
	 */
	
	public AttackShip(TypeSpacecraft ship,double x, int attackSpeed) {
		super(ship,x);
		this.attackSpeed = attackSpeed;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
}
