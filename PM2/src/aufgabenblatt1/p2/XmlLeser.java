package aufgabenblatt1.p2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlLeser {

	public Document document;
	
	public XmlLeser(String filepath){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		
		DocumentBuilder builder = null;
		try {
			builder= factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		try {
			document = builder.parse(new File(filepath));
		
		} catch (SAXException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Sensor getSensor(){
		
	List<Messungen> messung = new ArrayList<Messungen>();
	String id;
	String wertString;
	double wert;
	LocalDateTime zeitstempel;
	
	Node node = document.getElementsByTagName("Sensor").item(0);
	Element element = (Element) node;
	id = element.getAttribute("id");
	
	NodeList nodeList = element.getElementsByTagName("Messung");
	
	for(int i =0; i< nodeList.getLength();i++){
	element = (Element) nodeList.item(i);
	wertString = element.getAttribute("wert");
	wertString = wertString.replace(',', '.');
	wert = Double.parseDouble(wertString);

	zeitstempel = LocalDateTime.parse(element.getAttribute("zeitstempel"));
	
	messung.add(new Messungen(wert,zeitstempel));
	
	}
	return new Sensor(id,messung);
	}
	public static void main (String[] args){
		
		XmlLeser leser = new XmlLeser("src/aufgabenblatt1/p2/Sensor.xml");
		Sensor sensor = leser.getSensor();
		System.out.println(sensor.getMessungen().get(0).getWert());
		System.out.println(sensor.getMessungen().get(1).getWert());
	}
}
