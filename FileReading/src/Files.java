import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Files {
public static void main(String[] args) {
	String line = null;
	
	try{
		FileReader read = new FileReader("Nomina.txt");
		BufferedReader bRead = new BufferedReader(read);
		try {
			while((line = bRead.readLine()) != null){
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				String name = tokenizer.nextToken();
				double payment = Double.parseDouble(tokenizer.nextToken());
				System.out.println(name + ": " + payment*5);
				

				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	catch (FileNotFoundException e){
		System.out.println("404: File Not Found");
	}
}
}
