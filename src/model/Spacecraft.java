package model;

public class Spacecraft {
	
	private TypeSpacecraft ship;
	private Double posX;
	
	public Spacecraft(TypeSpacecraft ship, double x) {
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
	
	public void moveLeft() {
		posX = posX - 5;
	}
	
	public void moveRight() {
		posX = posX + 5;
	}
}
