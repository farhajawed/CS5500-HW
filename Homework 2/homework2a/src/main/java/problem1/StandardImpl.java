package problem1;


/**
 * It extends DeckImpl class. Standard deck consists of 52 Cards.
 * It is used to retrieve list of cards, 
 * shuffle and sort cards, cut deck at a point, pull card, check whether deck is empty and 
 * to get the official size of a Standard Deck.
 * @author farha
 * @version 1.0
 */
public class StandardImpl extends DeckImpl implements Standard{
    
	/**
	 * Rank object
	 */
	private Rank rank;
	
	/**
	 * Suit object
	 */
	private Suit suit;
	
	
	/**
	 * Constructs StandardImpl object with 52 cards in total and sets the official
	 * size of the deck.
	 * It is composed of ranks: TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,J,Q,K and
	 * 4 suits defined in SuitsEnum in EnumContainer class: CLUBS, DIAMONDS, HEARTS, SPADES.
	 */
	public StandardImpl() {		
		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
			suit = new SuitImpl(suitEnum.name());
			for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
				rank = new RankImpl(rankEnum.name());
				cardDeck.add(new CardImpl(rank,suit));
			}
		}
		this.officialSize = cardDeck.size();
	}

}
