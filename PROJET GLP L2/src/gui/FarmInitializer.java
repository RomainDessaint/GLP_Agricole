package gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import datas.DataObjects;


public class FarmInitializer {
	
	private JPanel pnlFarm;
	private int width;
	private int height;
	private  int indexFence = 0;
	private  int indexField = 0;
	
	public FarmInitializer(JPanel pnlFarm, int width, int height) {
		this.width = width;
		this.height = height;
		this.pnlFarm = pnlFarm;
		this.pnlFarm.setBackground(new Color(170, 223, 43));
		this.pnlFarm.setOpaque(true);
		DataObjects.vedgetables.put("Carotte", 1);
		DataObjects.vedgetables.put("Carotte", 2);
		for (int i=0; i<6; i++) {
			insertFence();
			insertField();
		}
	}

	public void insertFence() {
		JPanel pnlFence = new JPanel();
		if (DataObjects.FenceMap.size()%2 == 0) {
			 pnlFence = DrawFarm.drawFence(DataObjects.FenceMap.size()*100+15, 200, 100);
		}
		else {
			 pnlFence = DrawFarm.drawFence((DataObjects.FenceMap.size()-1)*100+15, 380, 100);
		}
		
		HashMap<Integer, JButton> HashButton = new HashMap<>();
		insertGrid(pnlFence, HashButton, false);
		DataObjects.FenceMap.put(indexFence, HashButton);
		pnlFence.setVisible(false);
		DataObjects.Fence.put(indexFence, pnlFence);
		pnlFarm.add(pnlFence);
		indexFence++;
	}
	
	public void insertField() {
		JPanel pnlField = new JPanel();
		if (DataObjects.FieldMap.size()%2 == 0) {
			 pnlField = DrawFarm.drawfield(850,DataObjects.FieldMap.size()*70+60, 100);
		}
		else {
			 pnlField = DrawFarm.drawfield(1000,(DataObjects.FieldMap.size()-1)*70+60, 100);
		}
		
		HashMap<Integer, JButton> HashButton = new HashMap<>();
		insertGrid(pnlField, HashButton, true);
		DataObjects.FieldMap.put(indexField, HashButton);
		pnlField.setVisible(false);
		DataObjects.Field.put(indexField, pnlField);
		pnlFarm.add(pnlField);
		indexField++;
	}
	
	public void insertGrid(JPanel container, HashMap<Integer, JButton> HashButton, boolean background) {
		JPanel pnlGrid = new JPanel();
		pnlGrid.setVisible(true);
		pnlGrid.setBounds(0, 0, container.getWidth(), container.getHeight());
		pnlGrid.setBackground(new Color(255, 0, 0, 0));
		pnlGrid.setOpaque(false);
		pnlGrid.setLayout(new GridBagLayout());
		initGrid(pnlGrid, HashButton, background);
		container.add(pnlGrid);
	}
	
	public void initGrid(JPanel pnlGrid, HashMap<Integer, JButton> HashButton, boolean background) {
		GridBagConstraints gbc = new GridBagConstraints();
		int index = 0;
		for (int j = 0; j<(pnlGrid.getWidth()/28)-2; j++) {
			gbc.gridy = j;
			gbc.gridwidth = 1;
			for (int i = 0; i<(pnlGrid.getWidth()/30)-1; i++) {
				gbc.gridx = i;
				JButton cellule = new JButton();
				cellule.setPreferredSize(new Dimension(pnlGrid.getWidth()/4, pnlGrid.getHeight()/4 +1));
				cellule.setBorder(null);
				cellule.setOpaque(background);
				if (background == false) {
					cellule.setBackground(new Color(173, 226, 46, 50));
				}
				else {
					cellule.setBackground(new Color(201, 179, 20));
				}
				
				HashButton.put(index, cellule);
				pnlGrid.add(cellule, gbc);
				index++;
			}
			gbc.gridwidth = GridBagConstraints.REMAINDER;
		}
	}
	
	public JPanel drawGround() {
		//Affichage du sol
		for (int i = 0; i < width; i +=50) {
			for (int j = 0; j < height; j += 50) {
				pnlFarm.add(DrawFarm.putImage("src\\images\\sol.png", i, j, 50, 50));
				pnlFarm.setBackground(new Color(170, 223, 43));
			}
		}
		return pnlFarm;
	}
	
	public JButton drawHouse() {
		ImageIcon iiHouse = new ImageIcon("src\\images\\house.png");
		JButton btnHouse = new JButton(iiHouse);
		btnHouse.setOpaque(false);
		btnHouse.setBorder(null);
		btnHouse.setBackground(new Color(255, 0, 0, 0));
		
		return btnHouse;
	}
	public JPanel getPnlFarm() {
		return pnlFarm;
	}

	public void setPnlFarm(JPanel pnlFarm) {
		this.pnlFarm = pnlFarm;
	}

	public int getIndexFence() {
		return indexFence;
	}

	public void setIndexFence(int indexFence) {
		this.indexFence = indexFence;
	}

	public int getIndexField() {
		return indexField;
	}

	public void setIndexField(int indexField) {
		this.indexField = indexField;
	}

}
