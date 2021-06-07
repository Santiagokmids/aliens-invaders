package thread;

import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import model.Alien;
import ui.AliensInvadersGUI;

public class AlienThread extends Thread{
	
	private AliensInvadersGUI aliensInvadersGUI;
	private Alien alien;
	private ImageView alienImageView;
	private boolean verify;
	private int velocity;
	
	public AlienThread(AliensInvadersGUI aliensInvadersGUI, Alien alien, ImageView alienImageView, boolean verify, int velocity) {
		
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.alien = alien;
		this.alienImageView = alienImageView;
		this.verify = verify;
		this.velocity = velocity;
	}
	
	public void run() {
		
		while(verify) {
			
			alien.moveAlien();
			
			Platform.runLater(new Thread(){
				public void run() {
					
					aliensInvadersGUI.updateAlien(alien.getPositionY(), alien.getPositionX()+alien.getX(), alienImageView);
					aliensInvadersGUI.searchAlien(alienImageView.getLayoutX(), alienImageView.getLayoutY(),alienImageView);
					
					if(alienImageView.isVisible()) {
						
						if(alienImageView.getImage() == alien.getImageOne()) {
							alienImageView.setImage(alien.getImageTwo());
							
						}else {
							alienImageView.setImage(alien.getImageOne());
						}
					}
					try {
						aliensInvadersGUI.validationPosition(alien, alienImageView);
					} catch (IOException e) {
					}
				}
			});
			
			
			verify = aliensInvadersGUI.getVerify();
			velocity = aliensInvadersGUI.getVelocity();
			
			try{
				Thread.sleep(velocity);
			}catch(InterruptedException e) {
				
			}
		}
	}
}

	