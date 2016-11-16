package aufgabenblatt3;

public class Lokfuehrer extends Thread {
	/**
	 * Aufgabe die der Lokfuehrer ausfuehren soll. Entweder einfahren oder
	 * ausfahren.
	 */
	private int aufgabe;
	/**
	 * 
	 */
	private Rangierbahnhof bahnhof;

	public Lokfuehrer(int aufgabe, Rangierbahnhof bahnhof) {
		this.aufgabe = aufgabe;
		this.bahnhof = bahnhof;
	}

	/**
	 * Die Hauptmethode des threads. Wenn eine 0 mitgegeben wird, f�hrt ein Zug
	 * ein, bei 1 aus
	 */
	public void run() {
		switch (aufgabe) {
		case 0:
			bahnhof.einfahren((int) (Math.random() * bahnhof.getGleiseLaenge()));
			break;
		case 1:
			bahnhof.ausfahren((int) (Math.random() * bahnhof.getGleiseLaenge()));
			break;
		}
	}

}