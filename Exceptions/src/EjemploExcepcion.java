public class EjemploExcepcion
{
	
	public void metodoC() throws MyException 
	{
		metodoD();
	}
	public void metodoD() throws MyException
	{
		throw new MyException();//"Whoops, ocurrió un error.");
	}


	public static void main(String[] args) 
	{
		try
		{
			EjemploExcepcion a = new EjemploExcepcion();
			a.metodoC();
		}
		catch(MyException e)
		{
			System.out.println("Error " + e );
			//e.printStackTrace();
		}

	}
}

