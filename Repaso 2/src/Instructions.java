import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Instructions extends JPanel{
	private JButton start, pause, reset;
	private JSlider r,g,b;
	private StopWatch sw;

	public Instructions(StopWatch sw) {
		super();
		this.sw = sw;
		this.start = new JButton("Start");
		this.pause = new JButton("Pause");
		this.reset = new JButton("Reset");
		this.r = new JSlider(0,255,0);
		this.g = new JSlider(0,255,0);
		this.b = new JSlider(0,255,0);
		this.r.setMajorTickSpacing(50);
		this.r.setMinorTickSpacing(10);
		this.r.setPaintTrack(false);
		this.r.setPaintTicks(true);
		this.r.setPaintLabels(true);
		this.r.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				Instructions.this.sw.setR(r.getValue());
			}
			
		});
		
		this.g.setMajorTickSpacing(50);
		this.g.setMinorTickSpacing(10);
		this.g.setPaintTrack(false);
		this.g.setPaintTicks(true);
		this.g.setPaintLabels(true);
		this.g.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {	
				Instructions.this.sw.setG(g.getValue());
			}
		});
		
		this.b.setMajorTickSpacing(50);
		this.b.setMinorTickSpacing(10);
		this.b.setPaintTrack(false);
		this.b.setPaintTicks(true);
		this.b.setPaintLabels(true);
		this.b.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				Instructions.this.sw.setB(b.getValue());
			}
		});
		
		
		this.add(start);
		this.add(pause);
		this.add(reset);
		this.add(r);
		this.add(g);
		this.add(b);
		
		this.setPreferredSize(new Dimension(200,600));
		
		this.start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Instructions.this.sw.Start();
			}
		});
		
		this.pause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Instructions.this.sw.Pause();
			}
		});
		
		this.reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructions.this.sw.Reset();				
			}
		});
		
		
		
	}


}
