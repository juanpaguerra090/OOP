//import java.awt.BorderLayout;
//import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.*;

public class Window extends JFrame{

	public Window (){
		super("Java Window");
		this.setPreferredSize(new Dimension(600,800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.pack();
		this.setVisible(true);

	}

	public static void main(String[] args) {
		Window win = new Window();
	}

}