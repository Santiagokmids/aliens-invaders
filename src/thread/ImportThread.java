package thread;

import java.io.BufferedReader;
import java.io.IOException;

import exceptions.NumberInNameException;
import exceptions.SpaceInNickException;
import javafx.application.Platform;
import model.AliensInvaders;

public class ImportThread extends Thread{

	private AliensInvaders aliensInvaders;
	private BufferedReader br;

	public ImportThread(AliensInvaders aliensInvaders, BufferedReader br) {
		this.aliensInvaders = aliensInvaders;
		this.br = br;
	}

	public void run() {
		
		Platform.runLater(new Thread() {
			
			@Override
			public void run() {
				String line = "";
				try {
					line = br.readLine();

					while(line != null) {
						
						try {
							String[] parts = line.split(",");


							int score = Integer.parseInt(parts[2]);
							int level = Integer.parseInt(parts[3]);
							String realName = parts[0];

							aliensInvaders.addPeople(realName);
							aliensInvaders.addPlayer(parts[1], score, level);
							line = br.readLine();
							
						} catch (NumberFormatException e) {
							line = br.readLine();
						}
					}

				}catch (IOException e) {
				}catch (SpaceInNickException sine) {
				}catch (NumberInNameException nine) {
				}
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		});
	}
}
