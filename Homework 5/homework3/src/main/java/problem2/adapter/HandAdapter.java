package problem2.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import diErBao.Ka;
import diErBao.Shou;
import diErBao.ShouShiXia;
import problem2.card.Card;
import problem2.hand.NewHand;
import problem2.rank.Rank;
import problem2.suit.SuitComparator;

/**
 * HandAdapter class has a pointer to Shou and implements NewHand interface
 * @author farha
 * @version 1.2
 */
public class HandAdapter implements NewHand{

	private Shou shou;
	private List<Card>cards = new ArrayList<>();
	private List<Ka> sho = new ArrayList<>();
	
	/**
	 * Constructs HandAdapter with shou as parameter
	 * @param shou
	 * @exception IllegalArgumentException if shou is null
	 */
	public HandAdapter(Shou shou) {
		if(shou == null) {
			   throw new IllegalArgumentException("Ill formed card");
		}
		this.shou = shou;
	}
	
	
	/**
	 * It returns the list of card objects in hand
	 * @return list of card objects in hand
	 */
	@Override
	public List<Card> showCard() {
		sho = ((ShouShiXia) shou).showHand();
		cards = new ArrayList<>();
		for(Ka ka : sho) {
			Card card = new CardAdapter(ka);
			cards.add(card);
		}
		return cards;
	}

	/**
	 * It accepts a card object and is added to hand.
	 * @param card object
	 * @exception IllegalArgumentException if card is null
	 */
	@Override
	public void accept(Card card) {
		if(card == null) {
			   throw new IllegalArgumentException("Card cannot be null");
		}
		
		CardAdapter cardAdapt = (CardAdapter) card;
		cards.add(cardAdapt);
		shou.accept(cardAdapt.getKa());
	}
	
	/**
	 * It is used to pull the first card at index 0 from hand.
	 * @return card object pulled
	 * @exception IndexOutOfBoundsException if no card in hand
	 */
	@Override
	public Card pullCard() {
		if(((ShouShiXia) shou).getHandSize() < 0) {
			throw new IndexOutOfBoundsException("Hand is empty");
		}
		
		Ka ka = shou.pullKa();
		return new CardAdapter(ka);
		
	}
	
	/**
	 * It checks whether a card is present in hand.
	 * @param card
	 * @return true if card is present
	 * @exception IllegalArgumentException if argument is null
	 */
	@Override
	public Boolean hasCard(Card card) {
		if(card==null) {
			throw new IllegalArgumentException("Card cannot be null");
		}
		CardAdapter cardAdapt = (CardAdapter) card;
		return shou.hasKa(cardAdapt.getKa());
	}

	/**
	 * It sorts Card in order of rank, suit or rank & suit both.
	 * Eg. Cards can be ordered according to Suits: CLUBS, DIAMONDS, HEARTS, SPADES.
	 * Cards can be ordered on Rank e.g. TWO,THREE,FOUR....,JACK,QUEEN,KING,ACE.
	 * Cards can be ordered on Suit and Rank both: TWO CLUBS, TWO DIAMONDS, TWO HEARTS, 
	 * TWO SPADES,THREE CLUBS........ACE CLUBS, ACE DIAMONDS,ACE HEARTS, ACE SPADES. 
	 * @param guidance which has three values: "bySuit","byRank","bySuitRankBoth".
	 * @exception IllegalArgumentException if input matches neither of
	 * "bySuit","byRank","bySuitRankBoth".
	 */
	@Override
	public void sort(String guidance) {
		if(guidance!="bySuit" && guidance!="byRank" && guidance!="bySuitRankBoth") {
			throw new IllegalArgumentException("Invalid sort type. Available types are: bySuit, byRank, bySuitRankBoth");
		}
		else if(guidance=="byRank") {
			shou.sort();
		}
		else if(guidance == "bySuit") {
			sortBySuit();
		}
		else if(guidance == "bySuitRankBoth") {
			sortBySuit();
			shou.sort();
			
		}		
	}
	
	/**
	 * Helper function for sorting cards according to suit
	 */
	private void sortBySuit() {
		Collections.sort(cards,new SuitComparator());
		int n = ((ShouShiXia) shou).getHandSize();
		for(int i = 0; i<n;i++) {
			pullCard();
		}
		for(Card card : cards) {
			shou.accept(((CardAdapter) card).getKa());
		}
	}

	/**
	 * It shuffles the cards in random order
	 */
	@Override
	public void shuffle() {
		((ShouShiXia) shou).shuffle();	
	}

	/**
	 * It counts the number of occurences of the given card in hand.
	 * @param card
	 * @return number of occurences of card
	 */
	@Override
	public int occurencesInHand(Card card) {
		CardAdapter cardAdapt = (CardAdapter) card;
		Ka kaToFind = cardAdapt.getKa();
		sho = ((ShouShiXia) shou).showHand();
		int numberOfOccurences = 0;
		for(Ka ka : sho) {
			if(ka.equals(kaToFind)) {
				numberOfOccurences++;
			}
		}	
		return numberOfOccurences;
	}
	

	/**
	 * It counts the number of occurences of the given rank in hand.
	 * @param card
	 * @return number of occurences of rank
	 */
	@Override
	public int occurencesInHand(Rank rank) {
		int numberOfOccurences = 0;
		List<Card>cardInHand = showCard();
		for(Card card : cardInHand) {
			if(card.getRank().equals(rank)) {
				numberOfOccurences++;
			}
		}
		return numberOfOccurences;
	}

}
