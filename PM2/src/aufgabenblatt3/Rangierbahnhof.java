package aufgabenblatt3;

import java.util.Observable;



public class Rangierbahnhof extends Observable {
/**
 * Ein Array vom Typ Zug.
 */
	private Zug[] gleise;
	/**
	 * Variable zum mitgeben der Aufgabe und des Gleises.
	 */
	private int change;

	public Rangierbahnhof(int anzahlGleise) {
		gleise = new Zug[anzahlGleise];
	}
/**
 * Synchronisierte Methode zum Einfahren eines Zuges wenn das Gleis frei ist.
 * Erstellt dabei ein neues Zug Objekt.
 * Benachrichtig wartenden Threads und Beobachter.
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
		System.out.println("Zug ist auf Gleis " + (gleis+1) + " eingefahren.");
		change = gleis * 10 + 1;
		setChanged();
		notifyObservers();
		notify();
	}
/**
 * Synchronisierte Methode zum Ausfahren eines Zuges wenn das Gleis besetzt ist.
 * Benachrichtig wartenden Threads und Beobachter.
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
		System.out.println("\t\tZug ist aus Gleis " + (gleis+1) + " ausgefahren.");
		change = gleis * 10 + 0;
		setChanged();
		notifyObservers();
		notify();
	}

	public int getGleiseLaenge() {
		return gleise.length;
	}

	public int getChange(){
		return change;
	}
}