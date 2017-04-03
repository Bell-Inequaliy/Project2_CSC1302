package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.List;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Deck;

/**
 * Controller class. Handles each individual game's stuffs.
 * @author J-Dierberger
 */
public class Controller {
	/**
	 * The cards that are on the table.
	 */
	private Deck table = new DeckImplementation();
	/**
	 * The score for this round.
	 */
	private int roundScore;
	/**
	 * The Dealer's team's bid.
	 */
	private int dealerBid;
	/**
	 * The dealer's opponent's team's bid.
	 */
	private int rivalBid;
	/**
	 * This is where the players are kept.
	 * Let's hope they don't figure out how to get out.
	 */
	private List<SpadesPlayer> players;
	/**
	 * The player whose turn it currently is.
	 */
	private SpadesPlayer currentPlayer;

	/**
	 * Constructs a Controller with input players.
	 * @param player1 is the dealer.
	 * @param player2 is the second player.
	 * @param player3 is the third player, player1's teammate.
	 * @param player4 is the fourth player, player2's teammate.
	 */
	public Controller(final SpadesPlayer player1, final SpadesPlayer player2,
			final SpadesPlayer player3, final SpadesPlayer player4) {
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		currentPlayer = player1;
	}

	/**
	 * Get the given player's team mate from the controller's array of players.
	 * @param player The player's team mate to get.
	 * @return The pointer to the player's team mate.
	 */
	public SpadesPlayer getTeamMate(final SpadesPlayer player) {
		// TODO Make this work.
		if (players.contains(player)) {
			if (players.indexOf(player) < 3) {
				return players.get(players.indexOf(players) + 2);
			} else {
				return players.get(players.indexOf(players) - 2);
			}
		} else {
			return null;
		}
	}
	/**
	 * Get the given player's team from the controller's array of players.
	 * 0 for Dealer's Team, 1 for Rival Team.
	 * @param player The player's team mate to get.
	 * @return A number representing the player's team.
	 */
	public int getTeam(final SpadesPlayer player) {
		// TODO Make this work.
		if (players.contains(player)) {
			if (players.indexOf(player) % 2 == 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}
	/**
	 * Get the cards that have been played (are on the table).
	 * @return The List of cards that have been played, ordered from P1 to P4.
	 */
	public List<Card> getPlayedCards() {
		return table;
	}
	/**
	 * plays a new card at the next spot.
	 * @param card The card being played.
	 */
	public void playCard(final Card card) {
		table.add(card);
	}
	/**
	 * This passes the turn to the next player.
	 */
	public void nextTurn() {
		currentPlayer = players.get(players.indexOf(currentPlayer) + 1);
	}
	/**
	 * Sets the bid for the dealer's team.
	 * @param bid the amount being bid
	 */
	public void setDealerBid(final int bid) {
		dealerBid = bid;
	}
	/**
	 * Sets the bid for the rival's team.
	 * @param bid the amount being bid
	 */
	public void setRivalBid(final int bid) {
		rivalBid = bid;
	}
	/**
	 * Returns the dealer team's bid.
	 * @return the aforementioned bid
	 */
	public int getDealerBid() {
		return dealerBid;
	}
	/**
	 * Returns the dealer team's bid.
	 * @return the aforementioned bid
	 */
	public int getRivalBid() {
		return rivalBid;
	}
	/**
	 * Sets the round's score.
	 * @param score the value of the score being set
	 */
	public void setScore(final int score) {
		roundScore = score;
	}
	/**
	 * This method returns the round's score.
	 * @return Take a wild guess.
	 */
	public int getScore() {
		return roundScore;
	}
}
