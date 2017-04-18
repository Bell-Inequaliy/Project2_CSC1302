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


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This program handles the popups for the player.
 * @author stgilbert & Joshua
 *
 */
public class PlayerTypePopup {

	/**
	 * This is a J frame.
	 */
	private JFrame frame;
	/**
	 * Jtextfield that will be used for a text box.
	 */
	private JTextField txtBox;
	/**
	 * PlayerNum to keep track of player number.
	 */
	private static int playerNum;

	/**
	 * If we should block progress. Used to wait for button presses.
	 */
	private static boolean block = true;

	/**
	 * Launch the application.
	 * @param args unused.
	 */
	public static void main(final String[] args) {
		block = true;
		String titleAndQuestion = args[0];
		String defaultText = args[1];
		playerNum = Integer.parseInt(args[2]);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerTypePopup window = new
							PlayerTypePopup(titleAndQuestion, defaultText);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while (PlayerTypePopup.block) {
			Runtime.getRuntime().freeMemory();
		}
	}

	/**
	 * Create the application.
	 * @param titleAndQuestion String
	 * @param defaultText String
	 */
	public PlayerTypePopup(final String titleAndQuestion,
			final String defaultText) {
		initialize(titleAndQuestion, defaultText);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param titleAndQuestion String
	 * @param defaultText String
	 */
	private void initialize(final String titleAndQuestion,
			final String defaultText) {
		frame = new JFrame(titleAndQuestion);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblQuestion = new JLabel(titleAndQuestion);
		lblQuestion.setBounds(31, 11, 403, 58);
		frame.getContentPane().add(lblQuestion);

		txtBox = new JTextField();
		txtBox.setText(defaultText);
		txtBox.setBounds(169, 108, 86, 20);
		frame.getContentPane().add(txtBox);
		txtBox.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				int switcheroo = Integer.parseInt(txtBox.getText());
				SpadesPlayerBase newlyMadePlayer = null;
				switch (switcheroo) {
				case 0:
					newlyMadePlayer = new SpadesPlayerAggressive();
					break;
				case 1:
					newlyMadePlayer = new SpadesPlayerChicken();
					break;
				case 2:
					newlyMadePlayer = new SpadesPlayerWildcard();
					break;
				case 3:
					newlyMadePlayer = new SpadesPlayerIntelligent();
					break;
				case 4:
					newlyMadePlayer = new SpadesPlayerUser();
					break;
				default:
					break;
				}

				System.out.println(newlyMadePlayer);
				SpadesGame.setPlayerByNumber(playerNum, newlyMadePlayer);
				block = false;
				frame.dispose();
			}
		});
		btnSubmit.setBounds(169, 150, 86, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
