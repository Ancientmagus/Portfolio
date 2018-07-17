package game_1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Store {

	JFrame storeFrame;
	private JPanel buttonPanel;

	public void buildGUI() {

		// frame and Panel
		storeFrame = new JFrame("SHOP");
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
		storeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Size and setting to visible
		storeFrame.getContentPane().add(buttonPanel);
		storeFrame.setBounds(50, 50, 600, 600);
		storeFrame.setResizable(false);
		storeFrame.setLocationRelativeTo(null);
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

}
