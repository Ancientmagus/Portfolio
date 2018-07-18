package game_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game_1.Game.CloseButtonListener;
import game_1.Game.MyDrawPanel;
import game_1.Game.SaveButtonListener;
import game_1.Game.StoreButtonListener;
import game_1.Game.TravelButtonListener;

public class Store {

	JFrame storeFrame;
	private JPanel buttonPanel;
	int lvl;
	int stars;

	public void buildGUI(int lvl, int stars) {

		//Store frame and background
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
		
		//images depending on stars and lvls
		if (lvl == 1){
			if (stars == 1){
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1.png")));
				itm1Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_p.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_3star.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			}else if (stars == 2) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2.png")));
				itm2Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_p.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			}else if (stars == 3) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3.png")));
				itm3Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3_p.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			}else if (stars == 4) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm4.png")));
				itm4Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm4_p.png")));
			}else if (stars == 5) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl1_itm4_s.png")));
			}else {
				System.out.println("Error str var in store!");
			}
		}else if (lvl == 2) {
			if (stars == 1){
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1.png")));
				itm1Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_p.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_3star.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			}else if (stars == 2) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2.png")));
				itm2Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_p.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_4star.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			}else if (stars == 3) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3.png")));
				itm3Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3_p.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_5star.png")));
			}else if (stars == 4) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm4.png")));
				itm4Btn.setPressedIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm4_p.png")));
			}else if (stars == 5) {
				itm1Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm1_s.png")));
				itm2Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm2_s.png")));
				itm3Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm3_s.png")));
				itm4Btn.setIcon(new ImageIcon(getClass().getResource("/images/strBtn_lvl2_itm4_s.png")));
			}else {
				System.out.println("Error str var in store!");
			}
		}else {
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
		storeFrame.getContentPane().add(background);
		storeFrame.setVisible(true);
		
	}
	
	public class Itm1BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			storeFrame.setVisible(false);
			storeFrame.dispose();
		}
	}
	
	public class Itm2BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			storeFrame.setVisible(false);
			storeFrame.dispose();
		}
	}
	
	public class Itm3BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			storeFrame.setVisible(false);
			storeFrame.dispose();
		}
	}
	
	public class Itm4BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			storeFrame.setVisible(false);
			storeFrame.dispose();
		}
	}
	
	public class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			System.exit(0);
			storeFrame.dispose();
		}
	}

}
