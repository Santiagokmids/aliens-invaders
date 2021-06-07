package thread;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import model.Alien;
import ui.AliensInvadersGUI;

public class SearchAlienThread extends Thread {

	private AliensInvadersGUI aliensInvadersGUI;
	private Alien first;
	private double x;
	private double y;
	private double posBallX;
	private double posBallY;
	private ImageView alienImageView;
	private boolean verify;
	private boolean knowShoot;
	private Circle circle;
	
	public SearchAlienThread(AliensInvadersGUI aliensInvadersGUI,Alien first, double x, double y, double posBallX,double posBallY,
			ImageView alienImageView,boolean verify,boolean knowShoot,Circle circle) {
		
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.first = first;
		this.x = x;
		this.y = y;
		this.posBallX = posBallX;
		this.posBallY = posBallY;
		this.verify = verify;
		this.alienImageView = alienImageView;
		this.knowShoot = knowShoot;
		this.circle = circle;
	}
	
	public void run() {
		
		boolean direction = true;
		boolean shoot = false;
		
		if(first == null) {
			shoot = false;
		}
		else {
			Alien current = first;
			
			while(!shoot && verify) {
				
				if(alienImageView.getLayoutX() == x && (posBallX >= alienImageView.getLayoutX() && posBallX <= alienImageView.getLayoutX()+75) 
						&& knowShoot &&	(alienImageView.getLayoutY() == y && (posBallY >= alienImageView.getLayoutY()-62 && posBallY <= alienImageView.getLayoutY()))
						&& circle.isVisible() && alienImageView.isVisible()) {
					
					Platform.runLater(new Thread(){
						public void run() {
							circle.setVisible(false);
							alienImageView.setVisible(false);
						}
							
					});
					shoot = true;
					
				}else {
					
					if(current.getNext() != null && direction) { 
						current = current.getNext();
						
					}else if(current.getDown() != null) {
						direction = false;
						current = current.getDown();
						
					}else if(current.getPrev() != null && !direction) {
						current = current.getPrev();
					}
					
				}
				
				posBallX = aliensInvadersGUI.getBallInMoveX();
				posBallY = aliensInvadersGUI.getBallInMoveY();
				verify = aliensInvadersGUI.getVerify();
				knowShoot = aliensInvadersGUI.getKnowShoot();
				
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					
				}
			}
		}
	}
}