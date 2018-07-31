import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Juan Pablo Ramírez 
 * A01226136
 */

public class Window extends JFrame {

	public Window(){
		super("Hello World"); // Constructor
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar
		StopWatch x=new StopWatch();
		this.add(x, BorderLayout.CENTER);
		this.add (new Instructions(x), BorderLayout.EAST);
		this.setLocation(200, 490);
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false);

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window main = new Window();
	}

}
