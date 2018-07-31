import javax.swing.JOptionPane;
public class MyDivisionException {
	public static int Division() {
		String strNum=JOptionPane.showInputDialog("Escribe el numerador");
		String strDen=JOptionPane.showInputDialog("Escribe el denominador");
		int a = Integer.parseInt(strNum);
		int b = Integer.parseInt(strDen);
		int x = a/b;
		System.out.println("El resultado de dividir " + a +" entre " + b + " es: " + x);
		return a/b;
	}

	public static void main(String args[]) {
		try {
			Division();
		}

		catch (ArithmeticException e) {
			System.out.println("La divisón con cero no es posible.");
			System.out.println("Error: " + e );
		}
	}
}