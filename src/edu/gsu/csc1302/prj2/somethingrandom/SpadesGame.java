package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
	private SpadesGame() {
	}

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
	 * This is where the players are kept.
	 * Let's hope they don't figure out how to get out.
	 */
	static List<SpadesPlayer> players;
	/**
	 * The player whose turn it currently is.
	 */
	SpadesPlayer currentPlayer;


	private static int playerOneBet;
	private static int playerTwoBet;
	private static int playerThreeBet;
	private static int playerFourBet;

	static Scanner in = new Scanner(System.in);

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
		//TODO change the 1 to in.nextintbois
		System.out.println("Welcome to Spades!");
		System.out.println("What play style would you like player One to be?");
		playerOne = new SpadesPlayer(in.nextInt());
		System.out.println("What play style would you like player Two to be?");
		playerTwo = new SpadesPlayer(in.nextInt());
		System.out.println("What play style would you like player Three to be?");
		playerThree = new SpadesPlayer(in.nextInt());
		System.out.println("What play style would you like player Four to be?");
		playerFour = new SpadesPlayer(in.nextInt());


//		List<SpadesPlayer> players = Arrays.asList(playerOne, playerTwo,
//			playerThree, playerFour);

		//making decks and giving them to the players
		DeckImplementation deck11 = new DeckImplementation(deck1);
		DeckImplementation deck22 = new DeckImplementation(deck2);
		DeckImplementation deck33 = new DeckImplementation(deck3);
		DeckImplementation deck44 = new DeckImplementation(deck4);
		playerOne.setHand(deck11);
		playerTwo.setHand(deck22);
		playerThree.setHand(deck33);
		playerFour.setHand(deck44);

			// TODO
			playerOneBet = playerOne.bet();
			System.out.println("Player One has bet " + playerOneBet + ".");
			playerTwoBet = playerTwo.bet();
			System.out.println("Player Two has bet " + playerTwoBet + ".");
			playerThreeBet = playerThree.bet();
			System.out.println("Player Three has bet " + playerThreeBet + ".");
			playerFourBet = playerFour.bet();
			System.out.println("Player Four has bet " + playerFourBet + ".");
			int teamOneBet = (playerOneBet + playerThreeBet);
			if (teamOneBet > 10) {
				teamOneBet = 10;
			}
			int teamTwoBet = (playerTwoBet + playerFourBet);
			if (teamTwoBet > 10) {
				teamTwoBet = 10;
			}
			System.out.println("Team One has bet " + teamOneBet
					+ ". Team Two has bet " + teamTwoBet + ".");

			Card play = new Card(null, null);
			for (int i = 0; i < 4; i++) {
	play = playerOne.play();
	System.out.println("Player One has played " + play);
	table.add(play);
	play = playerTwo.play();
	System.out.println("Player Two has played " + play);
	play = playerThree.play();
	table.add(play);
	System.out.println("Player Three has played " + play);
	play = playerThree.play();
	table.add(play);
	play = playerOne.play();
	System.out.println("Player Four has played " + play);
	table.add(play);
			}
		System.out.println("Player One has played " + play);
	in.close();
	}

	/** test.
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
