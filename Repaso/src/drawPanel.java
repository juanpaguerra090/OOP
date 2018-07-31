import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class drawPanel extends JPanel implements Runnable{
	private int RectSizeX, RectSizeY;
	public drawPanel() {
		super();
		this.setPreferredSize(new Dimension(600,600));
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(200, 100, RectSizeX, RectSizeY);
		System.out.println("Rectangle" + this.RectSizeX + this.RectSizeY);
//		repaint();
	}
	
//	public void drawRectangle(Graphics g){
//
//		
//	}
	public void drawLine(){
		System.out.println("Line");

	}
	public void drawCircle(){
		System.out.println("Circle");

	}
	public void drawTriangle(){
		System.out.println("Triangle");

	}
	public void drawArch(){
		System.out.println("Arch");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void setSizeX(int sizeX) {
		this.RectSizeX = sizeX;
	}
	public void setSizeY(int sizeY) {
		this.RectSizeY = sizeY;
	}
}
