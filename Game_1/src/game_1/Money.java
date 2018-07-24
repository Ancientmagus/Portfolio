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
			//game.setMoneyLabel(money + "(" + cashflow + ")");
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// CONTROL _ DELETE
			System.out.println(money);
		}
	}
	
	
	
}
