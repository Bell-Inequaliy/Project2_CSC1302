package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
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
	 * Set the player's bet number.
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
	}

}
