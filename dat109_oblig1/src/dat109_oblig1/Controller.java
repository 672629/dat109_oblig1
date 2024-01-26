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
		Spiller spiller = spillere.get(spillerTeller);

		while (true) {
			spiller = spillere.get(spillerTeller);
			printAtNySpiller(spiller);
			do {
				harFattSeks(spiller);

				// button();
				int terningVerdi = terning.trill();
				spillerUI.terningVerdi(terningVerdi);

				if (erFanget(spiller, terningVerdi)) {
					break;
				}

				int pos = spiller.spillTur(terningVerdi, spillerUI);

				printBrettFraUI(spiller);

				if (spiller.getHarVunnet()) {
					break;
				}

				oppdaterPosOgPrintHvisEffekt(spiller, brett, pos);

			} while (spiller.getTellerSeks() > 0
					&& spiller.getTellerSeks() < 3);

			if (spiller.getHarVunnet()) {
				spillerUI.vunnet(spiller.getName());
				break;
			}

			spillerTeller++;
			if (spillerTeller >= spillere.size()) {
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

	private void printAtNySpiller(Spiller spiller) {
		spillerUI.nySpillerTur(spiller.getName());
		printBrettFraUI(spiller);
	}
	
	private void printBrettFraUI(Spiller spiller) {
		spillerUI.printBrett(spiller.getPos() + 1, spiller.getName());
		
	}
	

	private void harFattSeks(Spiller spiller) {
		if (spiller.getTellerSeks() > 0) {
			spillerUI.skrivFikkSeks();
		}
	}

	private boolean erFanget(Spiller spiller, int terningVerdi) {
		if (spiller.getTripleSix()) {
			if (terningVerdi != 6) {
				return true;
			}
		}
		return false;
	}
	
	private void oppdaterPosOgPrintHvisEffekt(Spiller spiller, Brett brett, int pos) {
		spiller.updatePos(brett.ruteEffekt(pos));
		spillerUI.effekt(brett.getEffekt(pos), spiller.getPos() + 1,
				spiller.getName());
	}
	
	/*potensiell UI fiks for å få UI bare i controller kan gjøre liknende -
	 * metoder for de andre som bruker UI
	 * 
	 * private void spillerSluppetFri(Spiller spiller, int terningVerdi){
	 * 		if(spiller.getTripleSix() && terningVerdi == 6){
	 * 			spillerUi.ikkeFanget();
	 * 		}
	 * }
	 */

}
