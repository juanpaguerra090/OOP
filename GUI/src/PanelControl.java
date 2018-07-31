import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControl extends JPanel implements ActionListener, MouseListener, ChangeListener {

	private JTextField tfNombre;
	private JButton bImprime,
	bColorFondo,
	bAbrirArchivo;

	private JRadioButton rbRojo,
	rbVerde,
	rbAzul;

	private PanelDibujo pd;
	private JPanel PanelColor;
	private JSlider slider;

	public PanelControl(PanelDibujo pd) {
		super();
		this.pd = pd;

		this.addMouseListener(this);
		this.setPreferredSize(new Dimension(150,600));

		this.tfNombre = new JTextField(8);
		this.tfNombre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PanelControl.this.pd.setTextoNave(PanelControl.this.tfNombre.getText());
				
			}
		});

		this.bImprime = new JButton("Imprime Nombre");
		this.bColorFondo = new JButton("Cambiar Color");
		this.bAbrirArchivo = new JButton("Abrir Archivo");
		this.bAbrirArchivo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(PanelControl.this.pd);
				int op = fc.showOpenDialog(PanelControl.this.pd);
				if (op == JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(PanelControl.this.pd, "El archivo seleccionado fue: " + fc.getSelectedFile());
				}
			}});

		this.rbRojo = new JRadioButton("Rojo Obscuro");
		this.rbRojo.setSelected(true);
		this.rbVerde = new JRadioButton("Verde Claro");
		this.rbAzul = new JRadioButton("Azul Marino");

		ButtonGroup bg = new ButtonGroup();

		bg.add(this.rbRojo);
		bg.add(this.rbVerde);
		bg.add(this.rbAzul);

		this.bImprime.addActionListener(this);
		this.bColorFondo.addActionListener(this);

		this.add(this.tfNombre);
		this.add(this.bAbrirArchivo);
		this.add(this.rbRojo);
		this.add(this.rbVerde);
		this.add(this.rbAzul);


		this.add(this.bImprime);
		this.add(this.bColorFondo);

		this.PanelColor = new JPanel();
		this.PanelColor.setPreferredSize(new Dimension(50,50));
		this.PanelColor.setBackground(Color.orange);
		this.PanelColor.addMouseListener(this);
		this.add(PanelColor);

		this.slider = new JSlider(JSlider.VERTICAL, 0,255,0);
		this.slider.setMajorTickSpacing(50);
		this.slider.setMinorTickSpacing(10);
		this.slider.setPaintTrack(false);
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);
		this.slider.addChangeListener(this);
		this.add(this.slider);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if  (e.getSource() == this.bImprime){
			this.pd.setTextoNave(this.tfNombre.getText());
			System.out.println("Hola "+this.tfNombre.getText());
		}

		if (e.getSource() == this.bColorFondo){

			if(this.rbAzul.isSelected()){
				this.setBackground(Color.blue);
			}
			else if(this.rbVerde.isSelected()){
				this.setBackground(Color.green);
			}
			else if(this.rbRojo.isSelected()){
				this.setBackground(Color.red);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==this.PanelColor){
			Color color = JColorChooser.showDialog(this.pd,"Elige el color",this.PanelColor.getBackground());
			this.PanelColor.setBackground(color);
			this.pd.setColorNave(color);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.pd.setColorNave(slider.getValue());

	}
}
