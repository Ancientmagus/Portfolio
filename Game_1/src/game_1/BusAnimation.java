package game_1;

public class BusAnimation {

	public void go() {
		Game game = new Game();
		int x = game.getX();

		if (x < 509) {
			//for (int i = 0; i < 625; i++) {
				x++;
				game.setX(x);
				// game.repaintDrawPanel();
				//try {
					//Thread.sleep(50);
				//} catch (InterruptedException e) {
					//e.printStackTrace();
				//}

				//if (game.getRunning() == false) {
					//break;
				//}
			//}
		} else {
			x = -116;
			game.setX(x);
				System.out.println(x);
		}

	}
}
