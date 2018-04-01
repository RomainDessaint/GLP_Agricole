package datas;

public class DataGame {
	private static String[] difficultyStrings = {"Facile", "Moyen", "Difficile"};
	private static String[] genderStrings = {"Homme", "Femme"};
	private static Integer[] agePlayer = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
	private static int[] moneyStarter = {3000, 2000, 1000};
	
	public DataGame() {
	}

	public static String[] getDifficultyStrings() {
		return difficultyStrings;
	}

	public static String[] getGenderStrings() {
		return genderStrings;
	}
	
	public static Integer[] getAgePlayer() {
		return agePlayer;
	}

	public static int getStartingMoney(int difficulty) {
		return moneyStarter[difficulty];
	}	
}

