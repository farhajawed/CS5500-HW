package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Tests for verifying deck.
 * @author farha
 * @version 1.0
 */
public class VeriyDeck {
	
	private int STANDARD_DECK_SIZE=52;
	private int EUCHRE_DECK_SIZE=24;
	private int PINOCHLE_DECK_SIZE=48;
	private static int STANDARD_DECK_COPY = 8;
	
	Rank rankTwo = new RankImpl("TWO");
	Rank rankThree = new RankImpl("THREE");
	Rank rankFour = new RankImpl("FOUR");
	Rank rankFive = new RankImpl("FIVE");
	Rank rankSix = new RankImpl("SIX");
	Rank rankSeven = new RankImpl("SEVEN");
	Rank rankEight = new RankImpl("EIGHT");
	Rank rankNine = new RankImpl("NINE");
	Rank rankTen = new RankImpl("TEN");
	Rank rankJ = new RankImpl("J");
	Rank rankQ = new RankImpl("Q");
	Rank rankK = new RankImpl("K");
	Rank rankA = new RankImpl("A");
	
   
	Suit suitClubs = new SuitImpl("CLUBS");
	Suit suitDiamonds = new SuitImpl("DIAMONDS");
	Suit suitHearts = new SuitImpl("HEARTS");
	Suit suitSpades = new SuitImpl("SPADES");
	
	Card card1 = new CardImpl(rankTwo,suitClubs);
	Card card2 = new CardImpl(rankThree, suitClubs);
	Card card3 = new CardImpl(rankFour, suitClubs);
	Card card4 = new CardImpl(rankFive, suitClubs);
	Card card5 = new CardImpl(rankSix, suitClubs);
	Card card6 = new CardImpl(rankSeven, suitClubs);
	Card card7 = new CardImpl(rankEight, suitClubs);
	Card card8 = new CardImpl(rankNine, suitClubs);
	Card card9 = new CardImpl(rankTen, suitClubs);
	Card card10 = new CardImpl(rankJ, suitClubs);
	Card card11 = new CardImpl(rankQ, suitClubs);
	Card card12 = new CardImpl(rankK, suitClubs);
	Card card13 = new CardImpl(rankA, suitClubs);
	Card card14 = new CardImpl(rankTwo,suitDiamonds);
	Card card15 = new CardImpl(rankThree, suitDiamonds);
	Card card16 = new CardImpl(rankFour, suitDiamonds);
	Card card17 = new CardImpl(rankFive, suitDiamonds);
	Card card18 = new CardImpl(rankSix, suitDiamonds);
	Card card19 = new CardImpl(rankSeven, suitDiamonds);
	Card card20 = new CardImpl(rankEight, suitDiamonds);
	Card card21 = new CardImpl(rankNine, suitDiamonds);
	Card card22 = new CardImpl(rankTen, suitDiamonds);
	Card card23 = new CardImpl(rankJ, suitDiamonds);
	Card card24 = new CardImpl(rankQ, suitDiamonds);
	Card card25 = new CardImpl(rankK, suitDiamonds);
	Card card26 = new CardImpl(rankA, suitDiamonds);
	Card card27 = new CardImpl(rankTwo,suitHearts);
	Card card28 = new CardImpl(rankThree, suitHearts);
	Card card29 = new CardImpl(rankFour, suitHearts);
	Card card30 = new CardImpl(rankFive, suitHearts);
	Card card31 = new CardImpl(rankSix, suitHearts);
	Card card32 = new CardImpl(rankSeven, suitHearts);
	Card card33 = new CardImpl(rankEight, suitHearts);
	Card card34 = new CardImpl(rankNine, suitHearts);
	Card card35 = new CardImpl(rankTen, suitHearts);
	Card card36 = new CardImpl(rankJ, suitHearts);
	Card card37 = new CardImpl(rankQ, suitHearts);
	Card card38 = new CardImpl(rankK, suitHearts);
	Card card39 = new CardImpl(rankA, suitHearts);
	Card card40 = new CardImpl(rankTwo,suitSpades);
	Card card41 = new CardImpl(rankThree, suitSpades);
	Card card42 = new CardImpl(rankFour, suitSpades);
	Card card43 = new CardImpl(rankFive, suitSpades);
	Card card44 = new CardImpl(rankSix, suitSpades);
	Card card45 = new CardImpl(rankSeven, suitSpades);
	Card card46 = new CardImpl(rankEight, suitSpades);
	Card card47 = new CardImpl(rankNine, suitSpades);
	Card card48 = new CardImpl(rankTen, suitSpades);
	Card card49 = new CardImpl(rankJ, suitSpades);
	Card card50 = new CardImpl(rankQ, suitSpades);
	Card card51 = new CardImpl(rankK, suitSpades);
	Card card52 = new CardImpl(rankA, suitSpades);
	
	
	
