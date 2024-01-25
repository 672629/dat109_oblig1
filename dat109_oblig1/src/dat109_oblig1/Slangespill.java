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
		String[] spillernavn = getSpillerNames();
		for(int i = 0; i < antallSpillere; i++) {
			spillere.add(new Spiller(spillernavn[i]));
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


	public void start() {

		do {
			int terningVerdi = terning.trill();
			int pos = spiller.spillTur(terningVerdi);
			spiller.updatePos(brett.ruteEffekt(pos));
		} while (spiller.getTeller() > 0 && spiller.getTeller() < 3);

	}
	
	private String[] getSpillerNames() {
		String brukerInput = "No name";
		String[] alleSpillerNavn;
		int teller = 0;
		while (this.antallSpillere > teller) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Skriv inn spillernavn: ");
			brukerInput = scanner.nextLine();
			scanner.close();
			alleSpillerNavn[i] = brukerInput;
			teller++;
		}
		return alleSpillerNavn;
	}
}
