package game_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Game {
	static int money = 0;
	static int level = 1;
	static int cashflow = 5;
	static int stars = 1;
	static int starsLvl2 = 1;
	static int x = -116;
	static int x2 = -10;
	static int currentLvl = 1;
	static int pAnimNum;
	static boolean running;
	static JLabel moneyTitle;
	static MyDrawPanel drawPanel;
	String moneyLabel;
	JFrame theFrame;
	JPanel mainPanel;
	BufferedImageLoader loader = new BufferedImageLoader();
	Thread busThread;

	public void buildGUI() {

		// Game Frame
		theFrame = new JFrame("Game_1");
		theFrame.getContentPane().setLayout(null);

		// Frame background
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("/images/GUI_v1.5.png")));
		background.setBounds(0, 0, 630, 630);

		// Main Panel
		mainPanel = new JPanel();
		drawPanel = new MyDrawPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(drawPanel, BorderLayout.CENTER);
		mainPanel.setBounds(43, 75, 509, 343);

		// Buttons
		JButton storeBtn = new JButton();
		storeBtn.addActionListener(new StoreButtonListener());
		storeBtn.setBounds(37, 448, 150, 150);
		storeBtn.setIcon(new ImageIcon(getClass().getResource("/images/ShopBtn_unpressed.png")));
		storeBtn.setPressedIcon(new ImageIcon(getClass().getResource("/images/ShopBtn_pressed.png")));
		storeBtn.setContentAreaFilled(false);
		storeBtn.setBorderPainted(false);

		JButton saveBtn = new JButton();
		saveBtn.addActionListener(new SaveButtonListener());
		saveBtn.setBounds(227, 448, 150, 150);
		saveBtn.setIcon(new ImageIcon(getClass().getResource("/images/SaveBtn_unpressed.png")));
		saveBtn.setPressedIcon(new ImageIcon(getClass().getResource("/images/SaveBtn_pressed.png")));
		saveBtn.setContentAreaFilled(false);
		saveBtn.setBorderPainted(false);

		JButton travelBtn = new JButton();
		travelBtn.addActionListener(new TravelButtonListener());
		travelBtn.setBounds(414, 448, 150, 150);
		travelBtn.setIcon(new ImageIcon(getClass().getResource("/images/TravelBtn_unpressed.png")));
		travelBtn.setPressedIcon(new ImageIcon(getClass().getResource("/images/TravelBtn_pressed.png")));
		travelBtn.setContentAreaFilled(false);
		travelBtn.setBorderPainted(false);

		JButton closeBtn = new JButton();
		closeBtn.addActionListener(new CloseButtonListener());
		closeBtn.setBounds(568, 2, 55, 55);
		closeBtn.setOpaque(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);

		// Frame construction
		theFrame.setResizable(false);
		theFrame.setBounds(10, 10, 630, 630);
		theFrame.setUndecorated(true);
		theFrame.setLocationRelativeTo(null);
		theFrame.setBackground(new Color(0, 0, 0, 0));

		theFrame.getContentPane().add(travelBtn);
		theFrame.getContentPane().add(saveBtn);
		theFrame.getContentPane().add(storeBtn);
		theFrame.getContentPane().add(closeBtn);
		theFrame.getContentPane().add(mainPanel);
		theFrame.getContentPane().add(background);
		theFrame.setVisible(true);

		running = true;
	}

	class MyDrawPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {

			Levels levels = new Levels();
			Image location = levels.locationGen(level, stars, starsLvl2);
			g.drawImage(location, 0, 0, this.getWidth(), this.getHeight(), this);
			Image starsImg = levels.starsImage(level, stars, starsLvl2);
			g.drawImage(starsImg, 0, 0, 188, 41, this);

			// People Animation
			if (pAnimNum == 1) {
				Image male1Anim = loader.loadImage("/images/Male1_left1.png");
				g.drawImage(male1Anim, x2, 300, 18, 31, this);
			} else if (pAnimNum == 2) {
				Image male1Anim = loader.loadImage("/images/Male1_left2.png");
				g.drawImage(male1Anim, x2, 300, 18, 31, this);
			} else if (pAnimNum == 3) {
				Image male1Anim = loader.loadImage("/images/Male1_left3.png");
				g.drawImage(male1Anim, x2, 300, 18, 31, this);
			}

			// money text
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			String moneytext = (money + "(" + cashflow + ")");
			g2d.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
			g2d.setColor(Color.BLACK);
			g2d.drawString(moneytext, 350, 30);

			// Bus Animation
			if ((level == 1 && stars > 3) || (level == 2)) {
				Image busImg = loader.loadImage("/images/Bus.png");
				g.drawImage(busImg, x, 283, 116, 51, this);

				// Tires
				BufferedImage tireImg1 = loader.loadImage("/images/Tire.png");
				BufferedImage tireImg2 = loader.loadImage("/images/Tire.png");

				// locations
				int drawXT1 = x + 27;
				int drawYT1 = 317;
				int drawXT2 = x + 82;
				int drawYT2 = 317;

				// Rotation
				double rotationRequired = Math.toRadians(5);
				double locationX1 = tireImg1.getWidth() / 2;
				double locationY1 = tireImg1.getHeight() / 2;
				AffineTransform tx1 = AffineTransform.getRotateInstance(rotationRequired, locationX1, locationY1);
				AffineTransformOp op1 = new AffineTransformOp(tx1, AffineTransformOp.TYPE_BILINEAR);

				double locationX2 = tireImg2.getWidth() / 2;
				double locationY2 = tireImg2.getHeight() / 2;
				AffineTransform tx2 = AffineTransform.getRotateInstance(rotationRequired, locationX2, locationY2);
				AffineTransformOp op2 = new AffineTransformOp(tx2, AffineTransformOp.TYPE_BILINEAR);

				// drawing
				g2d.drawImage(op1.filter(tireImg1, null), drawXT1, drawYT1, null);
				g2d.drawImage(op2.filter(tireImg2, null), drawXT2, drawYT2, null);
			}
		}
	}

	public class StoreButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Store store = new Store();
			running = false;
			theFrame.setVisible(false);
			if (level == 1) {
				store.buildGUI(level, stars);
			} else if (level == 2) {
				store.buildGUI(level, starsLvl2);
			}
			theFrame.dispose();
		}
	}

	public class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SaveLoad invest = new SaveLoad();
			theFrame.setVisible(false);
			invest.buildGUI();
			theFrame.dispose();
		}
	}

	public class TravelButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Travel travel = new Travel();
			theFrame.setVisible(false);
			travel.buildGUI();
			theFrame.dispose();
		}
	}

	public class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				System.exit(0);
				theFrame.dispose();
			}
		}
	}

	public int getLevel() {
		return level;
	}

	void setLevel(int num) {
		level = num;
	}

	public int getStars() {
		return stars;
	}

	void setStars(int num) {
		stars = num;
	}

	public int getStarsLvl2() {
		return starsLvl2;
	}

	void setStarsLvl2(int num) {
		starsLvl2 = num;
	}

	public int getCurrentLvl() {
		return currentLvl;
	}

	void setCurrentLvl(int num) {
		currentLvl = num;
	}

	void changeMoney(int gold) {
		money += gold;
	}

	void changeCashflow(int flow) {
		cashflow += flow;
	}

	public int getMoney() {
		return money;
	}

	void setMoney(int num) {
		money = num;
	}

	void setMoneyLabel(String label) {
		moneyLabel = label;
	}

	void setPAnimNum(int num) {
		pAnimNum = num;
	}

	public int getCashflow() {
		return cashflow;
	}

	void setCashFlow(int num) {
		cashflow = num;
	}

	public int getX() {
		return x;
	}

	void setX(int val) {
		x = val;
	}

	public int getX2() {
		return x2;
	}

	void setX2(int val) {
		x2 = val;
	}

	void repaintDrawPanel() {
		drawPanel.repaint();
	}

	public boolean getRunning() {
		return running;
	}

	void setRunning(boolean runin) {
		running = runin;
	}
}
