package game_1;

public class BusAnimation {

	public void go() {
		Game game = new Game();
		int x = game.getX();

		if (x < 509) {
				x++;
				game.setX(x);
		} else {
			x = -116;
			game.setX(x);
				System.out.println(x);
		}
	}
}
