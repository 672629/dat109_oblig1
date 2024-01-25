package dat109_oblig1;

public class SpillerUI {
	
	
	public void skrivFikkSeks() {
		printer("Du fikk 6, kast en gang til");
	}
	
	public void trippelSeks() {
		printer("Du fikk tre seksere på rad og havner nå på rute 1");
	}
	
	public void fangetMelding() {
		printer("Du må rulle en seks for å kunne flytte deg");
	}
	
	public void fortsattFanget(int terning) {
		printer("Du fikk: " + terning + " du må ha 6 for å kunne flytte deg");
	}
	
	public void ikkeFanget() {
		printer("Du rullet en 6 og kan nå flytte deg");
	}
	
	public void effekt(int effekt) {
		if(effekt > 0 ) {
			printer("Du har landet på en stige og går opp " + effekt);
		}else if(effekt < 0) {
			printer("Du har landet på en slange og går ned " + effekt);
		}
	}
	
	public void overHundre(int pos) {
		printer("Du rullet over 100, du forblir i rute: " + pos);
	}
	
	public void vunnet(String navn) {
		printer("Gratulerer " + navn + " du har vunnet!!!!");
	}
	
	public void nySpillerTur(String spillernavn) {
		printer("Det er nå: " + spillernavn + " sin tur");
	}
	
	public void terningVerdi(int terning) {
		printer("Du har rullet " + terning);
	}
	
	public void printBrett(int spillerpos, String navn) {
		for(int i = 1; i <= 100; i++) {
			if(spillerpos != i) {
				System.out.print(i + " ");
			}else {
				System.out.print("[" + i + "] ");
			}
			if(i % 10 == 0) {
				printer("");
			}
		}
		printer("Spiller: " + navn + " er nå på rute: " + spillerpos);
	}
	
	public void printer(String melding) {
		System.out.println(melding);
	}
}
