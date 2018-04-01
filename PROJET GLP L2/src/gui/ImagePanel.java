package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image image;
	
	public ImagePanel(Image image) {
		this.image = image;
	}
	
	@Override
	public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
