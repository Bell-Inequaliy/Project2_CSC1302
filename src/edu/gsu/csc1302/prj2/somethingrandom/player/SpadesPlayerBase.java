package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;
import edu.gsu.csc1302.prj2.somethingrandom.DeckImplementation;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesComparatorImplementation;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesGame;

/**
 * Abstract base for the SpadesPlayer classes.
 * @author J-Dierberger
 *
 */
public abstract class SpadesPlayerBase {

	/**
	 * The hand of the player.
	 */
	protected Deck hand;

	/**
	 * Comparator used for evaluating betting numbers.
	 */
	protected SpadesComparatorImplementation aiComparator;

	/**
	 * Set the player's hand equal to the given deck.
	 * @param deck Deck
	 */
	public void setHand(final Deck deck) {
		hand = deck;
	}

	/**
	 * Return a player's hand.
	 * @return deck Deck
	 */
	public Deck getHand() {
		return hand;
	}

	/**
	 * This method returns if the Player wishes to bet blind or not.
	 * @return boolean
	 */
	public abstract boolean betBlind();

	/**
	 * Return the number the player or AI thinks they can win this round.
	 * @return int
	 */
	public abstract int bet();

	/**
	 * Return the number of cards the player (AI) thinks it can win with.
	 * @return int
	 */
	public abstract int talk();

	/**
	 * Play a card from the player's hand to the board.
	 * @return card
	 */
	public Card play() {
		Deck comparisonDeck = new DeckImplementation();
		Card playingCard = new Card(null, null);
		if (SpadesGame.getTableCards().size() == 0) {
			playingCard = hand.get(0);
			hand.remove(playingCard);
			return playingCard;
		}
		if (SpadesGame.getTableCards().size() != 0) {
			for (int i = 0; i < this.hand.size(); i++) {
				if (SpadesGame.getTableCards().get(0).getSuit()
						== hand.get(i).getSuit()) {
					comparisonDeck.add(hand.get(i));
				}
			}
			if (comparisonDeck.size() == 0) {
				comparisonDeck = hand;
			} //TLDR: It looks for any card that beats the board that's legal.
			//Failing that, or given any edge case, it plays its first card.
			for (int i = 0; i < comparisonDeck.size(); i++) {
				for (int j = 0; j < SpadesGame.getTableCards().size(); j++) {
					this.aiComparator = new
							SpadesComparatorImplementation(SpadesGame.getTableCards()
									.get(0).getSuit());
					if (aiComparator.compare(SpadesGame.getTableCards().get(j),
							comparisonDeck.get(i)) < 0) {
						//	System.out.println(playingCard);
						//	System.out.println(comparisonDeck);
						if (playingCard.getSuit() == null) {
							playingCard = comparisonDeck.get(i);
						} else if (aiComparator.compare(playingCard, comparisonDeck.get(i))
								< 0) {

							playingCard = comparisonDeck.get(i);
						}
					}
				}
			} if (playingCard.getSuit() == null) {
				playingCard = comparisonDeck.get(0);
			}
		} else {
			playingCard = hand.get(0);
		}
		hand.remove(playingCard);
		return playingCard;
	}

}

