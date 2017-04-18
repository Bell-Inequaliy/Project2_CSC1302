package edu.gsu.csc1302.prj2.somethingrandom.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import edu.gsu.csc1302.prj2.somethingrandom.SpadesGame;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerAggressive;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerBase;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerChicken;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerIntelligent;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerUser;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerWildcard;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerTypePopup {

	private JFrame frame;
	private JTextField txtBox;
	private static int playerNum;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {

		String titleAndQuestion = args[0];
		String defaultText = args[1];
		playerNum = Integer.parseInt(args[2]);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerTypePopup window = new PlayerTypePopup(titleAndQuestion, defaultText);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerTypePopup(final String titleAndQuestion, final String defaultText) {
		initialize(titleAndQuestion, defaultText);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String titleAndQuestion,
			final String defaultText) {
		frame = new JFrame(titleAndQuestion);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblQuestion = new JLabel(titleAndQuestion);
		lblQuestion.setBounds(169, 11, 86, 14);
		frame.getContentPane().add(lblQuestion);

		txtBox = new JTextField();
		txtBox.setText(defaultText);
		txtBox.setBounds(169, 108, 86, 20);
		frame.getContentPane().add(txtBox);
		txtBox.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int switcheroo = Integer.parseInt(txtBox.getText());
				SpadesPlayerBase newlyMadePlayer = null;
				switch (switcheroo) {
				case 0: newlyMadePlayer = new SpadesPlayerAggressive();
				break;
				case 1: newlyMadePlayer = new SpadesPlayerChicken();
				break;
				case 2: newlyMadePlayer = new SpadesPlayerWildcard();
				break;
				case 3: newlyMadePlayer = new SpadesPlayerIntelligent();
				break;
				case 4: newlyMadePlayer = new SpadesPlayerUser();
				default:
				}

				SpadesGame.setPlayerByNumber(playerNum, newlyMadePlayer);
			}
		});
		btnSubmit.setBounds(169, 150, 86, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
