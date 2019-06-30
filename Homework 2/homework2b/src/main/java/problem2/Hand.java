package problem2;

import java.util.List;

/**
 * Hand interface provides methods for showing cards in a player's
 * hands,accepting a card, pulling cards out of hand, checking whether a
 * particular card is present in hand, sorting and shuffling cards.
 * @author farha
 * @version 1.0
 */
public interface Hand {
	
	/**
	 * It returns the list of card objects in hand
	 * @return list of card objects in hand
	 */
	public List<Card> showCard();
	
	/**
	 * It accepts a card object and is added to hand.
	 * @param card object
	 */
	public void accept(Card card);
	
	/**
	 * It is used to pull the first card at index 0 from hand.
	 * @return card object pulled
	 */
	public Card pullCard();
	
	/**
	 * It checks whether a card is present in hand.
	 * @param card
	 * @return true if card is present
	 */
	public Boolean hasCard(Card card);
	
	/**
	 * It sorts Card in order of rank, suit or rank & suit both.
	 * Eg. Cards can be ordered according to Suits: CLUBS, DIAMONDS, HEARTS, SPADES.
	 * Cards can be ordered on Rank e.g. TWO,THREE,FOUR....,J,Q,K,A.
	 * Cards can be ordered on Suit and Rank both: TWO CLUBS, TWO DIAMONDS, TWO HEARTS, 
	 * TWO SPADES,THREE CLUBS........A CLUBS, A DIAMONDS,A HEARTS, A SPADES. 
	 * @param guidance which has three values: "bySuit","byRank","bySuitRankBoth".
	 * @exception IllegalArgumentException if input matches neither of
	 * "bySuit","byRank","bySuitRankBoth".
	 */
	public void sort(String guidance);
	
	/**
	 * It shuffles the cards in random order
	 */
	public void shuffle();
	

}
