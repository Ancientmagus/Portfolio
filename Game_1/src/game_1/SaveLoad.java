package game_1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Invest {
	JFrame investFrame;
	private JPanel buttonPanel;

	public void buildGUI() {

		// frame and Panel
		investFrame = new JFrame("INVEST");
		buttonPanel = new JPanel(new GridLayout(0, 3, 10, 10));

		// buttons
		JButton Item1 = new JButton("Item 1");
		Item1.addActionListener(new Itm1BtnListener());
		buttonPanel.add(Item1);
		Item1.setFont(new Font("Arial", Font.PLAIN, 10));

		JButton Item2 = new JButton("Item 2");
		Item2.addActionListener(new Itm2BtnListener());
		buttonPanel.add(Item2);
		Item2.setFont(new Font("Arial", Font.PLAIN, 10));

		JButton Item3 = new JButton("Item 3");
		Item3.addActionListener(new Itm3BtnListener());
		buttonPanel.add(Item3);
		Item3.setFont(new Font("Arial", Font.PLAIN, 10));
		
		JButton Item4 = new JButton("Item 4");
		Item4.addActionListener(new Itm4BtnListener());
		buttonPanel.add(Item4);
		Item4.setFont(new Font("Arial", Font.PLAIN, 10));

		// closing method
		investFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Size and setting to visible
		investFrame.getContentPane().add(buttonPanel);
		investFrame.setBounds(50, 50, 600, 600);
		investFrame.setResizable(false);
		investFrame.setLocationRelativeTo(null);
		investFrame.setVisible(true);

	}
	
	public class Itm1BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			investFrame.setVisible(false);
			investFrame.dispose();
		}
	}
	
	public class Itm2BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			investFrame.setVisible(false);
			investFrame.dispose();
		}
	}
	
	public class Itm3BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			investFrame.setVisible(false);
			investFrame.dispose();
		}
	}
	
	public class Itm4BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Game game = new Game();
			game.buildGUI();
			investFrame.setVisible(false);
			investFrame.dispose();
		}
	}

}
