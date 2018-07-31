public class MyException extends Exception 
{
	public MyException()
	{
		super("Ocurrió MyException");
	}
	
	public MyException(String msj) 
	{
		super(msj);
	}

}
