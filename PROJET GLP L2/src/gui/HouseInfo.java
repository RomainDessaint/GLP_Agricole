package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HouseInfo {
	
	public JFrame fram = new JFrame();
	private JLabel meats = new JLabel();
	private JLabel vedgs = new JLabel();
	public HouseInfo() {
		fram.setTitle("Maison");
		fram.setSize(300, 300);
		fram.setLocation(50,50);
		fram.setResizable(false);
		fram.setLocationRelativeTo(null);
		fram.setVisible(true);
		fram.setLayout(null);
		initHouseInfo();
	}
	public void initHouseInfo() {
		meats.setBounds(0, 0, fram.getWidth()/2, getFram().getHeight());
		vedgs.setBounds(meats.getWidth(), 0, fram.getWidth()/2, fram.getHeight());
		meats.setBackground(Color.DARK_GRAY);
		vedgs.setBackground(Color.gray);
		meats.setOpaque(true);
		vedgs.setOpaque(true);
		getFram().add(meats);
		getFram().add(meats);
		
	}
	
	public JFrame getFram() {
		return fram;
	}
	public void setFram(JFrame fram) {
		this.fram = fram;
	}
	public JLabel getMeats() {
		return meats;
	}
	public void setMeats(JLabel meats) {
		this.meats = meats;
	}
	public JLabel getVedgs() {
		return vedgs;
	}
	public void setVedgs(JLabel vedgs) {
		this.vedgs = vedgs;
	}
}
