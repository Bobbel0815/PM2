package aufgabenblatt1.p3;


public class ArrayListe<T extends Comparable<T>>{
	
private int anzahlElemente;
private Object[] elemente;

	public ArrayListe(){
		this.anzahlElemente = 0;
		this.elemente= new Object[2] ;
			}
	
	public void hinzufuegen(T neuesElement){
		elemente[anzahlElemente] = neuesElement;
		anzahlElemente++;
		if(anzahlElemente == elemente.length){
			Object[] neue_elemente = new Object[anzahlElemente*2];
			System.arraycopy(elemente, 0, neue_elemente, 0, anzahlElemente);
			elemente = neue_elemente;
		}
	}
	
	public T get(int index){
		if(index < anzahlElemente && elemente[index] != null){
			
			return (T)elemente[index];
			
			}
		return null;
	}
	
	public void entfernen(T altesElement){
		for(int i=0; i< anzahlElemente;i++){
			if(elemente[i].equals(altesElement)){
				entferneElementAnIndex(i);
				i--;
			}
		}
		
	}
	
	public void entferneElementAnIndex(int index){
		if(index < anzahlElemente){
			elemente[index] = null;
			for(int i = index+1; i < anzahlElemente;i++){
				elemente[i-1] = elemente[i];
			}
			anzahlElemente--;
		}
	}
	
	public int getAnzahlElemente(){
		return anzahlElemente;
	}
	
	public String toString(){
		String string = "[";
			for(int i =0; i< anzahlElemente; i++){
				if(i>0){
					string +=",";
				}
				string += elemente[i].toString();
			}
			string+= "]";
		return string;
	}
	
	public T getKleinstesElement(){
		T kleinstes_element= null;
		
		for(int i = 0; i < anzahlElemente;i++){
			if(i == 0){
				kleinstes_element = (T)elemente[i];
			}
			if(kleinstes_element.compareTo((T)elemente[i]) > 0){
				kleinstes_element = (T)elemente[i];
			}
		}
		return kleinstes_element;
	}
	
	public static void main(String[] args){
		ArrayListe<Integer> liste= new ArrayListe<>();
		liste.hinzufuegen(28);
		liste.hinzufuegen(24);
		liste.entfernen(28);
		liste.hinzufuegen(25);
		liste.hinzufuegen(13);
		liste.hinzufuegen(30);
		liste.hinzufuegen(8);
		liste.hinzufuegen(22);
		System.out.println(liste.toString());
		System.out.println(liste.getKleinstesElement());
	}
	
} 




