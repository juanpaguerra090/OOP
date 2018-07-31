
public class imprimeArreglo {
	
	public static void imprimir(int[] arreglo){
		for (int i = 0; i<arreglo.length; i++){
			System.out.print(arreglo[i]+", ");
		}
	}
	public static void main(String[] args) {
		int[] arreglo = {1,2,3,4,5,6,7,8,9,10};
		imprimir(arreglo);
		
	}
}
