package aufgabenblatt2.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner  {

	private DoubleDoubleZuDouble multiplikation = (zahl1,zahl2) -> {return zahl1*zahl2;};
	
	private enum Operation {ADDITION,SUBTRAKTION,MULTIPLIKATION,DIVISION};
	
	private Map<Operation,BinaryOperator<Double>>menge = new HashMap<Operation,BinaryOperator<Double>>();
	
	
	
	public Rechner(){
		menge.put(Operation.ADDITION, (zahl1,zahl2)-> zahl1+zahl2);
		menge.put(Operation.SUBTRAKTION,(zahl1,zahl2)-> zahl1+zahl2);
		menge.put(Operation.MULTIPLIKATION,(zahl1,zahl2)-> zahl1*zahl2);
		menge.put(Operation.DIVISION,(zahl1,zahl2)-> zahl1/zahl2);
	}
	
	public double berechne(Operation operation, double zahl1, double zahl2 ){
		return menge.get(operation).apply(zahl1, zahl2);	
	}
	
		
	
	
	public static void main (String[]args){
		Rechner rechner = new Rechner();
		System.out.println(rechner.berechne(Operation.MULTIPLIKATION, 5, 5));
		System.out.println(rechner.multiplikation.werteAus(5, 5));
	}

	
	
	
	
}

