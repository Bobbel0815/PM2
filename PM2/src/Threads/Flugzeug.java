package Threads;

public class Flugzeug {

	private String id;
	private int flugdauer;
	private Flughafen flughafen;
	private int startZeit;

	public enum Status {
		IM_FLUG, IM_LANDEANFLUG, GELANDET
	}

	private int zeit;
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
