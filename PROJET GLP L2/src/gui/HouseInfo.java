package gui;

import java.awt.Color;
import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import datas.DataObjects;

public class HouseInfo {
	
	public JFrame fram = new JFrame();
	private JPanel meats = new JPanel();
	private JPanel vedgs = new JPanel();
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
		meats.setOpaque(true);
		meats.setLayout(null);
		vedgs.setLayout(null);
		vedgs.setOpaque(true);
		getFram().add(meats);
		getFram().add(vedgs);
		VedgSeed();
		
	}
	public int VedgSeed() {
		int i = 1;
		int total = 0;
		JTextArea toto = new JTextArea("Masse conservée : ");
		toto.setBounds(0, 0, vedgs.getWidth(), 20);
		vedgs.add(toto);
		for (Map.Entry<String, Integer> e : DataObjects.vedgetablesHouse.entrySet()) {
			JLabel cellule = new JLabel();
			JLabel text = new JLabel(e.getKey()+": "+e.getValue()+" Kg");
			ImageIcon img = new ImageIcon(new ImageIcon("src\\images\\"+e.getKey()+".png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			JLabel image = new JLabel(img);
			cellule.setBounds(0, 5 +(i*25), vedgs.getWidth(),35);
			cellule.setVisible(true);
			cellule.setOpaque(true);
			image.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			text.setBounds(image.getWidth()+2, 0, 100, 30);
			text.setOpaque(true);
			text.setVisible(true);
			cellule.add(image);
			cellule.add(text);
			vedgs.add(cellule);
			i++;
			total+=e.getValue();
		}
		return total;
	}
	
	public JFrame getFram() {
		return fram;
	}
	public void setFram(JFrame fram) {
		this.fram = fram;
	}

}
