package aufgabenblatt1.p1;

import java.util.Comparator;

public class VornameVergleich implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		
		return student1.getVorname().compareTo(student2.getVorname());
		
	}

}


