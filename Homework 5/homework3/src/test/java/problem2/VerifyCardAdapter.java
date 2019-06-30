package problem2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import diErBao.Ka;
import diErBao.kaShiXia;
import problem2.adapter.CardAdapter;
import problem2.card.Card;
import problem2.card.EnumContainer;


/**
 * Tests for verifying cards using adapter class
 * @author farha
 * @version 1.0
 */
public class VerifyCardAdapter {
	
	
	 Ka ka = new kaShiXia(0,2);
	 Ka ka1 = new kaShiXia(1,0);
	 Ka ka2 = new kaShiXia(2,3);
	
	 Card cd = new CardAdapter(ka);
	 Card cd1 = new CardAdapter(ka1);
	 Card cd2 = new CardAdapter(ka2);
	
	 
	/**
	 * Test for checking whether the card reports the right rank and suit names using adapter.
	 * Ka-s are built from rank and suit values
	 * Rank: 0->TWO, 1->TW0, 2->THREE....9->KING, 10->QUEEN, 11->JACK, 12->ACE
	 * Suit: 0->CLUBS, 1->DIAMONDS, 2->HEARTS, 3->SPADES
	 */
    @Test
	public void testForCard() { 
    	int i = 0;
    	for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
   		     String rank = rankEnum.name();
   		     int j = 0;
   		     for(EnumContainer.SuitsEnum suitEnum : EnumContainer.SuitsEnum.values()) {
   		    	String suit = suitEnum.name();
   		    	Ka ka = new kaShiXia(i,j); 
   		    	Card cardAdapter = new CardAdapter(ka);
   		    	assertEquals(suit,cardAdapter.getSuit().getName());
   		    	assertEquals(rank,cardAdapter.getRank().getName());
                j++;    			
    		}
   		    i++;
    	} 	
	}
    
        
    /**
     * Test for null argument in CardAdapter constructor.
     * Expected output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForNullArgumentInCard() {
    	   Card cd = new CardAdapter(null);
    	   cd.getRank();
    }
    
    /**
     * Test for equals method in card.
     * It checks whether 2 cards are equal with same rank and suit names.
     * Expected output: true (since equal)
     */
    @Test
    public void testCardEqualsMethodForEqualCards() {
    	assertEquals(true,cd1.equals(cd1));
    }
    
    /**
     * Test for equals method in card.
     * It checks whether 2 cards are equal with same rank and suit names.
     * Expected output: false (since unequal)
     */
    @Test
    public void testCardEqualsMethodForUnEqualCards() {
    	assertEquals(false,cd1.equals(cd2));
    }
    
    
    /**
     * Test for equals method in card in case of comparison with null 
     * Expected output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCardEqualsMethodForNullCards() {
    	assertEquals(false,cd1.equals(null));
    }
    
    /**
     * Additional tests
     */
    
    /**
     * Test for invalid rank value less than 0
     * Expected IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalRankValue() {
    	Ka ka = new kaShiXia(-1,2);
    	Card card = new CardAdapter(ka);
        card.getRank();
    }
    
    /**
     * Test for invalid rank value greater than 12
     * Expected IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalRankValueGreaterThanTwelve() {
    	Ka ka = new kaShiXia(15,2);
    	Card card = new CardAdapter(ka);
        card.getRank();
    }
    
    /**
     * Test for invalid suit value less than 0
     * Expected IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalSuitValue() {
    	Ka ka = new kaShiXia(1,-2);
    	Card card = new CardAdapter(ka);
        card.getSuit();
    }
    
    /**
     * Test for invalid suit value greater than 3
     * Expected IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalSuitValueGreaterThanThree() {
    	Ka ka = new kaShiXia(1,5);
    	Card card = new CardAdapter(ka);
        card.getSuit();
    }
    
    
}
