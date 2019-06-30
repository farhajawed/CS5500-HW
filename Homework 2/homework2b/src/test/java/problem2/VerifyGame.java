package problem2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


/**
 * Tests for verifying game.
 * @author farha
 * @version 1.0
 */
public class VerifyGame {

	private int STANDARD_DECK_SIZE=52;
	private int EUCHRE_DECK_SIZE=24;
	private int PINOCHLE_DECK_SIZE=48;
	private static int STANDARD_DECK_COPY = 8;
	
	/**
     * Test for creation of deck by game when deck type
     * doesn't match with Standard, Vegas, Pinochle or Euchre
     * Expected output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalDeckInputInGame() {
    	Game game = new GameImpl();
    	game.createDeck("standrd");
    }
    
    /**
     * Test for Standard deck construction by game
     * Expected output: Cards contained in the deck and number of cards will match.
     */
    @Test
    public void testForStandardDeckCreationByGame() {
    	Game game = new GameImpl();
    	game.createDeck("Standard");
    	Deck deck = ((GameImpl) game).getDeck();
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
			Suit suit = new SuitImpl(suitEnum.name());
			for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
				Rank rank = new RankImpl(rankEnum.name());
				assertEquals(true,((DeckImpl) deck).contains(rank,suit));
			}
		}
    	assertEquals(STANDARD_DECK_SIZE,deck.officialSize()); 	
    }
    
    /**
     * Test for Pinochle deck construction by game.
     * Expected output: Cards contained in the deck and number of cards will match.
     */
    @Test
    public void testForPinochleDeckCreationByGame() {
    	Game game = new GameImpl();
    	game.createDeck("Pinochle");
    	Deck deck = ((GameImpl) game).getDeck();
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
			Suit suit = new SuitImpl(suitEnum.name());
			for(EnumContainer.EuchreRankEnum rankEnum : EnumContainer.EuchreRankEnum.values()) {
				Rank rank = new RankImpl(rankEnum.name());
				assertEquals(true,((DeckImpl) deck).contains(rank,suit));
			}
		}
    	assertEquals(PINOCHLE_DECK_SIZE,deck.officialSize());
    }
    
    /**
     * Test for Euchre deck construction by game
     * Expected output: Cards contained in the deck and number of cards will match.
     */
    @Test
    public void testForEuchreDeckCreationByGame() {
    	Game game = new GameImpl();
    	game.createDeck("Euchre");
    	Deck deck = ((GameImpl) game).getDeck();
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
			Suit suit = new SuitImpl(suitEnum.name());
			for(EnumContainer.EuchreRankEnum rankEnum : EnumContainer.EuchreRankEnum.values()) {
				Rank rank = new RankImpl(rankEnum.name());
				assertEquals(true,((DeckImpl) deck).contains(rank,suit));
			}
		}
    	assertEquals(EUCHRE_DECK_SIZE,deck.officialSize());
    }
    
    /**
     * Test for Vegas deck construction by game
     * Expected output: Cards contained in the deck and number of cards will match.
     */
    @Test
    public void testForVegasDeckCreationByGame() {
    	Game game = new GameImpl();
    	game.createDeck("Vegas",STANDARD_DECK_COPY);
    	Deck deck = ((GameImpl) game).getDeck();
    	for(int i = 0; i< STANDARD_DECK_COPY; i++) {
    		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    			Suit suit = new SuitImpl(suitEnum.name());
    			for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
    				Rank rank = new RankImpl(rankEnum.name());
    				assertEquals(true,((DeckImpl) deck).contains(rank,suit));
    			}
    		}
    	}	
    	assertEquals(STANDARD_DECK_SIZE*STANDARD_DECK_COPY,deck.officialSize()); 	
    }
    

    
    /**
     * Test for creation of deck when deck name is not equal to Vegas
     * in createDeck function with 2 arguments
     * Expected Output: IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalDeckNameInVegasDeckConstructiond() {
    	Game game = new GameImpl();
    	game.createDeck("Standard",1);
    }
    
    
    /**
     * Test for multiple hand construction while dealing cards
     * Expected output: Hand size will be 5.
     */
    @Test
    public void testForMultipleHandConstruction() {
    	Game game = new GameImpl();
    	game.createDeck("Standard");
    	game.setNumberOfHands(5);
    	game.deal();
    	List<Hand>hands = ((GameImpl) game).getHands();
    	assertEquals(5, hands.size());
    }
    
    /**
     * Test for card not in deck after pulled by hand.
     */ 
    @Test
    public void testForCardNotInDeckAfterPull() {
    	GameExtend game = new GameImpl();
    	game.createDeck("Standard");
    	game.setNumberOfHands(5);
    	game.deal();
    	List<Hand>hands = ((GameImpl) game).getHands();
    	Hand hand = hands.get(0);
    	Card cardPulled = hand.pullCard();
    	Deck deck = game.getDeck();
    	assertEquals(false,((DeckImpl) deck).contains(cardPulled.getRank(),cardPulled.getSuit()));
    }
   
    
    /**
     * Test for distributing specific number(5) of cards among all hands
     * Expected output: Each hand will have 5 cards
     */
    @Test
    public void testForDealingFiveCardsAmongHands() {
    	Game game = new GameImpl();
    	game.createDeck("Standard");
    	game.setNumberOfHands(5);
    	game.deal();
    	List<Hand>hands = ((GameImpl) game).getHands();
    	for(Hand hand:hands) {
    		assertEquals(GameImpl.NUMBER_OF_CARDS,hand.showCard().size()); 
    	} 		
    }
    
    
    /**
     * Test for dealing cards among hands when there are more hands than cards
     * Expected output: IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testForMoreHandsThanPlayers() {
    	Game game = new GameImpl();
    	game.createDeck("Pinochle");
    	game.setNumberOfHands(25);
    	game.deal();
    }
    
    /**
     * Test for dealing cards among hands when cards cannot be evenly distributed
     * among hands
     * Expected output: IndexOutOfBoundsException as 24 Euchre deck cards 
     * cannot be evenly distributed among 5 players each with 5 cards.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testForUnevenCardDistribution() {
    	Game game = new GameImpl();
    	game.createDeck("Euchre");
    	game.setNumberOfHands(5);
    	game.deal();
    }
	
		
}
