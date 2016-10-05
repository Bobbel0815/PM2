package aufgabenblatt1.p2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class XmlSchreiber {
	

	Document doc;
	
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	
	public XmlSchreiber(Sensor sensor){
		
		docFactory = DocumentBuilderFactory.newInstance();
		doc = docBuilder.newDocument();
		Element rootelement = doc.createElement("Sensor");
		doc.appendChild(rootelement);
		Element messung = doc.createElement("Messung");
		
		
	}
}
