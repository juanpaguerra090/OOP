import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Numerote{

	private byte [] numerote;
	private boolean signo;

	//Constructor Default
	public Numerote(){
		this.numerote = new byte[0];
	}
	//Constructor con parametro
	public Numerote(String a){

		if(a.charAt(0)=='-'){
			this.numerote = new byte[a.length()-1];

			for(int i=0;i<this.numerote.length;i++){
				this.signo=false;
				char digito = a.charAt(i+1);
				int b = Character.getNumericValue(digito);
				byte x = (byte)b;
				numerote[(a.length()-2)-i]=x;
			}
		}

		else{
			this.numerote = new byte[a.length()];

			for(int i=0;i<a.length();i++){
				this.signo=true;
				char digito = a.charAt(i);
				int b = Character.getNumericValue(digito);
				byte x = (byte)b;
				numerote[(a.length()-1)-i]=x;
			}
		}
	}
	//Suma
	public Numerote suma(Numerote a){

		int num1;
		int [] mult = new int[this.numerote.length + a.numerote.length];
		String nFinal = "";

		for (int i=0;i<this.numerote.length;i++){
			num1 = this.numerote[i];
			mult[i] += num1;
		}

		for (int i=0;i<a.numerote.length;i++){
			num1 = a.numerote[i];
			mult[i] += num1;
		}

		for(int ii = 0; ii<mult.length;ii++){
			if(mult[ii]>9){

				int carry = mult[ii]/10;
				int unidad = (mult[ii])%10;
				mult[ii]=  unidad;
				mult[ii+1]+=carry;
			}
		}

		for(int i = mult.length-1; i>=0;i--){
			if(mult[mult.length-1]==0){
				while(i>0){
					nFinal+= mult[i-1];
					break;
				}
			}
			else{
				nFinal+= mult[i];
			}
		}

		StringBuilder sb = new StringBuilder(nFinal);
		while ((nFinal.charAt(0)=='0')){
			sb.deleteCharAt(0);
			nFinal = sb.toString();
		}
		return new Numerote(nFinal);
	}

	//Resta
	public Numerote resta(Numerote a){

		byte num1 = 0;
		byte num2 = 0;
		int reduce=0;
		String sFinal = "";
		String nuevo = "";
		String signo = "";

		if (Arrays.equals(a.numerote,this.numerote)){
			nuevo = "0";
		}
		else{
			int len=0;
			if (this.numerote.length > a.numerote.length){
				len = a.numerote.length;
			}
			else{
				len = this.numerote.length;
			}

			for (int i=0;i<len;i++){

				if(this.numerote.length == a.numerote.length){

					for (int x=this.numerote.length-1;x>=0;x--){
						if (this.numerote[x]>a.numerote[x]){
							num1 = this.numerote[i];
							num2 = a.numerote[i];
							break;
						}
						else if (this.numerote[x]<a.numerote[x]){
							num1 = a.numerote[i];
							num2 = this.numerote[i];
							signo = "-";
							break;
						}	
						else{
							continue;
						}
					}
				}

				else if(this.numerote.length > a.numerote.length){
					num1 = this.numerote[i];
					num2 = a.numerote[i];
				}
				else if (this.numerote.length < a.numerote.length) {
					num1 = a.numerote[i];
					num2 = this.numerote[i];
					signo = "-";
				}

				int resta = num1-num2;
				if(i==0){
					if((resta)<0){
						sFinal+=resta+10+"";
						reduce = 1;
					}
					else{
						sFinal+=resta+"";
						reduce = 0;
					}	
				}
				if(i>0){
					if((resta - reduce) <0){
						sFinal+=resta-reduce+10+"";
						reduce = 1;
					}
					else if((resta-reduce)>=0){
						sFinal+=resta-reduce+"";
						reduce = 0;
					}			
				}
			}
			for(int i = Math.min(this.numerote.length,a.numerote.length); i< Math.max(this.numerote.length,a.numerote.length);i++){

				byte complemento;

				if(a.numerote.length>this.numerote.length){
					complemento = a.numerote[i];
				}
				else{
					complemento = this.numerote[i];
				}

				int resta = complemento - reduce;

				if((resta)<0){
					sFinal+=resta+10+"";
					reduce=1;
				}
				else if((resta)>=0){
					sFinal+=resta+"";
					reduce=0;
				}
			}
			for (int i = (sFinal.length()-1); i>=0;i--){
				nuevo += sFinal.charAt(i);
			}
			StringBuilder sb = new StringBuilder(nuevo);
			while(sb.charAt(0)=='0'){
				sb.deleteCharAt(0);
				nuevo = sb.toString();
			}
		}
		nuevo = signo + nuevo;
		return new Numerote(nuevo);
	}

	//Multiplicación
	public Numerote multiplica(Numerote a){

		int num1;
		int num2;

		int [] mult = new int[this.numerote.length + a.numerote.length];

		for (int i=0;i<a.numerote.length;i++){
			num1 = a.numerote[i];
			for(int j=0;j < this.numerote.length;j++){
				num2 = this.numerote[j];
				int x = num1 *num2;
				mult[i+j] += x;
			}
		}

		for(int ii = 0; ii<mult.length;ii++){
			if(mult[ii]>9){

				int carry = mult[ii]/10;
				int unidad = (mult[ii])%10;
				mult[ii]= unidad;
				mult[ii+1]+=carry;
			}

		}

		String nFinal = "";

		for(int i = mult.length-1; i>=0;i--){
			if(mult[mult.length-1]==0){
				while(i>0){
					nFinal+= mult[i-1];
					break;
				}
			}
			else{
				nFinal+= mult[i];
			}
		}
		StringBuilder sb = new StringBuilder(nFinal);
		while(sb.charAt(0)=='0'){
			sb.deleteCharAt(0);
			nFinal = sb.toString();
		}
		return new Numerote(nFinal);
	}
	//toString
	public String toString(){
		String x ="";
		for(int i=(this.numerote.length-1);i>=0;i--){
			x+=this.numerote[i];
		}
		return ((this.signo==true)?"":"-")+x;
	}
	//Ejecutar Archivo (main)
	public static void ejecutaArchivo (String entrada, String salida) {
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(entrada));
			PrintWriter pw = new PrintWriter(salida);

			String linea;

			while((linea = buffer.readLine())!=null){
				if (linea.isEmpty()){
					System.out.println("Error: Linea Vacía");
					pw.println("Error: Linea Vacía");
				}
				else{

					String oldStr=linea;
					String newStr = oldStr.replaceAll(",", " ");
					StringTokenizer archivo = new StringTokenizer(newStr);

					Numerote primero = new Numerote(archivo.nextToken());
					Numerote segundo = new Numerote(archivo.nextToken());
					String operacion = archivo.nextToken();


					//System.out.println("\n");
					try{
						if (operacion.contains("r")){
							if (primero.signo==true && segundo.signo == true){
								System.out.println(primero.resta(segundo));
								pw.println(primero.resta(segundo)); //<----------------------Terminda------------------>
							}
							else if(primero.signo==true && segundo.signo == false){
								System.out.println(segundo.suma(primero)); //<----------------------Terminda------------------>
								pw.println(segundo.suma(primero));
							}

							else if(primero.signo==false && segundo.signo == true){
								System.out.println("-" + primero.suma(segundo)); //<----------------------Terminda------------------>
								pw.println("-" + primero.suma(segundo));
							}
							else if(primero.signo==false && segundo.signo == false){
								System.out.println(segundo.resta(primero));//<----------------------Terminda------------------>
								pw.println(segundo.resta(primero));
							}
						}

						else if (operacion.contains("s")){
							if (primero.signo==true && segundo.signo == true){
								System.out.println(primero.suma(segundo)); //<----------------------Terminda------------------>
								pw.println(primero.suma(segundo));
							}
							else if(primero.signo==true && segundo.signo == false){
								System.out.println(primero.resta(segundo));//<----------------------Terminda------------------>
								pw.println(primero.resta(segundo));
							}

							else if(primero.signo==false && segundo.signo == true){
								System.out.println(segundo.resta(primero));
								pw.println(segundo.resta(primero));
							}
							else if(primero.signo==false && segundo.signo == false){
								System.out.println( "-" +primero.suma(segundo)); //<----------------------Terminda------------------>
								pw.println( "-" +primero.suma(segundo));
							}
						}

						else if (operacion.contains("m")){
							if (primero.signo==false && segundo.signo == false){
								System.out.println(primero.multiplica(segundo));//<----------------------Terminda------------------>
								pw.println(primero.multiplica(segundo));
							}
							if (primero.signo==true && segundo.signo == false){
								System.out.println("-" + primero.multiplica(segundo));//<----------------------Terminda------------------>
								pw.println("-" + primero.multiplica(segundo));
							}
							if (primero.signo==false && segundo.signo == true){
								System.out.println("-" + primero.multiplica(segundo));//<----------------------Terminda------------------>
								pw.println("-" + primero.multiplica(segundo));
							}
							else if(primero.signo==true && segundo.signo == true){
								System.out.println(primero.multiplica(segundo));//<----------------------Terminda------------------>
								pw.println(primero.multiplica(segundo));
							}

						}

						else if (!(operacion.contains("m"))&&!(operacion.contains("s"))&&!(operacion.contains("r"))) {
							throw new NumeroteException("No hay operando válido");
						}
						else if(linea.isEmpty()){
							throw new NoSuchElementException("Vacio");
						}
					}
					catch(NumeroteException e){
						pw.println("Error: " + e );
						System.out.println("Error: " + e);
					}
				}
			}

			pw.close();
			buffer.close();
		}

		catch (FileNotFoundException e){
			System.out.println("Error: " + e);
		}
		catch(IOException e){
			System.out.println("Error: " + e);
		}
	}
}