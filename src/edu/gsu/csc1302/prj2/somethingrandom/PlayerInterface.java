package edu.gsu.csc1302.prj2.somethingrandom;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;

/**
 * Interface for AI and user-controlled players.
 * @author J-Dierberger
 */
public interface PlayerInterface {

	/**
	 * Set the hand.
	 * @param deck The hand to pass in.
	 */
	void setHand(Deck deck);

	/**
	 * Bet on the current round.
	 * @return The bet.
	 */
	int bet();

	/**
	 * How many books the player thinks it can win.
	 * @return The number of books a player thinks it can win.
	 */
	int talk();

	/**
	 * Return the card that the player will play this round.
	 * @return The card the player will play this round.
	 */
	Card play();

}
