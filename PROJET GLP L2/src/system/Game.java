package system;

import java.util.HashMap;

import types.Infrastructure;

public class Game {
	private String gameName;
	private int difficulty;
	private Player player;
	private HashMap<String, Infrastructure> infrastructures;
	private Shop shop;
	private int money;
	private int eventState;
	
	public Game() {
	}

	public Game(String gameName, int difficulty, Player player,
			HashMap<String, Infrastructure> infrastructures, Shop shop, int money, int evenState) {
		this.gameName = gameName;
		this.difficulty = difficulty;
		this.player = player;
		this.infrastructures = infrastructures;
		this.shop = shop;
		this.money = money;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public HashMap<String, Infrastructure> getInfrastructures() {
		return infrastructures;
	}

	public void setInfrastructures(HashMap<String, Infrastructure> infrastructures) {
		this.infrastructures = infrastructures;
	}
	
	public int getMoney() {
		return money;
	}
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getEventState() {
		return eventState;
	}

	public void setEventState(int eventState) {
		this.eventState = eventState;
	}

	@Override
	public String toString() {
		return "Game [gameName=" + gameName + ", difficulty=" + difficulty + ", player=" + player
				+ ", infrastructures=" + infrastructures + ", shop=" + shop + ", money=" + money + ", eventState="
				+ eventState + "]";
	}
}
