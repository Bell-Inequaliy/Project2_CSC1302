package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;
import edu.gsu.csc1302.prj2.somethingrandom.DeckImplementation;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesGame;
import edu.gsu.csc1302.prj2.somethingrandom.swing.dialogs.PlayerBetPopup;

/**
 * User SpadesPlayer class.
 * @author stgilbert
 * @author J-Dierberger
 * @author ya boi Wesley
 *
 */

public class SpadesPlayerUser extends SpadesPlayerBase {
	/**
	 * SpadesPlayeruser hand.
	 */
	private static Deck hand;
	/**
	 * Int to track the player's bet.
	 */
	private static int playerBet = 0;
	/**
	 * Set the player's static hand.
	 * @param deck Deck
	 */
	public void setHand(final Deck deck) {
		hand = deck;
	}
	/**
	 * Set the player's bet number.
	 	 * Should we halt further execution?
	 * (Called externally to ensure the player's turn isn't skipped.)
	 */
	private static boolean block = true;

	/**
	 * Card the player has chosen to play.
	 */
	private static Card rCard;

	/**
	 * Set the player's bet.
	 * @param bet int
	 */
	public static void setPlayerBet(final int bet) {
		playerBet = bet;
	}
	/**
	 * Get the player's bet number.
	 * @return int
	 */
	public static int getPlayerBet() {
		return playerBet;
	}
	@Override
	public final boolean betBlind() throws Exception {
		return false;
	}

	@Override
	public final int bet() {
		PlayerBetPopup.main(new String[]{"Enter your bet:",
				"", "1"});
		return playerBet;
	}
	/**
	 * * Set the player's play number.
	 * @param cardNum The index of the card to play.
	 * @return If the card is a legal play.
	 */
	public static boolean setPlayCard(final int cardNum) {
		// TO DONE: Add a check so the player can't reneg.
		// If the player can play the card legally, return true.
		// Otherwise return false.
		Deck comparisonDeck = new DeckImplementation();
		if (hand.size() < cardNum) {
			return false;
		}
		if (SpadesGame.getTableCards().size() != 0) {
		for (int i = 0; i < hand.size(); i++) {
			if (SpadesGame.getTableCards().get(0).getSuit()
					== hand.get(i).getSuit()) {
				comparisonDeck.add(hand.get(i));
			}
		}
		if (comparisonDeck.size() != 0
				&& hand.get(cardNum - 1).getSuit()
				!= SpadesGame.getTableCards().get(0).getSuit()) {
			return false;
			}
		}
		rCard = hand.get(cardNum - 1);
		return true;
	}
	/**
	 * Set if the player should continue blocking or not.
	 * @param doBlock If the player should continue blocking or not.
	 */
	public static void setBlock(final boolean doBlock) {
		block = doBlock;
	}

	@Override
	public final int talk() {
		return 0;
	}

	@Override
	public final Card play() throws Exception {
		block = true;
		while (block) {
			Runtime.getRuntime().freeMemory();
		}
		hand.remove(hand.indexOf(rCard));
		return rCard;
	}

}
