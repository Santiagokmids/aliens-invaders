package model;

public class Circle extends Figures{
	
	private int radio;

	public Circle(int radio, String color) {
		super(color);
		this.setRadio(radio);
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
}
