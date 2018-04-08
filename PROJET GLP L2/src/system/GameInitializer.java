package system;

import java.util.HashMap;

import types.Infrastructure;

public class GameInitializer {

	public static Game newGame() {
		Game game = new Game();
		return game;
	}
	
	public static Player newPlayer() {
		Player player = new Player();
		return player;
	}
	
	public static Shop newShop() {
		Shop shop = new Shop();
		return shop;
	}
	
	public void loadGame() {
	}
}
