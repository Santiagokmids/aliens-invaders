package thread;

import java.util.Random;

import javafx.application.Platform;
import model.Alien;
import ui.AliensInvadersGUI;


public class BulletsThread extends Thread {

	private AliensInvadersGUI aliensInvadersGUI;
	private boolean verify;
	private Alien alien;
	private Alien current;

	public BulletsThread(AliensInvadersGUI aliensInvadersGUI,Alien alien,boolean verify) {
		this.aliensInvadersGUI = aliensInvadersGUI;
		this.verify = verify;
		this.alien = alien;
		current = null;
	}

	public void run() {

		while(verify) {

			if(alien != null) {

				boolean down = false;
				current = alien;
				Random alienToSelect = new Random();
				int aleatorio = (int)(alienToSelect.nextDouble() * 9);

				for (int i = 0; i < aleatorio; i++) {

					if(current.getNext() != null && !down) {
						current = current.getNext();

					}else if(current.getDown() != null && !down){
						current = current.getDown();
						down = true;

					}else if(current.getPrev() != null && down) {
						current = current.getPrev();
					}
				}
			}
			Platform.runLater(new Thread(){
				public void run() {

					if(current.getVisible()) {

						try {
							aliensInvadersGUI.selectAlien(current);
						} catch (InterruptedException e) {
						}
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
