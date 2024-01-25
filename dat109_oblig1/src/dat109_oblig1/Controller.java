package dat109_oblig1;

import java.util.List;

public class Controller {
	
	private SpillerUI spillerUI;
	
	public Controller() {
		this.spillerUI = new SpillerUI();
	}
	
	public void start(Brett brett, Terning terning, List<Spiller> spillere) {
		int teller = 0;
		
		while (true) {
			spillerUI.nySpillerTur(spillere.get(teller).getName());
			spillerUI.printBrett(spillere.get(teller).getPos() + 1, spillere.get(teller).getName());
			do {
				if(spillere.get(teller).getTeller() > 0) {
					spillerUI.skrivFikkSeks();
				}
				
				int terningVerdi = terning.trill();
				spillerUI.terningVerdi(terningVerdi);
				
				if(spillere.get(teller).getTripleSix()) {
					spillerUI.fangetMelding();
					if(terningVerdi != 6) {
						spillerUI.fortsattFanget(terningVerdi);
						break;
					}
					else {
						spillerUI.ikkeFanget();
					}
				}
				
				int pos = spillere.get(teller).spillTur(terningVerdi);
				
				if(spillere.get(teller).getTripleSix()) {
					spillerUI.trippelSeks();
				}
				
				spillerUI.printBrett(spillere.get(teller).getPos() + 1, spillere.get(teller).getName());
				spillerUI.effekt(brett.getEffekt(pos));
				spillere.get(teller).updatePos(brett.ruteEffekt(pos));
				spillerUI.printBrett(spillere.get(teller).getPos() + 1, spillere.get(teller).getName());
			} while (spillere.get(teller).getTeller() > 0 && spillere.get(teller).getTeller() < 3);
			
			if(spillere.get(teller).getHarVunnet()) {
				avsluttSpill(spillere.get(teller).getName());
				break;
			}
			
			teller++;
			if(teller >= spillere.size() - 1) {
				teller = 0;
			}
		}

	}
	
	
	private void avsluttSpill(String navn) {
		spillerUI.vunnet(navn);
	}
}
