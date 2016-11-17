package aufgabenblatt3;

/**
 * Simulations Klasse für den Rangierbahnhof, welche alle 500ms Lokfuehrer
 * Threads erstellt.
 * 
 * @author acc378
 *
 */
public class Simulation implements Runnable {
	/**
	 * Objekt, dass unseren Rangierbahnhof repreasentiert.
	 */
	private Rangierbahnhof bahnhof;

	/**
	 * 
	 * @param bahnhof
	 */
	public Simulation(GUI gui, int anzahlGleise) {
		this.bahnhof = new Rangierbahnhof(anzahlGleise);
		bahnhof.addObserver(gui);
	}

	/**
	 * Hauptmethode des Threads. Erstellt alle 500ms einen Lokfuehrer mit einer
	 * randomisierten Aufgabe und startet ihn.
	 */
	@Override
	public void run() {
		int aufgabe;
		Lokfuehrer lokfuehrer = null;
		while (true) {
			aufgabe = (int) (Math.random() * 2);
			switch (aufgabe) {
			case 0:
				lokfuehrer = new Lokfuehrer(Lokfuehrer.Aufgabe.EINFAHREN, bahnhof);
				break;
			case 1:
				lokfuehrer = new Lokfuehrer(Lokfuehrer.Aufgabe.AUSFAHREN, bahnhof);
				break;
			}
			lokfuehrer.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}