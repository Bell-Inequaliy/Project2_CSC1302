package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesComparatorImplementation;

/**
 * Aggressive SpadesPlayer class.
 * @author stgilbert
 * @author J-Dierberger
 *
 */
public class SpadesPlayerAggressive extends SpadesPlayerBase {

	@Override
	public final boolean betBlind() {
		return true;
	}

	@Override
	public final int bet() {
		int bettingNumber = 0;
		Card evaluationCard = null;
		for (int i = 0; i < this.hand.size(); i++) { // six, and all Spades.
			if (this.hand.get(i).getSuit() == Suit.SPADE) {
				bettingNumber++;
			} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.JACK);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
		}
		return bettingNumber;
	}

	@Override
	public final int talk() {
		Card evaluationCard = null;
		int bettingNumber = 0;
		for (int i = 0; i < this.hand.size(); i++) {
			if (this.hand.get(i).getSuit() == Suit.SPADE) {
				bettingNumber++;
			} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.NINE);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
		}
		return bettingNumber;
	}

}
