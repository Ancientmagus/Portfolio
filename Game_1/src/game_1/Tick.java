package game_1;

public class Tick implements Runnable {

	private volatile boolean running = true;
	private final Object pauseLock = new Object();

	public void run() {
		Game game = new Game();
		running = game.getRunning();
		BusAnimation bAnim = new BusAnimation();
		PeopleAnimation pAnim = new PeopleAnimation();
		int pAnimNum = 0;
		int yt = 0;

		while (running) {
			
			yt += 1;
			
			if (yt == 3) {
			if (pAnimNum == 3) {
				pAnimNum = 0;
			}
			pAnimNum += 1;
			game.setPAnimNum(pAnimNum);
			pAnim.go();
			yt = 0;
			}		
			
			int lvl = game.getLevel();
			int strs = game.getStars();
			synchronized (pauseLock) {
				if (!running) {
					System.out.println("paused");
					try {
						pauseLock.wait();
					} catch (InterruptedException ex) {
						break;
					}
				}
			}

			// animations
			if ((lvl == 1 && strs > 3) || (lvl == 2)) {
				bAnim.go();
			}

			// drawpanel update
			game.repaintDrawPanel();

			// tick speed
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void resume() {
		synchronized (pauseLock) {
			pauseLock.notifyAll();
		}
	}
}