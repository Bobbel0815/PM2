package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Threads.Flugzeug.Status;

public class Flughafen {
	int zeit;
	int anzahlFlugzeuge;
	List<Flugzeug> flugzeuge;

	public Flughafen(int anzahlFlugzeuge) {

		this.anzahlFlugzeuge = anzahlFlugzeuge;
		flugzeuge = new ArrayList<Flugzeug>();
		erzeugeFlugzeug(this, anzahlFlugzeuge);
	}

	public void run() {
		zeit = 1;
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < flugzeuge.size(); i++) {
				Flugzeug flugzeug = flugzeuge.get(i);
				int flugdauer = flugzeug.getFlugdauer();
				int startZeit = flugzeug.getStartZeit();
				
				if (flugdauer == 0) {
					flugzeug.setStatus(Status.IM_LANDEANFLUG);
					this.landen(flugzeug);
				}
				
				if(flugzeug.status == Status.IM_FLUG){
					flugzeug.setFlugdauer(flugdauer-1);
				}
				
				
				zeit++;
				System.out.println(flugzeuge.get(i).toString());
			}
			
		}
	
	}

	public synchronized void landen(Flugzeug flugzeug) {

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flugzeug.setStatus(Status.GELANDET);
		System.out.println("->Flugzeug gelandet: " + flugzeug.toString());
		int index = flugzeuge.indexOf(flugzeug);
		
		
		for(int i = flugzeuge.indexOf(flugzeug)+1; i < anzahlFlugzeuge;i++){
			flugzeuge.set((flugzeuge.indexOf(i)-1),flugzeuge.get(i));
		
		}
		
		
	}

	public void erzeugeFlugzeug(Flughafen flughafen, int anzahlFlugzeuge) {
		Random random = new Random();

		for (int i = 0; i < anzahlFlugzeuge; i++) {

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

			

			flugdauer = random.nextInt(10) + 1;
			id += " " + kennung;
			Flugzeug flugzeug = new Flugzeug(id, flugdauer, this, zeit);
			
			System.out.println("->Neues Flugzeug erzeugt: Flugzeug "+id+" ("+flugzeug.getStatus()+", Zeit bis Ziel: "+flugdauer+")");
			flugzeuge.add(flugzeug);
			
		}

	}

	public static void main(String[] args) {
		Flughafen flughafen = new Flughafen(3);
		flughafen.run();
	

	}
}
