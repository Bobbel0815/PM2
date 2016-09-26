package aufgabenblatt1.p2;

import java.time.LocalDateTime;

public class Messungen {

	private double wert;
	private LocalDateTime zeitstempel;
	
	public Messungen(double wert, LocalDateTime zeitstempel) {
		this.wert = wert;
		this.zeitstempel = zeitstempel;
	}

	public double getWert() {
		return wert;
	}

	public LocalDateTime getZeitstempel() {
		return zeitstempel;
	}
}
