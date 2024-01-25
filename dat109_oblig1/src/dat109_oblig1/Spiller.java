package dat109_oblig1;

public class Spiller {
	
	public String name;
	private int teller;
	private Brikke brikke;
	private boolean tripleSix;
	private boolean harVunnet;
	
	public Spiller(String name) {
		this.brikke = new Brikke();
		this.name = name;
		this.tripleSix = false;
		this.harVunnet = false;
	}
	
	int spillTur(int terning) {
		int sumPos = brikke.getPosisjon() + terning;
		
		if(tripleSix == true) {
			if(terning != 6) {
				//Break her
			}
			else {
				tripleSix = false;
			}
		}
		
		if(terning != 6) {
			resetTeller();
			}
		else {
			teller++;
			if(teller == 3) {
				brikke.setPosisjon(0);
				tripleSix = true;
				resetTeller();
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
			this.harVunnet = true;
			//Skriv ut at spilleren har vunnet
			// Husk å breake metoden og avslutt spillet
		}
		
		brikke.setPosisjon(sumPos);
		return sumPos;
	}
	
	private void resetTeller() {
		this.teller = 0;
	}
	
	public int getTeller() {
		return teller;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void updatePos(int pos) {
		brikke.setPosisjon(pos);
	}
	
	public int getPos() {
		return brikke.getPosisjon();
	}
	
	public boolean getTripleSix() {
		return this.tripleSix;
	}
	
	public boolean getHarVunnet() {
		return this.harVunnet;
	}
}
