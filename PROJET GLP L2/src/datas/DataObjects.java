package datas;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import types.Animal;

public class DataObjects {

	public static HashMap<String, Integer> vedgetables = new HashMap<>();
	public static HashMap<String, Integer> infrastructures = new HashMap<>();
	public static HashMap<String, Integer> animals = new HashMap<>();
	
	public static HashMap<Integer, HashMap<Integer, JButton>> FenceMap = new HashMap<>();
	public static HashMap<Integer, HashMap<Integer, JButton>> FieldMap = new HashMap<>();
	
	public static HashMap<Integer, JPanel> Fence = new HashMap<>();
	public static HashMap<Integer, JPanel> Field = new HashMap<>();

	
	public static HashMap<String , JButton> infraBuy = new HashMap<>();
	public static HashMap<String , JButton> ressourcesBuy = new HashMap<>();
	public static HashMap<String , JButton> animalBuy = new HashMap<>();
	
	public static HashMap<String, JButton> warehouse = new HashMap<>();
	
//	voir la différence entre les 2
	public static HashMap<String, Animal> Animals = new HashMap<>();
	
	private DataObjects() {
		
	}
}
