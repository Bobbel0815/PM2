package aufgabenblatt1.p1;

import java.util.List;

public class Student implements Comparable<Student>{

	private String vorname;
	private String nachname;
	private int matrikelnummer;
	private List<Pruefungsleistung> liste;
	
	public Student(String vorname, String nachname, int matrikelnummer, List<Pruefungsleistung> liste){
		this.vorname=vorname;
		this.nachname =nachname;
		this.matrikelnummer=matrikelnummer;
		this.liste=liste;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	@Override
	public int hashCode() {
		
		return matrikelnummer;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikelnummer != other.matrikelnummer)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student andererStudent) {
		
		return Integer.compare(this.matrikelnummer, andererStudent.getMatrikelnummer());
		
	}
}
