package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarketPanel{
	ImageIcon imageArticle;
	
	private JButton btnLess = new JButton("-");
	private JButton btnPlus = new JButton("+");
	private JButton btnSell = new JButton("Vendre");
	private JLabel articleIcon;
	private JLabel articleName ;
	private JLabel articlePrice;
	private JLabel articleQuantity;
	private JPanel panel = new JPanel();
	
	private String name;	
	int price;
	String gender;
	
	private int quantity;

	public MarketPanel(String name, Dimension iconDimension, int price, String gender) {
		this.imageArticle = new ImageIcon(new ImageIcon("src\\images\\"+name+".png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
		this.articleIcon = new JLabel(imageArticle);
		this.articleName = new JLabel(name);
		this.articlePrice = new JLabel("Prix : " +price);
		this.articleQuantity = new JLabel(" 0 ");
		this.quantity = 0;
		this.gender = gender;
		this.name = name;
		
		panel.setPreferredSize(iconDimension);
		panel.add(articleIcon);
		panel.add(articleName);
		panel.add(articlePrice);
		panel.add(btnLess);
		panel.add(articleQuantity);
		panel.add(btnPlus);
		panel.add(btnSell);
		
		btnLess.addActionListener(new LessAction(articleQuantity));
		btnPlus.addActionListener(new PlusAction(articleQuantity));
		btnSell.addActionListener( new SellAction(this, price));
		
	}
	
	public String getGender() {
		return gender;
	}
	public String getName() {
		return name;
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
		return btnSell;
	}
	public void setBtnBuy(JButton btnBuy) {
		this.btnSell = btnBuy;
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
	public class SellAction implements ActionListener {
		MarketPanel marketPanel;
		int money;
		int price;
		JLabel articleQuantity;
		
		public SellAction(MarketPanel marketPanel, int price) {
			this.marketPanel = marketPanel;
			this.money = GameFrame.game.getMoney();
			this.price = price;
		}

		public void actionPerformed(ActionEvent e) {
			String gender = MarketPanel.this.getGender();
			if (gender == "female")
				gender = "e";
			else if (gender == "male")
				gender = "";
			
			if (marketPanel.getQuantity() == 0) {
				System.out.println("Veuillez sélectionner une quantité");
				JOptionPane jop1 = new JOptionPane();
			    ImageIcon img = new ImageIcon("src\\images\\attention.png");
			    jop1.showMessageDialog(null, "Veuillez sélectionner une quantité", "Information", JOptionPane.INFORMATION_MESSAGE, img);
			}
			else {
				GameFrame.game.setMoney(money+(marketPanel.getQuantity()*price));
				MoneyPanel.updateValue();
				JOptionPane jop2 = new JOptionPane();
			    ImageIcon img = new ImageIcon("src\\images\\Ok.png");
			    if (marketPanel.getQuantity() == 1 || marketPanel.getName() == "Enclos")
			    	jop2.showMessageDialog(null,marketPanel.getQuantity()+" " +marketPanel.getName() +" " +"vendu"+gender+" avec succès", "Information", JOptionPane.INFORMATION_MESSAGE, img);
			    else {
			    	if (marketPanel.getName() == "Enclos")
			    		jop2.showMessageDialog(null,marketPanel.getQuantity()+" " +marketPanel.getName() +"s " +"vendu"+gender+"s avec succès", "Information", JOptionPane.INFORMATION_MESSAGE, img);
			    	else {
				    	jop2.showMessageDialog(null,marketPanel.getQuantity()+" " +marketPanel.getName() +"s " +"vendu"+gender+"s avec succès", "Information", JOptionPane.INFORMATION_MESSAGE, img);
				    }
			    }	
			}
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
