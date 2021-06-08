package model;

import javafx.scene.image.Image;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class Alien {
	
	public final static int MAXRIGHT = 150;
	public final static int MAXLEFT = 79;
	
	private int move;
	private double x;
	private double y;
	private double positionX;
	private double positionY;
	private Direction direction;
	private Image imageOne;
	private Image imageTwo;
	private Alien down;
	private Alien up;
	private Alien next;
	private Alien prev;
	
	/**
	 * <b>name:</b> Alien. <br>
	 * Create an object alien. <br>
	 * <b>post:</b> An object alien has created. <br>
	 * @param x is the size of the alien. x != null. 
	 * @param y is the size of the alien. y != null.
	 * @param positionX is the initial position of the alien in the game. positionX != null.
	 * @param positionY is the initial position of the alien in the game. positionY != null.
	 * @param imageOne is the first image of an alien. imageOne != "" y imageOne != null.
	 * @param imageTwo is the second image of an alien. imageTwo != "" y imageTwo != null.
	 */
	
	public Alien(double x, double y, double positionX, double positionY, Image imageOne, Image imageTwo) {
		
		this.x = x;
		this.y = y;
		this.positionX = positionX;
		this.positionY = positionY;
		direction = Direction.RIGHT;
		this.imageOne = imageOne;
		this.imageTwo = imageTwo;
		move = 0;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	/**
	 * <b>name:</b> moveAlien. <br>
	 * Move the alien. <br>
	 * <b>post:</b> The alien has been moved. <br>
	 */
	
	public void moveAlien() {
		
		if(direction == Direction.LEFT) {
			x -= move;
		}else {
			x += move;
		}
		
		verify();
	}
	
	/**
	 * <b>name:</b> verify. <br>
	 * Verify the direction of an alien. <br>
	 * <b>post:</b> The direction of an alien has been verified. 
	 */
	
	public void verify() {
		
		if(x >= MAXRIGHT) {
			positionY += move;
			changeDirection();
		}
		if(x <= MAXLEFT) {
			positionY += move;
			changeDirection();
		}
	}
	
	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	/**
	 * <b>name:</b> changeDirection. <br>
	 * Change the direction of an alien. <br>
	 * <b>post:</b> The direction of an alien has been changed. <br>
	 */
	
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
