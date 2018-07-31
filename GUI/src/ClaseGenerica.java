
public class ClaseGenerica <T,E extends Comparable<E> > {
	private T dato;
	private E[] arreglo;
	
	
	
	
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setArreglo(E[] arreglo) {
		this.arreglo = arreglo;
	}

	public E min(){
		E minimo = this.arreglo[0];
		for(E valor:this.arreglo){
			if(minimo.compareTo(valor) > 0  ){
				minimo = valor;
			}
		}
		return minimo;
	}

	public static void main(String[] args) {


		ClaseGenerica <Integer, String> objeto1 = new ClaseGenerica<Integer,String>();
		objeto1.setDato(10);
		System.out.println(objeto1.getDato());

		ClaseGenerica <String, Integer> objeto2 = new ClaseGenerica<String,Integer>();
		objeto2.setDato("Hola!");
		System.out.println(objeto2.getDato());

		// ClaseGenerica <MyException, Integer> objeto3 = new ClaseGenerica<>(); para poder usar algo que no posee comparable, se debe implementar en la otra clase
		// MyException no implementa Comparable, runtime error
		
		
		
		
		

	}

}
