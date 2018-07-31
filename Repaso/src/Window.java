import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window(){ // Aquí se añaden los futuros elementos (JPanels).
		super("Hello World"); // Constructor
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar
		drawPanel pd = new drawPanel();
		
		this.add( new setupPanel(pd), BorderLayout.WEST);
		this.add (new drawPanel(), BorderLayout.CENTER);
		this.setPreferredSize(new Dimension (800,650));
		this.setLocation(200, 490);
		
		
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
	}
	
	public static void main(String[] args) {
		Window main = new Window();
		
	}
}
