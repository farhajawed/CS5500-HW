package problem2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import diErBao.Ka;
import diErBao.Shou;
import diErBao.ShouShiXia;
import diErBao.kaShiXia;
import problem2.adapter.CardAdapter;
import problem2.adapter.HandAdapter;
import problem2.card.Card;
import problem2.hand.Hand;
import problem2.rank.Rank;
import problem2.rank.RankImpl;

/**
 * Tests for verifying hand adapter class
 * @author farha
 * @version 1.1
 */
public class VerifyHandAdapter {
	/**
	 * Rank: 0>TWO,1>THREE,2>FOUR,3>FIVE,4>SIX,5>SEVEN,6>EIGHT
	 * 7>NINE,8>TEN,9>JACK,10>QUEEN,11>KING,12>ACE
	 * 
	 * Suit: 0>CLUBS,1>DIAMONDS,2>HEARTS,3>SPADES
	 */
	 Ka ka1 = new kaShiXia(0,0);
	 Ka ka2 = new kaShiXia(1,0);
	 Ka ka3 = new kaShiXia(12,2);
	 Ka ka4 = new kaShiXia(9,0);
	 Ka ka5 = new kaShiXia(9,1);
	 Ka ka6 = new kaShiXia(9,3);
	 Ka ka7 = new kaShiXia(11,3);
	 
	 Rank rankJ = new RankImpl("JACK");
	 Rank rankFour = new RankImpl("FOUR");
	
	 Card card1 = new CardAdapter(ka1);
	 Card card2 = new CardAdapter(ka2);
	 Card card3 = new CardAdapter(ka3);
	 Card card4 = new CardAdapter(ka4);
	 Card card5 = new CardAdapter(ka5);
	 Card card6 = new CardAdapter(ka6);
	 Card card7 = new CardAdapter(ka7);
	 
	 
	
	Shou shou = new ShouShiXia();
	
	/**
     * Test for null argument in HandAdapter constructor.
     * Expected output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForNullArgumentInCard() {
    	   Hand hand = new HandAdapter(null);
    	   hand.showCard();
    }
    
    
	/**
	 * Test for hand construction with no cards.
	 * Expected output: number of cards in hand is zero.
	 */
	@Test
	public void testForHandConstruction() {
		Hand hand = new HandAdapter(shou);
		List<Card>cardsInHand = hand.showCard();
		assertEquals(0,cardsInHand.size());
	}
	
	/**
     * Test for card acceptance by hand.
     * Expected output: Number of cards in hand will increase by 
     * the number of cards accepted by hand
     */
    @Test
    public void testForCardAcceptanceByHand() {
    	Hand hand = new HandAdapter(shou);
    	hand.accept(card1);
    	hand.accept(card2);
    	hand.accept(card3);
    	int actualNumber = hand.showCard().size();
    	assertEquals(3,actualNumber);
    }
    
    /**
     * Test for card acceptance by hand when input is null
     * Expected output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForNullCardAcceptanceByHand() {
    	Hand hand = new HandAdapter(shou);
    	hand.accept(null);
    }
    
    /**
     * It sets up a hand with 5 cards
     * @return list of hands
     */
    public Hand handSetUp() {
    	Hand hand = new HandAdapter(shou);
    	hand.accept(card1);
    	hand.accept(card2);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
    	return hand;
    }
    
    /**
     * Test for whether a particular card,rank or suit is present in hand.
     * Expected Output: true if card is present.
     */
    @Test
    public void testForWhetherCardIsPresentInHand() {
    	Hand hand = handSetUp();
    	assertEquals(true,hand.hasCard(card4));
    	assertEquals(false,hand.hasCard(card7));
    }
    
    /**
     * Test for whether a card is present in hand when input is null.
     * Expected output: IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForCardPresenceInHandWhenNull() {
    	Hand hand = new HandAdapter(shou);
    	hand.hasCard(null);
    }
    
    /**
     * Test for card pull by hand from empty hand
     * Expected output: IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testForCardPullFromEmptyHand() {
    	Hand hand = new HandAdapter(shou);
    	hand.pullCard();
    }
    
    /**
     * Test for card pull by hand.
     * Expected output: Hand will have one less card
     * and that card will not be available in hand
     */
    @Test
    public void testForCardCountAfterPullByHand() {
    	Hand hand = handSetUp();
    	Card cardPulled = hand.pullCard();
    	int actualSizeInHand = hand.showCard().size();
    	assertEquals(5,actualSizeInHand);
    	assertEquals(false,hand.hasCard(cardPulled));
    }
    
