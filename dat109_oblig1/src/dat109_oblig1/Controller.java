package dat109_oblig1;

import java.util.List;
import java.util.Scanner;

public class Controller {
	
	private SpillerUI spillerUI;
	
	public Controller() {
		this.spillerUI = new SpillerUI();
	}
	
	public void start(Brett brett, Terning terning, List<Spiller> spillere) {
		int spillerTeller = 0;
		
		while (true) {
			spillerUI.nySpillerTur(spillere.get(spillerTeller).getName());
			spillerUI.printBrett(spillere.get(spillerTeller).getPos() + 1, spillere.get(spillerTeller).getName());
			do {
				if(spillere.get(spillerTeller).getTellerSeks() > 0) {
					spillerUI.skrivFikkSeks();
				}
				
				//button();
				int terningVerdi = terning.trill();
				spillerUI.terningVerdi(terningVerdi);
				
				if(spillere.get(spillerTeller).getTripleSix()) {
					if(terningVerdi != 6) {
						break;
					}
				}
				
				int pos = spillere.get(spillerTeller).spillTur(terningVerdi, spillerUI);
				
				
				spillerUI.printBrett(spillere.get(spillerTeller).getPos() + 1, spillere.get(spillerTeller).getName());
				
				if(spillere.get(spillerTeller).getHarVunnet()) {
					break;
				}
				
				spillere.get(spillerTeller).updatePos(brett.ruteEffekt(pos));
				spillerUI.effekt(brett.getEffekt(pos), spillere.get(spillerTeller).getPos() + 1, spillere.get(spillerTeller).getName());
				
			} while (spillere.get(spillerTeller).getTellerSeks() > 0 && spillere.get(spillerTeller).getTellerSeks() < 3);
			
			if(spillere.get(spillerTeller).getHarVunnet()) {
				spillerUI.vunnet(spillere.get(spillerTeller).getName());
				break;
			}
			
			spillerTeller++;
			if(spillerTeller >= spillere.size()) {
				spillerTeller = 0;
			}
			
		}

	}
	
	private void button() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
