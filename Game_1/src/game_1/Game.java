package game_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game {
	static int money = 0;
	static int level = 1;
	static int cashflow = 500;
	static int stars = 1;
	static int starsLvl2 = 1;
	static int x = -116;
	static int currentLvl = 1;
	static boolean running;
	static JLabel moneyTitle;
	static MyDrawPanel drawPanel;
	String moneyLabel;
	JFrame theFrame;
	JPanel mainPanel;
	BufferedImageLoader loader = new BufferedImageLoader();
	Thread busThread;


	public void buildGUI() {

		//Game Frame
		theFrame = new JFrame("Game_1");
		theFrame.getContentPane().setLayout(null);
		
		//Frame background
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("/images/GUI_v1.5.png")));
		background.setBounds(0, 0, 630, 630);
		
		//Main Panel
		mainPanel = new JPanel();
		drawPanel = new MyDrawPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(drawPanel, BorderLayout.CENTER);
		mainPanel.setBounds(43, 75, 509, 343);
		
		/*
		//Money panel
		moneyTitle = new JLabel(moneyLabel);
		moneyTitle.setBounds(394, 80, 151, 33);
		moneyTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		*/
		
		//Buttons
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
		
		//Frame construction
		theFrame.setResizable(false);
		theFrame.setBounds(10, 10, 630, 630);
		theFrame.setUndecorated(true);
		theFrame.setLocationRelativeTo(null);
		theFrame.setBackground(new Color(0, 0, 0, 0));

		theFrame.getContentPane().add(travelBtn);
		theFrame.getContentPane().add(saveBtn);
		theFrame.getContentPane().add(storeBtn);
		theFrame.getContentPane().add(closeBtn);
		//theFrame.getContentPane().add(moneyTitle);
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
			
			//Bus Animation
			Image busImg = loader.loadImage("/images/Bus.png");
			Image tireImg = loader.loadImage("/images/Tire.png");
			g.drawImage(busImg, x, 283, 116, 51, this);
			
			
			//System.out.println(x);
			
			//money text
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			String moneytext = (money + "(" + cashflow + ")");
			g2d.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
			g2d.setColor(Color.BLACK);
			g2d.drawString(moneytext, 350, 30);
			
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
	
	/*
	void setMoneyTitle() {
		moneyTitle.setText(money + "(" + cashflow + ")");
	}
	*/

	public int getCashflow() {
		return cashflow;
	}
	
	public int getX() {
		return x;
	}
	
	void setX (int val) {
		x = val;
	}
	
	void repaintDrawPanel () {
		drawPanel.repaint();
	}
	
	public boolean getRunning() {
		return running;
	}
	
	void setRunning(boolean runin) {
		running = runin;
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
			store.buildGUI(level, stars);
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
			Invest invest = new Invest();
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
	        int confirm = JOptionPane.showOptionDialog(
		             null, "Are You Sure to Close Application?", 
		             "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
					System.exit(0);
					theFrame.dispose();
		        }
		    }
		}
}
