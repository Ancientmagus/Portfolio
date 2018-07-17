package game_1;

public class Money implements Runnable{
	
	public void run() {
		Game game = new Game();
		int money = game.getMoney();
		int cashflow = game.getCashflow();
		
		while(true) {
			money += cashflow;
			game.setMoney(money);
			game.setMoneyLabel("Money: $" + money + "(" + cashflow + ")");
			
			System.out.println(money);
			
			try {
				Thread.sleep(1000);
			}catch (Exception ex) {ex.printStackTrace();}
		}
		
	}
}
