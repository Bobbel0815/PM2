package aufgabenblatt3;

import java.util.Observer;

public class Rangierbahnhof implements Runnable{

	Zug[] zugliste;
	private int anzahlgleise;

	public Rangierbahnhof(int anzahlgleise) {
		this.anzahlgleise = anzahlgleise;
		zugliste = new Zug[anzahlgleise];
		

	}

	public synchronized void einfahren(Zug zug, int gleis) {
		if (zugliste[gleis] == null) {
			zugliste[gleis] = zug;
		}
	}

	public synchronized void ausfahren(Zug zug, int gleis) {
		if (zugliste[gleis] != null) {
			zugliste[gleis] = null;
		}
	}

	@Override
	public void run() {
		eingahren(zug,Math.random()*anzahlgleise);
		ausfahren()
	}

}
