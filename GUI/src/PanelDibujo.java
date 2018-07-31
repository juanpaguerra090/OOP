import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel implements Runnable, MouseMotionListener{
	private int xV;
	private int yV;
	private boolean moverse;
	private Image fondo;
	private int w, z;
	private String TextoNave;
	private Color colorNave;


	public PanelDibujo(){

		super();
		this.colorNave=Color.orange;
		this.moverse=false;
		this.TextoNave = "Vamos Pocoyo";
		this.xV = this.yV = 0;
		this.w=70;
		this.z = 550;
		this.fondo = new ImageIcon("milkwaynasa.jpg").getImage();
		this.setPreferredSize(new Dimension(800,600));
		
		this.addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent e) {
				PanelDibujo.this.moverse = true;
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				PanelDibujo.this.moverse = false;
			}
			
		});
		this.addMouseMotionListener(this);

		Thread hilo = new Thread(this);
		hilo.start();
	}

	public void setTextoNave(String nombre){
		this.TextoNave = "Vamos "+ nombre;
	this.repaint();
	}

	public void setColorNave (int colorBlue){
		this.colorNave = new Color(120,200,colorBlue);
		this.repaint();
	}

	public void setColorNave(Color colorNave){
		this.colorNave=colorNave;
		this.repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0,this.getWidth(),this.getHeight(), this);
		this.pintarNave(g);
		this.pintaTexto(g);
	}
	
	private void pintaTexto(Graphics g){
		g.setColor(Color.BLACK);
		g.drawString(TextoNave, this.w, this.z);
	}
	
	private void pintarNave(Graphics g){
		g.setColor(colorNave);
		g.fillOval(50+ this.xV, 500 + this.yV, 200, 100);
		g.setColor(Color.CYAN);
		g.fillArc(50+ this.xV, 500 + this.yV, 200, 100, 350, 120);
		g.setColor(Color.black);
		g.drawLine(125+ this.xV,502 +this.yV,125+this.xV,400+this.yV);
		g.setColor(Color.red);
		g.fillOval(75+this.xV, 300+this.yV, 100, 100);
	}
	

	@Override
	public void run(){
		while(this.xV<400){
			try {
				if (moverse == true){
					this.xV+=3;
					this.yV--;
					repaint();

				}
				Thread.sleep(10);
			}

			catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Se esta arrastrando el mouse en  "+ e.getX() + " y " + e.getY());

		this.w = e.getX();	
		this.z = e.getY();
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
