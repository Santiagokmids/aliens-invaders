package model;

public class Figures {
	
	private String color;
	private double posX;
	private double posY;
	
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
