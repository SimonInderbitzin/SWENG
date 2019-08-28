package ch.fhnw.richards.topic06_Generics.solutions.deckWithEnum;

import java.util.ArrayList;

/**
 * This provides an example of using enums within an abstract class,
 * when the enums need to be set by the specific implementation in
 * the subclasses.
 * 
 * In this example, Suit can be defined once by the abstract class,
 * and is used by all subclasses. However, Rank differs by subclass.
 * Hence, Rank is an interface, and each subclass defines an enum
 * that implements this interface.
 */
public abstract class Deck {
	private ArrayList<Card> cards;
	
	public enum Suit { Spades, Hearts, Diamonds, Clubs };
	
	public class Card {
		private Suit suit;
		private Rank rank;
		
		public Card(Suit suit, Rank rank) {
			this.suit = suit;
			this.rank = rank;
		}

		public Suit getSuit() {
			return suit;
		}

		public Rank getRank() {
			return rank;
		}
	}
}
