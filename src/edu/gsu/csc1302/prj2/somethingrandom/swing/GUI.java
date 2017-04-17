package edu.gsu.csc1302.prj2.somethingrandom.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

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
		frmSpades.setTitle("Spades");
		frmSpades.getContentPane().setBackground(new Color(34, 139, 34));
		frmSpades.getContentPane().setLayout(null);
		
		Panel backPanel = new BackgroundPanel();
		frmSpades.getContentPane().add(backPanel);
		
		Panel panel1 = new Panel();
		panel1.setPreferredSize(new Dimension(64, 80));
		panel1.setMinimumSize(new Dimension(64, 80));
		panel1.setMaximumSize(new Dimension(64, 80));
		FlowLayout fl_panel1 = (FlowLayout) panel1.getLayout();
		fl_panel1.setVgap(0);
		fl_panel1.setHgap(0);
		panel1.setBounds(416, 26, 64, 80);
		frmSpades.getContentPane().add(panel1);
		
		JButton TableCard1 = new JButton("Table Card 1");
		panel1.add(TableCard1);
		
		Panel panel2 = new Panel();
		FlowLayout fl_panel2 = (FlowLayout) panel2.getLayout();
		fl_panel2.setVgap(0);
		fl_panel2.setHgap(0);
		panel2.setPreferredSize(new Dimension(64, 80));
		panel2.setMinimumSize(new Dimension(64, 80));
		panel2.setMaximumSize(new Dimension(64, 80));
		panel2.setBounds(496, 26, 64, 80);
		frmSpades.getContentPane().add(panel2);
		
		JButton TableCard2 = new JButton("Table Card 2");
		panel2.add(TableCard2);
		
		Panel panel3 = new Panel();
		FlowLayout fl_panel3 = (FlowLayout) panel3.getLayout();
		fl_panel3.setVgap(0);
		fl_panel3.setHgap(0);
		panel3.setPreferredSize(new Dimension(64, 80));
		panel3.setMinimumSize(new Dimension(64, 80));
		panel3.setMaximumSize(new Dimension(64, 80));
		panel3.setBounds(448, 112, 64, 80);
		frmSpades.getContentPane().add(panel3);
		
		JButton TableCard3 = new JButton("Table Card 3");
		panel3.add(TableCard3);
		
		Panel panel4 = new Panel();
		FlowLayout fl_panel4 = (FlowLayout) panel4.getLayout();
		fl_panel4.setVgap(0);
		fl_panel4.setHgap(0);
		panel4.setPreferredSize(new Dimension(64, 80));
		panel4.setMinimumSize(new Dimension(64, 80));
		panel4.setMaximumSize(new Dimension(64, 80));
		panel4.setBounds(528, 112, 64, 80);
		frmSpades.getContentPane().add(panel4);
		
		JButton TableCard4 = new JButton("Table Card 4");
		panel4.add(TableCard4);
		
		Panel panel5 = new Panel();
		FlowLayout flowLayout_1 = (FlowLayout) panel5.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		panel5.setPreferredSize(new Dimension(64, 80));
		panel5.setMinimumSize(new Dimension(64, 80));
		panel5.setMaximumSize(new Dimension(64, 80));
		panel5.setBounds(128, 208, 64, 80);
		frmSpades.getContentPane().add(panel5);
		
		JButton Handcard1 = new JButton("HandCard1");
		panel5.add(Handcard1);
		
		Panel panel6 = new Panel();
		FlowLayout fl_panel6 = (FlowLayout) panel6.getLayout();
		fl_panel6.setVgap(0);
		fl_panel6.setHgap(0);
		panel6.setPreferredSize(new Dimension(64, 80));
		panel6.setMinimumSize(new Dimension(64, 80));
		panel6.setMaximumSize(new Dimension(64, 80));
		panel6.setBounds(192, 208, 64, 80);
		frmSpades.getContentPane().add(panel6);
		
		JButton Handcard2 = new JButton("HandCard2");
		panel6.add(Handcard2);
		
		Panel panel7 = new Panel();
		FlowLayout fl_panel7 = (FlowLayout) panel7.getLayout();
		fl_panel7.setHgap(0);
		fl_panel7.setVgap(0);
		panel7.setPreferredSize(new Dimension(64, 80));
		panel7.setMinimumSize(new Dimension(64, 80));
		panel7.setMaximumSize(new Dimension(64, 80));
		panel7.setBounds(256, 208, 64, 80);
		frmSpades.getContentPane().add(panel7);
		
		JButton Handcard3 = new JButton("HandCard3");
		panel7.add(Handcard3);
		
		Panel panel8 = new Panel();
		FlowLayout fl_panel8 = (FlowLayout) panel8.getLayout();
		fl_panel8.setVgap(0);
		fl_panel8.setHgap(0);
		panel8.setPreferredSize(new Dimension(64, 80));
		panel8.setMinimumSize(new Dimension(64, 80));
		panel8.setMaximumSize(new Dimension(64, 80));
		panel8.setBounds(320, 208, 64, 80);
		frmSpades.getContentPane().add(panel8);
		
		JButton Handcard4 = new JButton("HandCard4");
		panel8.add(Handcard4);
		
		Panel panel9 = new Panel();
		FlowLayout flowLayout_2 = (FlowLayout) panel9.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		flowLayout_2.setVgap(0);
		panel9.setPreferredSize(new Dimension(64, 80));
		panel9.setMinimumSize(new Dimension(64, 80));
		panel9.setMaximumSize(new Dimension(64, 80));
		panel9.setBounds(384, 208, 64, 80);
		frmSpades.getContentPane().add(panel9);
		
		JButton Handcard5 = new JButton("HandCard5");
		Handcard5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel9.add(Handcard5);
		
		Panel panel10 = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel10.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel10.setPreferredSize(new Dimension(64, 80));
		panel10.setMinimumSize(new Dimension(64, 80));
		panel10.setMaximumSize(new Dimension(64, 80));
		panel10.setBounds(448, 208, 64, 80);
		frmSpades.getContentPane().add(panel10);
		
		JButton Handcard6 = new JButton("HandCard6");
		panel10.add(Handcard6);
		
		Panel panel11 = new Panel();
		FlowLayout fl_panel11 = (FlowLayout) panel11.getLayout();
		fl_panel11.setHgap(0);
		fl_panel11.setVgap(0);
		panel11.setPreferredSize(new Dimension(64, 80));
		panel11.setMinimumSize(new Dimension(64, 80));
		panel11.setMaximumSize(new Dimension(64, 80));
		panel11.setBounds(96, 288, 64, 80);
		frmSpades.getContentPane().add(panel11);
		
		JButton Handcard7 = new JButton("HandCard7");
		panel11.add(Handcard7);
		
		Panel panel12 = new Panel();
		FlowLayout flowLayout_3 = (FlowLayout) panel12.getLayout();
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		panel12.setPreferredSize(new Dimension(64, 80));
		panel12.setMinimumSize(new Dimension(64, 80));
		panel12.setMaximumSize(new Dimension(64, 80));
		panel12.setBounds(160, 288, 64, 80);
		frmSpades.getContentPane().add(panel12);
		
		JButton Handcard8 = new JButton("HandCard8");
		panel12.add(Handcard8);
		
		Panel panel13 = new Panel();
		FlowLayout flowLayout_4 = (FlowLayout) panel13.getLayout();
		flowLayout_4.setHgap(0);
		flowLayout_4.setVgap(0);
		panel13.setPreferredSize(new Dimension(64, 80));
		panel13.setMinimumSize(new Dimension(64, 80));
		panel13.setMaximumSize(new Dimension(64, 80));
		panel13.setBounds(224, 288, 64, 80);
		frmSpades.getContentPane().add(panel13);
		
		JButton Handcard9 = new JButton("HandCard9");
		panel13.add(Handcard9);
		
		Panel panel14 = new Panel();
		FlowLayout flowLayout_5 = (FlowLayout) panel14.getLayout();
		flowLayout_5.setVgap(0);
		flowLayout_5.setHgap(0);
		panel14.setPreferredSize(new Dimension(64, 80));
		panel14.setMinimumSize(new Dimension(64, 80));
		panel14.setMaximumSize(new Dimension(64, 80));
		panel14.setBounds(288, 288, 64, 80);
		frmSpades.getContentPane().add(panel14);
		
		JButton Handcard10 = new JButton("HandCard10");
		panel14.add(Handcard10);
		
		Panel panel15 = new Panel();
		FlowLayout flowLayout_6 = (FlowLayout) panel15.getLayout();
		flowLayout_6.setVgap(0);
		flowLayout_6.setHgap(0);
		panel15.setPreferredSize(new Dimension(64, 80));
		panel15.setMinimumSize(new Dimension(64, 80));
		panel15.setMaximumSize(new Dimension(64, 80));
		panel15.setBounds(352, 288, 64, 80);
		frmSpades.getContentPane().add(panel15);
		
		JButton Handcard11 = new JButton("HandCard11");
		panel15.add(Handcard11);
		
		Panel panel16 = new Panel();
		FlowLayout flowLayout_7 = (FlowLayout) panel16.getLayout();
		flowLayout_7.setVgap(0);
		flowLayout_7.setHgap(0);
		panel16.setPreferredSize(new Dimension(64, 80));
		panel16.setMinimumSize(new Dimension(64, 80));
		panel16.setMaximumSize(new Dimension(64, 80));
		panel16.setBounds(416, 288, 64, 80);
		frmSpades.getContentPane().add(panel16);
		
		JButton Handcard12 = new JButton("HandCard12");
		panel16.add(Handcard12);
		
		Panel panel17 = new Panel();
		FlowLayout flowLayout_8 = (FlowLayout) panel17.getLayout();
		flowLayout_8.setVgap(0);
		flowLayout_8.setHgap(0);
		panel17.setPreferredSize(new Dimension(64, 80));
		panel17.setMinimumSize(new Dimension(64, 80));
		panel17.setMaximumSize(new Dimension(64, 80));
		panel17.setBounds(480, 288, 64, 80);
		frmSpades.getContentPane().add(panel17);
		
		JButton Handcard13 = new JButton("HandCard13");
		panel17.add(Handcard13);
		
		Panel panel = new Panel();
		panel.setBounds(224, 80, 176, 80);
		frmSpades.getContentPane().add(panel);
		
		JButton btnTalk = new JButton("Talk");
		panel.add(btnTalk);
		
		table = new JTable();
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
		table.setBounds(32, 48, 176, 96);
		frmSpades.getContentPane().add(table);
		
		JTextPane txtpnSpades = new JTextPane();
		txtpnSpades.setFont(new Font("Tahoma", Font.BOLD, 36));
		txtpnSpades.setCaretColor(new Color(255, 255, 255));
		txtpnSpades.setForeground(SystemColor.text);
		txtpnSpades.setOpaque(false);
		txtpnSpades.setText("Spades");
		txtpnSpades.setBounds(240, 16, 144, 48);
		frmSpades.getContentPane().add(txtpnSpades);
		frmSpades.setBounds(100, 100, 672, 432);
		frmSpades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
