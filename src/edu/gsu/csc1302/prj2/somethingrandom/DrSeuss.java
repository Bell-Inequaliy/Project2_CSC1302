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
	 */
	protected DrSeuss() {
		if (verbose) {
			System.out.println(
				"And then the dark lord of the SpadesGame emerged... and his name was "
				+ toSeuss());
		}
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
	 * Returns this object's representation as a Seuss.
	 * @return this object's representation as a Seuss.
	 */
	public String toSeuss() {
		return "Dr." + toString() + "Seuss";
	}

}
