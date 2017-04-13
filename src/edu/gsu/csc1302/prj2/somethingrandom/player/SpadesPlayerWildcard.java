package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card.Suit;

/**
 * Wildcard SpadesPlayer class.
 * @author stgilbert
 * @author J-Dierberger
 *
 */
public class SpadesPlayerWildcard extends SpadesPlayerBase {

	@Override
	public final boolean betBlind() {
		return Math.random() < 0.05;
	}

	@Override
	public final int bet() {
		int bettingNumber = 0;
		for (int i = 0; i < this.hand.size(); i++) {
			if (this.hand.get(i).getSuit() == Suit.SPADE) {
				bettingNumber++;
			} else {
				if (Math.random() < .03) { //Yes this is almost a coin flip.
					bettingNumber++;
				}
			}
		}
		return bettingNumber;
	}

	@Override
	public final int talk() {
		int bettingNumber = 0;
		for (int i = 0; i < this.hand.size(); i++) { //Thinks it can win randomly.
			if (this.hand.get(i).getSuit() == Suit.SPADE) {
				bettingNumber++;
			} else {
				if (Math.random() < .05) { //Yes this is almost a coin flip.
					bettingNumber++; //Yes they might report different numbers each time
				} // Not sure if that's a problem or not. If it is, can be changed.
			}
		}
		return bettingNumber;
	}

}
