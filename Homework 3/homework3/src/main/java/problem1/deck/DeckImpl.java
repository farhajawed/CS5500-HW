package problem1.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import problem1.card.Card;
import problem1.rank.Rank;
import problem1.rank.RankComparator;
import problem1.suit.Suit;
import problem1.suit.SuitComparator;

/**
 * DeckImpl implements methods to retrieve list of cards in the deck, 
 * shuffle and sort cards, cut deck at a point, pull card, check whether deck is empty and 
 * to get the official size of a Deck of various kinds: Standard, Vegas, Pinochle and Euchre.
 * @author farha
 * @version 1.0
 */
public class DeckImpl implements DeckExtend{
	
	/**
	 * Creates an array list of Card objects
	 */
	protected List<Card>cardDeck = new ArrayList<Card>(); 
	
	/**
	 * Stores the official size of deck
	 */
	protected int officialSize;
	
	/**
	 * Returns a list of cards in the deck
	 * @return array list of cards
	 */
	public List<Card> getCards() {
		return cardDeck;
	}

	/**
	 * Shuffles the cards in random order
	 */
	public void shuffle() {
		Collections.shuffle(cardDeck);
	}

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
	public void sort(String guidance) {
		
		if(guidance!="bySuit" && guidance!="byRank" && guidance!="bySuitRankBoth") {
			throw new IllegalArgumentException
			("Invalid sort type. Available types are: bySuit, byRank, bySuitRankBoth");
		}	
	    else if(guidance == "bySuit") {
			Collections.sort(cardDeck,new SuitComparator());
		}
		else if(guidance == "byRank") {
			Collections.sort(cardDeck,new RankComparator());
		}
		else if(guidance == "bySuitRankBoth") {
			Collections.sort(cardDeck,new SuitComparator());
			Collections.sort(cardDeck,new RankComparator());	
		}	
	}
	
	/**
	 * It cuts the deck at a point which is cutPoint.
	 * Point in the deck is selected and first half of the deck is placed 
	 * at the bottom of the deck in order. 
	 * @param cutPoint
	 * @exception IndexOutOfBoundsException if cut point is greater than deck size
	 */
	public void cut(int cutPoint) {	
		if(cutPoint>cardDeck.size()) {
			throw new IndexOutOfBoundsException("Cut point should be less than deck size");
		}
		else {
			List<Card>cards = new ArrayList<Card>(); 
			for(int i =0 ; i<cutPoint-1; i++) {
				cards.add(cardDeck.get(0));
				cardDeck.remove(0);
			}
			cardDeck.addAll(cards);
		}
	}
	
	/**
	 * It is used for pulling the first card in the deck at index 0.
	 * Pulled card no longer remains in the deck.
	 * @return Card object which is pulled
	 * @exception IndexOutOfBoundsException if there are no cards in deck.
	 */
	public Card pullCard() {
		if(cardDeck.isEmpty()) {
			throw new IndexOutOfBoundsException("No cards in deck");
		}
		return cardDeck.remove(0);
	}

	/**
	 * Checks whether the deck is empty.
	 * @return true if deck is empty, false otherwise.
	 */
	public boolean emptyDeck() {
		return cardDeck.isEmpty();
	}

	/**
	 * Returns the original size of the deck. Eg. 52 for standard deck, 24 for Euchre
	 * deck, 48 for Pinochle deck, 312 for typical Vegas Deck, and different values
	 * depending on the size of Vegas deck.
	 * @return size of deck in integer
	 */
	public int officialSize() {
		return this.officialSize;
	}
	
	/**
	 * Return true if both rank and suit names are present
	 * in a card in Deck.
	 * @param rank
	 * @param suit
	 * @return true if rank and suit both are present in a card in deck.
	 */
	 public boolean contains(Rank rank, Suit suit) {
		   for (Card card: cardDeck) {
			   if ((rank.getName() == card.getRank().getName()) && 
				          (suit.getName() == card.getSuit().getName())) {
				   return true;
			   }
		   }	    	 
		   return false; 
     }
	
	
}
	

