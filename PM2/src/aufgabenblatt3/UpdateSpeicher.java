package aufgabenblatt3;

/**
 * Diese Klasse repraesentiert, das Gleis und die Aufgabe welche als Objekt
 * weitergegeben wird.
 * 
 * @author acc378
 *
 */
public class UpdateSpeicher {
	/**
	 * Gleis welches weitergegeben werden soll.
	 */
	private int gleis;
	/**
	 * Aufgabe welche weitergegeben werden soll.
	 */
	private Lokfuehrer.Aufgabe aufgabe;

	public UpdateSpeicher() {
		gleis = 0;
		aufgabe = Lokfuehrer.Aufgabe.EINFAHREN;
	}

	public void setGleis(int gleis) {
		this.gleis = gleis;
	}

	public void setAufgabe(Lokfuehrer.Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}

	public int getGleis() {
		return gleis;
	}

	public Lokfuehrer.Aufgabe getAufgabe() {
		return aufgabe;
	}

}
