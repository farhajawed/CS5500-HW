package problem3.deck;

import problem3.rank.Rank;
import problem3.suit.Suit;

/**
 * DeckExtend extends Deck interface to provide
 * additional functionality of finding a suit
 * and a rank in a deck of cards
 * @author farha
 * @version 1.0
 */

public interface DeckExtend extends Deck{
	
	
	/**
	 * Return true if both rank and suit names are present
	 * in a card in Deck.
	 * @param rank
	 * @param suit
	 * @return true if rank and suit both are present in a card in deck.
	 */
	 public boolean contains(Rank rank, Suit suit);
	
}
