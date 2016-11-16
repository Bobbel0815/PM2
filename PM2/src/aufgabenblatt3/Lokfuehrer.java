package aufgabenblatt3;



public class Lokfuehrer extends Thread {

	private int aufgabe;
	private Rangierbahnhof bahnhof;

	public Lokfuehrer(int aufgabe, Rangierbahnhof bahnhof) {
		this.aufgabe = aufgabe;
		this.bahnhof = bahnhof;
	}

	public void run() {
		switch (aufgabe) {
		case 0:
			bahnhof.einfahren((int) (Math.random() * bahnhof.getGleiseLaenge()) );
			break;
		case 1:
			bahnhof.ausfahren((int) (Math.random() * bahnhof.getGleiseLaenge()) );
			break;
		}
	}

}