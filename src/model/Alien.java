package model;

public class Alien {
	
	public final static int MOVE = 10;
	
	private double x;
	private double y;
	private double max;
	private Direction direction;
	
	public Alien(double x, double y) {
		this.x = x;
		this.y = y;
		direction = Direction.LEFT;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setMax(double max) {
		this.max = max;
	}
	
	public void moveAlien() {
		
		if(direction == Direction.LEFT) {
			x -= MOVE;
		}else {
			x += MOVE;
		}
		
		verify();
	}
	
	public void verify() {
		
		if(x >= max) {
			changeDirection();
		}
		if(x <= 0) {
			changeDirection();
		}
	}
	
	public void changeDirection() {
		
		if(direction == Direction.LEFT) {
			direction = Direction.RIGHT;
		}else {
			direction = Direction.LEFT;
		}
	}
}
