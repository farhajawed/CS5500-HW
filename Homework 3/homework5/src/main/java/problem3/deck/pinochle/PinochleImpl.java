package problem3.deck.pinochle;

import problem3.card.CardImpl;
import problem3.card.EnumContainer;
import problem3.deck.DeckImpl;
import problem3.rank.Rank;
import problem3.rank.RankImpl;
import problem3.suit.Suit;
import problem3.suit.SuitImpl;

/**
 * It extends DeckImpl class. Pinochle deck consists of 48 Cards.
 * It is used to retrieve list of cards, 
 * shuffle and sort cards, cut deck at a point, pull card, check whether deck is empty and 
 * to get the official size of a Standard Deck.
 * @author farha
 * @version 1.0
 */
public class PinochleImpl extends DeckImpl implements Pinochle{
	
	/**
	 * Rank object
	 */
	private Rank rank;
	
	/**
	 * Suit object
	 */
	private Suit suit;
	
	/**
	 * Keeps number of copies of suits of Pinochle deck.
	 */
	public static final int SUIT_COPY = 2;
	
	
	/**
	 * Constructs PinochleImpl object with 48 cards in total and sets the official
	 * size of the deck.
	 * It is composed of ranks: NINE,TEN,J,Q,K and
	 * 4 suits defined in SuitsEnum in EnumContainer class with 2 copies of each
	 * : CLUBS, DIAMONDS, HEARTS, SPADES.
	 */
	public PinochleImpl() {		
		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
			suit = new SuitImpl(suitEnum.name());
			for(EnumContainer.PinochleRankEnum rankEnum : EnumContainer.PinochleRankEnum.values()) {
				rank = new RankImpl(rankEnum.name());
				for(int k = 0; k<SUIT_COPY; k++) {
					cardDeck.add(new CardImpl(rank,suit));
				}
			}
		}
		this.officialSize = cardDeck.size();
	}


}
