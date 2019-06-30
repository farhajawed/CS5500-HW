package problem2;

/**
 * It extends DeckImpl class. Euchre deck consists of 24 Cards.
 * It is used to retrieve list of cards, 
 * shuffle and sort cards, cut deck at a point, pull card, check whether deck is empty and 
 * to get the official size of a Standard Deck.
 * @author farha
 * @version 1.0
 */
public class EuchreImpl extends DeckImpl implements Euchre{
    
	/**
	 * Rank object
	 */
	private Rank rank;
	
	/**
	 * Suit object
	 */
	private Suit suit;
	
	/**
	 * Constructs EuchreImpl object with 24 cards in total and sets the official
	 * size of the deck.
	 * It is composed of ranks: NINE,TEN,J,Q,K and
	 * 4 suits defined in SuitsEnum in EnumContainer class: CLUBS, DIAMONDS, HEARTS, SPADES.
	 */
	public EuchreImpl() {		
		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
			suit = new SuitImpl(suitEnum.name());
			for(EnumContainer.EuchreRankEnum rankEnum : EnumContainer.EuchreRankEnum.values()) {
				rank = new RankImpl(rankEnum.name());
				cardDeck.add(new CardImpl(rank,suit));
			}
		}
		this.officialSize = cardDeck.size();
	}

}
