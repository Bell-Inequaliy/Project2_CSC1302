package edu.gsu.csc1302.prj2.somethingrandom;

/**
 * Dr. Seuss watches over our spades game, and gives it his blessing.
 * @author Jake P
 * @author DrSeuss.java
 */
public abstract class DrSeuss {

	/**
	 * If our eggs are verbose or not.
	 */
	protected static boolean verbose = false;

	/**
	 * And thus the dark lord himself was born...
	 * @param verbose If he can speak
	 */
	protected DrSeuss(final boolean verbose) {
		this.verbose = verbose;
		if (verbose) {
			System.out.println(
				"And then the dark lord of the SpadesGame emerged... and his name was "
				+ toSeuss());
		}
	}

	/**
	 * And thus the dark lord himself was born...
	 */
	protected DrSeuss() {
		this(true);
	}

	/**
	 * One fish.
	 */
	static int fish = 1;

	/**
	 * Two fish.
	 */
	static {
		fish++;
	}

	/**
	 * Red fish.
	 */
	static String color = "RED";

	/**
	 * Blue fish.
	 */
	static {
		color = "BLUE";
	}

	/**
	 * its ya main man dr seuss.
	 * @param args boi
	 */
	public static void main(final String[] args) {
		if (verbose) {
			while (true) {
				System.out.println("ONE FISH");
				System.out.println("TWO FISH");
				System.out.println("RED FISH");
				System.out.println("BOI FISH");
			}
		}
	}

	/**
	 * Returns this object's representation as a Seuss.
	 * @return this object's representation as a Seuss.
	 */
	public String toSeuss() {
		return "Dr." + toString() + "Seuss";
	}

}
