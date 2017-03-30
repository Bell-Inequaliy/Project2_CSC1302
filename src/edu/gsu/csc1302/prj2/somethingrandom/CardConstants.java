package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.HashMap;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;

/**
 * Constants class so that you don't have to create a new card
 * each time to compare.
 * @author J-Dierberger
 */
public final class CardConstants {

	/**
	 * Checkstyle.
	 */
	private CardConstants() { }

	/**
	 * Map of cards.
	 */
	private static HashMap<String, Card> cardMap = new HashMap<String, Card>();

	static {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				Card card = new Card(s, r);
				cardMap.put(r + "." + s, card);
			}
		}
	}

	/**
	 * Get the card at the designated key value, in the format "(RANK).(SUIT)".
	 * @param key The key of the card.
	 * @return The card of that type.
	 */
	public static Card getCard(final String key) {
		return cardMap.get(key.toUpperCase());
	}

	/**
	 * Quickly create a card with the given rank and suit.
	 * @param rank The rank of the card.
	 * @param suit The suit of the card.
	 * @return The card of the given rank and suit.
	 */
	public static Card quickCard(final Rank rank, final Suit suit) {
		return new Card(suit, rank);
	}

}
