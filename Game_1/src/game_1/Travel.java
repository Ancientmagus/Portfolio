package game_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class Travel {
	static JFrame travelFrame;
	JPanel buttonPanel;
	JFrame buyFrame;
	Game game = new Game();
	int money = game.getMoney();
	int currentLvl = game.getCurrentLvl();
	static int price;
	static int changeCF;
	private String text;

	public void buildGUI() {

		// Store frame, background and buttons
		travelFrame = new JFrame("Game_1");
		travelFrame.getContentPane().setLayout(null);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("/images/GUI_Travel.png")));
		background.setBounds(0, 0, 630, 630);

		JButton lvl1Btn = new JButton();
		lvl1Btn.addActionListener(new Lvl1BtnListener());
		lvl1Btn.setBounds(37, 67, 525, 150);
		lvl1Btn.setContentAreaFilled(false);
		lvl1Btn.setBorderPainted(false);
		lvl1Btn.setIcon(new ImageIcon(getClass().getResource("/images/Lvl1_Btn.png")));

		JButton lvl2Btn = new JButton();
		lvl2Btn.addActionListener(new Lvl2BtnListener());
		lvl2Btn.setBounds(37, 255, 525, 150);
		lvl2Btn.setContentAreaFilled(false);
		lvl2Btn.setBorderPainted(false);

		// images depending on stars and lvls
		if (currentLvl == 1) {
			lvl2Btn.setIcon(new ImageIcon(getClass().getResource("/images/Lvl2_Btn_Buy.png")));
		} else if (currentLvl == 2) {
			lvl2Btn.setIcon(new ImageIcon(getClass().getResource("/images/Lvl2_Btn.png")));
		} else {
			System.out.println("Error lvl var in store!");
		}
		
		JButton backBtn = new JButton();
		backBtn.addActionListener(new BackButtonListener());
		backBtn.setBounds(145, 8, 51, 48);
		backBtn.setContentAreaFilled(false);
		backBtn.setBorderPainted(false);
		
		JButton closeBtn = new JButton();
		closeBtn.addActionListener(new CloseButtonListener());
		closeBtn.setBounds(569, 8, 55, 55);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);

		travelFrame.setResizable(false);
		travelFrame.setBounds(10, 10, 630, 630);
		travelFrame.setUndecorated(true);
		travelFrame.setLocationRelativeTo(null);
		travelFrame.setBackground(new Color(0, 0, 0, 0));

		travelFrame.getContentPane().add(lvl1Btn);
		travelFrame.getContentPane().add(lvl2Btn);
		travelFrame.getContentPane().add(backBtn);
		travelFrame.getContentPane().add(closeBtn);
		travelFrame.getContentPane().add(background);
		travelFrame.setVisible(true);
	}

	public class Lvl1BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			// unpause the animations thread
			Tick tick = new Tick();
			tick.resume();
			
			//rebuild game
			game.setLevel(1);
			game.buildGUI();
			travelFrame.setVisible(false);
			travelFrame.dispose();
		}
	}

	public class Lvl2BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {

			if (currentLvl == 2) {
				// unpause the animations thread
				Tick tick = new Tick();
				tick.resume();
				
				//rebuild game
				game.setLevel(2);
				game.buildGUI();
				travelFrame.setVisible(false);
				travelFrame.dispose();
			} else if (currentLvl == 1) {
				//price and change in cashflow
				price = 50000;
				changeCF = 50;
				
				//constructing buy frame
				Travel travel = new Travel();
				travel.BuyFrameBuilder("Beach Location");
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
			travelFrame.setVisible(false);
			travelFrame.dispose();
		}
	}
	
	public class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			//are you sure frame
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				System.exit(0);
				travelFrame.dispose();
			}
		}
	}
	
	public void BuyFrameBuilder(String title) {

		// Frame and buttons construction
		buyFrame = new JFrame(title);
		buyFrame.getContentPane().setLayout(new BorderLayout());

		WindowListener exitListener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				travelFrame.setVisible(true);
				buyFrame.setVisible(false);
				buyFrame.dispose();
			}
		};
		buyFrame.addWindowListener(exitListener);

		text = ("This new location costs $" + price + ", and increases your" + "<br>" + "CashFlow by $" + changeCF
				+ ", are you sure you want to buy?");
		JLabel buyText = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		buyText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		buyText.setHorizontalAlignment(SwingConstants.CENTER);
		buyText.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton yesButton = new JButton("BUY");
		yesButton.addActionListener(new YesBtnListener());
		yesButton.setPreferredSize(new Dimension(55, 55));
		yesButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

		JButton noButton = new JButton("Cancel");
		noButton.addActionListener(new NoBtnListener());
		noButton.setPreferredSize(new Dimension(55, 55));
		noButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 40, 0));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 5, 40));

		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		buyFrame.add(buyText, BorderLayout.CENTER);
		buyFrame.add(buttonPanel, BorderLayout.SOUTH);

		buyFrame.setBounds(10, 10, 550, 200);
		buyFrame.setLocationRelativeTo(null);
		buyFrame.setVisible(true);
		travelFrame.setVisible(false);
	}
	
	public class YesBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {

			// taking the money, updating cashflow if there's enough money
			if (money > price) {
				game.changeMoney(-price);
				game.changeCashflow(changeCF);
				game.setCurrentLvl(2);
				
				// closing warning frame
				buyFrame.setVisible(false);
				buyFrame.dispose();

				// Build the game window again
				game.setLevel(2);
				game.buildGUI();

				// unpause the animations thread
				Tick tick = new Tick();
				tick.resume();

				// destroy shop frame
				travelFrame.dispose();
			} else {
				// not enough money window
				JFrame opFrame = new JFrame();
				JOptionPane.showMessageDialog(opFrame, "NOT ENOUGH MONEY!");

				// construct store frame
				travelFrame.setVisible(true);
				buyFrame.setVisible(false);
				buyFrame.dispose();
			}
		}
	}

	public class NoBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			// closing warning frame
			travelFrame.setVisible(true);
			buyFrame.setVisible(false);
			buyFrame.dispose();
		}
	}
}
