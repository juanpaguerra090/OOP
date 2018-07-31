import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MiVentana extends JFrame {

	public MiVentana(){
		super("Mi primer ventana en Java");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelDibujo pd = new PanelDibujo();
		this.add(pd);

		this.add(new PanelControl(pd),BorderLayout.WEST);

		this.pack();

		this.setVisible(true);
	}


	public static void main (String [] args){
		MiVentana ventana = new MiVentana();
	}
}
