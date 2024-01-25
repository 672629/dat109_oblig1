package dat109_oblig1;

import java.util.List;
import java.util.Scanner;

public class Slangespill {
	private Brett brett;
	private List<Spiller> spillere;
	private Terning terning;
	private int antallSpillere;
	private Controller controller;
	
	public Slangespill() {
		brett = new Brett();
		terning = new Terning();
		antallSpillere = skrivSpillere();
		String[] spillernavn = getSpillerNames();
		for(int i = 0; i < antallSpillere; i++) {
			spillere.add(new Spiller(spillernavn[i]));
		}
		controller.start(brett, terning, spillere);
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
		int teller = 0;
		while(!spillere[teller].getharvunnet()) {
		}
		do {
			int terningVerdi = terning.trill();
			int pos = spiller.spillTur(terningVerdi);
			spiller.updatePos(brett.ruteEffekt(pos));
		} while (spiller.getTeller() > 0 && spiller.getTeller() < 3);
		
		teller++;
		if(teller = spillere.size()) {
			teller = 0;
		}

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
			alleSpillerNavn[teller] = brukerInput;
			teller++;
		}
		return alleSpillerNavn;
	}
}
