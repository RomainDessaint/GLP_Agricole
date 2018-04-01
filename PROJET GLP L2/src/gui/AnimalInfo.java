package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import datas.DataObjects;
import gui.ShopPanel.AnimalInfoAction;
import types.Animal;

public class AnimalInfo {
	private JFrame frame = new JFrame();
	private Animal animal;
	private int indecFence;
	private int indexCellule;
	public AnimalInfo(Animal animal, int indexFence, int indexCellule) {
		
		this.animal = animal;
		this.indecFence = indexFence;
		this.indexCellule = indexCellule;
		
		frame.setName(animal.getName());
		frame.setSize(300, 80);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(new Color(100, 100, 100));
		JLabel text = new JLabel(animal.getName()+" poids : "+animal.getWeight());
		text.setOpaque(true);
		text.setSize(300, 90);
		JButton action = new JButton("abatre");
		action.setSize(80, 30);
		frame.add(text);
		frame.add(action);
		frame.setLayout(null);
		action.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DataObjects.FenceMap.get(indexFence).get(indexCellule).setIcon(null);
				frame.setVisible(false);
				
			}
		});
	}

}
