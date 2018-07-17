package game_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class Game {
	static int money = 0;
	static int level = 1;
	static int cashflow = 50;
	static int stars = 3;
	String moneyLabel;
	JFrame theFrame;
	JPanel mainPanel;
	static JLabel moneyTitle;
	private BufferedImage bi = null;
	BufferedImageLoader loader = new BufferedImageLoader();

	public void buildGUI() {

		theFrame = new JFrame("Game_1");
		theFrame.getContentPane().setLayout(null);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\GUI_v1.5.png"));
		background.setBounds(0, 0, 630, 630);

		mainPanel = new JPanel();
		MyDrawPanel drawPanel = new MyDrawPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(drawPanel, BorderLayout.CENTER);
		mainPanel.setBounds(43, 75, 509, 343);

		JButton storeBtn = new JButton();
		storeBtn.addActionListener(new StoreButtonListener());
		storeBtn.setBounds(37, 448, 150, 150);
		storeBtn.setIcon(new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\ShopBtn_unpressed.png"));
		storeBtn.setPressedIcon(new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\ShopBtn_pressed.png"));
		storeBtn.setContentAreaFilled(false);
		storeBtn.setBorderPainted(false);

		JButton saveBtn = new JButton();
		saveBtn.addActionListener(new SaveButtonListener());
		saveBtn.setBounds(227, 448, 150, 150);
		saveBtn.setIcon(new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\SaveBtn_unpressed.png"));
		saveBtn.setPressedIcon(
				new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\SaveBtn_pressed.png"));
		saveBtn.setContentAreaFilled(false);
		saveBtn.setBorderPainted(false);

		JButton travelBtn = new JButton();
		travelBtn.addActionListener(new TravelButtonListener());
		travelBtn.setBounds(414, 448, 150, 150);
		travelBtn
				.setIcon(new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\TravelBtn_unpressed.png"));
		travelBtn.setPressedIcon(
				new ImageIcon("C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\TravelBtn_pressed.png"));
		travelBtn.setContentAreaFilled(false);
		travelBtn.setBorderPainted(false);

		JButton closeBtn = new JButton();
		closeBtn.addActionListener(new CloseButtonListener());
		closeBtn.setBounds(568, 2, 55, 55);
		closeBtn.setOpaque(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);

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

		/*
		 * // frame and mainPanel theFrame = new JFrame("GAME_1"); //****VER ISTO
		 * theFrame.setLayout(new BorderLayout()); Levels levels = new Levels(1); Image
		 * nivel1 = levels.le1(); JLabel backgroundGUI = new JLabel(new
		 * ImageIcon(nivel1)); theFrame.add(backgroundGUI, BorderLayout.CENTER);
		 * backgroundGUI.setLayout(new BorderLayout());
		 * 
		 * 
		 * BorderLayout layout = new BorderLayout(); JPanel mainPanel = new
		 * JPanel(layout); mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10,
		 * 10, 10));
		 * 
		 * // bottom Panel JPanel bottomPanel = new JPanel(new BorderLayout());
		 * 
		 * // buttons Panel JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10,
		 * 10)); buttonPanel.setPreferredSize(new Dimension(800, 100));
		 * buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 * 
		 * JButton storeBtn = new JButton("STORE"); storeBtn.addActionListener(new
		 * StoreButtonListener()); buttonPanel.add(storeBtn); storeBtn.setFont(new
		 * Font("Arial", Font.PLAIN, 35));
		 * 
		 * JButton investBtn = new JButton("INVEST"); investBtn.addActionListener(new
		 * InvestButtonListener()); buttonPanel.add(investBtn); investBtn.setFont(new
		 * Font("Arial", Font.PLAIN, 35));
		 * 
		 * JButton travelBtn = new JButton("TRAVEL"); travelBtn.addActionListener(new
		 * TravelButtonListener()); buttonPanel.add(travelBtn); travelBtn.setFont(new
		 * Font("Arial", Font.PLAIN, 35));
		 * 
		 * //TO MAKE IT TRANSPARENT:
		 * 
		 * travelBtn.setOpaque(false); travelBtn.setContentAreaFilled(false);
		 * travelBtn.setBorderPainted(false);
		 * 
		 * 
		 * // Money and Stars Panel JPanel scorePanel = new JPanel(new GridLayout(1,
		 * 2)); scorePanel.setMinimumSize(new Dimension(600, 50));
		 * scorePanel.setMaximumSize(new Dimension(600, 50));
		 * scorePanel.setPreferredSize(new Dimension(600, 50));
		 * 
		 * moneyTitle = new JLabel(moneyLabel);
		 * moneyTitle.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		 * 
		 * bi = loader.loadImage(
		 * "C:\\Users\\Bruno\\eclipse-workspace\\Game_1\\Images\\stars.jpg"); Image dim
		 * = bi.getScaledInstance(100, 18, Image.SCALE_SMOOTH); ImageIcon stars = new
		 * ImageIcon(dim); JLabel starsLabel = new JLabel("QUALITY: ", stars,
		 * JLabel.LEFT); starsLabel.setIconTextGap(-200);
		 * starsLabel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		 * 
		 * // Game Graphics Panel MyDrawPanel drawPanel = new MyDrawPanel();
		 * 
		 * // Main Panel Setting
		 * 
		 * scorePanel.add(starsLabel); scorePanel.add(moneyTitle);
		 * mainPanel.add(bottomPanel, BorderLayout.SOUTH); mainPanel.add(drawPanel,
		 * BorderLayout.CENTER); bottomPanel.add(buttonPanel, BorderLayout.CENTER);
		 * bottomPanel.add(scorePanel, BorderLayout.NORTH);
		 * 
		 * theFrame.getContentPane().add(mainPanel);
		 * 
		 * // closing method theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * // Size and setting to visible theFrame.setBounds(50, 50, 600, 600);
		 * theFrame.setUndecorated(true); theFrame.setResizable(false);
		 * theFrame.setLocationRelativeTo(null); theFrame.setVisible(true);
		 * 
		 */

	}

	class MyDrawPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {

			Levels levels = new Levels();
			Image location = levels.locationGen(level, stars);
			g.drawImage(location, 0, 0, this.getWidth(), this.getHeight(), this);

			Image starsImg = levels.starsImage(stars);
			g.drawImage(starsImg, 0, 0, 188, 41, this);

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
		money += num;
	}

	void setMoneyLabel(String label) {
		moneyLabel = label;
		// moneyTitle.setText(label);
	}

	public int getCashflow() {
		return cashflow;
	}

	public class StoreButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Store store = new Store();
			theFrame.setVisible(false);
			store.buildGUI();
		}
	}

	public class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Invest invest = new Invest();
			theFrame.setVisible(false);
			invest.buildGUI();
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
		}
	}

	public class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			System.exit(0);
			theFrame.dispose();
		}
	}

}
