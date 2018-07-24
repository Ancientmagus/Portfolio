package game_1;

public class TickTest implements Runnable {

	private volatile boolean running = true;
	private final Object pauseLock = new Object();

	public void run() {
		Game game = new Game();
		running = game.getRunning();
		int lvl = game.getLevel();
		int strs = game.getStars();
		BusAnimation bAnim = new BusAnimation();
		
		while (running) {
			synchronized (pauseLock) {
				if (!running) {
					System.out.println("paused");
					try {
						pauseLock.wait();
					} catch (InterruptedException ex) {break;}
				}
			}
			
			//animations
			if ((lvl == 1 && strs >2) || (lvl == 2)) {
				bAnim.go();	
			}
			
			//drawpanel update
			game.repaintDrawPanel();
			
			//tick speed
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
