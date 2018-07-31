public class EjemploExcepcion
{

	public void metodoD() throws NumeroteException
	{
		int x = 1;
		if(x==0){
			System.out.println("Seh...");
		}
		else{
			throw new NumeroteException("Whoops, ocurrió un error.");
		}
	}

	public static void main(String[] args) 
	{
		try
		{
			EjemploExcepcion a = new EjemploExcepcion();
			a.metodoD();
		}
		catch(NumeroteException e)
		{
			System.out.println("Error: " + e);
			//e.printStackTrace();
		}
	}
}

