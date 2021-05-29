package model;

public class RecognShip extends Spacecraft{
	
	private int live;
	
	public RecognShip(TypeSpacecraft ship, int live) {
		super(ship);
		this.live = live;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}
}
