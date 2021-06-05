package model;

public class Spacecraft {
	
	private TypeSpacecraft ship;
	private Double posX;
	
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
	
	public void moveLeft() {
		posX = posX - 10;
	}
	
	public void moveRight() {
		posX = posX + 10;
	}
}
