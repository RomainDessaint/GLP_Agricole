package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import types.Animal;

public class AnimalInfo {
	private JFrame frame = new JFrame();
	private Animal animal;
	public AnimalInfo(Animal animal) {
		this.animal = animal;
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
				// TODO Auto-generated method stub
				
			}
		});
	}

}
