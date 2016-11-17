package aufgabenblatt3;

/**
 * Diese Klasse beschreibt einen Lokfuehrer Thread, der einen Zug Ein- oder
 * Ausfahren kann.
 * 
 * @author acc378
 *
 */
public class Lokfuehrer extends Thread {

	public static enum Aufgabe {
		EINFAHREN, AUSFAHREN
	}

	/**
	 * Aufgabe die der Lokfuehrer ausfuehren soll. Entweder einfahren oder
	 * ausfahren.
	 */
	private Aufgabe aufgabe;
	/**
	 * 
	 */
	private Rangierbahnhof bahnhof;

	public Lokfuehrer(Aufgabe aufgabe, Rangierbahnhof bahnhof) {
		this.aufgabe = aufgabe;
		this.bahnhof = bahnhof;
	}

	/**
	 * Die Hauptmethode des threads. Wenn eine 0 mitgegeben wird, f�hrt ein
	 * Zug ein, bei 1 aus
	 */
	public void run() {
		switch (aufgabe) {
		case EINFAHREN:
			bahnhof.einfahren((int) (Math.random() * bahnhof.getGleiseLaenge()));
			break;
		case AUSFAHREN:
			bahnhof.ausfahren((int) (Math.random() * bahnhof.getGleiseLaenge()));
			break;
		}
	}

}