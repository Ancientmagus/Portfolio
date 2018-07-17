package game_1;

public class Launcher {
	public static void main (String[] args) {
		Game game = new Game();
		game.buildGUI();
		
		//money thread
		Money money = new Money();
		Thread moneyThread = new Thread(money);
		moneyThread.start();
	}

}
