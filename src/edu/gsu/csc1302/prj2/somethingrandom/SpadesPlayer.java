package edu.gsu.csc1302.prj2.somethingrandom;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;

/**
 * Spades Player to manage the four AI player types.
 *
 * @author stgilbert
 * @author J-Dierberger
 *
 */
public class SpadesPlayer implements PlayerInterface {

	/**
	 * Aggressive player type constant.
	 */
	public static final int TYPE_AGGRESSIVE = 0;

	/**
	 * Chicken player type constant.
	 */
	public static final int TYPE_CHICKEN = 1;

	/**
	 * Wildcard player type constant.
	 */
	public static final int TYPE_WILDCARD = 2;

	/**
	 * Savagely intelligent player type constant.
	 */
	public static final int TYPE_INTELLIGENT = 3;

	/**
	 * User controlled player constant.
	 */
	public static final int TYPE_USER = 4;

	/**
	 * Int to track the actual designated player type.
	 */
	private int playerType;

	/**
	 * Player constructor.
	 * @param type Player type to use.
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
