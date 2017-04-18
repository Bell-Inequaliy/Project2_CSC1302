package edu.gsu.csc1302.prj2.somethingrandom.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
	private JFrame frmSpades;
	/**
	 * The table of things for the stuff and whatnot.
	 */
	private JTable table;
	/**
	 * background image.
	 */
	private final JLabel background = new JLabel("background");

	/**
	 * Launch the application.
	 * @param args The arguments for the watchamacallit.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmSpades.setVisible(true);
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
		frmSpades = new JFrame();
		frmSpades.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/edu/gsu/csc1302/prj2/somethingrandom/swing/graphics/Spade_Ace.png")));
		frmSpades.setTitle("Spades");
		frmSpades.getContentPane().setBackground(new Color(34, 139, 34));
		frmSpades.getContentPane().setLayout(null);

		Panel backPanel = new BackgroundPanel();
		FlowLayout flowLayout = (FlowLayout) backPanel.getLayout();
		flowLayout.setHgap(0);
		frmSpades.getContentPane().add(backPanel);

		Panel panel1 = new Panel();
		panel1.setPreferredSize(new Dimension(64, 80));
		panel1.setMinimumSize(new Dimension(64, 80));
		panel1.setMaximumSize(new Dimension(64, 80));
		panel1.setBounds(416, 17, 64, 80);
		frmSpades.getContentPane().add(panel1);
		panel1.setLayout(null);

		JButton tableCard1 = new JButton("Table Card 1");
		tableCard1.setBounds(-14, 0, 93, 23);
		panel1.add(tableCard1);

		Panel panel2 = new Panel();
		FlowLayout flpanel2 = (FlowLayout) panel2.getLayout();
		flpanel2.setVgap(0);
		flpanel2.setHgap(0);
		panel2.setPreferredSize(new Dimension(64, 80));
		panel2.setMinimumSize(new Dimension(64, 80));
		panel2.setMaximumSize(new Dimension(64, 80));
		panel2.setBounds(496, 17, 64, 80);
		frmSpades.getContentPane().add(panel2);

		JButton tableCard2 = new JButton("Table Card 2");
		panel2.add(tableCard2);

		Panel panel3 = new Panel();
		FlowLayout flpanel3 = (FlowLayout) panel3.getLayout();
		flpanel3.setVgap(0);
		flpanel3.setHgap(0);
		panel3.setPreferredSize(new Dimension(64, 80));
		panel3.setMinimumSize(new Dimension(64, 80));
		panel3.setMaximumSize(new Dimension(64, 80));
		panel3.setBounds(448, 104, 64, 80);
		frmSpades.getContentPane().add(panel3);

		JButton tableCard3 = new JButton("Table Card 3");
		panel3.add(tableCard3);

		Panel panel4 = new Panel();
		FlowLayout flpanel4 = (FlowLayout) panel4.getLayout();
		flpanel4.setVgap(0);
		flpanel4.setHgap(0);
		panel4.setPreferredSize(new Dimension(64, 80));
		panel4.setMinimumSize(new Dimension(64, 80));
		panel4.setMaximumSize(new Dimension(64, 80));
		panel4.setBounds(528, 104, 64, 80);
		frmSpades.getContentPane().add(panel4);

		JButton tableCard4 = new JButton("Table Card 4");
		panel4.add(tableCard4);

		Panel panel5 = new Panel();
		FlowLayout flowLayout1 = (FlowLayout) panel5.getLayout();
		flowLayout1.setHgap(0);
		flowLayout1.setVgap(0);
		panel5.setPreferredSize(new Dimension(64, 80));
		panel5.setMinimumSize(new Dimension(64, 80));
		panel5.setMaximumSize(new Dimension(64, 80));
		panel5.setBounds(128, 200, 64, 80);
		frmSpades.getContentPane().add(panel5);

		JButton handcard1 = new JButton("HandCard1");
		panel5.add(handcard1);

		Panel panel6 = new Panel();
		FlowLayout flpanel6 = (FlowLayout) panel6.getLayout();
		flpanel6.setVgap(0);
		flpanel6.setHgap(0);
		panel6.setPreferredSize(new Dimension(64, 80));
		panel6.setMinimumSize(new Dimension(64, 80));
		panel6.setMaximumSize(new Dimension(64, 80));
		panel6.setBounds(192, 200, 64, 80);
		frmSpades.getContentPane().add(panel6);


		JButton handcard2 = new JButton("HandCard2");
		panel6.add(handcard2);

		Panel panel7 = new Panel();
		FlowLayout flpanel7 = (FlowLayout) panel7.getLayout();
		flpanel7.setHgap(0);
		flpanel7.setVgap(0);
		panel7.setPreferredSize(new Dimension(64, 80));
		panel7.setMinimumSize(new Dimension(64, 80));
		panel7.setMaximumSize(new Dimension(64, 80));
		panel7.setBounds(256, 200, 64, 80);
		frmSpades.getContentPane().add(panel7);

		JButton handcard3 = new JButton("HandCard3");
		panel7.add(handcard3);

		Panel panel8 = new Panel();
		FlowLayout flpanel8 = (FlowLayout) panel8.getLayout();
		flpanel8.setVgap(0);
		flpanel8.setHgap(0);
		panel8.setPreferredSize(new Dimension(64, 80));
		panel8.setMinimumSize(new Dimension(64, 80));
		panel8.setMaximumSize(new Dimension(64, 80));
		panel8.setBounds(320, 200, 64, 80);
		frmSpades.getContentPane().add(panel8);

		JButton handcard4 = new JButton("HandCard4");
		panel8.add(handcard4);
		initialize1();
	}
/**
 * Extends the initialize method.
 */
	private void initialize1() {
		Panel panel9 = new Panel();
		FlowLayout flowLayout2 = (FlowLayout) panel9.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setAlignment(FlowLayout.LEADING);
		flowLayout2.setVgap(0);
		panel9.setPreferredSize(new Dimension(64, 80));
		panel9.setMinimumSize(new Dimension(64, 80));
		panel9.setMaximumSize(new Dimension(64, 80));
		panel9.setBounds(384, 200, 64, 80);
		frmSpades.getContentPane().add(panel9);
		JButton handcard5 = new JButton("HandCard5");
		panel9.add(handcard5);
		Panel panel10 = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel10.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel10.setPreferredSize(new Dimension(64, 80));
		panel10.setMinimumSize(new Dimension(64, 80));
		panel10.setMaximumSize(new Dimension(64, 80));
		panel10.setBounds(448, 200, 64, 80);
		frmSpades.getContentPane().add(panel10);
		JButton handcard6 = new JButton("HandCard6");
		panel10.add(handcard6);
		Panel panel11 = new Panel();
		FlowLayout flpanel11 = (FlowLayout) panel11.getLayout();
		flpanel11.setHgap(0);
		flpanel11.setVgap(0);
		panel11.setPreferredSize(new Dimension(64, 80));
		panel11.setMinimumSize(new Dimension(64, 80));
		panel11.setMaximumSize(new Dimension(64, 80));
		panel11.setBounds(96, 280, 64, 80);
		frmSpades.getContentPane().add(panel11);
		JButton handcard7 = new JButton("HandCard7");
		panel11.add(handcard7);

		Panel panel12 = new Panel();
		FlowLayout flowLayout3 = (FlowLayout) panel12.getLayout();
		flowLayout3.setVgap(0);
		flowLayout3.setHgap(0);
		panel12.setPreferredSize(new Dimension(64, 80));
		panel12.setMinimumSize(new Dimension(64, 80));
		panel12.setMaximumSize(new Dimension(64, 80));
		panel12.setBounds(160, 280, 64, 80);
		frmSpades.getContentPane().add(panel12);
		JButton handcard8 = new JButton("HandCard8");
		panel12.add(handcard8);

		Panel panel13 = new Panel();
		FlowLayout flowLayout4 = (FlowLayout) panel13.getLayout();
		flowLayout4.setHgap(0);
		flowLayout4.setVgap(0);
		panel13.setPreferredSize(new Dimension(64, 80));
		panel13.setMinimumSize(new Dimension(64, 80));
		panel13.setMaximumSize(new Dimension(64, 80));
		panel13.setBounds(224, 280, 64, 80);
		frmSpades.getContentPane().add(panel13);

		JButton handcard9 = new JButton("HandCard9");
		panel13.add(handcard9);

		Panel panel14 = new Panel();
		FlowLayout flowLayout5 = (FlowLayout) panel14.getLayout();
		flowLayout5.setVgap(0);
		flowLayout5.setHgap(0);
		panel14.setPreferredSize(new Dimension(64, 80));
		panel14.setMinimumSize(new Dimension(64, 80));
		panel14.setMaximumSize(new Dimension(64, 80));
		panel14.setBounds(288, 280, 64, 80);
		frmSpades.getContentPane().add(panel14);

		JButton handcard10 = new JButton("HandCard10");
		panel14.add(handcard10);

		Panel panel15 = new Panel();
		FlowLayout flowLayout6 = (FlowLayout) panel15.getLayout();
		flowLayout6.setVgap(0);
		flowLayout6.setHgap(0);
		panel15.setPreferredSize(new Dimension(64, 80));
		panel15.setMinimumSize(new Dimension(64, 80));
		panel15.setMaximumSize(new Dimension(64, 80));
		panel15.setBounds(352, 280, 64, 80);
		frmSpades.getContentPane().add(panel15);

		JButton handcard11 = new JButton("HandCard11");
		panel15.add(handcard11);

		Panel panel16 = new Panel();
		FlowLayout flowLayout7 = (FlowLayout) panel16.getLayout();
		flowLayout7.setVgap(0);
		flowLayout7.setHgap(0);
		panel16.setPreferredSize(new Dimension(64, 80));
		panel16.setMinimumSize(new Dimension(64, 80));
		panel16.setMaximumSize(new Dimension(64, 80));
		panel16.setBounds(416, 280, 64, 80);
		frmSpades.getContentPane().add(panel16);

		JButton handcard12 = new JButton("HandCard12");
		panel16.add(handcard12);

		Panel panel17 = new Panel();
		FlowLayout flowLayout8 = (FlowLayout) panel17.getLayout();
		flowLayout8.setVgap(0);
		flowLayout8.setHgap(0);
		panel17.setPreferredSize(new Dimension(64, 80));
		panel17.setMinimumSize(new Dimension(64, 80));
		panel17.setMaximumSize(new Dimension(64, 80));
		panel17.setBounds(480, 280, 64, 80);
		frmSpades.getContentPane().add(panel17);

		JButton handcard13 = new JButton("HandCard13");
		panel17.add(handcard13);

		Panel panel = new Panel();
		panel.setBounds(224, 80, 176, 80);
		frmSpades.getContentPane().add(panel);
				panel.setLayout(null);

				JButton btnTalk = new JButton("");
				btnTalk.setBounds(-16, -4, 209, 89);
				panel.add(btnTalk);
				btnTalk.setContentAreaFilled(false);
				btnTalk.setVerticalAlignment(SwingConstants.TOP);
				btnTalk.setIcon(new ImageIcon(GUI.class.getResource(
						"/edu/gsu/csc1302/prj2/somethingrandom/swing/graphics/"
						+ "TalkButton.png")));
				btnTalk.setSelectedIcon(new ImageIcon(GUI.class.getResource(
						"/edu/gsu/csc1302/prj2/somethingrandom/swing/graphics/"
						+ "TalkButton.png")));

		table = new JTable();
		table.setBorder(null);
		table.setRowHeight(32);
		table.setBackground(SystemColor.desktop);
		table.setForeground(SystemColor.text);
		table.setGridColor(SystemColor.text);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, "Bid", "Score"},
					{"Team 1", null, null},
					{"Team 2", null, null},
				},
				new String[] {
						"New column", "New column", "New column"
				}
				));
		table.setBounds(33, 41, 176, 96);
		frmSpades.getContentPane().add(table);
		background.setIcon(new ImageIcon(GUI.class.getResource("/edu/gsu/csc1302/prj2/somethingrandom/swing/graphics/Layout.png")));
		background.setBounds(0, 0, 654, 385);
		frmSpades.getContentPane().add(background);
		frmSpades.setBounds(100, 100, 672, 432);
		frmSpades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
