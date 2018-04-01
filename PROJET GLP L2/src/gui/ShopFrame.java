package gui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import datas.DataAnimal;
import datas.DataInfrastructure;
import datas.DataObjects;
import datas.DataRessource;

public class ShopFrame {
	
	
	private JPanel pnlContent;
	private JPanel pnlInfrastructures;
	private JPanel pnlRessources;
	private JPanel pnlAnimals;
	
	private JLabel lbInfrastructures;
	private JLabel lbRessources;
	private JLabel lbAnimals;
	
	private GridLayout contentLayout;
	
	private Font titleFont;
	
	private JFrame frame;
	
	JScrollPane scrollInfrastructures=new JScrollPane(
			pnlInfrastructures,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
		);
	
	JScrollPane scrollRessources=new JScrollPane(
			pnlRessources,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
		);
	
	JScrollPane scrollAnimals=new JScrollPane(
			pnlAnimals,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
		);
	
	public ShopFrame() {
		frame = new JFrame();
		frame.setTitle("Shop");
		frame.setSize(1200, 500);
		frame.setLocation(50,50);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		pnlInfrastructures = new JPanel();
		pnlInfrastructures.setBackground(Color.gray);
		
		pnlRessources = new JPanel();
		pnlRessources.setBackground(Color.WHITE);
		
		pnlAnimals = new JPanel();
		pnlAnimals.setBackground(Color.pink);
		
		pnlContent = new JPanel();
		pnlContent.setOpaque(false);
		contentLayout = new GridLayout(1,3);
		pnlContent.setLayout(contentLayout);
		
		pnlContent.add(pnlInfrastructures);
		pnlContent.add(pnlRessources);
		pnlContent.add(pnlAnimals);		
		
		lbInfrastructures = new JLabel("Achetez de nouvelles infrastructures :");
		lbRessources = new JLabel("Achetez de nouvelles ressources :");
		lbAnimals = new JLabel("Achetez de nouveaux animaux :");
		titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 17);
		
		lbInfrastructures.setFont(titleFont);
		lbRessources.setFont(titleFont);
		lbAnimals.setFont(titleFont);
		
		pnlInfrastructures.add(lbInfrastructures, BorderLayout.NORTH);
		pnlRessources.add(lbRessources, BorderLayout.NORTH);
		pnlAnimals.add(lbAnimals, BorderLayout.NORTH);
		
		pnlInfrastructures.add(scrollInfrastructures, BorderLayout.EAST);
		pnlRessources.add(scrollRessources, BorderLayout.EAST);
		pnlAnimals.add(scrollAnimals,BorderLayout.EAST);
		
		frame.setContentPane(pnlContent);
		frame.setVisible(true);
		displayArticle(pnlInfrastructures, "Réserve", DataInfrastructure.getReservePrice(), DataObjects.infraBuy, "infrastructure", DataInfrastructure.getReserveGender());
		displayArticle(pnlInfrastructures, "Silo", DataInfrastructure.getSiloPrice(), DataObjects.infraBuy, "infrastructure", DataInfrastructure.getSiloGender());
		displayArticle(pnlInfrastructures, "Garage", DataInfrastructure.getGaragePrice(), DataObjects.infraBuy, "infrastructure", DataInfrastructure.getGarageGender());
		displayArticle(pnlInfrastructures, "Camion", DataInfrastructure.getTruckPrice(), DataObjects.infraBuy, "infrastructure", DataInfrastructure.getTruckGender());
		displayArticle(pnlInfrastructures, "Champ", DataInfrastructure.getFieldPrice(), DataObjects.infraBuy, "Champs", DataInfrastructure.getFieldGender());
		displayArticle(pnlInfrastructures, "Enclos", DataInfrastructure.getEnclosurePrice(), DataObjects.infraBuy, "Enclos", DataInfrastructure.getEnclosureGender());
		
		displayArticle(pnlRessources, "Carotte", DataRessource.getCarrotPrice(), DataObjects.ressourcesBuy, "ressources", DataRessource.getCarrotGender());
		displayArticle(pnlRessources, "Blé", DataRessource.getWheatPrice(), DataObjects.ressourcesBuy, "ressources", DataRessource.getWheatGender());
		displayArticle(pnlRessources, "Pomme", DataRessource.getApplePrice(), DataObjects.ressourcesBuy, "ressources", DataRessource.getAppleGender());
		displayArticle(pnlRessources, "Tomate", DataRessource.getTomatoPrice(), DataObjects.ressourcesBuy, "ressources", DataRessource.getTomatoGender());
		displayArticle(pnlRessources, "Melon", DataRessource.getMeloonPrice(), DataObjects.ressourcesBuy, "ressources", DataRessource.getMeloonGender());
		displayArticle(pnlRessources, "Tournesol", DataRessource.getSunflowerPrice(), DataObjects.ressourcesBuy, "ressources", DataRessource.getSunflowerGender());
		
		displayArticle(pnlAnimals, "Mouton", DataAnimal.getSheepPrice(), DataObjects.animalBuy, "animal", DataAnimal.getSheepGender());
		displayArticle(pnlAnimals, "Poule", DataAnimal.getChickenPrice(), DataObjects.animalBuy, "animal", DataAnimal.getChickenGender());
		displayArticle(pnlAnimals, "Coq", DataAnimal.getChickenPrice(), DataObjects.animalBuy, "animal", DataAnimal.getChicken2Gender());
		displayArticle(pnlAnimals, "Cochon", DataAnimal.getPigPrice(), DataObjects.animalBuy, "animal", DataAnimal.getPigGender());
		displayArticle(pnlAnimals, "Lapin", DataAnimal.getRabbitPrice(), DataObjects.animalBuy, "animal", DataAnimal.getRabbitGender());
		displayArticle(pnlAnimals, "Chèvre", DataAnimal.getGoatPrice(), DataObjects.animalBuy, "animal", DataAnimal.getGoatGender());
		
		
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
		buyFence();
	}
}
public HashMap<String, JButton> getInfraBuy() {
		return DataObjects.infraBuy;
	}



	public HashMap<String, JButton> getRessourcesBuy() {
		return DataObjects.ressourcesBuy;
	}



	public HashMap<String, JButton> getAnimalBuy() {
		return DataObjects.animalBuy;
	}



	
	public void displayArticle(JPanel pnlShop, String name, int price, HashMap<String, JButton> hashButton, String action, String gender) {
		Dimension iconDimension = new Dimension(pnlShop.getWidth()-50, 35);
		ShopPanel pnlArticle = new  ShopPanel(name, iconDimension, price, hashButton, action, gender);
		pnlShop.add(pnlArticle.getPanel());
	}



	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}