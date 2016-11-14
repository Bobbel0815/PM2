package aufgabenblatt3.Simulation;

import aufgabenblatt3.Lokführer.Lokfuehrer;
import aufgabenblatt3.Rangierbahnhof.Rangierbahnhof;

public class Simulation implements Runnable {
	
	private Rangierbahnhof bahnhof;
	
	public Simulation(Rangierbahnhof bahnhof){
		this.bahnhof = bahnhof;
	}

	@Override
	public void run() {
		int aufgabe;
		Lokfuehrer lokfuehrer;
		while(true){
			aufgabe = (int)(Math.random() * 2);
			lokfuehrer = new Lokfuehrer(aufgabe,bahnhof);
			lokfuehrer.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
