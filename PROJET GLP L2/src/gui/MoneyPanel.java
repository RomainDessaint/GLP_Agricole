package gui;

import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyPanel {
	
	
	int money;
	static JLabel moneyValue = new JLabel("");
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private JPanel panel = new JPanel();
	public MoneyPanel() {
		init();
	}
	
	public void init() { 
		this.money = 0;
		moneyValue.setFont(font);
		panel.add(moneyValue);
		updateValue();
	}
	
	public static void updateValue() {
		int money = GameFrame.game.getMoney();
		moneyValue.setText("Argent : " +Integer.toString(money));
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
}
