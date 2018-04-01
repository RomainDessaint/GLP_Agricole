package gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class animatedPanel {
	private JPanel screen;
	public animatedPanel() {
	}
	public void initAnimation(JPanel scr) {
		screen = scr;
		screen.setBackground(new Color(76, 45, 120, 30));
		screen.setLayout(null);

		
	}
	public void truckAnimation() {
		
		JLabel truck = new JLabel("truck0");
		ImageIcon imgTruck = new ImageIcon("src\\images\\truck_left.png");
		truck.setIcon(imgTruck);
		int i = 0;
		truck.setBounds(700-i, 300, imgTruck.getIconWidth(), imgTruck.getIconHeight());
		truck.setIcon(imgTruck);
		screen.add(truck);
		i+=50;
	
		
	}

}
