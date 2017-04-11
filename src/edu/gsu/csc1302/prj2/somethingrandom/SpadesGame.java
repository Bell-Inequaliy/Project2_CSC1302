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
 * @author J-Dierberger
 * @author stgilbert
 * @author Jake P
 * @author DrSeuss.java
 *
 */
public final class SpadesGame {

	/**
	 * Fixing checkstyle errors.
	 */
	private SpadesGame() {
	}

	/**
	 * Universal input scanner.
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
	 * Leading suit of the round.
	 */
	private static Suit leadsuit;

	/**
	 * Team one's tricks that they won.
	 */
	private static int teamOneTricks;


	/**
	 * Team two's tricks that they won.
	 */
	private static int teamTwoTricks;


	/**
	 * Team one's score.
	 */
	private static int teamOneScore;

	/**
	 * Team two's score.
	 */
	private static int teamTwoScore;

	/**
	 * Highest card of a trick.
	 */
	private static Card highCard;

	/**
	 * Player one's bet.
	 */
	private static int playerOneBet;

	/**
	 * Player two's bet.
	 */
	private static int playerTwoBet;

	/**
	 * Player three's bet.
	 */
	private static int playerThreeBet;

	/**
	 * Player four's bet.
	 */
	private static int playerFourBet;

	/**
	 * Main method.
	 * @param args Console launch args.
	 */
	public static void main(final String[] args) {

		// Set up the decks and the hands the players will have.
		LinkedList<Card> fullDeck = new LinkedList<>();
		LinkedList<Card> shuffledDeck = new LinkedList<>();
		LinkedList<Card> deck1 = new LinkedList<>();
		LinkedList<Card> deck2 = new LinkedList<>();
		LinkedList<Card> deck3 = new LinkedList<>();
		LinkedList<Card> deck4 = new LinkedList<>();

		// Populate the full deck.
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card adder = new Card(s, r);
				fullDeck.add(adder);
			}
		}

		/*
		 * Shuffle the deck by randomly removing a card from
		 * the full deck and adding it to the shuffled deck.
		 */
		for (int shuffleNum = 52; shuffleNum != 0; shuffleNum--) {
			int cardNum = (int) (Math.random() * shuffleNum);
			shuffledDeck.add(fullDeck.get(cardNum));
			fullDeck.remove(cardNum);
		}

		//  Deal to the players.
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

		// Start the game and get the desired player configurations.
		System.out.println("Welcome to Spades!");
		System.out.println("What play style would you like player One to be?");
		playerOne = new SpadesPlayer(IN.nextInt());
		System.out.println("What play style would you like player Two to be?");
		playerTwo = new SpadesPlayer(IN.nextInt());
		System.out.println("What play style would you like player Three to be?");
		playerThree = new SpadesPlayer(IN.nextInt());
		System.out.println("What play style would you like player Four to be?");
		playerFour = new SpadesPlayer(IN.nextInt());

		/*
		 * Create the DeckImplementations from the lists
		 * and give them to the players.
		 */
		DeckImplementation deck11 = new DeckImplementation(deck1);
		DeckImplementation deck22 = new DeckImplementation(deck2);
		DeckImplementation deck33 = new DeckImplementation(deck3);
		DeckImplementation deck44 = new DeckImplementation(deck4);
		playerOne.setHand(deck11);
		playerTwo.setHand(deck22);
		playerThree.setHand(deck33);
		playerFour.setHand(deck44);

		// Call on the players to bet.
		playerOneBet = playerOne.bet();
		System.out.println("Player One has bet " + playerOneBet + ".");
		playerTwoBet = playerTwo.bet();
		System.out.println("Player Two has bet " + playerTwoBet + ".");
		playerThreeBet = playerThree.bet();
		System.out.println("Player Three has bet " + playerThreeBet + ".");
		playerFourBet = playerFour.bet();
		System.out.println("Player Four has bet " + playerFourBet + ".");

		// Make sure the bets don't go overboard.
		int teamOneBet = (playerOneBet + playerThreeBet);
		if (teamOneBet > 10) {
			teamOneBet = 10;
		}

		// Ditto.
		int teamTwoBet = (playerTwoBet + playerFourBet);
		if (teamTwoBet > 10) {
			teamTwoBet = 10;
		}

		// Print the bets.
		System.out.println("Team One has bet " + teamOneBet
				+ ". Team Two has bet " + teamTwoBet + ".");

		// Temporary variable that stores which card has been played.
		Card play = new Card(null, null);

		// The player number who won the trick (1, 2, 3, 4).
		int winnerBois;

		// Loop 13 times (since each player has 13 cards to play)
		for (int i = 0; i < 13; i++) {
			// Get player one's play.
			play = playerOne.play();
			// Print out what they played.
			System.out.println("Player One has played " + play);
			// Add it to the list of cards currently on the table.
			table.add(play);
			// Set the lead suit to whatever they played.
			leadsuit = play.getSuit();
			// Create a comparator for future use, based on the lead suit.
			SpadesComparatorImplementation comparer = new
					SpadesComparatorImplementation(leadsuit);
			/*
			 * At this point in time player one is the only one who played.
			 * Therefore, he won.
			 */
			winnerBois = 1;
			highCard = play;

			// Repeat the above code but for player two.
			play = playerTwo.play();
			System.out.println("Player Two has played " + play);
			table.add(play);

			// Now, if the card we just played beats the card on the table...
			if (comparer.compare(highCard, play) > 0) {
				// Set the new high card and winning player.
				highCard = play;
				winnerBois = 2;
			}
			// Otherwise do nothing.

			// Repeat above code for player three.
			play = playerThree.play();
			System.out.println("Player Three has played " + play);
			table.add(play);
			if (comparer.compare(highCard, play) > 0) {
				highCard = play;
				winnerBois = 3;
			}

			// Repeat above code for player four.
			play = playerFour.play();
			System.out.println("Player Four has played " + play);
			table.add(play);
			table.add(play);
			if (comparer.compare(highCard, play) > 0) {
				highCard = play;
				winnerBois = 4;
			}

			// Clear the table
			table.clear();

			// If the winner is an even number...
			if (winnerBois % 2 == 0) {
				// Team two won
				teamTwoTricks++;
			} else {
				// Otherwise team one won.
				teamOneTricks++;
			}

			// Print the winning player and the number of tricks each team has won.
			System.out.println("WINNERBOIS = " + winnerBois);
			System.out.println("Team One tricks: " + teamOneTricks + ", "
					+ "Team Two tricks: " + teamTwoTricks + ".");
		} // Continue looping...

		// After the loop concludes, determine the scores for each team.
		if (teamOneTricks - teamOneBet > 0 && teamOneTricks - teamOneBet < 4) {
			teamOneScore += teamOneBet * 10;
		} else {
			teamOneScore -= teamOneBet * 10;
		}
		if (teamTwoTricks - teamTwoBet > 0 && teamTwoTricks - teamTwoBet < 4) {
			teamTwoScore += teamTwoBet * 10;
		} else {
			teamTwoScore -= teamTwoBet * 10;
		}
		// Print the updated scores.
		System.out.println("Team One score: " + teamOneScore + ", "
				+ "Team Two Score: " + teamTwoScore + ".");

		// Close the input stream.
		IN.close();
	}

	/**
	 * Get the cards currently on the table.
	 * @return The cards currently on the table.
	 */
	public static DeckImplementation getTableCards() {
		return table;
	}

	/**
	 * Get the player's team mate.
	 * @param player The player to find the team mate of.
	 * @return The player's team mate.
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
