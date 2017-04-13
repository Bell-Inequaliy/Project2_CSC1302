package edu.gsu.csc1302.prj2.somethingrandom.testing;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesComparatorImplementation;

/**
 * Basic functionality testing using System.out.printlns go here.
 * @author Unascribed
 *
 */
public final class BasicTests {

	/**
	 * Fixing Checkstyle errors.
	 */
	private BasicTests() { }

	/**
	 * Main method.
	 * @param args Console arguments.
	 */
	public static void main(final String[] args) {
		SpadesComparatorImplementation comp =
				new SpadesComparatorImplementation(Suit.DIAMOND);
		Card c1 = new Card(Suit.DIAMOND, Rank.KING);
		Card c2 = new Card(Suit.DIAMOND, Rank.ACE);
		System.out.println(comp.compare(c1, c2));
	}

}
