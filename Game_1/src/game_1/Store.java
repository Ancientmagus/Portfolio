package game_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Store {

	static JFrame storeFrame;
	JFrame buyFrame;
	static int level;
	static int str;
	static int price;
	static int changeCF;
	static int changeStr;
	private String text;
	Game game = new Game();
	int money = game.getMoney();
	int cashflow = game.getCashflow();

	public void buildGUI(int lvl, int stars) {

		// setting lvl and stars to use in actionlisteners
		level = lvl;
		str = stars;

		// Store frame, background and buttons
		storeFrame = new JFrame("Game_1");
		storeFrame.getContentPane().setLayout(null);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("/images/GUI_store.png")));
		background.setBounds(0, 0, 630, 630);

		JButton itm1Btn = new JButton();
		itm1Btn.addActionListener(new Itm1BtnListener());
		itm1Btn.setBounds(25, 48, 277, 277);
		itm1Btn.setContentAreaFilled(false);
		itm1Btn.setBorderPainted(false);

		JButton itm2Btn = new JButton();
		itm2Btn.addActionListener(new Itm2BtnListener());
		itm2Btn.setBounds(308, 48, 277, 277);
		itm2Btn.setContentAreaFilled(false);
		itm2Btn.setBorderPainted(false);

		JButton itm3Btn = new JButton();
		itm3Btn.addActionListener(new Itm3BtnListener());
		itm3Btn.setBounds(25, 329, 277, 277);
		itm3Btn.setContentAreaFilled(false);
		itm3Btn.setBorderPainted(false);

		JButton itm4Btn = new JButton();
		itm4Btn.addActionListener(new Itm4BtnListener());
		itm4Btn.setBounds(308, 329, 277, 277);
		itm4Btn.setContentAreaFilled(false);
		itm4Btn.setBorderPainted(false);

		JButton closeBtn = new JButton();
		closeBtn.addActionListener(new CloseButtonListener());
		closeBtn.setBounds(569, 5, 55, 55);
		closeBtn.setOpaque(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);

		JButton backBtn = new JButton();
		backBtn.addActionListener(new BackButtonListener());
		backBtn.setBounds(161, 0, 51, 48);
		backBtn.setOpaque(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setBorderPainted(false);

		// images depending on stars and lvls
		if (lvl == 1) {
			if (stars == 1) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1.png")));
				itm1Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_p.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_3star.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			} else if (stars == 2) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2.png")));
				itm2Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_p.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			} else if (stars == 3) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3.png")));
				itm3Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3_p.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			} else if (stars == 4) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm4.png")));
				itm4Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm4_p.png")));
			} else if (stars == 5) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm4_s.png")));
			} else {
				System.out.println("Error str var in store!");
			}
		} else if (lvl == 2) {
			if (stars == 1) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1.png")));
				itm1Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_p.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_3star.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			} else if (stars == 2) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2.png")));
				itm2Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_p.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			} else if (stars == 3) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3.png")));
				itm3Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3_p.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			} else if (stars == 4) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm4.png")));
				itm4Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm4_p.png")));
			} else if (stars == 5) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm4_s.png")));
			} else {
				System.out.println("Error str var in store!");
			}
		} else {
			System.out.println("Error lvl var in store!");
		}

		storeFrame.setResizable(false);
		storeFrame.setBounds(10, 10, 630, 630);
		storeFrame.setUndecorated(true);
		storeFrame.setLocationRelativeTo(null);
		storeFrame.setBackground(new Color(0, 0, 0, 0));

		storeFrame.getContentPane().add(itm1Btn);
		storeFrame.getContentPane().add(itm2Btn);
		storeFrame.getContentPane().add(itm3Btn);
		storeFrame.getContentPane().add(itm4Btn);
		storeFrame.getContentPane().add(closeBtn);
		storeFrame.getContentPane().add(backBtn);
		storeFrame.getContentPane().add(background);
		storeFrame.setVisible(true);

	}

	public class Itm1BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (str == 1) {
				if (level == 1) {
					// Setting Price
					price = 1000;
					changeCF = 10;
				} else if (level == 2) {
					//Setting Price
					price = 100000;
					changeCF = 100;
				}
				// setting stars
				changeStr = 2;

				// slow down to show animation
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Warning frame construction
				Store store = new Store();
				store.BuyFrameBuilder("2 Stars Upgrade");
			}
		}
	}

	public class Itm2BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (str == 2) {
				if (level == 1) {
					// Setting Price
					price = 5000;
					changeCF = 15;
				} else if (level == 2) {
					//Setting Price
					price = 300000;
					changeCF = 200;
				}
				
				// setting stars
				changeStr = 3;

				// slow down to show animation
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Warning frame construction
				Store store = new Store();
				store.BuyFrameBuilder("3 Stars Upgrade");
			}
		}
	}

	public class Itm3BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (str == 3) {
				if (level == 1) {
					// Setting Price
					price = 20000;
					changeCF = 20;
				} else if (level == 2) {
					//Setting Price
					price = 500000;
					changeCF = 200;
				}
				// setting stars
				changeStr = 4;

				// slow down to show animation
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Warning frame construction
				Store store = new Store();
				store.BuyFrameBuilder("4 Stars Upgrade");
			}
		}
	}

	public class Itm4BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (str == 4) {
				if (level == 1) {
					// Setting Price
					price = 100000;
					changeCF = 100;
				} else if (level == 2) {
					price = 1000000;
					changeCF = 1000;
				}
				// setting stars
				changeStr = 5;

				// slow down to show animation
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Warning frame construction
				Store store = new Store();
				store.BuyFrameBuilder("5 Stars Upgrade");
			}
		}
	}

	public class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				System.exit(0);
				storeFrame.dispose();
			}
		}
	}

	public class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			// Build the game window again
			game.buildGUI();

			// unpause the animations thread
			Tick tick = new Tick();
			tick.resume();

			// destroy shop frame
			storeFrame.setVisible(false);
			storeFrame.dispose();
		}
	}
	
	public void BuyFrameBuilder(String title) {

		// Frame and buttons construction
		buyFrame = new JFrame(title);
		buyFrame.getContentPane().setLayout(new BorderLayout());

		WindowListener exitListener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				storeFrame.setVisible(true);
				buyFrame.setVisible(false);
				buyFrame.dispose();
			}
		};
		buyFrame.addWindowListener(exitListener);

		text = ("This upgrade costs $" + price + ", and increases your" + "<br>" + "CashFlow by $" + changeCF
				+ ", are you sure you want to buy?");
		JLabel buyText = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		buyText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		buyText.setHorizontalAlignment(SwingConstants.CENTER);
		buyText.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton yesButton = new JButton("BUY");
		yesButton.addActionListener(new YesBtnListener());

		JButton noButton = new JButton("Cancel");
		noButton.addActionListener(new NoBtnListener());
		noButton.hasFocus();

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		buyFrame.add(buyText, BorderLayout.CENTER);
		buyFrame.add(buttonPanel, BorderLayout.SOUTH);

		buyFrame.setBounds(10, 10, 550, 150);
		buyFrame.setLocationRelativeTo(null);
		buyFrame.setVisible(true);
		storeFrame.setVisible(false);
	}
	
	public class YesBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {

			// taking the money, updating cashflow if there's enough money
			if (money > price) {
				game.changeMoney(-price);
				game.changeCashflow(changeCF);
				if (level == 1) {
					game.setStars(changeStr);
				} else if (level == 2) {
					game.setStarsLvl2(changeStr);
				}

				// closing warning frame
				buyFrame.setVisible(false);
				buyFrame.dispose();

				// Build the game window again
				game.buildGUI();

				// unpause the animations thread
				Tick tick = new Tick();
				tick.resume();

				// destroy shop frame
				storeFrame.dispose();
			} else {
				// not enough money window
				JFrame opFrame = new JFrame();
				JOptionPane.showMessageDialog(opFrame, "NOT ENOUGH MONEY!");

				// construct store frame
				storeFrame.setVisible(true);
				buyFrame.setVisible(false);
				buyFrame.dispose();
			}
		}
	}

	public class NoBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			// closing warning frame
			storeFrame.setVisible(true);
			buyFrame.setVisible(false);
			buyFrame.dispose();
		}
	}
}
