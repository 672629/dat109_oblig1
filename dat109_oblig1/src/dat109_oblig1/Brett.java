package dat109_oblig1;

import java.util.ArrayList;
import java.util.List;

public class Brett {
	private List<Ruter> ruter = new ArrayList();
	
	public Brett() {
		for(int i = 0; i<=99; i++) {
			ruter.add(new Ruter());
		}
	}
	
	public int sjekkPosisjon(int pos) {
		return ruter.get(pos).getEffekt();
	}
	
}
