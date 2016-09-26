package aufgabenblatt1.p1;

import java.util.Comparator;

public class NachnameVergleich implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		
		return student1.getNachname().compareTo(student2.getNachname());
		
	}

}
