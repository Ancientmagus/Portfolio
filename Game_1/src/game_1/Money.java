package game_1;

public class Money implements Runnable {
	
	String label;
	
	public void run() {
		Game game = new Game();

		while (true) {
			int money = game.getMoney();
			int cashflow = game.getCashflow();
			money += cashflow;
			game.setMoney(money);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(game.getStars());
			System.out.println(game.getStarsLvl2());
		}
	}
	
	
	
}
