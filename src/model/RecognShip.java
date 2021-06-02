package model;

public class RecognShip extends Spacecraft{
	
	private int live;
	
	public RecognShip(TypeSpacecraft ship, double x, int live) {
		super(ship,x);
		this.live = live;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}
}
