package model;

public class Rectangle extends Figures{
	
	private int weidth;
	private int high;

	public Rectangle(int weidth, int high, String color) {
		
		super(color);
		this.setWeidth(weidth);
		this.setHigh(high);
	}

	public int getWeidth() {
		return weidth;
	}

	public void setWeidth(int weidth) {
		this.weidth = weidth;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}
}
