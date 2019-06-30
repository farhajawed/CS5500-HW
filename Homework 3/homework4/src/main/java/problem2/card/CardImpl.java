package problem2.card;

import java.util.Objects;

import problem2.rank.Rank;
import problem2.suit.Suit;

/**
 * CardImpl class consists of Rank and Suit objects. It is used to retrieve 
 * it's Rank and Suit, and to compare two Card objects.
 * @author farha
 * @version 1.0
 */
public class CardImpl implements Card{
	
	/**
	 * Rank object of CardImpl class
	 */
	private Rank rank;
	
	/**
	 * Suit object of CardImpl class
	 */
	private Suit suit;
    
	/**
	 * Constructs a CardImpl object with Rank and Suit objects
	 * @param rank of the card
	 * @param suit of the card
	 */
	public CardImpl(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns Rank of the Card
	 * @return Rank object
	 */
	public Rank getRank() {
		return this.rank;
	}
    
	/**
	 * Returns Suit of the Card
	 * @return Suit object
	 */
	public Suit getSuit() {
		return this.suit;
	}
	
	
	/**
	 * It compares two Card objects and returns true if two Cards have same rank name and suit name.
	 * @param object of Card instance
	 * @return true if both Cards have same rank and suit names.
	 */
	public boolean equals(Object o) {
		if(o instanceof Card) {
			Card c = (Card) o;
			return getRank().getName() == c.getRank().getName() && 
				   getSuit().getName() == c.getSuit().getName();
		}
		return false;
	}
	
	/**
	 * It overrides hashCode method as equals method has been overriden.
	 * @return the hashcode value of object
	 */
	 @Override
	 public int hashCode() {
	        return Objects.hash(rank,suit);
	 }
	 
     /**
      * Returns the object in string format with name of rank, suit, and symbol.
      * @return string with name of rank, suit, and symbol.
      */
	 @Override
	 public String toString() {
			return this.rank.getName()+" "+this.suit.getName()+" "+this.suit.getSymbol()+" \n";
	  }
}
