package dat109_oblig1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Slangespill {
	private Brett brett;
	private List<Spiller> spillere = new ArrayList<>();
	private Terning terning;
	private int antallSpillere;
	private Controller controller;
	
	public Slangespill() {
		brett = new Brett();
		terning = new Terning();
		controller = new Controller();
		antallSpillere = skrivSpillere();
		String[] spillernavn = getSpillerNames();
		for(int i = 0; i < antallSpillere; i++) {
			spillere.add(new Spiller(spillernavn[i]));
		}
		controller.start(brett, terning, spillere);
	}

	public int skrivSpillere() {
		int brukerInput = 0;
		Scanner scanner = new Scanner(System.in);
		while (brukerInput != 2 && brukerInput != 3 && brukerInput != 4) {

			System.out.print("Skriv inn hvor mange spillere (mellom 2 og 4): ");
			brukerInput = scanner.nextInt();
			scanner.nextLine();
		}
		return brukerInput;
	}

	
	private String[] getSpillerNames() {
		String brukerInput = "No name";
		String[] alleSpillerNavn = new String[antallSpillere];
		int teller = 0;
		Scanner scanner = new Scanner(System.in);
		while (this.antallSpillere > teller) {
			System.out.print("Skriv inn spillernavn: ");
			brukerInput = scanner.nextLine();
			alleSpillerNavn[teller] = brukerInput;
			teller++;
		}
		scanner.close();
		return alleSpillerNavn;
	}
}
