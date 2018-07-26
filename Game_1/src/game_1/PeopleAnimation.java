package game_1;

public class PeopleAnimation {

	public void go() {
		Game game = new Game();
		int x2 = game.getX2();

		if (x2 < 350) {
			x2++;
			game.setX2(x2);
		} else {
			x2 = -80;
			game.setX2(x2);
			System.out.println(x2);
		}
	}
}
