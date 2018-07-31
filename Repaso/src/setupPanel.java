import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class setupPanel extends JPanel {
	private JButton btGetFile, btSaveFile, btLine, btRectangle, btCircle, btTriangle, btArch, run; // 
	private JTextField fileName, txR, txG, txB; //
	private JSlider red, green, blue;  //
	//private JPanel colorPanel; 
	private JRadioButton rbSmall, rbMedium, rbLarge; //
	private String bgFile = "milkwaynasa.jpg";
	private Image background;
	private JLabel file, shapes, color, size, colRed, colGreen ,colBlue; //
	private drawPanel dp; 
	private Graphics g; 
	
	private int RectSizeX, RectSizeY;

	
	public setupPanel(drawPanel dp){ 
		super();
		
		this.dp = dp;
		this.setPreferredSize(new Dimension(150,650));
	
		// Buttons
		this.btGetFile = new JButton("Get File");
		this.btSaveFile = new JButton ("Save File");
		this.btLine = new JButton("Line");
		this.btRectangle = new JButton("Rectangle");
		this.btCircle = new JButton("Circle");
		this.btTriangle = new JButton("Triangle");
		this.btArch = new JButton("Arch");
		this.run = new JButton("run");
		
		// Text Fields
		this.fileName = new JTextField(null, "File Name", 10 );
		this.txR = new JTextField(3);
		this.txG = new JTextField(3);
		this.txB = new JTextField(3);
		
		// Labels
		this.file = new JLabel("File:");
		this.shapes = new JLabel("Shapes:");
		this.color = new JLabel("Color:");
		this.size = new JLabel("Size:");
		
		this.colRed = new JLabel("Red");
		this.colGreen = new JLabel ("Green");
		this.colBlue = new JLabel ("Blue");
		
		// Sliders
		this.red = new JSlider(0,255,0);
		this.green = new JSlider(0,255,0);
		this.blue = new JSlider(0,255,0);
		
		//Radio Buttons
		this.rbSmall = new JRadioButton("Small");
		this.rbMedium = new JRadioButton("Medium");
		this.rbLarge = new JRadioButton("Large");

		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		this.background = new ImageIcon(bgFile).getImage();
//		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(Color.WHITE);
		
		//Add File
		this.add(file);
		this.add(btGetFile);
		this.add(btSaveFile);
		this.add(fileName);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		// Add Shapes
		this.add(shapes);
		this.add(btRectangle);
		RectSizeX = 10;
		RectSizeY = 30;
		this.btRectangle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				setupPanel.this.dp.setSizeX(RectSizeX);
				setupPanel.this.dp.setSizeY(RectSizeY);
				System.out.println("Rectangle" + RectSizeX+ RectSizeY);
				setupPanel.this.RectSizeX+=10;
				setupPanel.this.RectSizeY+=10;
			}
		});
		
		this.add(btLine);
		this.add(btCircle);
		this.add(btTriangle);
		this.add(btArch);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));

		// Add Colors
		this.add(color);
		this.add(txR);
		this.add(txG);
		this.add(txB);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));

		// Add Sliders
		this.add(colRed);
		this.add(red);
		this.add(colGreen);
		this.add(green);
		this.add(colBlue);
		this.add(blue);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		//Add Rb
		this.add(rbSmall);
		this.add(rbMedium);
		this.add(rbLarge);	
		
		
	}
}
