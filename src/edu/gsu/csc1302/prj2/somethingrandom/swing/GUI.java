package edu.gsu.csc1302.prj2.somethingrandom.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * This is the GUI.
 * It is not very gooey.
 * Hopefully.
 * @author jakep
 * I did not make the class, just the comments and some changes.
 */
public class GUI {

	/**
	 * This is a JFrame. Obviously.
	 */
	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args The arguments for the watchamacallit.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
