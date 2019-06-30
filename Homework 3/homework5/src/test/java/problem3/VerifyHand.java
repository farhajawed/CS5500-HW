package problem3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import problem3.card.Card;
import problem3.card.CardImpl;
import problem3.deck.Deck;
import problem3.factory.DeckFactory;
import problem3.hand.Hand;
import problem3.rank.Rank;
import problem3.rank.RankImpl;
import problem3.suit.Suit;
import problem3.suit.SuitImpl;

/**
 * Tests for verifying hand.
 * @author farha
 * @version 1.0
 */
public class VerifyHand {
	
	Rank rankThree = new RankImpl("THREE");
	Rank rankTwo = new RankImpl("TWO");
	Rank rankJ = new RankImpl("JACK");
	Rank rankK = new RankImpl("KING");
	Rank rankA = new RankImpl("ACE");
	
   
	Suit suitClubs = new SuitImpl("CLUBS");
	Suit suitDiamonds = new SuitImpl("DIAMONDS");
	Suit suitHearts = new SuitImpl("HEARTS");
	Suit suitSpades = new SuitImpl("SPADES");
	
	Card card1 = new CardImpl(rankTwo,suitClubs);
	Card card2 = new CardImpl(rankThree, suitClubs);
	Card card3 = new CardImpl(rankA, suitHearts);
	Card card4 = new CardImpl(rankJ, suitClubs);
	Card card5 = new CardImpl(rankJ, suitDiamonds);
	Card card6 = new CardImpl(rankJ, suitSpades);
	Card card7 = new CardImpl(rankK, suitSpades);
	
	public static DeckFactory deckFactory;
	
	/**
	 * Instantiating deckFactory object
	 */
	@BeforeClass
	public static void setup() {
		 deckFactory = new DeckFactory();
	}
	
	/**
	 * Test for hand construction with no cards.
	 * Expected output: number of cards in hand is zero.
	 */
	@Test
	public void testForHandConstruction() {
		Hand hand = deckFactory.createHand();
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
    	Hand hand = deckFactory.createHand();
    	hand.accept(card1);
    	hand.accept(card2);
    	hand.accept(card3);
    	int actualNumber = hand.showCard().size();
    	assertEquals(3,actualNumber);
    }
	
    /**
     * It sets up a hand with 5 cards
     * @return list of hands
     */
    public Hand handSetUp() {
    	Hand hand = deckFactory.createHand();
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
     * Test for card pull by hand from empty hand
     * Expected output: IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testForCardPullFromEmptyDeck() {
    	Hand hand = deckFactory.createHand();
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
     * Test for card pull by hand in Pinochle deck which has 2 copies of each suit.
     * Expected output: Hand will have one less card than before the card was
     * pulled and card count for that particular card with 
     * specific suit and rank will decrease by one
     */
    
    @Test
    public void testForCardCountAfterPullByHandPinochle() {
    	Hand hand = deckFactory.createHand();
    	
    	Deck deck = deckFactory.getDeck("Pinochle");
    	List<Card>cards = deck.getCards();
    	
    	for(Card card : cards) {
    		hand.accept(card);
    	}
    	
      	Card cardPulled = hand.pullCard();
      	List<Card>cardsInHand = hand.showCard();
      	int actualSizeInHand = cardsInHand.size();
    	assertEquals(deck.officialSize()-1,actualSizeInHand);
    	
    	int count = 0;
    	for(Card card: cardsInHand) {
    		if(card.equals(cardPulled)) {
    			count++;
    		}
    	}
   	   assertEquals(1,count);
    }
    
    
   
    /**
     * Test for card shuffle in hand.
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
     * Test for invalid input for sorting cards in hand i.e. parameters not matching
     * with bySuit, byRank or bySuitRankBoth
     * Expected output: IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalHandSortInput() {
    	Hand hand = handSetUp();
    	hand.sort("byranksuit");
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
    	System.out.println(actualOutput);
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
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
	
	
	
}
