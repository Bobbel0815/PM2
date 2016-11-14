package aufgabenblatt3.Rangierbahnhof;

import java.util.Observable;

import aufgabenblatt3.Zug.Zug;

public class Rangierbahnhof extends Observable {

	private Zug[] gleise;
	private int change;

	public Rangierbahnhof(int anzahlGleise) {
		gleise = new Zug[anzahlGleise];
	}

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
