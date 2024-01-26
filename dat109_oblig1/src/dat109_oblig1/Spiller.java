package dat109_oblig1;

public class Spiller {
	
	public String name;
	private int tellerSeks;
	private Brikke brikke;
	private boolean tripleSix;
	private boolean harVunnet;
	
	public Spiller(String name) {
		this.brikke = new Brikke();
		this.name = name;
		this.tripleSix = false;
		this.harVunnet = false;
	}
	
	public int spillTur(int terning) {
		int sumPos = brikke.getPosisjon() + terning;
		
		if(tripleSix == true) {
			if(terning != 6) {
				return getPos();
			}
			else {
				tripleSix = false;
			}
		}
		
		if(terning != 6) {
			resetTeller();
			}
		else {
			tellerSeks++;
			if(tellerSeks == 3) {
				brikke.setPosisjon(0);
				tripleSix = true;
				resetTeller();
				return getPos();
			}
		}
		
		if(brikke.getPosisjon() >= 93) {
			if(sumPos > 99) {
				return getPos();
			}
		}
		
		brikke.setPosisjon(sumPos);
		return sumPos;
	}
	
	private void resetTeller() {
		this.tellerSeks = 0;
	}
	
	public int getTellerSeks() {
		return tellerSeks;
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
	
	public void setHarVunnet() {
		this.harVunnet  = true;
	}
}
