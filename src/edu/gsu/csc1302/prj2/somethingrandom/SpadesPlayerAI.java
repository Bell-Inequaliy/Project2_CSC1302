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
public class SpadesPlayerAI implements PlayerInterface{
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
	 * Comparator used for evaluating betting numbers.
	 */
	private int teamZeroOrOne;

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
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.SIX);
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
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.SIX);
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
		if (this.teamZeroOrOne == 0) {
			if (this.myController.getDealerBid() + bettingNumber >= 10) {
				bettingNumber = 10 - this.myController.getDealerBid();
			}
		} else {
			if (this.myController.getRivalBid() + bettingNumber >= 10) {
				bettingNumber = 10 - this.myController.getRivalBid();
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
		Card evaluationCard = null;
		int bettingNumber = 0;
		//Aggressive first
		if (this.playerType == 0) {
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.FOUR);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
					}
				}
			}
		} else if (this.playerType == 1) { //Chicken second
			for (int i = 0; i < this.hand.size(); i++) {

				evaluationCard = new Card(hand.get(i).getSuit(), Rank.SEVEN);
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
				if (Math.random() < .08) { //Yes this is almost a coin flip.
					bettingNumber++; // Yes they might report a different number each time
				} // Not sure if that's a problem or not. If it is, can be changed.
				}
			}
		} else if (this.playerType == 3) { //Intelligent last
			//if statement comparing scores between the two teams
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.FOUR);
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
	 * Evaluates which card to play onto a given hand, then returns it and removes
	 * it from the player's deck.
	 * @return Card
	 */
	public Card play() {
		Deck comparisonDeck = new DeckImplementation();
		Card playingCard = new Card(null, null);
		for (int i = 0; i < this.hand.size(); i++) {
			if (myController.getPlayedCards().get(0).getSuit()
				== hand.get(i).getSuit()) {
			comparisonDeck.add(hand.get(i));
			}
		}
		if (comparisonDeck.size() == 0) {
			comparisonDeck = hand;
		}
		for (int i = 0; i < comparisonDeck.size(); i++) {
			for (int j = 0; j < myController.getPlayedCards().size(); j++) {
				this.aiComparator = new
						SpadesComparatorImplementation(myController.getPlayedCards()
								.get(0).getSuit());
				if (aiComparator.compare(myController.getPlayedCards().get(j),
						comparisonDeck.get(i)) < 0) {
					if (aiComparator.compare(playingCard, comparisonDeck.get(i))
							< 0) {

					playingCard = comparisonDeck.get(i);
				}
				}
			}
		} if (playingCard.getSuit() == null) {
			playingCard = comparisonDeck.get(0);
		}
		hand.remove(playingCard);
		return playingCard;
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
		this.teamZeroOrOne = myController.getTeam(this);
	}

}
