import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class StopWatch extends JPanel implements Runnable{
	private int x, startAngle, finishAngle, r,g,b;



	public StopWatch(){
		super();
		this.setBackground(new Color(120,120,120));
		this.setPreferredSize(new Dimension(600,600));
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void paintComponent(Graphics g){
		this.drawClock(g);
	}
	public void drawClock (Graphics g){
		this.startAngle = 90;
		g.setColor(new Color(this.r,this.g,this.b));
		g.fillOval((this.getWidth()/2) -100, (this.getHeight()/2) -100, 300, 300);
		g.setColor(new Color(0,0,0));		
		g.drawArc((this.getWidth()/2)-100, (this.getHeight()/2) -100 ,300,300, startAngle, finishAngle );
		this.repaint();
	}

	public void Start(){
		System.out.println("Start");
	
	}

	public void Pause(){
		System.out.println("Pause");
	}

	public void Reset(){
		System.out.println("Reset");
		System.out.println();
	}
	public void run() {
		while(this.finishAngle< -361){
			try {
				this.finishAngle-=6;
				repaint();
				Thread.sleep(1000);
				}
			
			catch (InterruptedException e){
				System.out.println("Error: " +e);
			}
		}
	}
	public void setR(int r) {
		this.r = r;
	}
	public void setG(int g) {
		this.g = g;
	}
	public void setB(int b) {
		this.b = b;
	}
}
