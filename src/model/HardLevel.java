package model;

public class HardLevel extends Level {
	
private int movementSpeed;
private int attackSpeed;
	
	public HardLevel(int aliens, int movementSpeed, int attackSpeed) {
		super(aliens);
		this.movementSpeed = movementSpeed;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
}
