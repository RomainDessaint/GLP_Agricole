package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import system.Player;

public class FarmerInfo {
	private JFrame frame = new JFrame();
	private JPanel pnlMain = new JPanel();
	
	public FarmerInfo() {
		Player player = GameFrame.game.getPlayer();
		frame.setName("Farmer");
		frame.setSize(300, 80);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(new Color(100, 100, 100));
		
		pnlMain.setLayout(new GridLayout(3,1));
		
		JLabel lblName = new JLabel("Nom : " +player.getName());
		JLabel lblAge = new JLabel("Age : " +player.getAge());
		JLabel lblGender = new JLabel("Sexe : " +player.getGender());
		
		pnlMain.add(lblName);
		pnlMain.add(lblAge);
		pnlMain.add(lblGender);
		frame.setContentPane(pnlMain);
	}
}
