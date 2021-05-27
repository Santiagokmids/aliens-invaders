package model;

public class EasyLevel extends Level{
	
	private int movementSpeed;
	
	public EasyLevel(int aliens, int movementSpeed) {
		super(aliens);
		this.movementSpeed = movementSpeed;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	
	
}