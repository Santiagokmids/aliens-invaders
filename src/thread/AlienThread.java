package thread;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import model.Alien;
import ui.AliensInvadersGUI;

public class AlienThread extends Thread{
	
	private AliensInvadersGUI aliensInvadersGUI;
	private Alien alien;
	private ImageView alienImageView;
	private boolean verify;
	
	public AlienThread(AliensInvadersGUI aliensInvadersGUI, Alien alien, ImageView alienImageView, boolean verify) {
		
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.alien = alien;
		this.alienImageView = alienImageView;
		this.verify = verify;
	}
	
	public void run() {
		
		while(verify) {
			
			alien.moveAlien();
			
			Platform.runLater(new Thread(){
				public void run() {
					
					aliensInvadersGUI.updateAlien(alien.getPositionX()+alien.getX(), alienImageView);
					
					if(alienImageView.getImage() == alien.getImageOne()) {
						alienImageView.setImage(alien.getImageTwo());
					}else {
						alienImageView.setImage(alien.getImageOne());
					}
				}
			});
			
			verify = aliensInvadersGUI.getVerify();
			
			try{
				Thread.sleep(200);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
