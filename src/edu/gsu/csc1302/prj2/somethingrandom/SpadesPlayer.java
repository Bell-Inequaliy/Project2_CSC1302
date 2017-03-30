package edu.gsu.csc1302.prj2.somethingrandom;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;

/**
 * Spades Player to manage the four AI player types.
 *
 * @author stgilbert
 *
 */
public class SpadesPlayer implements PlayerInterface {

	/**
	 * Int to track.
	 */
	private int playerType;

	/**
	 * Player constructor.
	 * @param type int
	 * @param controller Controller object for the game
	 */
	public SpadesPlayer(final int type, final Controller controller) {

	}

	@Override
	public final void setHand(final Deck deck) {
	}

	@Override
	public final int bet() {
		return 0;
	}

	@Override
	public final int talk() {
		return 0;
	}

	@Override
	public final Card play() {
		return null;
	}

}
