package dat109_oblig1;

import java.util.List;
import java.util.Scanner;

public class Slangespill {
	private Brett brett;
	private List<Spiller> spillere;
	private Terning terning;

	private antallSpillere;
	
	public SlangeSpill() {
		brett = new Brett();
		terning = new Terning();
		antallSpillere = skrivSpillere();
		for(int i = 0; i < antallSpillere; i++) {
			spillere.add(new Spiller(i));
		}
		start();
	}

	public int skrivSpillere() {
		int brukerInput = 0;
		while (brukerInput != 2 && brukerInput != 3 && brukerInput != 4) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Skriv inn hvor mange spillere (mellom 2 og 4): ");
			brukerInput = scanner.nextInt();
			scanner.close();
		}
		return brukerInput;
	}

	public void ruteEffekt(int pos) {
			
			int effekt = brett.sjekkPosisjon(pos);

			if (effekt < 0) {
				// print slangeEffekt
			}
			if (effekt > 0) {
				// print stigeEffekt
			}
			pos = pos + effekt;
		// send pos tilbake kan også sjekke
	}
	
	public void start() {
		
		terningVerdi = terning.trill();
		if(terningVerdi != 6) {
			int pos = spiller.spillTur(terningVerdi);
			ruteEffekt(pos);
		}else {
			while(terningVerdi == 6) {
				int pos = spiller.spillTur(terningVerdi);
				if(pos == 0) {
					break;
				}
				ruteEffekt(pos);
				terningVerdi = terning.trill();
			}
		}
	}
	
	
}
