package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 * Tests for verifying rank, suit and card.
 * @author farha
 * @version 1.0
 */
public class VerifyRankSuitCard {
          
	Rank rankTwo = new RankImpl("TWO");
	Rank rankThree = new RankImpl("THREE");
	Rank rankA = new RankImpl("A");
	
   
	Suit suitClubs = new SuitImpl("CLUBS");
	Suit suitHearts = new SuitImpl("HEARTS");
	
	Card cardOne = new CardImpl(rankTwo,suitClubs);
	Card cardTwo = new CardImpl(rankA, suitHearts);
	
	
	
	
	/**
	 * Test for checking whether the card reports the right rank and suit names
	 * Cards are built from enumerations of Rank and Suit in EnumContainer class.
	 * class.
	 */
    @Test
	public void testForRank() { 
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
    		 RankExtend rank = new RankImpl(rankEnum.name());
    		for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
    			Suit suit = new SuitImpl(suitEnum.name());
    			Card card = new CardImpl(rank,suit);
    			
    			String rankExpected = rankEnum.name();
    			String suitExpected = suitEnum.name();
    		    String rankActual = card.getRank().getName();
    		    String suitActual = card.getSuit().getName();
    		   
    		    assertEquals(rankExpected,rankActual);
    		    assertEquals(suitExpected,suitActual);
    		}
    	} 	
	}
    
    /**
	 * Test for checking whether the card reports the right sorting
	 * order for rank in order to sort it on Rank value.
	 */
    @Test
	public void testForSortValueForRank() { 
    	Integer i = 1;
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
    		 RankExtend rank = new RankImpl(rankEnum.name());
    		 for(int j = 0; j < EnumContainer.SuitsEnum.values().length; j++) {
    		    assertEquals(i,rank.getSortValue());
    		}
    		i++;
    	} 	
	}
	
	/**
	 * Test for equals method in RankImpl class.
	 * It is checking whether 2 ranks have the same name and pip value.
	 * Expected output: true.
	 */
	@Test
    public void testRankEqualMethod() {
    	assertEquals(true,rankTwo.equals(rankTwo));
    }
	
	/**
	 * Test for equals method in RankImpl class.
	 * It is checking whether 2 ranks have the same name and pip value.
	 * Expected output: false.
	 */
	@Test
    public void testRankEqualMethodForUnequalRanks() {
    	assertEquals(false,rankTwo.equals(rankThree));
    }
	
	  /**
     * Test for equals method in card. 
     * It checks whether 2 cards are equal with same rank and suit names
     * Expected output: true (since equal)
     */
    @Test
    public void testCardEqualsMethodForEqualCards() {
    	assertEquals(true,cardOne.equals(cardOne));
    }
    
    /**
     * Test for equals method in card.
     * It checks whether 2 cards are equal with same rank and suit names.
     * Expected output: false (since unequal)
     */
    @Test
    public void testCardEqualsMethodForUnEqualCards() {
    	assertEquals(false,cardOne.equals(cardTwo));
    }
    
    
	 /**
     * Test for invalid name of suit when getting suit SYMBOL
     * i.e. suit name is not equal to DIAMONDS, HEARTS, SPADES or CLUBS
     * Expected IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSuitForSymbol() {
    	Suit suit = new SuitImpl("diamond");
    	suit.getSymbol();
    }
    
    /**
     * Test for invalid name of suit when getting suit NAME
     * i.e. suit name is not equal to DIAMONDS, HEARTS, SPADES or CLUBS
     * Expected IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSuitForName() {
    	Suit suit = new SuitImpl("diaMonds");
    	suit.getName();
    }
    
    /**
     * Testing RankComparator for comparing two ranks 
     * on sorting value (obtained from getSortValue() of RankImpl class)
     * Output should be greater than 0 when first rank is of higher sorting value than
     * the second.
     */
    @Test
    public void greaterTestForRankComparator() {
    	RankComparator rankComparator = new RankComparator();
    	int value = rankComparator.compare(cardTwo,cardOne);
    	assertTrue(value>0);
    }
    
    /**
     * Testing RankComparator for comparing two ranks
     * on sorting value (obtained getSortValue() of RankImpl class)
     * Output should be less than 0 when first rank has lower sorting value than
     * the second.
     */
    @Test
    public void lowerTestForRankComparator() {
    	RankComparator rankComparator = new RankComparator();
    	int value = rankComparator.compare(cardOne,cardTwo);
    	assertTrue(value<0);
    }
    
    /**
     * Testing RankComparator for comparing two ranks 
     * on sorting value (obtained getSortValue() of RankImpl class)
     * Output should be equal to 0 when first rank same sorting value as
     * the second.
     */
    @Test
    public void equalTestForRankComparator() {
    	RankComparator rankComparator = new RankComparator();
    	int value = rankComparator.compare(cardTwo,cardTwo);
    	assertTrue(value==0);
    }
  
}
