package edu.gsu.csc1302.prj2.somethingrandom;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.coll1.Deck;

/**
 * Spades Player to manage the four AI player types and the user player.
 *
 * @author stgilbert
 * @author J-Dierberger
 *
 */
public class SpadesPlayer extends DrSeuss {

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
	 * Comparator used for evaluating betting numbers.
	 */
	private SpadesComparatorImplementation aiComparator;

	/**
	 * Player constructor.
	 * @param type Player type to use.
	 */
	public SpadesPlayer(final int type) {
		super();
		playerType = type;
		if (playerType > 4) {
			playerType = 4;
		}
		hand = null;
	}

	/**
	 * Set the player's hand equal to the given deck.
	 * @param deck Deck
	 */
	public void setHand(final Deck deck) {
		hand = deck;
	}
	/**
	 * Return a player's hand.
	 * @return deck Deck
	 */
	public Deck getHand() {
		return hand;
	}
	/**
	 * This method returns if the Player wishes to bet blind or not.
	 * @return boolean
	 */
	public boolean betBlind() {
		switch (playerType) {
		case TYPE_AGGRESSIVE:
			return true;
		case TYPE_CHICKEN:
			return false;
		case TYPE_WILDCARD:
			return Math.random() < .05;
		case TYPE_INTELLIGENT:
			return true;
		case TYPE_USER:
			System.out.println("Do you want to bet blind? Y/N");
			while (true) { //loop till we get a valid response
			char r = SpadesGame.IN.next().charAt(0);
			if (r == 'Y') {
				return true;
			} else if (r == 'N') {
				return false;
			}
			System.out.println("Invalid input, please return Y or N");
			}

		default:
			throw new RuntimeException(//HOW DID WE GET HERE?!?
					"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}

	}

	/**
	 * Return the number the player or AI thinks they can win this round.
	 * @return int
	 */
	public int bet() {
		int r = 0;
		Card evaluationCard = null;
		int bettingNumber = 0;

		switch (playerType) {
		case TYPE_AGGRESSIVE: // This player type bets on any card stronger than a
			for (int i = 0; i < this.hand.size(); i++) { // six, and all Spades.
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
					evaluationCard = new Card(hand.get(i).getSuit(), Rank.JACK);
					this.aiComparator = new
							SpadesComparatorImplementation(this.hand.get(i).getSuit());
					if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
						bettingNumber++;
					}
				}
			}
			break;
		case TYPE_CHICKEN: //This player only bets on face cards.
			for (int i = 0; i < this.hand.size(); i++) {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.KING);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
			System.err.println("BET BOI " + bettingNumber);
			bettingNumber = (int) Math.ceil(bettingNumber / 2);
			bettingNumber = (int) (bettingNumber * (Math.random() * .5 + .5));
			break;
		case TYPE_WILDCARD: //This player bets randomly.
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
					if (Math.random() < .03) { //Yes this is almost a coin flip.
						bettingNumber++;
					}
				}
			}
			break;
		case TYPE_INTELLIGENT: //This player bets on cards higher than 8,
			for (int i = 0; i < this.hand.size(); i++) { // and spades.
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
					evaluationCard = new Card(hand.get(i).getSuit(), Rank.KING);
					this.aiComparator = new
							SpadesComparatorImplementation(this.hand.get(i).getSuit());
					if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
						bettingNumber++;
					}
				}
			}
			bettingNumber = (int) (bettingNumber * (Math.random() * .5 + .5));
			break;
		case TYPE_USER: //User makes their own bet.
			System.out.println(hand);
			System.out.println("Enter your bet:");
			r = Integer.parseInt(SpadesGame.IN.nextLine());
			if (r > 13) {
				r = 13;
			}
			return r;
		default:
			throw new RuntimeException(//HOW DID WE GET HERE?!?
					"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}
		r = bettingNumber;
		return r;
	}

	/**
	 * Return the number of cards the player (AI) thinks it can win with.
	 * @return int
	 */
	public int talk() {
		int r = 0;
		Card evaluationCard = null;
		int bettingNumber = 0;
		switch (playerType) {
		case TYPE_AGGRESSIVE: //Thinks it can win anything better than 4.
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
					evaluationCard = new Card(hand.get(i).getSuit(), Rank.NINE);
					this.aiComparator = new
							SpadesComparatorImplementation(this.hand.get(i).getSuit());
					if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
						bettingNumber++;
					}
				}
			}
			r = bettingNumber;
			break;
		case TYPE_CHICKEN: //Thinks it can win on things better than 7.
			for (int i = 0; i < this.hand.size(); i++) {
				evaluationCard = new Card(hand.get(i).getSuit(), Rank.JACK);
				this.aiComparator = new
						SpadesComparatorImplementation(this.hand.get(i).getSuit());
				if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
					bettingNumber++;
				}
			}
			bettingNumber = bettingNumber / 2;
			r = bettingNumber;
			break;
		case TYPE_WILDCARD:
			for (int i = 0; i < this.hand.size(); i++) { //Thinks it can win randomly.
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
					if (Math.random() < .05) { //Yes this is almost a coin flip.
						bettingNumber++; //Yes they might report different numbers each time
					} // Not sure if that's a problem or not. If it is, can be changed.
				}
			} r = bettingNumber;
			break;
		case TYPE_INTELLIGENT: //Thinks it can win on cards higher than 6.
			for (int i = 0; i < this.hand.size(); i++) {
				if (this.hand.get(i).getSuit() == Suit.SPADE) {
					bettingNumber++;
				} else {
					evaluationCard = new Card(hand.get(i).getSuit(), Rank.JACK);
					this.aiComparator = new
							SpadesComparatorImplementation(this.hand.get(i).getSuit());
					if (aiComparator.compare(evaluationCard, hand.get(i)) > 0) {
						bettingNumber++;
					}
				}
			}
			bettingNumber = (int) (bettingNumber * (Math.random() * .5 + .5));
			r = bettingNumber;
			break;
		case TYPE_USER: //Player talks to themselves.
			System.out.println("Enter how many books you think you can win:");
			r = Integer.parseInt(SpadesGame.IN.nextLine());
			break;
		default:
			throw new RuntimeException(
					"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}
		return r;
	}

	/**
	 * Play a card from the player's hand to the board.
	 * @return card
	 */
	public Card play() { //AI plays to win every round.
		Card r = null;
		switch (playerType) {
		case TYPE_AGGRESSIVE:
			r = aiPlay();
			break;
		case TYPE_CHICKEN:
			r = aiPlay();
			break;
		case TYPE_WILDCARD:
			r = aiPlay();
			break;
		case TYPE_INTELLIGENT:
			r = aiPlay();
			break;
		case TYPE_USER:
			r = playerTurn();
			break;
		default:
			throw new RuntimeException(
					"DEFAULT CASE IN SWITCH THAT SHOULDN'T DEFAULT");
		}
		return r;
	}

	/**
	 * Code for the AI to play a card.
	 * @return The card the AI chooses to play.
	 */
	private Card aiPlay() {
		Deck comparisonDeck = new DeckImplementation();
		Card playingCard = new Card(null, null);
		if (SpadesGame.getTableCards().size() == 0) {
			playingCard = hand.get(0);
			hand.remove(playingCard);
			return playingCard;
		}
		if (SpadesGame.getTableCards().size() != 0) {
			for (int i = 0; i < this.hand.size(); i++) {
				if (SpadesGame.getTableCards().get(0).getSuit()
						== hand.get(i).getSuit()) {
					comparisonDeck.add(hand.get(i));
				}
			}
			if (comparisonDeck.size() == 0) {
				comparisonDeck = hand;
			} //TLDR: It looks for any card that beats the board that's legal.
			//Failing that, or given any edge case, it plays its first card.
			for (int i = 0; i < comparisonDeck.size(); i++) {
				for (int j = 0; j < SpadesGame.getTableCards().size(); j++) {
					this.aiComparator = new
							SpadesComparatorImplementation(SpadesGame.getTableCards()
									.get(0).getSuit());
					if (aiComparator.compare(SpadesGame.getTableCards().get(j),
							comparisonDeck.get(i)) < 0) {
						//	System.out.println(playingCard);
						//	System.out.println(comparisonDeck);
						if (playingCard.getSuit() == null) {
							playingCard = comparisonDeck.get(i);
						} else if (aiComparator.compare(playingCard, comparisonDeck.get(i))
								< 0) {

							playingCard = comparisonDeck.get(i);
						}
					}
				}
			} if (playingCard.getSuit() == null) {
				playingCard = comparisonDeck.get(0);
			}
		} else {
			playingCard = hand.get(0);
		}
		hand.remove(playingCard);
		return playingCard;
	}

	/**
	 * The turn method is called when it's the player's turn.
	 * When it's the players turn, they need to be able to do
	 * various tasks.
	 * Thus, to de-clutter code I made a method exclusively for
	 * handling the code to ask the player what they want to do
	 * and performing those actions.
	 * @return The card the player has chosen to play
	 */
	private Card playerTurn() {
		Card r = null;
		// Loop till we break (when we get a card)
		while (true) {
			// Get user input and parse it for the switch statement.
			System.out.println("What would you like to do? (type \"?\" for help)");
			String str = SpadesGame.IN.nextLine().toLowerCase();
			String[] command;

			// The string will only contain () if the player is providing args.
			if (str.contains("(") || str.contains(")")) {
				// Separate the command from the () contents
				str = str.replace("(", " ").replace(")", " ");
				command = str.split(" ");
			} else {
				/*
				 * Otherwise just set the arguments to be the command.
				 * That way we can just switch off the arguments (so that
				 * if they player uses a command with args we won't need a
				 * separate switch statement then if they use a command
				 * without args).
				 */
				command = new String[]{str};
			}

			switch (command[0]) {
			case "?":
				System.out.println(
						"\"talk\": Ask your teammate how many books they can win");
				System.out.println(
						"\"view_hand\": View the cards in your hand");
				System.out.println(
						"\"view_table\": View the cards on the table");
				System.out.println(
						"\"play(RANK SUIT)\": Play the card of the given RANK and SUIT.");
				break;
			case "help":
				System.out.println(
						"\"talk\": Ask your teammate how many books they can win");
				System.out.println(
						"\"view_hand\": View the cards in your hand");
				System.out.println(
						"\"view_table\": View the cards on the table");
				System.out.println(
						"\"play(NUM)\": Play the card at the given NUM in your hand.");
				break;
			case "talk":
				System.out.println("Your team mate estimates they can win "
						+ SpadesGame.getPlayerTeamMate(this).talk() + "books.");
				break;
			case "view_hand":
				System.out.println("Your hand:");
				System.out.println(hand);
				break;
			case "view_table":
				System.out.println(
						"Cards on the table (P1 -> P4; null means not played):");
				System.out.println(SpadesGame.getTableCards());
				break;
			case "play":
				// Make sure args are given and that they're correct
				if (command.length == 1) {
					System.out.println(
							"You have not provided any information about what card to play!"
							);
					System.out.println("Please try again.");
					break;
				}
				try {
					r = hand.get(Integer.parseInt(command[1]) - 1);
				} catch (Exception e) {
					System.out.println("You entered an invalid integer! Please make sure "
							+ "it isn't larger than your hand and that it is a whole number."
							);
				}
				break;
			default:
				System.out.println("I'm sorry, that is not a valid command.");
				break;
			}
			if (r != null) {
				break;
			}
		}
		return r;
	}

}
