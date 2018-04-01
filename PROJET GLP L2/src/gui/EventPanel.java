package gui;

import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventPanel {
	private JPanel panel = new JPanel();
	int event;
	
	static JLabel eventValue = new JLabel("");
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	public EventPanel() {
		init();
	}
	
	public void init() {
		this.event = 0;
		eventValue.setFont(font);
		panel.repaint();
		panel.add(eventValue);
		updateValue();
	}
	
	public static void updateValue() {
		int event = GameFrame.game.getEventState();
		switch(event) {
			case -1:
				eventValue.setText("Bienvenue dans votre ferme.");
				break;
			case 0: 
				eventValue.setText("Aucun évènement particulier pour l'instant.");
				break;
			case 1:
				eventValue.setText("Incendie.");
				break;
			case 2:
				eventValue.setText("Naissance.");
				break;
			case 3:
				eventValue.setText("Argent insuffisant");
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
