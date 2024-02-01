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

				int terningVerdi = terning.trill();
				spillerUI.terningVerdi(terningVerdi);
				

				if (erFanget(spiller, terningVerdi) || erOverHundre(spiller, terningVerdi)) {
					break;
				}

				int pos = spiller.spillTur(terningVerdi);
				
				printHvisTrippelSeks(spiller);

				printBrettFraUI(spiller);

				oppdaterPosOgPrintHvisEffekt(spiller, brett, pos);
				
				if(sjekkOgSettVunnet(spiller)) {
					break;
				}

			} while (spiller.getTellerSeks() > 0 && spiller.getTellerSeks() < 3);

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
				spillerUI.fangetMelding();
				return true;
			}
			spillerUI.ikkeFanget();
		}
		return false;
	}

	private void oppdaterPosOgPrintHvisEffekt(Spiller spiller, Brett brett, int pos) {
		spiller.updatePos(brett.ruteEffekt(pos));
		spillerUI.effekt(brett.getEffekt(pos), spiller.getPos() + 1, spiller.getName());
	}


	private void printHvisTrippelSeks(Spiller spiller) {
		if (spiller.getTripleSix()) {
			spillerUI.trippelSeks();
			spillerUI.fangetMelding();
		}
	}
	
	private boolean erOverHundre(Spiller spiller, int terningVerdi) {
		int spillerpos = spiller.getPos();
		int total = spillerpos + terningVerdi;
		if(spillerpos >= 93) {
			if(total > 99) {
				spillerUI.overHundre(spillerpos + 1);
				return true;
			}
		}
		return false;
	}
	
	private boolean sjekkOgSettVunnet(Spiller spiller) {
		if(spiller.getPos() == 99) {
			spiller.setHarVunnet();
		}
		return spiller.getHarVunnet();
	}

}
