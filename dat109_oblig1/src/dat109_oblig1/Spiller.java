package dat109_oblig1;

public class Spiller {
	
	public String navn;
	private int teller;
	private Brikke brikke;
	
	public Spiller() {
		this.brikke = new Brikke();
	}
	
	int spillTur(int terning) {
		int terningVerdi = terning;
		int sumPos = brikke.getPosisjon() + terningVerdi;
		
		if(terningVerdi == 6) {
			teller++;
			if(teller == 3) {
				brikke.setPosisjon(0);
				//Husk å breake funskjonen her
			}
		}
		
		if(brikke.getPosisjon() >= 93) {
			if(sumPos > 99) {
				//Husk å breake metoden her
			}
		}
		
		if(sumPos == 99) {
			brikke.setPosisjon(sumPos);
			//Skriv ut at spilleren har vunnet
			// Husk å breake metoden og avslutt spillet
		}
		
		brikke.setPosisjon(sumPos);
		return sumPos;
	}
	
	void resetTeller() {
		this.teller = 0;
	}
}
