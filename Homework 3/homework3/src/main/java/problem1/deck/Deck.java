package problem1.deck;

import java.util.List;

import problem1.card.Card;
/**
 * Deck consists of a list of Cards. 
 * It provides interface to retrieve list of cards, 
 * shuffle and sort cards, cut deck at a point, pull card, check whether deck is empty and 
 * to get the official size of a Deck of various kinds: Standard, Vegas, Pinochle and Euchre.
 * @author farha
 * @version 1.0
 */
public interface Deck {
	
	/**
	 * Returns a list of cards in the deck
	 * @return array list of cards
	 */
	public List<Card> getCards();
	
	/**
	 * Shuffles the cards in random order
	 */
	public void shuffle();
	
	/**
	 * It sorts Card in order of rank, suit or rank & suit both.
	 * Eg. Cards can be ordered according to Suits: CLUBS, DIAMONDS, HEARTS, SPADES.
	 * Cards can be ordered by Rank: TWO,THREE,FOUR....,J,Q,K,A for standard deck.
	 * Cards can be ordered by Suit and Rank both: TWO CLUBS, TWO DIAMONDS, TWO HEARTS, 
	 * TWO SPADES,THREE CLUBS........A CLUBS, A DIAMONDS,A HEARTS, A SPADES. 
	 * @param guidance which has three values: "bySuit","byRank","bySuitRankBoth".
	 * @exception IllegalArgumentException if input matches neither of
	 * "bySuit","byRank","bySuitRankBoth".
	 */
	public void sort(String guidance);
	
	/**
	 * It cuts the deck at a point which is cutPoint.
	 * Point in the deck is selected and first half of the deck is placed 
	 * at the bottom of the deck in order. 
	 * @param cutPoint at which deck is to be cut
	 * @exception IndexOutOfBoundsException if cut point is greater than deck size
	 */
	public void cut(int cutPoint);
	
	/**
	 * It is used for pulling the first card in the deck at index 0.
	 * Pulled card no longer remains in the deck.
	 * @return Card object which is pulled
	 * @exception IndexOutOfBoundsException if there are no cards in deck.
	 */
	public Card pullCard();
	
	/**
	 * Checks whether the deck is empty.
	 * @return true if deck is empty, false otherwise.
	 */
	public boolean emptyDeck();
	
	/**
	 * Returns the official size of the deck. Eg. 52 for standard deck, 24 for Euchre
	 * deck, 48 for Pinochle deck, 312 for typical Vegas Deck, and different values
	 * depending on the size of Vegas deck.
	 * @return size of deck in integer
	 */
	public int officialSize();
}
