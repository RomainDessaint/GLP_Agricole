package gui;

import java.util.Map;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import datas.DataObjects;

public class SiloInfo {
	FarmInitializer Farm;
	
	private JFrame frame = new JFrame();
	
	public SiloInfo() {
		frame.setSize(300	, 400);
		frame.setLocation(50,50);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(new Color(41, 41, 41));
		frame.setLayout(null);
		initSiloInfo();
	}
	public void initSiloInfo() {
		JLabel info = new JLabel();
		info.setBounds(0, 0, frame.getWidth(), 15);
		info.setVisible(true);
		int tot = VedgSeed();
		info.setText("Masse conservée : "+tot+" Masse totale disponible : "+(1000-tot));
		frame.add(info);
	}
	public int VedgSeed() {
		int i = 1;
		int total = 0;
		
		for (Map.Entry<String, Integer> e : DataObjects.vedgetables.entrySet()) {
			JLabel cellule = new JLabel();
			JLabel text = new JLabel(e.getKey()+": "+e.getValue()+" Kg");
			ImageIcon img = new ImageIcon(new ImageIcon("src\\images\\"+e.getKey()+".png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			JLabel image = new JLabel(img);
			cellule.setBounds(0, 5 +(i*40), frame.getWidth(),35);
			cellule.setVisible(true);
			cellule.setOpaque(true);
			image.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			text.setBounds(image.getWidth()+2, 0, 100, 30);
			text.setOpaque(true);
			text.setVisible(true);
			cellule.add(image);
			cellule.add(text);
			frame.add(cellule);
			i++;
			total+=e.getValue();
		}
		return total;
		
	}
	public FarmInitializer getFarm() {
		return Farm;
	}
	public void setFarm(FarmInitializer farm) {
		Farm = farm;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
