package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFarm {
	
	
	public static JLabel putImage(String imagePath, int posX, int posY, int width, int height) {
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(imagePath));
		label.setBounds(posX, posY, width, height);
		return label;
	}
	
	public static JPanel drawFence(int posX, int posY , int fenceWidth) {
		JPanel pnlFence = new JPanel();
		pnlFence.setOpaque(false);
		pnlFence.setBackground(new Color(255, 0, 0, 100));
		pnlFence.setLayout(null);
		pnlFence.setBounds(posX, posY, fenceWidth+40, fenceWidth+30);

		//Coté Bas de l'enclos
		for (int i = 0; i < fenceWidth; i += 32) {
			pnlFence.add(putImage("src\\images\\Enclos.png", i+9, 0, 32, 18));
		}

		//Coté Haut de l'enclos
		for (int i = 0; i < fenceWidth; i += 32 ) {
			pnlFence.add(putImage("src\\images\\Enclos.png", i+9, fenceWidth+13, 32, 18));
		}

		//Coté Gauche de l'enclos
		for(int i = 0; i < fenceWidth; i += 18) {
			pnlFence.add(putImage("src\\images\\fence_top.png", 0, i, 18, 32));
		}
		
		//Coté Gauche de l'enclos
		for(int i = 0; i < fenceWidth; i += 18) {
			pnlFence.add(putImage("src\\images\\fence_top.png", fenceWidth+28, i, 18, 32));
		}
		return pnlFence;	
	}
	public static JPanel drawfield( int posX, int posY , int fenceWidth) {
		JPanel pnlFence = new JPanel();
		pnlFence.setOpaque(false);
		pnlFence.setBackground(new Color(255, 0, 0, 100));
		pnlFence.setLayout(null);
		pnlFence.setBounds(posX, posY, fenceWidth+40, fenceWidth+30);

		//Coté Bas de l'enclos
		for (int i = 0; i < fenceWidth; i += 18) {
			pnlFence.add(putImage("src\\images\\field_top.png", i+9, 0, 32, 18));
		}

		//Coté Haut de l'enclos
		for (int i = 0; i < fenceWidth+8; i += 16 ) {
			pnlFence.add(putImage("src\\images\\field_bottom.png", i+11, fenceWidth+13, 37, 18));
		}

		//Coté Gauche de l'enclos
		for(int i = 0; i < fenceWidth; i += 18) {
			pnlFence.add(putImage("src\\images\\field_left.png", 0, i, 18, 32));
		}
		
		//Coté Gauche de l'enclos
		for(int i = 0; i < fenceWidth+16; i += 18) {
			pnlFence.add(putImage("src\\images\\field_right.png", fenceWidth+15, i, 18, 32));
		}
		

		return pnlFence;	
	}
}
	