    /**
     * Test for invalid input for sorting cards in hand i.e. parameters not matching
     * with bySuit, byRank or bySuitRankBoth
     * Expected output: IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalHandSortInput() {
    	Hand hand = handSetUp();
    	hand.sort("byranksuit");
    }
    
    
   /** Test for card shuffle in hand.
    * Expected output: It will have different order than before.
    * If position of one of the card changes, hand is considered to be shuffled.
    * Shuffle will be run 3 times unless a card changes it's position.
    */
   @Test
   public void testForShuffleHandCards() {	
   	int numberOfShuffles = 3;
   	boolean isMatch = true;
   	Hand hand = handSetUp();
   	List<Card>cardsInHand = hand.showCard();
	@SuppressWarnings("unchecked")
	List<Card>beforeShuffle = ((List<Card>) ((ArrayList<Card>) cardsInHand).clone()); 
	hand.shuffle();
   	List<Card>afterShuffle = hand.showCard();
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
    * Test for sorting of cards in hand by rank
    */ 
   @Test
   public void testForSortingHandCardsByRank() {
   	Hand hand = handSetUp();
   	hand.shuffle();
   	hand.sort("byRank");
   	List<Card>actualOutput = hand.showCard();
    assertEquals(actualOutput.get(0).getRank(),card1.getRank());
    assertEquals(actualOutput.get(1).getRank(),card2.getRank());
    assertEquals(actualOutput.get(2).getRank(),card4.getRank());
    assertEquals(actualOutput.get(3).getRank(),card5.getRank());
    assertEquals(actualOutput.get(4).getRank(),card6.getRank());
    assertEquals(actualOutput.get(5).getRank(),card3.getRank());
   }
   
   /**
    * Test for sorting of cards in hand by suit
    */
   @Test
   public void testForSortingHandCardsBySuit() {
   	Hand hand = handSetUp();
   	hand.shuffle();
   	hand.sort("bySuit");
   	List<Card>actualOutput = hand.showCard();
       assertEquals(actualOutput.get(0).getSuit(),card1.getSuit());
       assertEquals(actualOutput.get(1).getSuit(),card2.getSuit());
       assertEquals(actualOutput.get(2).getSuit(),card4.getSuit());
       assertEquals(actualOutput.get(3).getSuit(),card5.getSuit());
       assertEquals(actualOutput.get(4).getSuit(),card3.getSuit());
       assertEquals(actualOutput.get(5).getSuit(),card6.getSuit());
   }
   
   
   
   /**
    * Test for sorting of cards in hand by rank and suit
    */
   @Test
   public void testForSortingHandCardsBySuitRankBoth() {
	   Hand hand = handSetUp();
	   hand.shuffle();
	   hand.sort("bySuitRankBoth");
	   List<Card>actualOutput = hand.showCard();
       assertEquals(actualOutput.get(0),card1);
       assertEquals(actualOutput.get(1),card2);
       assertEquals(actualOutput.get(2),card4);
       assertEquals(actualOutput.get(3),card5);
       assertEquals(actualOutput.get(4),card6);
       assertEquals(actualOutput.get(5),card3);
   }
   
   /**
    * Test for number of occurences of a card in hand.
    * Expected Output: 3.
    */
   @Test
	public void testForNumberOfOccurencesOfCard() {
		Hand hand = handSetUp();
		hand.accept(card1);
		hand.accept(card1);
		assertEquals(3, ((HandAdapter) hand).occurencesInHand(card1));
	}
   
   
   /**
    * Test for number of occurences of a card in hand.
    * Expected Output: 0.
    */
   @Test
	public void testForNumberOfOccurencesOfCardZero() {
	    Hand hand = handSetUp();
		assertEquals(0, ((HandAdapter) hand).occurencesInHand(card7));
	}
   
   /**
    * Test for number of occurences of a rank in hand.
    * Expected Output: 3.
    */
   @Test
	public void testForNumberOfOccurencesOfRank() {
	    Hand hand = handSetUp();
		assertEquals(3, ((HandAdapter) hand).occurencesInHand(rankJ));
	}
   
   
   
   /**
    * Test for number of occurences of a rank in hand.
    * Expected Output: 0.
    */
   @Test
	public void testForNumberOfOccurencesOfRankZero() {
	     Hand hand = handSetUp();
		 assertEquals(0, ((HandAdapter) hand).occurencesInHand(rankFour));
	}
   
   
   
   

}
