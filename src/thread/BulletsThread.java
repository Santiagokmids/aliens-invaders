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

				current = alien;
				Random alienToSelect = new Random();
				int aleatorio = (int)(alienToSelect.nextDouble() * 10);
				int cont = 0;
				alien.getNext().getNext().getNext().getNext().setNext(null);
				
				for (int i = 0; i <= 5; i++) {
					
					if(cont < 5 && current.getNext() != null) {
						cont++;
						current = current.getNext();

					}else if(cont < 5 && current.getNext() == null ) {
						cont++;
						current = current.getDown();

					}
					else if(cont >= 5 && current.getPrev() != null) {
						cont++;
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
