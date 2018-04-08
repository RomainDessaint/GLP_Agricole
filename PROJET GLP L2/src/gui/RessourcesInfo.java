package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import datas.DataObjects;
import types.Animal;
import types.Ressource;

public class RessourcesInfo {
	private JFrame frame = new JFrame();
	private Ressource vedg;
	private int indecField;
	private int indexCellule;
	
	public RessourcesInfo(Ressource vedg, int indexField, int indexCellule) {
		this.vedg = vedg;
		this.indecField = indexField;
		this.indexCellule = indexCellule;
		frame.setName(vedg.getName());
		frame.setSize(300, 80);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(new Color(100, 100, 100));
		JLabel text = new JLabel(vedg.getName()+" poids : "+vedg.getWeight());
		text.setOpaque(true);
		text.setSize(300, 90);
		JButton action = new JButton("abatre");
		action.setSize(80, 30);
		frame.add(text);
		frame.add(action);
		frame.setLayout(null);

	
	DataObjects.FenceMap.get(indexField).get(indexCellule).setIcon(null);
	frame.setVisible(false);
	}
		
}