package edu.gsu.csc1302.prj2.somethingrandom.player;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.prj2.somethingrandom.SpadesGame;

/**
 * User SpadesPlayer class.
 * @author stgilbert
 * @author J-Dierberger
 * @author ya boi Wesley
 *
 */
public class SpadesPlayerUser extends SpadesPlayerBase {

	@Override
	public final boolean betBlind() throws Exception {
		System.out.println("Do you want to bet blind? Y/N");
		while (true) { //loop till we get a valid response
			char r = SpadesGame.IN.readLine().charAt(0);
			if (r == 'Y') {
				return true;
			} else if (r == 'N') {
				return false;
			}
			System.out.println("Invalid input, please return Y or N");
		}
	}

	@Override
	public final int bet() {
		System.out.println(hand);

		int r = -1;
		while (r == -1) {
			try {
				System.out.println("Enter your bet:");
				r = (int) Math.abs(Integer.parseInt(SpadesGame.IN.readLine()));
			} catch (Exception e) {
				System.out.println("Please enter a number.");
			}
		}

		if (r > 13) {
			r = 13;
		}
		return r;
	}

	@Override
	public final int talk() {
		int r = -1;
		while (r == -1) {
			try {
				System.out.println("Enter how many books you think you can win:");
				r = (int) Math.abs(Integer.parseInt(SpadesGame.IN.readLine()));
			} catch (Exception e) {
				System.out.println("Please enter a number.");
			}
		}
		return r;
	}

	@Override
	public final Card play() throws Exception {
		Card r = null;
		// Loop till we break (when we get a card)
		while (true) {
			// Get user input and parse it for the switch statement.
			System.out.println("What would you like to do? (type \"?\" for help)");
			String str = SpadesGame.IN.readLine().toLowerCase();
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
						"\"play(NUM)\": Play the card of the given RANK and SUIT.");
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
				System.out.print("[");
				for (int l = 1; l <= hand.size(); l++) {
					int lengthOfCard = hand.get(l - 1).toString().length();
					for (int m = 0; m < lengthOfCard / 2 - 1; m++) {
						System.out.print(" ");
					}
					System.out.print(" " + l);
					for (int m = 0; m < lengthOfCard / 2; m++) {
						System.out.print(" ");
					}
					System.out.print(" ");
				}
				System.out.print("]");
				System.out.println();
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
					r = hand.remove(Integer.parseInt(command[1]) - 1);
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
