import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NovedadesJava {

	public void leerArchivo(){

		try(BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
			System.out.println(br.readLine());
		}

		catch(IOException e){
			System.out.println("Error: " + e );
		}

	}
	public static int suma(int...a){
		int total = 0; 

		for(int valor:a){
			total+=valor;

		}
		return total;

	}
	public static void main(String[] args) {
		int[] arreglo = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		for (int valor:arreglo){
			System.out.println(valor);
			System.out.println(suma(1));
			System.out.println(suma(1,2));
			System.out.println(suma(12,3));
			System.out.println(suma(1,2,3,4));
			System.out.println(suma(1,2,3,4,5));
		}

	}

}
