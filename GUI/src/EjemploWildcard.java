import java.util.*;
public class EjemploWildcard {

	public static <T extends Number> double suma(ArrayList< ? extends Number> lista){
		double x = 0;
		for(Number i:lista){
			x += i.doubleValue(); 	
		}	
		return x;

	}

	public static void main(String[] args) {
		//Numbers
		ArrayList<Number> arreglo = new ArrayList<Number>();

		arreglo.add(98.0);
		arreglo.add(2);
		arreglo.add(8.0);
		arreglo.add(2);
		arreglo.add(8.5);
		arreglo.add(24);
		arreglo.add(2489173217L); // L es long, f es Float ...etc

		System.out.println(suma(arreglo));

		ArrayList<Integer> arreglo2 = new ArrayList<Integer>();
		
		// Integers
		arreglo.add(98);
		arreglo.add(2);
		arreglo.add(8);
		arreglo.add(2);
		arreglo.add(8);
		arreglo.add(24);
		arreglo.add(24217); // L es long, f es Float ...etc

		System.out.println(suma(arreglo2));
		
	}
}

