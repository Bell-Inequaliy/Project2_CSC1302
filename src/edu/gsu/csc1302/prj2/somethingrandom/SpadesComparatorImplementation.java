package edu.gsu.csc1302.prj2.somethingrandom;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.coll1.SpadesComparator;

/**
 * Implementation of the SpadesComparator class.
 * @author J-Dierberger
 */
public class SpadesComparatorImplementation extends SpadesComparator {

	/**
	 * Construct a new SpadeComparatorImplementation.
	 * @param leadSuit The leading suit.
	 */
	public SpadesComparatorImplementation(final Suit leadSuit) {
		super(leadSuit);
	}

	@Override
	public final int compare(final Card arg0, final Card arg1) {
		/*
		 * Twos trump (hearts, clubs, diamonds, spades)
		 * Spades trump all suits
		 * Lead suit trumps other suits
		 */
		Rank r0 = arg0.getRank();
		Rank r1 = arg1.getRank();
		Suit s0 = arg0.getSuit();
		Suit s1 = arg1.getSuit();

		// If not twos...
		if (!r0.equals(Rank.TWO) && !r1.equals(Rank.TWO)) {

			// If we aren't spades or lead suit but the other card is...
			if (!(s0.compareTo(leadSuit) == 0 || s0.compareTo(Suit.SPADE) == 0)
					&& (s1.compareTo(leadSuit) == 0 || s1.compareTo(Suit.SPADE) == 0)) {
				return 1; // We know we already lost.

				// If we are spades or lead suit but the other card isn't...
			} else if ((s0.compareTo(leadSuit) == 0 || s0.compareTo(Suit.SPADE) == 0)
					&& !(s1.compareTo(leadSuit) == 0 || s1.compareTo(Suit.SPADE) == 0)) {
				return -1; // We know we already won.

				// Both not spades or leading suit...
			} else if ((s0.compareTo(leadSuit) != 0 && s0.compareTo(Suit.SPADE) != 0)
					&& (s1.compareTo(leadSuit) != 0 && s1.compareTo(Suit.SPADE) != 0)) {
				return 0; // Equal for our purposes.

				// If we and the other are either spades or lead suit...
			} else {
				// If we are spades and the other isn't...
				if (s0.compareTo(Suit.SPADE) == 0 && s1.compareTo(Suit.SPADE) != 0) {
					return -1; // We know we already won.
					// Inverse case...
				} else if (s0.compareTo(Suit.SPADE) != 0
						&& s1.compareTo(Suit.SPADE) == 0) {
					return 1; // We know we already lost.
					// If we both are or are not spades...
				} else {
					// If our rank is greater than the other card...
					if (r0.compareTo(r1) > 0) {
						return -1; // We win.
						// If our rank is less than the other card...
					} else if (r0.compareTo(r1) < 0) {
						return 1; // We lose.
						// Our suits are equal and our ranks are equal...
					} else {
						return 0;
					}
				}
			}
			/*
			 * If we are twos then the rank comparison and suit comparison is
			 * out of order so we need to do special things here instead of compareTo.
			 */
		} else {

			// If we are a two and the other is not we already won
			if (r0.compareTo(Rank.TWO) == 0 && r1.compareTo(Rank.TWO) != 0) {
				return -1;
				// Inverse we lose
			} else if (r0.compareTo(Rank.TWO) != 0 && r1.compareTo(Rank.TWO) == 0) {
				return 1;
				// Both twos...
			} else {
				// If they're equal let's go ahead and get that out of the way.
				if (s0.compareTo(s1) == 0) {
					return 0;
				}

				// If one or the other are hearts...
				if (s0.compareTo(Suit.HEART) == 0 && s1.compareTo(Suit.HEART) != 0) {
					return -1;
				} else if (s0.compareTo(Suit.HEART) != 0
						&& s1.compareTo(Suit.HEART) == 0) {
					return 1;
					// If they both aren't hearts...
				} else {
					if (s0.compareTo(Suit.CLUB) == 0 && s1.compareTo(Suit.CLUB) != 0) {
						return -1;
					} else if (s0.compareTo(Suit.CLUB) != 0
							&& s1.compareTo(Suit.CLUB) == 0) {
						return 1;
					} else {
						if (s0.compareTo(Suit.DIAMOND) == 0
								&& s1.compareTo(Suit.DIAMOND) != 0) {
							return -1;
						} else if (s0.compareTo(Suit.DIAMOND) != 0
								&& s1.compareTo(Suit.DIAMOND) == 0) {
							return 1;
						} else {
							if (s0.compareTo(Suit.SPADE) == 0
									&& s1.compareTo(Suit.SPADE) != 0) {
								return -1;
							} else if (s0.compareTo(Suit.SPADE) != 0
									&& s1.compareTo(Suit.SPADE) == 0) {
								return 1;
							} else {
								return 0;
							}
						}
					}
				}
			}
		}
	}

}
