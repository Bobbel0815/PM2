package aufgabenblatt1.p1;

public class Pruefungsleistung {

	private String modulname;
	private int note;
	
	public Pruefungsleistung(String modulname, int note) {
		
		this.modulname = modulname;
		this.note = note;
	}

	public String getModulname() {
		return modulname;
	}

	public int getNote() {
		return note;
	}
	
}
