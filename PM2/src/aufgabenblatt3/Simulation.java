package aufgabenblatt3;

public class Simulation implements Runnable {
	/**
	 * Objekt, dass unseren Rangierbahnhof repreasentiert.
	 */
	private Rangierbahnhof bahnhof;

	/**
	 * 
	 * @param bahnhof
	 */
	public Simulation(Rangierbahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	/**
	 * Hauptmethode des Threads. Erstellt alle 500ms einen Lokfuehrer mit einer
	 * randomisierten Aufgabe und startet ihn.
	 */
	@Override
	public void run() {
		int aufgabe;
		Lokfuehrer lokfuehrer;
		while (true) {
			aufgabe = (int) (Math.random() * 2);
			lokfuehrer = new Lokfuehrer(aufgabe, bahnhof);
			lokfuehrer.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}