package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import animals.Chicken;
import animals.Pig;
import animals.Rabbit;
import animals.Sheep;
import datas.DataObjects;
import types.Animal;

public class ShopPanel {
	ImageIcon imageArticle;
	
	
	JButton btnLess = new JButton("-");
	JButton btnPlus = new JButton("+");
	JButton btnBuy = new JButton("Acheter");
	
	JLabel articleIcon;
	JLabel articleName ;
	JLabel articlePrice;
	JLabel articleQuantity;
	
	String name;
	
	private JPanel panel = new JPanel();
	private HashMap<String, Animal> animals = new HashMap<>();
	int price;
	String gender;
	
	private int quantity;

	public ShopPanel(String name, Dimension iconDimension, int price, HashMap<String, JButton> hashButton, String action, String gender) {
		this.imageArticle = new ImageIcon(new ImageIcon("src\\images\\"+name+".png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.articleIcon = new JLabel(imageArticle);
		this.articleName = new JLabel(name);
		this.articlePrice = new JLabel("Prix : " +price);
		this.articleQuantity = new JLabel(" 0 ");
		this.quantity = 0;
		this.price = price;
		this.name = name;
		this.gender = gender;
		
		panel.setPreferredSize(iconDimension);
		panel.add(articleIcon);
		panel.add(articleName);
		panel.add(articlePrice);
		panel.add(btnLess);
		panel.add(articleQuantity);
		panel.add(btnPlus);
		panel.add(btnBuy);
		
		btnLess.addActionListener(new LessAction(this, articleQuantity));
		btnPlus.addActionListener(new PlusAction(this, articleQuantity));
		btnBuy.addActionListener(new BuyAction(this, price));
		
		if (action == "animal") {
			btnBuy.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i=0; i< getQuantity(); i++) {
						buyAnimal(name);
					}
					
				}
			});
		}
		else if (action == "ressources") {
			btnBuy.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!DataObjects.vedgetables.containsKey(name)) {
						
						if (DataObjects.CurrentKgHouseVedgs<DataObjects.MaxKgHouseVegds) {
							DataObjects.vedgetables.put(name, 1);
							DataObjects.vedgetablesHouse.put(name, 1);
							for (int i=1; i<getQuantity();i++) {
								DataObjects.vedgetables.put(name, DataObjects.vedgetables.get(name)+1);
								DataObjects.vedgetablesHouse.put(name, DataObjects.vedgetablesHouse.get(name)+1);
							}
						}
						else {
							DataObjects.vedgetables.put(name, 1);
							DataObjects.vedgetablesSilo.put(name, 1);
							for (int i=1;i<getQuantity();i++) {
								DataObjects.vedgetables.put(name, DataObjects.vedgetables.get(name)+1);
								DataObjects.vedgetablesSilo.put(name, DataObjects.vedgetablesSilo.get(name)+1);
							}
						}
					}
					else {
						if(DataObjects.CurrentKgHouseVedgs<DataObjects.MaxKgHouseVegds) {
							for (int i=0; i<getQuantity();i++) {
								DataObjects.vedgetables.put(name, DataObjects.vedgetables.get(name)+1);
								DataObjects.vedgetablesHouse.put(name, DataObjects.vedgetablesHouse.get(name)+1);
							}
							
						}
						else {
							for (int i=0; i<getQuantity();i++) {
								DataObjects.vedgetables.put(name, DataObjects.vedgetables.get(name)+1);
								DataObjects.vedgetablesSilo.put(name, DataObjects.vedgetablesSilo.get(name)+1);
							}
							
							
						}
						
					}
					
				}
			});
		}
		else if (action == "Enclos") {
			System.out.println("dans ajouter action fence");
			btnBuy.addActionListener(new AddFenceAction());
		}
		else if (action == "infrastructure") {
			btnBuy.addActionListener(new AddInfrastructures(name));
		}
		hashButton.put(name, btnBuy);
		
	}
		

	public void buyAnimal(String Name) {
		int indexFence = 0;
		int indexCellule = 0;
		while (DataObjects.Fence.get(indexFence).isVisible()) {
				if(indexCellule<9) {
					if (isCelluleEmpty( indexFence, indexCellule)) {
						indexCellule++;
					}
					else if(indexCellule<=8) {
						animals.put(name+animals.size(), switchAnimal(name));						
						DataObjects.FenceMap.get(indexFence).get(indexCellule).setIcon(new ImageIcon("src\\images\\"+Name+".png"));
						DataObjects.FenceMap.get(indexFence).get(indexCellule).addActionListener(new AnimalInfoAction(animals.get((name+(animals.size()-1))), indexFence, indexCellule));

						break;
					}	
				}
				
				else {
					indexFence++;
					indexCellule =0;
					
				}
			}
	}
	public class AddInfrastructures implements ActionListener{
		String name;
		public AddInfrastructures(String name) {
			this.name = name;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			DataObjects.warehouse.get(name).setVisible(true);
			
		}
	}
	public class AnimalInfoAction implements ActionListener{
		private Animal animal;
		private int indexFence;
		private int indexCellule;
		public AnimalInfoAction(Animal animal, int indexFence, int indexCellule) {
			this.animal = animal;
			this.indexFence = indexFence;
			this.indexCellule = indexCellule;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			animalInfo(animal, indexFence, indexCellule);
		}
	}
	
	public Animal switchAnimal(String name) { 
		switch(name) {
		case "Mouton": 
			return (new Sheep(name+animals.size()));
		case "Poule" : 
			return (new Chicken(name+animals.size()));
		case "Cochon" : 
			return (new Pig(name+animals.size()));
		case "Chèvre" : 
			return (new Sheep(name+animals.size()));
		case "Lapin" : 
			return (new Rabbit(name+animals.size()));
			default : 
				return null;
		}
	}
	public String getGender() {
		return gender;
	}
	public void animalInfo(Animal animal, int indexFence, int indexCellule) {
		new AnimalInfo(animal, indexFence, indexCellule);
	}
	public boolean isCelluleEmpty( int indexFence, int indexCellule) {
		return (DataObjects.FenceMap.get(indexFence).get(indexCellule).getIcon()!= null);
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
	public String getName() {
		return name;
	}
	
	public class LessAction implements ActionListener {
		ShopPanel shopPanel;
		int quantity;
		JLabel articleQuantity;
		
		public LessAction(ShopPanel shopPanel, JLabel articleQuantity) {
			this.shopPanel = shopPanel;
			this.articleQuantity = articleQuantity;
		}
		public void actionPerformed(ActionEvent e) {
			quantity = shopPanel.getQuantity();
			if(quantity > 0) {
				quantity--;
				shopPanel.setQuantity(quantity);
			}
			articleQuantity.setText(" "+Integer.toString(quantity)+" ");
		}
	}
	
	public class PlusAction implements ActionListener {
		ShopPanel shopPanel;
		int quantity;
		JLabel articleQuantity;
		
		public PlusAction(ShopPanel shopPanel, JLabel articleQuantity) {
			this.shopPanel = shopPanel;
			this.articleQuantity = articleQuantity;
		}

		public void actionPerformed(ActionEvent e) {
			quantity = shopPanel.getQuantity();
			if(quantity < 50) {
				quantity++;
				shopPanel.setQuantity(quantity);
			}
			articleQuantity.setText(" "+Integer.toString(quantity)+" ");
			System.out.println(shopPanel.getQuantity());
		}
	}
	
	public class BuyAction implements ActionListener {
		ShopPanel shopPanel;
		int money;
		int price;
		
		public BuyAction(ShopPanel shopPanel, int price) {
			this.shopPanel = shopPanel;
			this.money = GameFrame.game.getMoney();
			this.price = price;
		}

		public void actionPerformed(ActionEvent e) {
			String gender = ShopPanel.this.getGender();
			if (gender == "female")
				gender = "e";
			else if (gender == "male")
				gender = "";
			if(money >= shopPanel.getQuantity()*price) {
				if (shopPanel.getQuantity() == 0) {
					JOptionPane jop1 = new JOptionPane();
				    ImageIcon img = new ImageIcon("src\\images\\attention.png");
				    jop1.showMessageDialog(null, "Veuillez sélectionner une quantité", "Information", JOptionPane.INFORMATION_MESSAGE, img);
				}
				else {
					GameFrame.game.setMoney(money-(shopPanel.getQuantity()*price));
					MoneyPanel.updateValue();
					JOptionPane jop2 = new JOptionPane();
				    ImageIcon img = new ImageIcon("src\\images\\Ok.png");
				    if (shopPanel.getQuantity() == 1)
				    	jop2.showMessageDialog(null,shopPanel.getQuantity()+" " +shopPanel.getName() +" " +"acheté"+gender+" avec succès", "Information", JOptionPane.INFORMATION_MESSAGE, img);
				    else {
				    	jop2.showMessageDialog(null,shopPanel.getQuantity()+" " +shopPanel.getName() +"s " +"acheté"+gender+"s avec succès", "Information", JOptionPane.INFORMATION_MESSAGE, img);
				    }
				    shopPanel.setQuantity(0);
				}
			}
			else {
				JOptionPane jop2 = new JOptionPane();
			    ImageIcon img = new ImageIcon("src\\images\\attention.png");
			    jop2.showMessageDialog(null, "Argent insuffisant", "Information", JOptionPane.INFORMATION_MESSAGE, img);
			}
		}
	}
	
	public void buyAnimal(JButton btnShopAnimal) {
		int index = 0;
		while (DataObjects.FenceMap.get(0).get(index).getIcon()!= null) {
			index++;
		}
		if (index<10) {
			DataObjects.FenceMap.get(0).get(index).setIcon(btnShopAnimal.getIcon());
		}
	}
	public void buyField() {
		int index = 0;
		while(DataObjects.Field.get(index).isVisible()) {
			index++;
		}
		if (index<6) {
			DataObjects.Field.get(index).setVisible(true);
		}
	}
	
	public void buyFence() {
		int index = 0;
		System.out.println("dans buyfence");
		while(DataObjects.Fence.get(index).isVisible()) {
			index++;
		}
		if (index<6) {
			DataObjects.Fence.get(index).setVisible(true);
		}
	}
public class AddFieldAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			buyField();
		}
	}

public class AddFenceAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (getQuantity()>0) {
			for (int i=0; i<getQuantity(); i++) {
				System.out.println("dans Addfence Action");
				buyFence();
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
