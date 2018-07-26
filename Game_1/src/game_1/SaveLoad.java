package game_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SaveLoad {
	JFrame saveFrame;
	Game game = new Game();

	public void buildGUI() {

		// Store frame, background and buttons
		saveFrame = new JFrame("Save/Load");
		saveFrame.getContentPane().setLayout(null);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(getClass().getResource("/images/GUI_SaveLoad.png")));
		background.setBounds(0, 0, 630, 630);

		JButton saveBtn = new JButton();
		saveBtn.addActionListener(new SaveBtnListener());
		saveBtn.setBounds(39, 147, 525, 150);
		saveBtn.setContentAreaFilled(false);
		saveBtn.setBorderPainted(false);

		JButton loadBtn = new JButton();
		loadBtn.addActionListener(new LoadBtnListener());
		loadBtn.setBounds(39, 365, 525, 150);
		loadBtn.setContentAreaFilled(false);
		loadBtn.setBorderPainted(false);

		JButton backBtn = new JButton();
		backBtn.addActionListener(new BackButtonListener());
		backBtn.setBounds(112, 9, 51, 48);
		backBtn.setContentAreaFilled(false);
		backBtn.setBorderPainted(false);

		JButton closeBtn = new JButton();
		closeBtn.addActionListener(new CloseButtonListener());
		closeBtn.setBounds(569, 8, 55, 55);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);

		saveFrame.setResizable(false);
		saveFrame.setBounds(10, 10, 630, 630);
		saveFrame.setUndecorated(true);
		saveFrame.setLocationRelativeTo(null);
		saveFrame.setBackground(new Color(0, 0, 0, 0));

		saveFrame.getContentPane().add(saveBtn);
		saveFrame.getContentPane().add(loadBtn);
		saveFrame.getContentPane().add(backBtn);
		saveFrame.getContentPane().add(closeBtn);
		saveFrame.getContentPane().add(background);
		saveFrame.setVisible(true);
	}

	public class SaveBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			//confirmation window
			int confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to save?", "Save Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				
				//storing variables
				int s1 = game.getLevel();
				int s2 = game.getStars();
				int s3 = game.getStarsLvl2();
				int s4 = game.getCurrentLvl();
				int s5 = game.getMoney();
				int s6 = game.getCashflow();
				try {
					FileOutputStream fileStream = new FileOutputStream("game_save.ser");
					ObjectOutputStream os = new ObjectOutputStream(fileStream);
					os.writeObject(s1);
					os.writeObject(s2);
					os.writeObject(s3);
					os.writeObject(s4);
					os.writeObject(s5);
					os.writeObject(s6);
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// save confirmation
				JFrame opFrame = new JFrame();
				JOptionPane.showMessageDialog(opFrame, "Game Saved!");
			}
		}
	}

	public class LoadBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			//confirmation window
			int confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to Load?", "Load Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				
				//reading file
				try {
					FileInputStream fileStream = new FileInputStream("game_save.ser");
					ObjectInputStream os = new ObjectInputStream(fileStream);
					int s1 = (int) os.readObject();
					int s2 = (int) os.readObject();
					int s3 = (int) os.readObject();
					int s4 = (int) os.readObject();
					int s5 = (int) os.readObject();
					int s6 = (int) os.readObject();
					game.setLevel(s1);
					game.setStars(s2);
					game.setStarsLvl2(s3);
					game.setCurrentLvl(s4);
					game.setMoney(s5);
					game.setCashFlow(s6);
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// load confirmation
				JFrame opFrame = new JFrame();
				JOptionPane.showMessageDialog(opFrame, "Game Loaded!");
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
			saveFrame.setVisible(false);
			saveFrame.dispose();
		}
	}

	public class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				System.exit(0);
				saveFrame.dispose();
			}
		}
	}
}