	/**
	 * Test for right cards in Standard Deck and the right number of cards
	 */
	@Test
    public void testForCardsInStandardDeck() {	
		Deck deck = new StandardImpl();
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
     * Test for right cards in Euchre deck and the right number of cards
     */
    @Test
    public void testForCardsInEuchreDeck() {	
    	Deck deck = new EuchreImpl();
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
     * Test for right cards in Pinochle deck and the right number of cards
     */
    @Test
    public void testForCardsInPinochleDeck() {	
    	Deck deck = new PinochleImpl();
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
     * Test for right cards in Vegas deck consisting of 8 standard decks 
     * and with right number of cards 
     */
    @Test
    public void testForCardsInVegasDeck() {	
    	Deck deck = new VegasImpl(STANDARD_DECK_COPY);
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
     * Testing when a deck of card is shuffled, it has different order than before.
     * If position of one of the card changes, deck is considered to be shuffled.
     * Shuffle will be run 3 times unless a card changes it's position.
     */
	@Test
    public void testForShuffleDeck() {
		int numberOfShuffles = 3;
		boolean isMatch = true;
    	Deck deck = new StandardImpl();
    	List<Card>cards = deck.getCards();
		@SuppressWarnings("unchecked")
		List<Card>beforeShuffle = ((List<Card>) ((ArrayList<Card>) cards).clone()); 
    	deck.shuffle();
    	List<Card>afterShuffle = deck.getCards();
    	for(int count = 0; count < numberOfShuffles; count++) {
    		for(int i = 0; i<beforeShuffle.size();i++) {
            	if(!beforeShuffle.get(i).equals(afterShuffle.get(i))) {
            		isMatch = false;
            		break;
            	}
            }
    		if(isMatch == false) break;
    	}     
        assertEquals(false,isMatch);
    }
	
	/**
	 * Helper function for adding cards in an array list sorted by suit 
	 */
	public List<Card> buildingCardsBySuit() {
		List<Card>cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
		cards.add(card6);
		cards.add(card7);
		cards.add(card8);
		cards.add(card9);
		cards.add(card10);
		cards.add(card11);
		cards.add(card12);
		cards.add(card13);
		cards.add(card14);
		cards.add(card15);
		cards.add(card16);
		cards.add(card17);
		cards.add(card18);
		cards.add(card19);
		cards.add(card20);
		cards.add(card21);
		cards.add(card22);
		cards.add(card23);
		cards.add(card24);
		cards.add(card25);
		cards.add(card26);
		cards.add(card27);
		cards.add(card28);
		cards.add(card29);
		cards.add(card30);
		cards.add(card31);
		cards.add(card32);
		cards.add(card33);
		cards.add(card34);
		cards.add(card35);
		cards.add(card36);
		cards.add(card37);
		cards.add(card38);
		cards.add(card39);
		cards.add(card40);
		cards.add(card41);
		cards.add(card42);
		cards.add(card43);
		cards.add(card44);
		cards.add(card45);
		cards.add(card46);
		cards.add(card47);
		cards.add(card48);
		cards.add(card49);
		cards.add(card50);
		cards.add(card51);
		cards.add(card52);
		return cards;
	}
	
	/**
	 * Helper function for adding cards in an array list sorted by suit and rank.
	 */
	public List<Card> buildingCardsBySuitRank() {
		List<Card>cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card14);
		cards.add(card27);
		cards.add(card40);
		cards.add(card2);
		cards.add(card15);
		cards.add(card28);
		cards.add(card41);
		cards.add(card3);
		cards.add(card16);
		cards.add(card29);
		cards.add(card42);
		cards.add(card4);
		cards.add(card17);
		cards.add(card30);
		cards.add(card43);
		cards.add(card5);
		cards.add(card18);
		cards.add(card31);
		cards.add(card44);
		cards.add(card6);
		cards.add(card19);
		cards.add(card32);
		cards.add(card45);
		cards.add(card7);
		cards.add(card20);
		cards.add(card33);
		cards.add(card46);
		cards.add(card8);
		cards.add(card21);
		cards.add(card34);
		cards.add(card47);
		cards.add(card9);
		cards.add(card22);
		cards.add(card35);
		cards.add(card48);
		cards.add(card10);
		cards.add(card23);
		cards.add(card36);
		cards.add(card49);
		cards.add(card11);
		cards.add(card24);
		cards.add(card37);
		cards.add(card50);
		cards.add(card12);
		cards.add(card25);
		cards.add(card38);
		cards.add(card51);
		cards.add(card13);
		cards.add(card26);
		cards.add(card39);
		cards.add(card52);
		return cards;
	}
	
	/**
	 * Test for sorting deck of cards by rank
	 */
	@Test
	public void testForSortByRank() {
		List<Card> cards = buildingCardsBySuitRank();
		Deck deck = new StandardImpl();
		deck.shuffle();
		deck.sort("byRank");
		List<Card>cardsActual = deck.getCards();
		int i = 0;
		
		for(Card card : cardsActual) {
			assertEquals(card.getRank().getName(), cards.get(i).getRank().getName());
			i++;
		}
	}
	
	/**
	 * Test for sorting deck of cards by suit
	 */
	@Test
	public void testForSortBySuit() {
		List<Card> cards = buildingCardsBySuit();
		Deck deck = new StandardImpl();
		deck.shuffle();
		deck.sort("bySuit");
		List<Card>cardsActual = deck.getCards();
		int i = 0;
		
		for(Card card : cardsActual) {
			assertEquals(card.getSuit().getName(), cards.get(i).getSuit().getName());
			i++;
		}
	}
	
	
	/**
	 * Test for sorting deck of cards by suit and rank both
	 */
	@Test
	public void testForSortBySuitRankBoth() {
		List<Card> cards = buildingCardsBySuitRank();
		Deck deck = new StandardImpl();
		deck.shuffle();
		deck.sort("bySuitRankBoth");
		List<Card>cardsActual = deck.getCards();
		int i = 0;
		
		for(Card card : cardsActual) {
			assertEquals(true,card.equals(cards.get(i)));
			i++;
		}
	}
	
	
	 /**
     * Test for IllegalArgumentException when sort type
     * doesn't match with bySuit,byRank,bySuitRankBoth
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSortInput() {
    	Deck deck = new StandardImpl();
    	deck.sort("byrank");
    }
    
    /**
	 * Test for sorting Standard deck of cards by rank.
	 * rankEnum is used to iterate over the ranks.
	 */
    @Test
    public void testForSortingByRankForStandardDeck() {
    	Deck deck = new StandardImpl();
    	deck.shuffle();
    	deck.sort("byRank");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
	    	for(int i = 0 ;i<EnumContainer.SuitsEnum.values().length;i++) {
	    		Rank rank = new RankImpl(rankEnum.name());
	    		assertEquals(cards.get(j).getRank(),rank);
	    		j++;
	    	}
    	}
    }
    
    /**
     * Test for sorting Standard deck of cards by suit.
     * suitEnum is used to iterate over the suits.
     */
    @Test
    public void testForSortingBySuitForStandardDeck() {
    	Deck deck = new StandardImpl();
    	deck.shuffle();
    	deck.sort("bySuit");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    		for(int i = 0 ;i<EnumContainer.StandardRankEnum.values().length;i++) {
    			Suit suit = new SuitImpl(suitEnum.name());
	    		assertEquals(cards.get(j).getSuit(),suit);
	    		j++;
	    	}
    	}
    }
    
    /**
     * Test for sorting Standard deck of cards by suit and rank.
     * suitEnum and rankEnum are used to iterate over the ranks and suits.
     */
    @Test
    public void testForSortingByRankSuitBothForStandardDeck() {
    	Deck deck = new StandardImpl();
    	deck.shuffle();
    	deck.sort("bySuitRankBoth");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
    		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    		   Card card = new CardImpl(new RankImpl(rankEnum.name()),new SuitImpl(suitEnum.name()));
    		   assertTrue(cards.get(j).equals(card));
    		   j++;
    		}
    	}	
    }
    
    /**
     * Test for sorting Vegas deck of cards by rank.
     * rankEnum is used to iterate over the ranks.
     */
    @Test
    public void testForSortingByRankForVegasDeck() {
    	int numberOfDecks = 3;
    	Deck deck = new VegasImpl(numberOfDecks);
    	deck.shuffle();
    	deck.sort("byRank");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
	    	for(int i = 0 ;i<EnumContainer.SuitsEnum.values().length;i++) {
	    		for(int k = 0; k<numberOfDecks; k++) {
		    		Rank rank = new RankImpl(rankEnum.name());
		    		assertEquals(cards.get(j).getRank(),rank);
		    		j++;
	    	   }
    	    }
	    }
    }
    
    /**
     * Test for sorting Vegas deck of cards by suit.
     * suitEnum is used to iterate over the suits.
     */
    @Test
    public void testForSortingBySuitForVegasDeck() {
    	int numberOfDecks = 3;
    	Deck deck = new VegasImpl(numberOfDecks);
    	deck.shuffle();
    	deck.sort("bySuit");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    	  for(int k = 0; k<numberOfDecks; k++) {
    		for(int i = 0 ;i<EnumContainer.StandardRankEnum.values().length;i++) {
    			Suit suit = new SuitImpl(suitEnum.name());
	    		assertEquals(cards.get(j).getSuit(),suit);
	    		j++;
	    	}
    	  }
    	}
    }
    
    /**
     * Test for sorting Vegas deck of cards by suit and rank.
     * suitEnum and rankEnum are used to iterate over the ranks and suits.
     */
    @Test
    public void testForSortingByRankSuitBothForVegasDeck() {
    	int numberOfDecks = 3;
    	Deck deck = new VegasImpl(numberOfDecks);
    	deck.shuffle();
    	deck.sort("bySuitRankBoth");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
    		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values())  {
	    		for(int k = 0; k<numberOfDecks; k++) {
		    		Rank rank = new RankImpl(rankEnum.name());
		    		Suit suit = new SuitImpl(suitEnum.name());
		    		Card card = new CardImpl(rank,suit);
		    		assertEquals(cards.get(j),card);
		    		j++;
	    	   }
    	    }
	    }
    }
    
    /**
     * Test for sorting Pinochle deck of cards by rank.
     * rankEnum is used to iterate over the ranks.
     */
    @Test
    public void testForSortingByRankForPinochleDeck() {
    	Deck deck = new PinochleImpl();
    	deck.shuffle();
    	deck.sort("byRank");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.PinochleRankEnum rankEnum : EnumContainer.PinochleRankEnum.values()) {
	    	for(int i = 0 ;i<EnumContainer.SuitsEnum.values().length;i++) {
	    		for(int k = 0; k < 2; k++) {
	    			Rank rank = new RankImpl(rankEnum.name());
		    		assertEquals(cards.get(j).getRank(),rank);
		    		j++;
	    		}
	    	}  		
    	}
    }
    
    /**
     * Test for sorting Pinochle deck of cards by suit.
     * suitEnum is used to iterate over the suits.
     */
    @Test
    public void testForSortingBySuitForPinochleDeck() {
    	Deck deck = new PinochleImpl();
    	deck.shuffle();
    	deck.sort("bySuit");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    		for(int k = 0; k < 2; k++) {
	    		for(int i = 0 ;i<EnumContainer.PinochleRankEnum.values().length;i++) {
	    			Suit suit = new SuitImpl(suitEnum.name());
		    		assertEquals(cards.get(j).getSuit(),suit);
		    		j++;
		    	}
    		}
    	}
    }
    
    /**
     * Test for sorting Pinochle deck of cards by suit and rank.
     * suitEnum and rankEnum are used to iterate over the ranks and suits.
     */
    @Test
    public void testForSortingBySuitRankBothForPinochleDeck() {
    	Deck deck = new PinochleImpl();
    	deck.shuffle();
    	deck.sort("bySuitRankBoth");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.PinochleRankEnum rankEnum : EnumContainer.PinochleRankEnum.values()) {
	    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
	    		for(int k = 0; k < 2; k++) {
	    			Card card = new CardImpl(new RankImpl(rankEnum.name()),new SuitImpl(suitEnum.name()));
		    		assertEquals(cards.get(j),card);
		    		j++;
	    		}
	    	}  		
    	}
    }
    
    /**
     * Test for sorting Euchre deck of cards by suit and rank.
     * rankEnum is used to iterate over the ranks.
     */
    @Test
    public void testForSortingByRankForEuchreDeck() {
    	Deck deck = new EuchreImpl();
    	deck.sort("byRank");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.EuchreRankEnum rankEnum : EnumContainer.EuchreRankEnum.values()) {
	    	for(int i = 0 ;i<EnumContainer.SuitsEnum.values().length;i++) {
	    		Rank rank = new RankImpl(rankEnum.name());
	    		assertEquals(cards.get(j).getRank(),rank);
	    		j++;
	    	}
    	}
    }
    
    /**
     * Test for sorting Euchre deck of cards by suit.
     * suitEnum is used to iterate over the suits.
     */
    @Test
    public void testForSortingBySuitForEuchreDeck() {
    	Deck deck = new EuchreImpl();
    	deck.shuffle();
    	deck.sort("bySuit");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    		for(int i = 0 ;i<EnumContainer.EuchreRankEnum.values().length;i++) {
    			Suit suit = new SuitImpl(suitEnum.name());
	    		assertEquals(cards.get(j).getSuit(),suit);
	    		j++;
	    	}
    	}
    }
    
    /**
     * Test for sorting Euchre deck of cards by suit and rank.
     * suitEnum and rankEnum are used to iterate over the ranks and suits.
     */
    @Test
    public void testForSortingByRankSuitBothForEuchreDeck() {
    	Deck deck = new EuchreImpl();
    	deck.shuffle();
    	deck.sort("bySuitRankBoth");
    	List<Card>cards= deck.getCards();
    	int j = 0;
    	for(EnumContainer.EuchreRankEnum rankEnum : EnumContainer.EuchreRankEnum.values()) {
    		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    		   Card card = new CardImpl(new RankImpl(rankEnum.name()),new SuitImpl(suitEnum.name()));
    		   assertEquals(true,cards.get(j).equals(card));
    		   j++;
    		}
    	}	
    }
    
    /**
     * Test for cut point when it is greater than the size of deck
     * Expected IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIllegalCutPoint() {
    	Deck deck = new StandardImpl();
    	deck.cut(deck.officialSize()+1);
    }
    
    /**
     * Helper function for testing order of cards when cut point
     * is less than or equal to zero
     */ 
    public void testCutPointWhenZeroOrLess(int point) {
    	int cutPoint = point;
    	Deck deck = new EuchreImpl();
    	List<Card>cards = deck.getCards();
    	@SuppressWarnings("unchecked")
		List<Card>cardsBeforeCut = ((List<Card>) ((ArrayList<Card>) cards).clone()); 
    	deck.cut(cutPoint);
    	List<Card>cardsAfterCut = deck.getCards();
    	for(int i = 0; i<cards.size(); i++) {
    		assertEquals(true,cardsAfterCut.get(i).equals(cardsBeforeCut.get(i)));   		
    	}	
    }
    
    /**
     * Test for cut point when it is equal to zero.
     * Expected output: deck of cards will be in the same order.
     */ 
    @Test
    public void testCutPointWhenZero() {
    	testCutPointWhenZeroOrLess(0);
    }
    
    /**
     * Test for cut point when it is less than zero.
     * Expected output: deck of cards will be in the same order.
     */ 
    @Test
    public void testCutPointWhenLessThanZero() {
    	testCutPointWhenZeroOrLess(-1);
    }
    
    /**
     * Test for deck after being cut is in right order i.e.
     * testing that first half of deck is at the bottom
     * of the deck in order after cut point is selected
     */ 
    @Test
    public void testCutPoint() {
    	Deck deck = new EuchreImpl();
    	int cutPoint = 10;
    	List<Card>cards = deck.getCards();
    	@SuppressWarnings("unchecked")
		List<Card>cardsBeforeCut = ((List<Card>) ((ArrayList<Card>) cards).clone()); 
    	deck.cut(cutPoint);
    	List<Card>cardsAfterCut = deck.getCards();
    	int j = cutPoint-1;
    	for(int i = 0; i<cards.size(); i++) {
    		if(i == cards.size()-cutPoint+1) {
    			j = 0;
    		}
    		assertEquals(true,cardsAfterCut.get(i).equals(cardsBeforeCut.get(j)));
    		j++;    		
    	}	
    }
	
   
	  /**
	   * Test for card pull for more than the size of deck.
	   * Expected output: IndexOutOfBoundsException
	   */
	  @Test(expected = IndexOutOfBoundsException.class)
	  public void testForCardPullMoreThanSizeOfDeck() {
	  	Deck deck = new StandardImpl();
	  	for(int i=0; i<deck.officialSize()+1;i++) {
	     	 deck.pullCard();
	     }
	  }
	  
	  
	  /**
	   * Test for card pull from empty deck.
	   * Expected output: IndexOutOfBoundsException
	   */
	  @Test(expected = IndexOutOfBoundsException.class)
	  public void testIllegalCardPullFromEmptyDeck() {
	  	Deck deck = new DeckImpl();
	    deck.pullCard();
	
	  }
 
    /**
     * Test for card pull from deck.
     * Expected output: Deck will have one less card than before the card was
     * pulled and the card will no longer be in deck.
     */
     @Test
     public void testForCardPull() {
     	Deck deck = new StandardImpl();
     	int size = deck.officialSize();
     	Card card = deck.pullCard();
     	assertEquals(size-1,deck.getCards().size());
     	assertEquals(false,((DeckImpl) deck).contains(card.getRank(),card.getSuit()));
     }
     
  
     
     /**
      * Test for card pull from Pinochle deck which has 2 copies of each suit.
      * Expected output: Deck will have one less card than before the card was
     * pulled and card count for that specific suit and rank will decrease by one
      */
     @Test
     public void testForCardNotInPinochleDeckAfterPull() {
     	Deck deck = new PinochleImpl();
     	int size = deck.officialSize();
     	Card card = deck.pullCard();
     	List<Card>cards = deck.getCards();
     	int cardCount = 0;
     	for(Card item: cards) {
     		if(item.getRank().getName()==card.getRank().getName() 
     		   && item.getSuit().getName() == card.getSuit().getName()) {
     			cardCount++;
     		}
     	}
     	assertEquals(size-1,deck.getCards().size());
     	assertEquals(1,cardCount);
     }
     
     
     /**
      * Test for card pull from Vegas deck which has any number of copies of each suit.
      * Expected output: Deck will have one less card than before the card was
     *  pulled and card count for that specific suit and rank will decrease by one
      */
     @Test
     public void testForCardNotInVegasDeckAfterPull() {
     	Deck deck = new VegasImpl(4);
     	int size = deck.officialSize();
     	Card card = deck.pullCard();
     	List<Card>cards = deck.getCards();
     	int cardCount = 0;
     	for(Card item: cards) {
     		if(item.getRank().getName()==card.getRank().getName() 
     		   && item.getSuit().getName() == card.getSuit().getName()) {
     			cardCount++;
     		}
     	}
     	assertEquals(size-1,deck.getCards().size());
     	assertEquals(3,cardCount);
     }
   
    /** 
     * Test for empty deck with no cards.
     * Expected output: True as deck is empty
     */
    @Test
    public void testForEmptyDeck() {
    	Deck deck = new StandardImpl();
    	List<Card>cards = deck.getCards();
    	cards.clear();
    	assertEquals(true,deck.emptyDeck());
    }
    
    
    

}
