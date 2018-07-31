import javax.swing.JOptionPane;

public class MyDivisionException  {
	public static int division(int a, int b){
		return a/b ;
		
	}
	public static void main(String[] args) throws NumeroteException {
		
		
		String strNum=JOptionPane.showInputDialog("Escribe el numerador");
		String strDen=JOptionPane.showInputDialog("Escribe el denominador");
		if (Integer.parseInt(strDen) != 0)
		{
			int num = Integer.parseInt(strNum);
			int den = Integer.parseInt(strDen);
	
			System.out.println("El resultado de dividir " + num +" entre " + den + " es: " + division(num, den));
		}
		else
		{
			throw new NumeroteException("No se pudo completar la acción, el denominador fue 0.");
		}
		
		System.out.println("Hubo Excepción");
		
		
	}

}
