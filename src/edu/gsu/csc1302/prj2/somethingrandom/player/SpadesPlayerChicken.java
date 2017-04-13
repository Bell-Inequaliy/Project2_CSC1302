package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesComparatorImplementation;

/**
 * Chicken SpadesPlayer class.
 * @author stgilbert
 * @author J-Dierberger
 *
 */
public class SpadesPlayerChicken extends SpadesPlayerBase {

	/**
	 * returns the blind betting response for this player type.
	 * @return false
	 */
	public final boolean betBlind() {
		return false;
	}

	/**
	 * Returns the betting number for this player.
	 * @return bettingNumber
	 */
	public final int bet() {
		int bettingNumber = 0;
		Card evaluationCard = null;
		for (int i = 0; i < this.hand.size(); i++) {
			evaluationCard = new Card(hand.get(i).getSuit(), Rank.KING);
			this.aiComparator = new
					SpadesComparatorImplementation(this.hand.get(i).getSuit());
			if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
				bettingNumber++;
			}
		}
		bettingNumber = (int) (Math.ceil(bettingNumber / 2.0));
		return bettingNumber;
	}

	@Override
	public final int talk() {
		Card evaluationCard = null;
		int bettingNumber = 0;
		for (int i = 0; i < this.hand.size(); i++) {
			evaluationCard = new Card(hand.get(i).getSuit(), Rank.JACK);
			this.aiComparator = new
					SpadesComparatorImplementation(this.hand.get(i).getSuit());
			if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
				bettingNumber++;
			}
		}
		bettingNumber = bettingNumber / 2;
		return bettingNumber;
	}

}
