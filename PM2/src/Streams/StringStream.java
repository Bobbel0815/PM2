package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStream {
	String[] text;

	public StringStream(String[] text) {
		this.text = text;
	}

	public List<String> ordnen() {
		List<String> eingabe = Arrays.asList(text);
		List<String> ausgabe = new ArrayList<>();
		eingabe.stream()
			.filter(Objects::nonNull)
			.map(String::toUpperCase)
			.map(String::trim)
			.map(s->s.substring(0, 7))
			.map(s->s.replaceAll("Ä", "AE"))
			.map(s->s.replaceAll("Ö", "OE"))
			.map(s->s.replaceAll("Ü", "UE"))
			.map(s->s.replaceAll("ß", "SS"))
			.forEach(ausgabe::add);
		return ausgabe;
		
		
		
		
		
	}
	
	
	public static void main (String[] args){
		String[] text = {"Eingabe ", "Äußeres ", null, "Strassen-Feger", " ein Haus" };
		StringStream stream = new StringStream(text);
		System.out.println(stream.ordnen());
	}
		

}
