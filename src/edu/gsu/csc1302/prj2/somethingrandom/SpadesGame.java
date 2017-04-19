package edu.gsu.csc1302.prj2.somethingrandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.coll1.Deck;
import edu.gsu.csc1302.prj2.somethingrandom.player.SpadesPlayerBase;
import edu.gsu.csc1302.prj2.somethingrandom.swing.GUI;
import edu.gsu.csc1302.prj2.somethingrandom.swing.dialogs.PlayerTypePopup;

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
public final class SpadesGame extends DrSeuss {

	/**
	 * Fixing checkstyle errors.
	 */
	private SpadesGame() {
	}

	/**
	 * Boolean to store if a user player exists.
	 */
	private static boolean hasUserPlayer = false;

	/**
	 * Cards on the table.
	 */
	private static DeckImplementation table = new DeckImplementation();

	/**
	 * Player one variable.
	 */
	private static SpadesPlayerBase playerOne;

	/**
	 * Player two variable.
	 */
	private static SpadesPlayerBase playerTwo;

	/**
	 * Player three variable.
	 */
	private static SpadesPlayerBase playerThree;

	/**
	 * Player four variable.
	 */
	private static SpadesPlayerBase playerFour;

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
	private static int teamOneBet;

	/**
	 * Player two's bet.
	 */
	private static int teamTwoBet;

	/**
	 * Track if team one bet Blind.
	 */
	private static boolean teamOneBlind = false;
	/**
	 * Track if team two bet Blind.
	 */
	private static boolean teamTwoBlind = false;

