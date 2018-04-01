package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GarageInfo{
	
	JFrame frame = new JFrame();
	public GarageInfo() {
		frame.setSize(300	, 300);
		frame.setLocation(50,50);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(initLabel("camion"));
		
	}
	public void initGarageInfo() {
		JPanel textpan = new JPanel();
		JTextArea text = new JTextArea("Utiliser un vehicule");
		text.setVisible(true);
		text.setEditable(false);
		textpan.add(text);
		frame.add(textpan);
		JPanel camion = initLabel("camion");
		frame.add(camion);
		
	}
	public JPanel initLabel(String name) {
		JPanel pan = new JPanel();
		JLabel img = new JLabel(new ImageIcon("src\\images\\"+name+".png")); 
		JLabel Name = new JLabel(name);
		JButton btn = new JButton("utiliser");
		pan.add(img);
		pan.add(Name);
		pan.add(btn);
		return pan;
	}

}
