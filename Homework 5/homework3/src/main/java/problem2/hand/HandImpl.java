package problem2.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import problem2.card.Card;
import problem2.rank.RankComparator;
import problem2.suit.SuitComparator;

/**
 * Hand interface provides methods for showing cards in a player's
 * hands,accepting a card, pulling cards out of hand, checking whether a
 * particular card is present in hand, sorting and shuffling cards.
 * @author farha
 * @version 1.0
 */
public class HandImpl implements Hand{
	
	/**
	 * Initializes an array list of cards in hand which is initially empty.
	 */
	protected List<Card>cards;
	
   
	
	public HandImpl() {
		cards = new ArrayList<Card>();
	}
	
	/**
	 * It returns the list of card objects in hand
	 * @return list of card objects in hand
	 */
	public List<Card> showCard() {
		return cards;
	}
    
	/**
	 * It accepts a card object and is added to hand.
	 * @param card object
	 */
	public void accept(Card card) {
		if(card!=null) {
			cards.add(card);
		}
	}
    
	/**
	 * It is used to pull the first card at index 0 from hand.
	 * @return card object pulled
	 */
	public Card pullCard() {
		return cards.remove(0);
	}
	
	
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
	public void sort(String guidance) {
		if(guidance!="bySuit" && guidance!="byRank" && guidance!="bySuitRankBoth") {
			throw new IllegalArgumentException("Invalid sort type. Available types are: bySuit, byRank, bySuitRankBoth");
		}
		else if(guidance == "bySuit") {
			Collections.sort(cards,new SuitComparator());
		}
		else if(guidance == "byRank") {
			Collections.sort(cards,new RankComparator());
		}
		else if(guidance == "bySuitRankBoth") {
			Collections.sort(cards,new SuitComparator());
			Collections.sort(cards,new RankComparator());
			
		}	
	}

	/**
	 * It checks whether a card is present in hand.
	 * @param card
	 * @return true if card is present
	 */
	public Boolean hasCard(Card cardToFind) {
		Boolean found = false;
		for(Card card: cards) {
			if(card.equals(cardToFind)) {
		    	found = true;
		    }
		}
		return found;
	}
	
	/**
	 * It shuffles the cards in random order
	 */
	public void shuffle() {
		Collections.shuffle(cards);	
	}
	
	
}
