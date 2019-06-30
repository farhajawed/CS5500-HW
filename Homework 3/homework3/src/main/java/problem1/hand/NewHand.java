package problem1.hand;

import problem1.card.Card;
import problem1.rank.Rank;

/**
 * NewHand interface extends Hand interface and overrides hasCard method
 * to use custom-built hand iterator and implements two additional methods for 
 * counting the number of occurences of a card and rank in hand
 * @author farha
 * @version 1.1
 */
public interface NewHand extends Hand{

	/**
	 * It checks whether a card is present in hand.
	 * @param card
	 * @return true if card is present
	 */
	public Boolean hasCard(Card cardToFind);
	
	/**
	 * It counts the number of occurences of the given card in hand.
	 * @param card
	 * @return number of occurences of card
	 */
	public int occurencesInHand(Card card);
	
	
	/**
	 * It counts the number of occurences of the given rank in hand.
	 * @param card
	 * @return number of occurences of rank
	 */
	public int occurencesInHand(Rank rank);
	
}
