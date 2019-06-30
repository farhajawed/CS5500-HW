package problem2.card;

import problem2.rank.Rank;
import problem2.suit.Suit;

/**
 * Card interface provides methods for retrieving it's Rank and Suit.
 * @author farha
 * @version 1.0
 */
public interface Card {
	
	/**
	 * Returns Rank of the Card
	 * @return Rank object
	 */
	public Rank getRank();
	
	/**
	 * Returns Suit of the Card
	 * @return Suit object
	 */
	public Suit getSuit();

}
