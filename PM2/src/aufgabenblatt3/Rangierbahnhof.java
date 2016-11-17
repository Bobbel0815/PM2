package aufgabenblatt3;

import java.util.Observable;

/**
 * Diese Klasse beschreibt den Rangierbahnhof mit einer Anzahl von Gleisen auf
 * denen Züge stehen können.
 * 
 * @author acc378
 *
 */
public class Rangierbahnhof extends Observable {
	/**
	 * Ein Array vom Typ Zug.
	 */
	private Zug[] gleise;
	/**
	 * Variable zum mitgeben der Aufgabe und des Gleises.
	 */
	private UpdateSpeicher change;

	public Rangierbahnhof(int anzahlGleise) {
		gleise = new Zug[anzahlGleise];
		change = new UpdateSpeicher();
	}

	/**
	 * Synchronisierte Methode zum Einfahren eines Zuges wenn das Gleis frei
	 * ist. Erstellt dabei ein neues Zug Objekt. Benachrichtig wartenden Threads
	 * und Beobachter.
	 * 
	 * @param gleis
	 */
	public synchronized void einfahren(int gleis) {
		while (gleise[gleis] != null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gleise[gleis] = new Zug();
		System.out.println("Zug ist auf Gleis " + (gleis + 1) + " eingefahren.");
		change.setGleis(gleis);
		change.setAufgabe(Lokfuehrer.Aufgabe.EINFAHREN);
		setChanged();
		notifyObservers(change);
		notify();
	}

	/**
	 * Synchronisierte Methode zum Ausfahren eines Zuges wenn das Gleis besetzt
	 * ist. Benachrichtig wartenden Threads und Beobachter.
	 * 
	 * @param gleis
	 */
	public synchronized void ausfahren(int gleis) {
		while (gleise[gleis] == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gleise[gleis] = null;
		System.out.println("\t\tZug ist aus Gleis " + (gleis + 1) + " ausgefahren.");
		change.setGleis(gleis);
		change.setAufgabe(Lokfuehrer.Aufgabe.AUSFAHREN);
		setChanged();
		notifyObservers(change);
		notify();
	}

	public int getGleiseLaenge() {
		return gleise.length;
	}
}