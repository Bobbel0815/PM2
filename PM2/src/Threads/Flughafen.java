package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Threads.Flugzeug.Status;
/**
 * Diese Klasse repraesentiert einen Flughafen mit einer Landebahn.
 * @author acc378
 *
 */
public class Flughafen extends Thread {
	/**
	 * Zeitschritt der pro run() Auruf, erhoet wird.
	 */
	int zeit;
	/**
	 * Anzahl von Flugzeugen in der Liste.
	 */
	int anzahlFlugzeuge;
	/**
	 * Liste vom Typ Flugzeug.
	 */
	List<Flugzeug> flugzeuge;

	public Flughafen(int anzahlFlugzeuge) {

		this.anzahlFlugzeuge = anzahlFlugzeuge;
		flugzeuge = new ArrayList<Flugzeug>();
		erzeugeFlugzeug(this, anzahlFlugzeuge);
	}

	/**
	 * Hauptmethode des Thread. Gibt alle 500ms alle Stati der Fluzeuge aus.
	 * Aktualisiert die Flugdauer und die Zeit.
	 */
	public void run() {
		zeit = 1;
		while (true) {
			System.out.println("\nZeit: " + zeit);

			if (flugzeuge.size() < anzahlFlugzeuge) {
				erzeugeFlugzeug(this, 1);
			}
			for (int i = 0; i < flugzeuge.size(); i++) {
				Flugzeug flugzeug = flugzeuge.get(i);
				
						flugzeug.setFlugdauer();
					

					System.out.println(flugzeuge.get(i).toString());
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			zeit++;
		}
}

	

	/**
	 * Synchornisierte Methode, die alle 1500ms ein FLugzeug mit der Flugdauer
	 * 0, landen laesst. Und es dann aus der Liste entfernt.
	 * 
	 * @param flugzeug
	 */
	public synchronized void landen(Flugzeug flugzeug) {
		flugzeug.setStatus(Status.IM_LANDEANFLUG);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flugzeug.setStatus(Status.GELANDET);
		System.out.println("->Flugzeug gelandet: " + flugzeug.toString());
		flugzeuge.remove(flugzeug);

		// System.out.println("anzahlflugzeuge: "+anzahlFlugzeuge+ "listengröße:
		// "+ flugzeuge.size());

	}

	/**
	 * Erzeugt mit Hilfe von vordefinierten Fluglinien und einer randomisierten
	 * Kennung, die ID eines Flugzeuges, eine zufaellig Flugdauer, erstellt dieses und fuegt es der Liste zu.
	 * Startet jeden Flugzeug Thread. 
	 * @param flughafen
	 * @param flugzeugZahl
	 */
	public void erzeugeFlugzeug(Flughafen flughafen, int flugzeugZahl) {
		Random random = new Random();

		for (int i = 0; i < flugzeugZahl; i++) {

			int randomAirline = random.nextInt(6) + 1;
			int flugdauer = 0;
			String id = "";
			int kennung;

			switch (randomAirline) {
			case 1:
				id = "Lufthansa";
				break;
			case 2:
				id = "Ryanair";
				break;
			case 3:
				id = "Emirates";
				break;
			case 4:
				id = "Turkish Airlines";
				break;
			case 5:
				id = "Air France";
				break;
			case 6:
				id = "American Airlines";
				break;
			}
			kennung = random.nextInt(8999) + 1000;

			flugdauer = random.nextInt(100) + 1;
			id += " " + kennung;
			Flugzeug flugzeug = new Flugzeug(id, flugdauer, this, zeit);
			flugzeug.start();
			System.out.println("->Neues Flugzeug erzeugt: Flugzeug " + id + " (" + flugzeug.getStatus()
					+ ", Zeit bis Ziel: " + flugdauer + ")");
			flugzeuge.add(flugzeug);

		}

	}

	public static void main(String[] args) {
		Flughafen flughafen = new Flughafen(10);
		flughafen.start();

	}
}
