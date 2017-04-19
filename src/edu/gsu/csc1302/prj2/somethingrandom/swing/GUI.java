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

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesGame;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerUser;
import edu.gsu.csc1302.prj2.somethingrandom.swing.dialogs.GenericMessagePopup;

import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * first card in hand.
	 */
	JButton handcard1 = new JButton("HandCard1");
	/**
	 * second card in hand.
	 */
	JButton handcard2 = new JButton("HandCard2");
	/**
	 * third card in hand.
	 */
	JButton handcard3 = new JButton("HandCard3");
	/**
	 * fourth card in hand.
	 */
	JButton handcard4 = new JButton("HandCard4");
	/**
	 * fifth card in hand.
	 */
	JButton handcard5 = new JButton("HandCard5");
	/**
	 * sixth card in hand.
	 */
	JButton handcard6 = new JButton("HandCard6");
	/**
	 * seventh card in hand.
	 */
	JButton handcard7 = new JButton("HandCard7");
	/**
	 * eighth card in hand.
	 */
	JButton handcard8 = new JButton("HandCard8");
	/**
	 * ninth card in hand.
	 */
	JButton handcard9 = new JButton("HandCard9");
	/**
	 * tenth card in hand.
	 */
	JButton handcard10 = new JButton("HandCard10");
	/**
	 * eleventh card in hand.
	 */
	JButton handcard11 = new JButton("HandCard11");
	/**
	 * Twelfth card in hand.
	 */
	JButton handcard12 = new JButton("HandCard12");
	/**
	 * Thirteenth card in hand.
	 */
	JButton handcard13 = new JButton("HandCard13");
	/**
	 * First card on table.
	 */
	JButton tableCard1 = new JButton("Table Card 1");
	/**
	 * Second card on table.
	 */
	JButton tableCard2 = new JButton("Table Card 2");
	/**
	 * Third card on table.
	 */
	JButton tableCard3 = new JButton("Table Card 3");
	/**
	 * Fourth card on table.
	 */
	JButton tableCard4 = new JButton("Table Card 4");

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpades = new JFrame();
		frmSpades.setResizable(false);
		frmSpades.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.
				getResource(
				"/edu/gsu/csc1302/prj2/somethingrandom/swing/graphics/Spade_Ace.png")));
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

		handcard1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(1)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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
		handcard2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(2)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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
		handcard3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(3)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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


		handcard4.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(1)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard5.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(5)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard6.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(6)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard7.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(7)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard8.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(8)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard9.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(9)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
		panel13.add(handcard9);
		initialize3();
	}

	/**
	 * continues initialization even further.
	 */
	public void initialize3() {

		Panel panel14 = new Panel();
		FlowLayout flowLayout5 = (FlowLayout) panel14.getLayout();
		flowLayout5.setVgap(0);
		flowLayout5.setHgap(0);
		panel14.setPreferredSize(new Dimension(64, 80));
		panel14.setMinimumSize(new Dimension(64, 80));
		panel14.setMaximumSize(new Dimension(64, 80));
		panel14.setBounds(288, 280, 64, 80);
		frmSpades.getContentPane().add(panel14);

		handcard10.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(10)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard11.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(11)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		handcard12.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(12)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
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

		
		handcard13.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (SpadesPlayerUser.setPlayCard(13)) {
					SpadesPlayerUser.setBlock(false);
				} else {
					GenericMessagePopup.main(new String[]{
							"Notice", "You cannot play this card without reneging!"});
				}
			}
		});
		panel17.add(handcard13);

		Panel panel = new Panel();
		panel.setBounds(224, 80, 176, 80);
		frmSpades.getContentPane().add(panel);
				panel.setLayout(null);

				JButton btnTalk = new JButton("");
				btnTalk.setBounds(-16, -5, 209, 89);
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
		background.setIcon(new ImageIcon(GUI.class.getResource(
				"/edu/gsu/csc1302/prj2/somethingrandom/swing/graphics/Layout.png")));
		background.setBounds(0, 0, 654, 385);
		frmSpades.getContentPane().add(background);
		frmSpades.setBounds(100, 100, 643, 412);
		frmSpades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Fill out every button on the board with its appropriate image.
	 * @author stGilbert
	 */
	public void boardImageFiller() {
		if (SpadesGame.getTableCards().size() >= 4) {
			tableCard4.setIcon(new ImageIcon(setImage(
					SpadesGame.getTableCards().get(3))));
		} else {
			tableCard4.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesGame.getTableCards().size() >= 3) {
			tableCard3.setIcon(new ImageIcon(setImage(
					SpadesGame.getTableCards().get(2))));
		} else {
			tableCard3.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesGame.getTableCards().size() >= 2) {
			tableCard2.setIcon(new ImageIcon(setImage(
					SpadesGame.getTableCards().get(1))));
		} else {
			tableCard2.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesGame.getTableCards().size() >= 1) {
			tableCard1.setIcon(new ImageIcon(setImage(
					SpadesGame.getTableCards().get(0))));
		} else {
			tableCard1.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 13) {
			handcard13.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(12))));
		} else {
			handcard13.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 12) {
			handcard12.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(11))));
		} else {
			handcard12.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 11) {
			handcard11.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(10))));
		} else {
			handcard11.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 10) {
			handcard10.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(9))));
		} else {
			handcard10.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 9) {
			handcard9.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(8))));
		} else {
			handcard9.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 8) {
			handcard8.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(7))));
		} else {
			handcard8.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 7) {
			handcard7.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(6))));
		} else {
			handcard7.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 6) {
			handcard6.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(5))));
		} else {
			handcard6.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 5) {
			handcard5.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(4))));
		} else {
			handcard5.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 4) {
			handcard4.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(3))));
		} else {
			handcard4.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 3) {
			handcard3.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(2))));
		} else {
			handcard3.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 2) {
			handcard2.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(1))));
		} else {
			handcard2.setIcon(new ImageIcon(setImage(null)));
		} if (SpadesPlayerUser.getStaticHand().size() >= 1) {
			handcard1.setIcon(new ImageIcon(setImage(
					SpadesPlayerUser.getStaticHand().get(0))));
		} else {
			handcard1.setIcon(new ImageIcon(setImage(null)));
		}
	}

	/**
	 * return the image directory for the given card.
	 * @param card Card
	 * @return String
	 */
	public String setImage(final Card card) {
		if (card == null) {
			return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
					+ "graphics/CardFrame.png";
		}
		if (card.getSuit() == Suit.CLUB) {
			if (card.getRank() == Rank.TEN) {
			return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
					+ "graphics/Club_10.png";
			} if (card.getRank() == Rank.NINE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_9.png";
			} if (card.getRank() == Rank.EIGHT) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_8.png";
			} if (card.getRank() == Rank.SEVEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_7.png";
			} if (card.getRank() == Rank.SIX) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_6.png";
			} if (card.getRank() == Rank.FIVE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_5.png";
			} if (card.getRank() == Rank.FOUR) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_4.png";
			} if (card.getRank() == Rank.THREE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_3.png";
			} if (card.getRank() == Rank.TWO) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_TWO.png";
			} if (card.getRank() == Rank.ACE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_Ace.png";
			} if (card.getRank() == Rank.JACK) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_Jack.png";
			} if (card.getRank() == Rank.QUEEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_Queen.png";
			} if (card.getRank() == Rank.KING) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Club_King.png";
			}

		} if (card.getSuit() == Suit.DIAMOND) {
			return setDiamondImage(card);
		} if (card.getSuit() == Suit.HEART) {
			return setHeartImage(card);
		} if (card.getSuit() == Suit.SPADE) {
			return setSpadeImage(card);
		}
		return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
		+ "graphics/CardFrame.png";
	}
	/**
	 * return the image directory for the given card.
	 * @param card Card
	 * @return String
	 */
	public String setDiamondImage(final Card card) {
		if (card.getRank() == Rank.TEN) {
			return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
					+ "graphics/Diamond_10.png";
			} if (card.getRank() == Rank.NINE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_9.png";
			} if (card.getRank() == Rank.EIGHT) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_8.png";
			} if (card.getRank() == Rank.SEVEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_7.png";
			} if (card.getRank() == Rank.SIX) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_6.png";
			} if (card.getRank() == Rank.FIVE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_5.png";
			} if (card.getRank() == Rank.FOUR) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_4.png";
			} if (card.getRank() == Rank.THREE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_3.png";
			} if (card.getRank() == Rank.TWO) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_TWO.png";
			} if (card.getRank() == Rank.ACE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_Ace.png";
			} if (card.getRank() == Rank.JACK) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_Jack.png";
			} if (card.getRank() == Rank.QUEEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_Queen.png";
			} if (card.getRank() == Rank.KING) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Diamond_King.png";
			}
			return null;
	}
	/**
	 * return the image directory for the given card.
	 * @param card Card
	 * @return String
	 */
	public String setHeartImage(final Card card) {
		if (card.getRank() == Rank.TEN) {
			return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
					+ "graphics/Heart_10.png";
			} if (card.getRank() == Rank.NINE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_9.png";
			} if (card.getRank() == Rank.EIGHT) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_8.png";
			} if (card.getRank() == Rank.SEVEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_7.png";
			} if (card.getRank() == Rank.SIX) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_6.png";
			} if (card.getRank() == Rank.FIVE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_5.png";
			} if (card.getRank() == Rank.FOUR) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_4.png";
			} if (card.getRank() == Rank.THREE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_3.png";
			} if (card.getRank() == Rank.TWO) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_TWO.png";
			} if (card.getRank() == Rank.ACE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_Ace.png";
			} if (card.getRank() == Rank.JACK) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_Jack.png";
			} if (card.getRank() == Rank.QUEEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_Queen.png";
			} if (card.getRank() == Rank.KING) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Heart_King.png";
			}
			return null;
	}
	/**
	 * return the image directory for the given card.
	 * @param card Card
	 * @return String
	 */
	public String setSpadeImage(final Card card) {
		if (card.getRank() == Rank.TEN) {
			return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
					+ "graphics/Spade_10.png";
			} if (card.getRank() == Rank.NINE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_9.png";
			} if (card.getRank() == Rank.EIGHT) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_8.png";
			} if (card.getRank() == Rank.SEVEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_7.png";
			} if (card.getRank() == Rank.SIX) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_6.png";
			} if (card.getRank() == Rank.FIVE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_5.png";
			} if (card.getRank() == Rank.FOUR) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_4.png";
			} if (card.getRank() == Rank.THREE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_3.png";
			} if (card.getRank() == Rank.TWO) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_TWO.png";
			} if (card.getRank() == Rank.ACE) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_Ace.png";
			} if (card.getRank() == Rank.JACK) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_Jack.png";
			} if (card.getRank() == Rank.QUEEN) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_Queen.png";
			} if (card.getRank() == Rank.KING) {
				return "/Project2/src/edu/gsu/csc1302/prj2/somethingrandom/swing/"
						+ "graphics/Spade_King.png";
			}
			return null;
	}
}
