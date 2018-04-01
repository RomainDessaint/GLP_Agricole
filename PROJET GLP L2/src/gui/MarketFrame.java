package gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datas.DataAnimal;
import datas.DataRessource;


public class MarketFrame {	
	private JPanel pnlContent;
	private JPanel pnlRessources;
	private JPanel pnlAnimals;
	
	private JLabel lbRessources;
	private JLabel lbAnimals;
	private JFrame frame = new JFrame();
	
	private GridLayout contentLayout;
	
	private Font titleFont;
	
	public MarketFrame() {
		frame.setTitle("Market");
		frame.setSize(1200, 500);
		frame.setLocation(50,50);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);	
		
		pnlRessources = new JPanel();
		pnlRessources.setBackground(Color.WHITE);
		
		pnlAnimals = new JPanel();
		pnlAnimals.setBackground(Color.pink);
		
		pnlContent = new JPanel();
		pnlContent.setOpaque(false);
		contentLayout = new GridLayout(1,2);
		
		pnlContent.setLayout(contentLayout);
		pnlContent.add(pnlRessources);
		pnlContent.add(pnlAnimals);		
		
		lbRessources = new JLabel("Vendez vos ressources :");
		lbAnimals = new JLabel("Vendez vos animaux :");
		titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 17);
		
		lbRessources.setFont(titleFont);
		lbAnimals.setFont(titleFont);
		
		pnlRessources.add(lbRessources, BorderLayout.NORTH);
		pnlAnimals.add(lbAnimals, BorderLayout.NORTH);
		
		frame.setContentPane(pnlContent);
		frame.setVisible(true);
		
		displayArticle(pnlRessources, "Carotte", DataRessource.getCarrotPrice(), DataRessource.getCarrotGender());
		displayArticle(pnlRessources, "Blé", DataRessource.getWheatPrice(), DataRessource.getWheatGender());
		displayArticle(pnlRessources, "Pomme", DataRessource.getApplePrice(), DataRessource.getAppleGender());
		displayArticle(pnlRessources, "Tomate", DataRessource.getTomatoPrice(), DataRessource.getTomatoGender());
		displayArticle(pnlRessources, "Melon", DataRessource.getMeloonPrice(), DataRessource.getMeloonGender());
		displayArticle(pnlRessources, "Tournesol", DataRessource.getSunflowerPrice(), DataRessource.getSunflowerGender());
		displayArticle(pnlAnimals, "Mouton", DataAnimal.getSheepPrice(), DataAnimal.getSheepGender());
		displayArticle(pnlAnimals, "Poule", DataAnimal.getChickenPrice(), DataAnimal.getChickenGender());
		displayArticle(pnlAnimals, "Coq", DataAnimal.getChickenPrice(), DataAnimal.getChicken2Gender());
		displayArticle(pnlAnimals, "Cochon", DataAnimal.getPigPrice(), DataAnimal.getPigGender());
		displayArticle(pnlAnimals, "Lapin", DataAnimal.getRabbitPrice(), DataAnimal.getRabbitGender());
		displayArticle(pnlAnimals, "Chèvre", DataAnimal.getGoatPrice(), DataAnimal.getGoatGender());
	}
	
	public void displayArticle(JPanel pnlShop, String name, int price, String gender) {
		Dimension iconDimension = new Dimension(pnlShop.getWidth()-50, 35);
		MarketPanel pnlArticle = new MarketPanel(name, iconDimension, price);
		pnlShop.add(pnlArticle.getPanel());
	}
}