	/**
	 * Main method.
	 * @param args Console launch args.
	 * @throws Exception When various unaccounted for things occur.
	 */
	public static void main(final String[] args) throws Exception {
		GUI.main(args);
		// Start the game and get the desired player configurations.
		System.out.println("Welcome to Spades!");
		PlayerTypePopup.main(new String[]{"What type do you want Player One to be?",
				"1", "1"});
		PlayerTypePopup.main(new String[]{"What type do you want Player Two to be?",
				"1", "2"});
		PlayerTypePopup.main(new String[]{
				"What type do you want Player Three to be?", "1", "3"});
		PlayerTypePopup.main(new String[]{
				"What type do you want Player Four to be?", "1", "4"});

		shuffleAndDeal();
		playRound();
		teamOneScore += teamOneTricks * 10;
		teamTwoScore += teamTwoTricks * 10;
		System.out.println("Team One score: " + teamOneScore + ", "
				+ "Team Two Score: " + teamTwoScore + ".");

		teamOneTricks = 0;
		teamTwoTricks = 0;

		int teamOneSet = 0;
		int teamTwoSet = 0;
		while (true) {
			shuffleAndDeal();

			makeBets();

			playRound();
			// Handle Bostons. (Bet 10, win 13).
			if ((teamOneTricks == 13 && teamOneBet == 10 && !teamOneBlind)
					&& !(teamTwoTricks == 13 && teamTwoBet == 10)) {
				System.out.println("Team one got a Boston and won the game!");
				break;
			} else if (!(teamOneTricks == 13 && teamOneBet == 10)
					&& (teamTwoTricks == 13 && teamTwoBet == 10 && !teamTwoBlind)) {
				System.out.println("Team two got a Boston and won the game!");
				break;
			}

			boolean teamOneDidSet = false;
			boolean teamTwoDidSet = false;
			// After the loop concludes, determine the scores for each team.
			if (teamOneTricks - teamOneBet > 0 && teamOneTricks - teamOneBet < 4) {
				if (teamOneBlind) { //handle blind-bet bonus.
					teamOneScore += teamOneBet * 20;
				} else {
					teamOneScore += teamOneBet * 10;
				}
				// We won, reset our set either way.
				teamTwoSet = 0;
			} else {
				teamOneScore -= teamOneBet * 10;
				// We lost, increment our set.
				teamOneSet++;
				// Set that we lost to true.
				teamOneDidSet = true;
			}
			if (teamTwoTricks - teamTwoBet > 0 && teamTwoTricks - teamTwoBet < 4) {
				if (teamTwoBlind) { //handle blind-bet bonus.
					teamTwoScore += teamTwoBet * 20;
				} else {
					teamTwoScore += teamTwoBet * 10;
				}
				// We won, reset our set either way.
				teamTwoSet = 0;
			} else {
				teamTwoScore -= teamTwoBet * 10;
				// We lost, incremement the set.
				teamTwoSet++;
				// Set that we lost to true.
				teamTwoDidSet = true;
			}

			// If they both lose, reset the set count.
			if (teamOneDidSet && teamTwoDidSet) {
				teamOneSet = 0;
				teamTwoSet = 0;
			}

			if (teamOneSet == 2 && teamTwoSet < 2) {
				System.out.println("Team one lost twice in a row and lost!");
				System.out.println("Team two won!");
			} else if (teamOneSet == 2 && teamTwoSet < 2) {
				System.out.println("Team two lost twice in a row and lost!");
				System.out.println("Team one won!");
			} else if (teamOneSet > 2 || teamTwoSet > 2) {
				throw new RuntimeException("ERROR WHERE THERE SHOULDN'T BE: \n"
						+ "TEAM ONE SET: " + teamOneSet + "\nTEAM TWO SET: " + teamTwoSet);
			}

			// Handle win conditions
			if (teamOneScore >= 500 && teamTwoScore < 500) {
				System.out.println("Team one got to 500 points and won the game!");
				break;
			} else if (teamOneScore < 500 && teamTwoScore >= 500) {
				System.out.println("Team two got to 500 points and won the game!");
				break;
			} else if ((teamOneScore >= 500 && teamTwoScore >= 500)
					&& teamOneScore == teamTwoScore) {
				System.out.println("Team one and two have tied to play another round!");
			} else if ((teamOneScore >= 500 && teamTwoScore >= 500)
					&& teamOneScore > teamTwoScore) {
				System.out.println("Team one and two have both got to 500 points, "
						+ "but team one has more!");
				System.out.println("Team one has won the game!");
				break;
			} else if ((teamOneScore >= 500 && teamTwoScore >= 500)
					&& teamTwoScore > teamOneScore) {
				System.out.println("Team one and two have both got to 500 points, "
						+ "but team two has more!");
				System.out.println("Team two has won the game!");
				break;
			}

			// Reset the trick count.
			teamOneTricks = 0;
			teamTwoTricks = 0;

			// Print the updated scores.
			System.out.println("Team One score: " + teamOneScore + ", "
					+ "Team Two Score: " + teamTwoScore + ".");

			// Get if the player wants to go again.
			System.out.println("Do you want to play again? (y.../n...)");
			BufferedReader blockingReader =
					new BufferedReader(new InputStreamReader(System.in));
			try {
				String response = blockingReader.readLine();
				if (response.toLowerCase().toCharArray()[0] == 'n') {
					blockingReader.close();
					break;
				} else {
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Shuffle and deal the deck of cards.
	 */
	private static void shuffleAndDeal() {
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
	}

	/**
	 * Have the players make bets.
	 * @throws Exception When various unaccounted for things occur.
	 */
	private static void makeBets() throws Exception {
		/*
		 * Preemptive setup of ghost-deck.
		 */
		DeckImplementation ghostDeck = new DeckImplementation();
		for (Rank r : Rank.values()) {
			Card adder = new Card(Suit.HEART, r);
			ghostDeck.add(adder);
		}
		//setup of default values
		int playerOneBet = 0;
		int playerTwoBet = 0;
		int playerThreeBet = 0;
		int playerFourBet = 0;
		teamOneBlind = false;
		teamTwoBlind = false;
		//default case
		if (Math.abs(teamOneScore - teamTwoScore) < 100) {
			// Call on the players to bet.
			playerOneBet = playerOne.bet();
			System.out.println("Player One has bet " + playerOneBet + ".");
			playerTwoBet = playerTwo.bet();
			System.out.println("Player Two has bet " + playerTwoBet + ".");
			playerThreeBet = playerThree.bet();
			System.out.println("Player Three has bet " + playerThreeBet + ".");
			playerFourBet = playerFour.bet();
			System.out.println("Player Four has bet " + playerFourBet + ".");
		} else if (teamOneScore - teamTwoScore > 100) { //if team 1 is way ahead
			playerOneBet = playerOne.bet();
			System.out.println("Player One has bet " + playerOneBet + ".");
			if (playerTwo.betBlind()) {
				System.out.println("Player Two has bet blind.");
				Deck storageDeck = playerTwo.getHand();
				playerTwo.setHand(ghostDeck);
				playerTwoBet = playerTwo.bet();
				playerTwo.setHand(storageDeck);
				teamTwoBlind = true;
			} else {
				playerTwoBet = playerTwo.bet();
			}
			System.out.println("Player Two has bet " + playerTwoBet + ".");
			playerThreeBet = playerThree.bet();
			System.out.println("Player Three has bet " + playerThreeBet + ".");
			if (playerFour.betBlind()) {
				System.out.println("Player Four has bet blind.");
				Deck storageDeck = playerFour.getHand();
				playerFour.setHand(ghostDeck);
				playerFourBet = playerFour.bet();
				playerFour.setHand(storageDeck);
				teamTwoBlind = true;
			} else {
				playerTwoBet = playerFour.bet();
			}
			System.out.println("Player Four has bet " + playerFourBet + ".");
		} else if (teamTwoScore - teamOneScore > 100) { // if team 2 is way ahead
			// Call on the players to bet.
			if (playerOne.betBlind()) {
				System.out.println("Player One has bet blind.");
				Deck storageDeck = playerOne.getHand();
				playerOne.setHand(ghostDeck);
				playerOneBet = playerOne.bet();
				playerOne.setHand(storageDeck);
				teamOneBlind = true;
			} else {
				playerOneBet = playerTwo.bet();
			}
			System.out.println("Player One has bet " + playerOneBet + ".");
			playerTwoBet = playerTwo.bet();
			System.out.println("Player Two has bet " + playerTwoBet + ".");
			if (playerThree.betBlind()) {
				System.out.println("Player Three has bet blind.");
				Deck storageDeck = playerThree.getHand();
				playerThree.setHand(ghostDeck);
				playerThreeBet = playerThree.bet();
				playerThree.setHand(storageDeck);
				teamOneBlind = true;
			} else {
				playerOneBet = playerTwo.bet();
			}
			System.out.println("Player Three has bet " + playerThreeBet + ".");
			playerFourBet = playerFour.bet();
			System.out.println("Player Four has bet " + playerFourBet + ".");
		}

		// Make sure the bets don't go overboard. Or underboard.
		teamOneBet = (playerOneBet + playerThreeBet);
		if (teamOneBet > 10) {
			teamOneBet = 10;
		}
		if (teamOneBet < 6 && teamOneBlind) {
			teamOneBet = 6;
		}

		// Ditto.
		teamTwoBet = (playerTwoBet + playerFourBet);
		if (teamTwoBet > 10) {
			teamTwoBet = 10;
		}
		if (teamTwoBet < 6 && teamTwoBlind) {
			teamTwoBet = 6;
		}

		// Print the bets.
		System.out.println("Team One has bet " + teamOneBet
				+ ". Team Two has bet " + teamTwoBet + ".");

	}

	/**
	 * Code that runs through a round of the game (1 round is 13 tricks).
	 * @throws Exception When various unaccounted for things occur.s
	 */
	private static void playRound() throws Exception {
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
			GUI.main(null);
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
			GUI.main(null);
			// Repeat above code for player three.
			play = playerThree.play();
			System.out.println("Player Three has played " + play);
			table.add(play);
			if (comparer.compare(highCard, play) > 0) {
				highCard = play;
				winnerBois = 3;
			}
			GUI.main(null);
			// Repeat above code for player four.
			play = playerFour.play();
			System.out.println("Player Four has played " + play);
			table.add(play);
			table.add(play);
			if (comparer.compare(highCard, play) > 0) {
				highCard = play;
				winnerBois = 4;
			}
			GUI.main(null);
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
			GUI.main(null);
			// Print the winning player and the number of tricks each team has won.
			System.out.println("WINNERBOIS = " + winnerBois);
			System.out.println("Team One tricks: " + teamOneTricks + ", "
					+ "Team Two tricks: " + teamTwoTricks + ".");
		} // Continue looping...
	}

	/**
	 * Get the cards currently on the table.
	 * @return The cards currently on the table.
	 */
	public static DeckImplementation getTableCards() {
		return table;
	}
	/**
	 * return if there is a user player.
	 * @return boolean
	 */
	public static boolean isUserPlayer() {
		return hasUserPlayer;
	}
	/**
	 * sets if there is a user player.
	 */
	public static void setUserPlayer() {
		hasUserPlayer = true;
	}
	/**
	 * This method determines who a given player's teammate is.
	 * @param player the player whose teammate you want to retrieve.
	 * @return the input player's teammate.
	 */
	public static SpadesPlayerBase getPlayerTeamMate(
			final SpadesPlayerBase player) {
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
/**
 * Sets the player by their number.
 * @param playerNum int
 * @param player SpadesPlayerBase
 */
	public static void setPlayerByNumber(final int playerNum,
			final SpadesPlayerBase player) {
		System.out.println(playerNum);
		switch (playerNum) {
		case 1: playerOne = player; break;
		case 2: playerTwo = player; break;
		case 3: playerThree = player; break;
		case 4: playerFour = player; break;
		default: throw new RuntimeException("HOW DID THIS HAPPEN :(");
		}
	}
}
