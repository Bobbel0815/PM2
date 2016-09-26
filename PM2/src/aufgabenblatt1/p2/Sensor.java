package aufgabenblatt1.p2;

import java.util.List;

public class Sensor {

	private String id;
	private List<Messungen> messungen;
	
	public Sensor(String id, List<Messungen> messungen) {
		
		this.id = id;
		this.messungen = messungen;
	}

	public String getId() {
		return id;
	}

	public List<Messungen> getMessungen() {
		return messungen;
	}
}
