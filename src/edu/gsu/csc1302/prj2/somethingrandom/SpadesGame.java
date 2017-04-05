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
		//making the player controller (????)
		Controller controller = new Controller();

		//starting the game and getting player behaviors
		//TODO change the 1 to in.nextintbois
		System.out.println("Welcome to Spades!");
		System.out.println("What play style would you like player One to be?");
		SpadesPlayer playerOne = new SpadesPlayer(1, controller);
		System.out.println("What play style would you like player Two to be??");
		SpadesPlayer playerTwo = new SpadesPlayer(1, controller);
		System.out.println("What play style would you like player Three to be?");
		SpadesPlayer playerThree = new SpadesPlayer(1, controller);
		System.out.println("What play style would you like player Four to be?");
		SpadesPlayer playerFour = new SpadesPlayer(1, controller);

		//making the games controller (??)
		Controller gameController = new Controller(playerOne, playerTwo,
				playerThree, playerFour);

		//making decks and giving them to the players
		DeckImplementation deck11 = new DeckImplementation(deck1);
		DeckImplementation deck22 = new DeckImplementation(deck2);
		DeckImplementation deck33 = new DeckImplementation(deck3);
		DeckImplementation deck44 = new DeckImplementation(deck4);
		playerOne.setHand(deck11);
		playerTwo.setHand(deck22);
		playerThree.setHand(deck33);
		playerFour.setHand(deck44);
		gameController.playCard(playerOne.play());
		playerOne.play();

			//start betting starting with dealers opponent
			playerTwo.bet();
			playerFour.bet();
			playerOne.bet();
			playerThree.bet();

			//	System.out.println(fullDeck);
		//	System.out.println(shuffledDeck);
		System.out.println(deck11);
		System.out.println(deck22);
		System.out.println(deck33);
		System.out.println(deck44);
		IN.close();
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
