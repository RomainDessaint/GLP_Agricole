package datas;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import types.Animal;
import types.Ressource;

public class DataObjects {
	public static int MaxKgHouseVegds = 100;
	public static int MaxKgHouseMeat = 100;
	
	public static int CurrentKgHouseVedgs = 0;
	public static int CurrentKgHouseMeat = 0;

	public static HashMap<String, Integer> vedgetables = new HashMap<>();
	public static HashMap<String, Integer> vedgetablesHouse = new HashMap<>();
	public static HashMap<String, Integer> vedgetablesSilo = new HashMap<>();
	
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
	public static HashMap<String, Ressource> Ressources = new HashMap<>();
	
	private DataObjects() {	
	}
	
	public static void addMeatKg(int quantity) {
		CurrentKgHouseMeat += quantity;
	}
	public static void addVedgsKg(int quantity) {
		CurrentKgHouseVedgs += quantity;
	}	
}
