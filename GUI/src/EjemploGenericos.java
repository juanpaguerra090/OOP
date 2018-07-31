
public class EjemploGenericos {

	public static <E> void  imprimir(E[] arreglo){
		for (int i = 0; i<arreglo.length; i++){
			if(i<arreglo.length -1 ){
				System.out.print(arreglo[i]+", ");

			}
			else{
				System.out.print(arreglo[i]);

			}
		}
	}

	public static void main(String[] args) {
		Integer[] arreglo = {1,2,3,4,5,6,7,8,9,10};
		imprimir(arreglo);
		System.out.println();
		System.out.println();

		String[] palabras = {"hola", "como", "estás", "bye"};
		imprimir(palabras);

		System.out.println();
		System.out.println();

		Double[] dobles = {1.00,.5,.45,.218391};
		imprimir(dobles);
	}
}
