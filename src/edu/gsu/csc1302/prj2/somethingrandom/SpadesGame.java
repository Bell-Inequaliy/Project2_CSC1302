package edu.gsu.csc1302.prj2.somethingrandom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	Scanner in = new Scanner(System.in);
	LinkedList<Card> FullDeck = new LinkedList<>();
	LinkedList<Card> ShuffledDeck = new LinkedList<>();
	private Deck deck1 = null;
	private Deck deck2 = null;
	private Deck deck3 = null;
	private Deck deck4 = null;
	

	for (Suit s : Suit.values()) {
		for (Rank r : Rank.values()) {
			Card adder = new Card(s,r);
			FullDeck.add(adder);

		}
	}

	for (int ShuffleNum = 51; ShuffleNum != 0; ShuffleNum-- ) {
		int CardNum = (int) (Math.random()*ShuffleNum);
		ShuffledDeck.add(FullDeck.get(CardNum));
		FullDeck.remove(CardNum);
	}
	
	//shuffle that shit

	System.out.println("What would you like the play style of player One to be?");
	SpadesPlayer playerOne = new SpadesPlayer((in.nextInt()), deck1);
	System.out.println("What would you like the play style of player Two to be?");
	SpadesPlayer playerTwo = new SpadesPlayer((in.nextInt()), deck2);
	System.out.println("What would you like the play style of player Three to be?");
	SpadesPlayer playerThree = new SpadesPlayer((in.nextInt()), deck3);
	System.out.println("What would you like the play style of player Four to be?");
	SpadesPlayer playerFour = new SpadesPlayer((in.nextInt()), deck4);
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