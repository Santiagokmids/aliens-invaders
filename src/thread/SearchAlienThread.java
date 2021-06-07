package thread;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
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
	
	public SearchAlienThread(AliensInvadersGUI aliensInvadersGUI,Alien first, double x, double y, double posBallX,double posBallY,
			ImageView alienImageView,boolean verify,boolean knowShoot) {
		
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.first = first;
		this.x = x;
		this.y = y;
		this.posBallX = posBallX;
		this.posBallY = posBallY;
		this.verify = verify;
		this.alienImageView = alienImageView;
		this.knowShoot = knowShoot;
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
				
				if(alienImageView.getLayoutX() == x && (posBallX-62 == alienImageView.getLayoutX()) && knowShoot && 
						alienImageView.getLayoutY() == y && (posBallY == alienImageView.getLayoutY())) {
					Platform.runLater(new Thread(){
						public void run() {
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
					Thread.sleep(200);
				}catch(InterruptedException e) {
					
				}
			}
		}
	}
}