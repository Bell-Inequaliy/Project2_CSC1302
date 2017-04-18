package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;
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
	 * Int to track the player's bet.
	 */
	private static int playerBet = 0;

	/**
	 * Should we halt further execution?
	 * (Called externally to ensure the player's turn isn't skipped.)
	 */
	private static boolean block = true;

	/**
	 * Card the player has chosen to play.
	 */
	private static Card rCard;

	/**
	 * Set the player's bet number.
	 * @param bet The bet amount.
	 */
	public static void setPlayerBet(final int bet) {
		playerBet = bet;
	}
	/**
	 * Set the player's bet number.
	 * @param cardNum The index of the card to play.
	 * @return If the card is a legal play.
	 */
	public static boolean setPlayCard(final int cardNum) {
		// TO DO: Add a check so the player can't reneg or whatever the damn word is.
		// If the player can play the card legally, return true. Otherwise return false.
		return true;
		
	}
	/**
	 * Set if the player should continue blocking or not.
	 * @param doBlock If the player should continue blocking or not.
	 */
	public static void setBlock(final boolean doBlock) {
		block = doBlock;
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
		// TO DO: Popup
		return false;
	}

	@Override
	public final int bet() {
		PlayerBetPopup.main(new String[]{"Enter your bet:",
				"Enter your bet:", "1"});
		return playerBet;
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
		return rCard;
	}

}
