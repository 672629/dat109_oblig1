package dat109_oblig1;

import java.util.ArrayList;
import java.util.List;

public class Brett {
	private List<Ruter> ruter = new ArrayList();

	public Brett() {
		for (int i = 0; i <= 99; i++) {
			ruter.add(new Ruter());
		}
	}

	public int ruteEffekt(int pos) {

		int effekt = ruter.get(pos).getEffekt();

		if (effekt < 0) {
			// print slangeEffekt
		}
		if (effekt > 0) {
			// print stigeeffekt
		}
		pos = pos + effekt;
		return pos;
	}
	
	public int getEffekt(int pos) {
		return ruter.get(pos).getEffekt();
	}

}
