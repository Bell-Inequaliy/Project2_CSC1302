package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesComparatorImplementation;

/**
 * Intelligent SpadesPlayer class.
 * @author stgilbert
 * @author J-Dierberger
 *
 */
public class SpadesPlayerIntelligent extends SpadesPlayerBase {

	@Override
	public final boolean betBlind() {
		return true;
	}

	@Override
	public final int bet() {
		int bettingNumber = 0;
		Card evaluationCard = null;
		for (int i = 0; i < this.hand.size(); i++) { // and spades.
			if (this.hand.get(i).getSuit() == Suit.SPADE) {
				bettingNumber++;
			} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.KING);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
		}
		bettingNumber = (int) (bettingNumber * (Math.random() * .5 + .5));
		return bettingNumber;
	}

	@Override
	public final int talk() {
		int bettingNumber = 0;
		Card evaluationCard = null;
		for (int i = 0; i < this.hand.size(); i++) {
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
		bettingNumber = (int) (bettingNumber * (Math.random() * .5 + .5));
		return bettingNumber;
	}

}
