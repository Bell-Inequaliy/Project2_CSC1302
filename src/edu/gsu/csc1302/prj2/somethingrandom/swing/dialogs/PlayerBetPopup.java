package edu.gsu.csc1302.prj2.somethingrandom.swing.dialogs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerUser;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This program handles the popups for the player.
 * @author stgilbert & Joshua
 *
 */
public class PlayerBetPopup {

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
					PlayerBetPopup window = new
							PlayerBetPopup(titleAndQuestion, defaultText);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while (PlayerBetPopup.block) {
			Runtime.getRuntime().freeMemory();
		}
	}

	/**
	 * Create the application.
	 * @param titleAndQuestion String
	 * @param defaultText String
	 */
	public PlayerBetPopup(final String titleAndQuestion,
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
				System.out.println(switcheroo);
				SpadesPlayerUser.setPlayerBet(switcheroo);
				block = false;
				frame.dispose();
			}
		});
		btnSubmit.setBounds(169, 150, 86, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
