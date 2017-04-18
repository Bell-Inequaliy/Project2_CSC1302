package edu.gsu.csc1302.prj2.somethingrandom.swing.dialogs;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This program handles the popups for the player.
 * @author stgilbert & Joshua
 *
 */
public class GenericMessagePopup {

	/**
	 * This is a J frame.
	 */
	private JFrame frame;
	/**
	 * PlayerNum to keep track of player number.
	 */

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
		String title = args[0];
		String message = args[1];

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenericMessagePopup window = new
							GenericMessagePopup(title, message);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while (GenericMessagePopup.block) {
			Runtime.getRuntime().freeMemory();
		}
	}

	/**
	 * Create the application.
	 * @param title String
	 * @param message String
	 */
	public GenericMessagePopup(final String title,
			final String message) {
		initialize(title, message);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param title String
	 * @param message String
	 */
	private void initialize(final String title,
			final String message) {
		frame = new JFrame(title);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMessage = new JLabel(message);
		lblMessage.setBounds(31, 11, 376, 128);
		frame.getContentPane().add(lblMessage);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				block = false;
				frame.dispose();
			}
		});
		btnOK.setBounds(171, 194, 86, 23);
		frame.getContentPane().add(btnOK);
	}
}
