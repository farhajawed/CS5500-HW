package problem1;

/**
 * It extends DeckImpl class. Vegas deck is composed of 6 standard decks.
 * It can be built with any number of standard decks.
 * It is used to retrieve list of cards, 
 * shuffle and sort cards, cut deck at a point, pull card, check whether deck is empty and 
 * to get the official size of a Standard Deck.
 * @author farha
 * @version 1.0
 */
import java.util.List;

import problem1.Standard;
import problem1.StandardImpl;


public class VegasImpl extends DeckImpl implements Vegas{
	
	/**
	 * It instantiates StandardImpl object of type Standard
	 */
	private Standard standard = new StandardImpl();
	
	/**
	 * It stores the cards in standard deck which will
	 * be used for building vegas deck.
	 */
	private List<Card>cards = standard.getCards();	
	
	/**
	 * It represents the number of standard decks of a typical Vegas Blackjack deck
	 */
	public static final int DECK_COPY = 6;
	
	/**
	 * Constructs VegasImpl object with 312 cards in total i.e. composition
	 * of 6 standard decks and sets the official
	 * size of the deck.
	 * It is composed of ranks: TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,J,Q,K and
	 * 4 suits defined in SuitsEnum in EnumContainer class: CLUBS, DIAMONDS, HEARTS, SPADES.
	 */
	public VegasImpl() {	
		for(int i =0 ; i< DECK_COPY ; i++) {
			cardDeck.addAll(cards);
		}
		this.officialSize = cardDeck.size();
	}
	
	/**
	 * Constructs VegasImpl object with number of decks provided as arguments
	 * and sets the official size of the deck.
	 * It is composed of ranks: TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,J,Q,K and
	 * 4 suits defined in SuitsEnum in EnumContainer class: CLUBS, DIAMONDS, HEARTS, SPADES.
	 * @param numberOfDecks that is the number of copies of standard decks to create
	 */
	public VegasImpl(int numberOfDecks) {
		for(int i =0 ; i<numberOfDecks ; i++) {
			cardDeck.addAll(cards);
		}
		this.officialSize = cardDeck.size();
	}
}
