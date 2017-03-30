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
	 * The hand of the player.
	 */
	private Deck hand;

	/**
	 * The controller object.
	 */
	private final Controller myController;

	/**
	 * Player constructor.
	 * @param type Player type to use.
	 * @param controller Controller object for the game
	 */
	public SpadesPlayer(final int type, final Controller controller) {
		playerType = type;
		if (playerType > 4) {
			playerType = 4;
		}
		hand = null;
		myController = controller;
	}

	@Override
	public final void setHand(final Deck deck) {
		hand = deck;
	}

	@Override
	public final int bet() {
		int r = 0;
		switch (playerType) {
		case TYPE_AGGRESSIVE:
			break;
		case TYPE_CHICKEN:
			break;
		case TYPE_WILDCARD:
			break;
		case TYPE_INTELLIGENT:
			break;
		case TYPE_USER:
			break;
		default:
			throw new RuntimeException(
					"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}
		return r;
	}

	@Override
	public final int talk() {
		int r = 0;
		switch (playerType) {
			case TYPE_AGGRESSIVE:
				break;
			case TYPE_CHICKEN:
				break;
			case TYPE_WILDCARD:
				break;
			case TYPE_INTELLIGENT:
				break;
			case TYPE_USER:
				break;
			default:
				throw new RuntimeException(
						"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}
		return r;
	}

	@Override
	public final Card play() {
		Card r = null;
		switch (playerType) {
		case TYPE_AGGRESSIVE:
			break;
		case TYPE_CHICKEN:
			break;
		case TYPE_WILDCARD:
			break;
		case TYPE_INTELLIGENT:
			break;
		case TYPE_USER:
			break;
		default:
			throw new RuntimeException(
					"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}
		return r;
	}

}
