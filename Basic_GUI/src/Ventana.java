import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana(){
		super("Ventanita");
		Panel x = new Panel();
		this.add(x);
	}
	
	public static void main(String[] args) {
		Ventana x = new Ventana();
	}
}
