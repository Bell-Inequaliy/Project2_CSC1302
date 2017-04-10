package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.LinkedList;
import java.util.Scanner;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;

/**
 * Spades Player to manage the generic game stuff.
 *
 * @author Wesley
 *
 */
public final class SpadesGame {

	/**
	 * Fixing checkstyle errors.
	 */
	private SpadesGame() { }

	/**
	 * Now we don't have to reinstantiate the scanner every time we need it.
	 */
	public static final Scanner IN = new Scanner(System.in);

	/**
	 * Cards on the table.
	 */
	private static DeckImplementation table = new DeckImplementation();

	/**
	 * Player one variable.
	 */
	private static SpadesPlayer playerOne = new SpadesPlayer(1);

	/**
	 * Player two variable.
	 */
	private static SpadesPlayer playerTwo = new SpadesPlayer(1);

	/**
	 * Player three variable.
	 */
	private static SpadesPlayer playerThree = new SpadesPlayer(1);

	/**
	 * Player four variable.
	 */
	private static SpadesPlayer playerFour = new SpadesPlayer(1);

	/**
	 * Main method.
	 * @param args Console launch args.
	 */
	public static void main(final String[] args) {
		boolean playing = true;
		LinkedList<Card> fullDeck = new LinkedList<>();
		LinkedList<Card> shuffledDeck = new LinkedList<>();
		LinkedList<Card> deck1 = new LinkedList<>();
		LinkedList<Card> deck2 = new LinkedList<>();
		LinkedList<Card> deck3 = new LinkedList<>();
		LinkedList<Card> deck4 = new LinkedList<>();


		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card adder = new Card(s, r);
				fullDeck.add(adder);

			}
		}

		for (int shuffleNum = 52; shuffleNum != 0; shuffleNum--) {
			int cardNum = (int) (Math.random() * shuffleNum);
			shuffledDeck.add(fullDeck.get(cardNum));
			fullDeck.remove(cardNum);
		}

		for (int deal = 0; deal < 13; deal++) {
			deck1.add(shuffledDeck.get(0));
			shuffledDeck.remove(0);
			deck2.add(shuffledDeck.get(0));
			shuffledDeck.remove(0);
			deck3.add(shuffledDeck.get(0));
			shuffledDeck.remove(0);
			deck4.add(shuffledDeck.get(0));
			shuffledDeck.remove(0);
		}

		//starting the game and getting player behaviors
		System.out.println("Welcome to Spades!");
		System.out.println("What play style would you like player One to be?");
		playerOne = new SpadesPlayer(1);
		System.out.println("What play style would you like player Two to be??");
		playerTwo = new SpadesPlayer(1);
		System.out.println("What play style would you like player Three to be?");
		playerThree = new SpadesPlayer(1);
		System.out.println("What play style would you like player Four to be?");
		playerFour = new SpadesPlayer(1);

		//making decks and giving them to the players
		DeckImplementation deck11 = new DeckImplementation(deck1);
		DeckImplementation deck22 = new DeckImplementation(deck2);
		DeckImplementation deck33 = new DeckImplementation(deck3);
		DeckImplementation deck44 = new DeckImplementation(deck4);
		playerOne.setHand(deck11);
		playerTwo.setHand(deck22);
		playerThree.setHand(deck33);
		playerFour.setHand(deck44);


		while (playing) {
			// TODO
			Runtime.getRuntime();
		}
		IN.close();
	}

	/**
	 * ass.
	 * @return ass.
	 */
	public static DeckImplementation getTableCards() {
		return table;
	}

	/**
	 * ass.
	 * @param player ass.
	 * @return ass.
	 */
	public static SpadesPlayer getPlayerTeamMate(
			final SpadesPlayer player) {
		if (player.equals(playerOne)) {
			return playerThree;
		} else if (player.equals(playerTwo)) {
			return playerFour;
		} else if (player.equals(playerThree)) {
			return playerOne;
		} else if (player.equals(playerFour)) {
			return playerTwo;
		}
		return null;
	}

}

//get players
//set player turns
//get inputs
//static
//set random dealers
//create deck
//pass array of players into controller object
//move dealer
//get gamestate in between turns
//what to do each turn

//game 13 cards x 4 dealers
//round 13 cards each
//book 1 card
