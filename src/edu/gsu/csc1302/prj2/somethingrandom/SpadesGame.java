package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.LinkedList;
import java.util.Scanner;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.Card.Rank;
import edu.gsu.csc1302.coll1.Card.Suit;
import edu.gsu.csc1302.coll1.Deck;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesPlayer;

/**
 * Spades Player to manage the generic game stuff.
 *
 * @author Wesley
 *
 */
public class SpadesGame {
	public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	LinkedList<Card> fullDeck = new LinkedList<>();
	LinkedList<Card> shuffledDeck = new LinkedList<>();
	Deck deck1 = null;
	Deck deck2 = null;
	Deck deck3 = null;
	Deck deck4 = null;


	for (Suit s : Suit.values()) {
		for (Rank r : Rank.values()) {
			Card adder = new Card(s,r);
			fullDeck.add(adder);

		}
	}

	for (int shuffleNum = 51; shuffleNum != 0; shuffleNum--) {
		int cardNum = (int) (Math.random() * shuffleNum);
		shuffledDeck.add(fullDeck.get(cardNum));
		fullDeck.remove(cardNum);
	}
	//shuffle that shit

	System.out.println("What play style would you like player Four to be?");
	SpadesPlayer playerOne = new SpadesPlayer((in.nextInt()), deck1);
	System.out.println("What play style would you like player Two to be??");
	SpadesPlayer playerTwo = new SpadesPlayer((in.nextInt()), deck2);
	System.out.println("What play style would you like player Three to be?");
	SpadesPlayer playerThree = new SpadesPlayer((in.nextInt()), deck3);
	System.out.println("What play style would you like player Four to be?");
	SpadesPlayer playerFour = new SpadesPlayer((in.nextInt()), deck4);


	in.close();
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