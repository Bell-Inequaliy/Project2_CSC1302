package edu.gsu.csc1302.prj2.somethingrandom;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.coll1.Deck;
/**
 * Class to manage the AI actions for the Spades AI players.
 *
 * @author stgilbert
 *
 */
public class SpadesPlayerAI implements PlayerInterface {
	/**
	 * Stores the behavior type of the given Player object.
	 */
	private int playerType;
	/**
	 * Stores the number of winnable hands after estimation. Not used yet.
	 */
	private int winningHands;
	/**
	 * Stores the hand of cards for the given Player object.
	 */
	private Deck hand;
	/**
	 * Stores the Controller for the given Player object.
	 */
	private Controller myController;
	/**
	 * Comparator used for evaluating betting numbers.
	 */
	private SpadesComparatorImplementation aiComparator;

	/**
	 * Sets this player's deck to be the deck it is dealt.
	 * @param deck Deck
	 */
	public void setHand(final Deck deck) {
		this.hand = deck;
	}

	/**
	 * Evaluates what to bet given the player's hand and its betting type.
	 * Returns the estimated number of winnable books.
	 * This should NEVER be player type.
	 * @return int
	 */
	public int bet() {
		Card evaluationCard = null;
		int bettingNumber = 0;
		//Aggressive first
		if (this.playerType == 0) {
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.FIVE);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
					}
				}
			}
		} else if (this.playerType == 1) { //Chicken second
			for (int i = 0; i < this.hand.size(); i++) {

				evaluationCard = new Card(hand.get(i).getSuit(), Rank.TEN);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
		} else if (this.playerType == 2) { //Wild-card third
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
				if (Math.random() < .05) { //Yes this is almost a coin flip.
					bettingNumber++;
				}
				}
			}
		} else if (this.playerType == 3) { //Intelligent last
			//if statement comparing scores between the two teams
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.FIVE);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
					}
				}
			}
			//else statement calling the other option.
			for (int i = 0; i < this.hand.size(); i++) {

				evaluationCard = new Card(hand.get(i).getSuit(), Rank.TEN);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
		}

		return bettingNumber;
	}

	/**
	 * Evaluates what CAN be won given the player's hand and its betting type.
	 * Returns the estimated number of potentially winnable books.
	 * @return int
	 */
	public int talk() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Evaluates which card to play onto a given hand, then returns it and removes
	 * it from the player's deck.
	 * @return Card
	 */
	public Card play() {
		return null;
	}

	/**
	 * Constructs the AI player according to the given parameters.
	 * @param type int
	 * @param controller Controller
	 */
	public SpadesPlayerAI(final int type, final Controller controller) {
		this.playerType = type;
		if (this.playerType > 4) {
			this.playerType = 4;
		}
		this.hand = null;
		this.myController = controller;
	}

}
