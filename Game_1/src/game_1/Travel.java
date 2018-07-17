package game_1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Travel {
	JFrame travelFrame;
	JPanel buttonPanel;
	
	public void buildGUI() {
		
		//frame and Panel
		travelFrame = new JFrame("TRAVEL");
		buttonPanel = new JPanel(new GridLayout(1,3,10,10));
		
		//buttons
		JButton level1Btn = new JButton("Poor Beach");
		level1Btn.addActionListener(new Level1BtnListener());
		buttonPanel.add(level1Btn);
		level1Btn.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JButton level2Btn = new JButton("City Center");
		level2Btn.addActionListener(new Level2BtnListener());
		buttonPanel.add(level2Btn);
		level2Btn.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JButton level3Btn = new JButton("Coming soon");
		level3Btn.addActionListener(new Level3BtnListener());
		buttonPanel.add(level3Btn);
		level3Btn.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//closing method
		travelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Size and setting to visible
		travelFrame.getContentPane().add(buttonPanel);
		travelFrame.setBounds(50,50,600,600);
		travelFrame.setResizable(false);
		travelFrame.setLocationRelativeTo(null);
		travelFrame.setVisible(true);
		
	}
	
	public class Level1BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.setLevel(1);
			game.buildGUI();
			travelFrame.setVisible(false);
			travelFrame.dispose();
		}
	}
	
	public class Level2BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.setLevel(2);
			game.buildGUI();
			travelFrame.setVisible(false);
			travelFrame.dispose();
		}
	}
	
	public class Level3BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
		}
	}

}
