package gui;

import system.Game;

public class Main {
	
	public static void main(String[] args) {
//		new MenuFrame();
		Game game = new Game();
		game.setMoney(100000);
		new GameFrame(game);
	}
}