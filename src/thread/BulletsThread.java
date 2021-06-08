package thread;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import model.Alien;
import ui.AliensInvadersGUI;


public class BulletsThread extends Thread {

	private AliensInvadersGUI aliensInvadersGUI;
	private boolean verify;
	private ImageView image;
	private Alien alien;

	public BulletsThread(AliensInvadersGUI aliensInvadersGUI, ImageView image,Alien alien,boolean verify) {
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.verify = verify;
		this.image = image;
		this.alien = alien;
	}

	public void run() {
		
		while(verify) {
			Platform.runLater(new Thread(){
				public void run() {
					try {
						if(image.isVisible() && alien.getVisible()) {
							synchronized (aliensInvadersGUI) {
								aliensInvadersGUI.selectAlien();
							}
						}
					} catch (InterruptedException e) {
					}
				}

			});

			verify = aliensInvadersGUI.getVerify();

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e) {

			}
			
		}
		
	}
}
