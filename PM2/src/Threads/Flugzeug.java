package Threads;

import Threads.Flugzeug.Status;

public class Flugzeug extends Thread{
	/**
	 * ID des Flugzeuges
	 */
	private String id;
	/**
	 * Flugdauer eines FLugzeuges.
	 */
	private int flugdauer;
	/**
	 * Flughafen auf dem gestartet und gelandet wird.
	 */
	private Flughafen flughafen;
	/**
	 * Startzeit eines Flugzeuges.
	 */
	private int startZeit;
	/**
	 * Status eines Flugzeuges in Form eines Enums.
	 * @author Dennis
	 *
	 */
	public enum Status {
		IM_FLUG, IM_LANDEANFLUG, GELANDET
	}
	
	
	Status status;

	public Flugzeug(String id, int fludauer, Flughafen flughafen, int startZeit) {
		this.id = id;
		this.flugdauer = fludauer;
		this.flughafen = flughafen;
		status = Status.IM_FLUG;
	}

	public boolean istGelandet() {
		if (status == Status.GELANDET) {
			return true;
		}
		return false;
	}

	public void setFlugdauer(int zeit) {
		this.flugdauer = zeit;
	}

	public int getFlugdauer() {
		return flugdauer;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void run() {
		while (flugdauer > 0) {
			while(flugdauer>0){
				try {
	 				sleep(250);
	 			} catch (InterruptedException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 		}
	 		flughafen.landen(this);
	 		
	}
	}
	public int getStartZeit() {
		// TODO Auto-generated method stub
		return startZeit;
	}

	@Override
	public String toString() {
		return "Flugzeug " + id+" ( "+status +  ", Zeit bis Ziel: " + flugdauer+")";
	}
}
