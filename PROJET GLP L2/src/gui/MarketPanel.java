package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarketPanel{
	ImageIcon imageArticle;
	
	private JButton btnLess = new JButton("-");
	private JButton btnPlus = new JButton("+");
	private JButton btnBuy = new JButton("Vendre");
	private JLabel articleIcon;
	private JLabel articleName ;
	private JLabel articlePrice;
	private JLabel articleQuantity;
	private JPanel panel = new JPanel();
	
	int price;
	
	private int quantity;

	public MarketPanel(String name, Dimension iconDimension, int price) {
		this.imageArticle = new ImageIcon(new ImageIcon("src\\images\\"+name+".png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
		this.articleIcon = new JLabel(imageArticle);
		this.articleName = new JLabel(name);
		this.articlePrice = new JLabel("Prix : " +price);
		this.articleQuantity = new JLabel(" 0 ");
		this.quantity = 0;
		
		panel.setPreferredSize(iconDimension);
		panel.add(articleIcon);
		panel.add(articleName);
		panel.add(articlePrice);
		panel.add(btnLess);
		panel.add(articleQuantity);
		panel.add(btnPlus);
		panel.add(btnBuy);
		
		btnLess.addActionListener(new LessAction(articleQuantity));
		btnPlus.addActionListener(new PlusAction(articleQuantity));
	}
	
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public JButton getBtnLess() {
		return btnLess;
	}
	public void setBtnLess(JButton btnLess) {
		this.btnLess = btnLess;
	}
	public JButton getBtnPlus() {
		return btnPlus;
	}
	public void setBtnPlus(JButton btnPlus) {
		this.btnPlus = btnPlus;
	}
	public JButton getBtnBuy() {
		return btnBuy;
	}
	public void setBtnBuy(JButton btnBuy) {
		this.btnBuy = btnBuy;
	}
	
	public class LessAction implements ActionListener {
		int quantity = 0;
		JLabel articleQuantity;
		
		public LessAction(JLabel articleQuantity) {
			this.quantity = 0;
			this.articleQuantity = articleQuantity;
		}

		public void actionPerformed(ActionEvent e) {
			this.quantity = MarketPanel.this.getQuantity();
			if(this.quantity > 0) {
				this.quantity--;
				MarketPanel.this.setQuantity(this.quantity);
			}
			articleQuantity.setText(" "+Integer.toString(quantity)+" ");
		}
	}
	
	public class PlusAction implements ActionListener {
		int quantity = 0;
		JLabel articleQuantity;
		
		public PlusAction(JLabel articleQuantity) {
			this.quantity = 0;
			this.articleQuantity = articleQuantity;
		}

		public void actionPerformed(ActionEvent e) {
			this.quantity = MarketPanel.this.getQuantity();
			if(quantity < 50) {
				quantity++;
				MarketPanel.this.setQuantity(this.quantity);
			}
			articleQuantity.setText(" "+Integer.toString(quantity)+" ");
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
