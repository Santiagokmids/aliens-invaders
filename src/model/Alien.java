package model;

import javafx.scene.image.Image;

public class Alien {
	
	public final static int MOVE = 10;
	
	private double x;
	private double y;
	private double max;
	private double positionX;
	private double positionY;
	private Direction direction;
	private Image imageOne;
	private Image imageTwo;
	private Alien down;
	private Alien up;
	private Alien next;
	private Alien prev;
	
	public Alien(double x, double y, double positionX, double positionY, Image imageOne, Image imageTwo) {
		
		this.x = x;
		this.y = y;
		this.positionX = positionX;
		this.positionY = positionY;
		direction = Direction.LEFT;
		this.imageOne = imageOne;
		this.imageTwo = imageTwo;
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
		if(x <= -79) {
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
	
	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public Image getImageOne() {
		return imageOne;
	}

	public Image getImageTwo() {
		return imageTwo;
	}

	public Alien getDown() {
		return down;
	}

	public void setDown(Alien down) {
		this.down = down;
	}

	public Alien getUp() {
		return up;
	}

	public void setUp(Alien up) {
		this.up = up;
	}

	public Alien getNext() {
		return next;
	}

	public void setNext(Alien next) {
		this.next = next;
	}

	public Alien getPrev() {
		return prev;
	}

	public void setPrev(Alien prev) {
		this.prev = prev;
	}
}
