/**
 * YO WHAT'S UP THIS IS A THING I HAD TO MAKE.
 */
package edu.gsu.csc1302.prj2.somethingrandom.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

/**
 * This is a panel that uses an image as a background instead of a solid color.
 * @author jakep
 * I really hope this works.
 */
public class BackgroundPanel extends Panel {
	/**
	 * Apparently I need this.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The background image.
	 */
	Image background;
	/**
	 * gets the backkground image when initialized.
	 */
	public BackgroundPanel() {
        background = Toolkit.getDefaultToolkit().createImage(
        		"edu.gsu.csc1302.prj2.somethingrandom.swing.Layout.png");
    }

    /**
     * Sets the background when painted.
     * @param g Input graphics?!
     */
	public void paint(final Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
