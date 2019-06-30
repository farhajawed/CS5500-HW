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
import problem3.game.Game;
import problem3.game.GameImpl;
import problem3.hand.Hand;
import problem3.hand.NewHand;
import problem3.iterator.Aggregate;
import problem3.iterator.ConcreteAggregate;
import problem3.iterator.HandIterator;
import problem3.rank.Rank;
import problem3.rank.RankImpl;
import problem3.suit.Suit;
import problem3.suit.SuitImpl;


/**
 * Tests for verifying new hand with custom-built iterator.
 * @author farha
 * @version 1.0
 */
public class VerifyNewHandWithIterator {
    
	public static Aggregate concreteAgg;
	
    public static DeckFactory deckFactory;
    
    public static List<Hand>hands;
    
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
	
	/**
	 * Instantiating deckFactory, concreteAgg and hands
	 */
	@BeforeClass
	public static void setup() {
		 deckFactory = new DeckFactory();
		 concreteAgg = new ConcreteAggregate();
		 hands = new ArrayList<Hand>();
	}
	
	/**
	 * Sets up 2 hands with 5 card each from Vegas deck consisting of 2
	 * standard decks
	 */
	public void setUpHand() {
		Game game = new GameImpl();
		game.createDeck("Vegas", 2);
        Deck deck = ((GameImpl) game).getDeck();
        deck.shuffle();
		game.setNumberOfHands(2);
		game.deal();
		hands = ((GameImpl) game).getHands();
	}
	
	/**
	 * It checks to see whether the above function(setUpHand) creates two hands
	 */
	@Test
	public void testForTwoHandCreation() {
		setUpHand();
		assertEquals(2,hands.size());
	}
	
	/**
	 * It checks to see whether the above function(setUpHand) creates two hands
	 * with 2 cards
	 */
	@Test
	public void testForTwoHandWithFiveCards() {
		setUpHand();
		for(Hand hand:hands) {
			assertEquals(2,hand.showCard().size());
		}
	}
	
	/** 
	 * Checks whether iterator returns first position as 0
	 */
	@Test
	public void testForIteratorFirstPosition() {
		setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		HandIterator<Card> it = concreteAgg.createIterator(hand);
		assertEquals(0,it.first());
	}
	
	/** 
	 * Checks whether iterator increments its position when next()
	 * is called.
	 */
	@Test
	public void testForIteratorNextPosition() {
		setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		HandIterator<Card> it = concreteAgg.createIterator(hand);
		assertEquals(1,it.next());
		assertEquals(2,it.next());
		assertEquals(3,it.next());
	}
	
	/**
	 * Tests whether first position is returned as 0 after next() call
	 */
	@Test
	public void testForIteratorFirstPositionAfterNext() {
		setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		HandIterator<Card> it = concreteAgg.createIterator(hand);
		assertEquals(1,it.next());
		assertEquals(2,it.next());
		assertEquals(3,it.next());
		assertEquals(0,it.first());
	}
	/**
	 * Test for done() to check whether end of cards in hand is reached.
	 * Hand is built with 5 cards.
	 * Expected output: true as next() is called 2 times
	 */
	@Test
	public void testForReachingEndOfCard() {
		setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		HandIterator<Card> it = concreteAgg.createIterator(hand); 
		for(int i = 0; i<2;i++) {
			it.next();
		}
		assertEquals(true,it.isDone());
	}
	
	/**
	 * Test for done() to check whether end of cards in hand is reached.
	 * Hand is built with 2 cards.
	 * Expected output: false as next() is called less than 2 times
	 */
	@Test
	public void testForFalseReachingEndOfCard() {
		setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		HandIterator<Card> it = concreteAgg.createIterator(hand); 
		for(int i = 0; i<1;i++) {
			it.next();
		}
		assertEquals(false,it.isDone());
	}
	
    /**
     * Test to check whether iterator returns the current card
     * at a specific index.
     */
	@Test
	public void testForCurrentCard() {
		setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		List<Card>cards = hand.showCard();
		HandIterator<Card> it = concreteAgg.createIterator(hand);
		for(int i = 0; i<2;i++) {
			assertEquals(cards.get(i),it.current());
			it.next();
		}
	}
	
	 /**
     * Test for current card when hand is empty
     * Expected IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testForCurrentCardInEmptyHand() {
    	NewHand hand = deckFactory.createHand();
    	HandIterator<Card> it = concreteAgg.createIterator(hand);
    	it.current();
    }
    
    /**
     * Test for current card when current position of card is greater than 
     * hand size
     * Expected IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testForCurrentCardWhenPositionIsGreaterThanHandSize() {
    	setUpHand();
		NewHand hand = (NewHand) hands.get(0);
		List<Card>cards = hand.showCard();
		HandIterator<Card> it = concreteAgg.createIterator(hand);
		for(int i = 0; i<6;i++) {
			assertEquals(cards.get(i),it.current());
			it.next();
		}
    }
	
	
    /**
     * Test for whether a particular card is present in hand.
     * Expected Output: true if card is present.
     */
    @Test
	public void testForHasCard() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card2);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(true,hand.hasCard(card3));
	}
    
    /**
     * Test for whether a particular card is present in hand.
     * Expected Output: false as card is not present.
     */
    @Test
	public void testForHasCardFalse() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card2);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(false,hand.hasCard(card7));
	}
    
    /**
     * Test for whether a particular card is present in hand when input is null
     * Expected Output: false as input is null.
     */
    @Test
	public void testForHasCardNull() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card2);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(false,hand.hasCard(null));
	}
	
	
    /**
     * Test for number of occurences of a card in hand.
     * Expected Output: 2.
     */
    @Test
	public void testForNumberOfOccurencesOfCard() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card1);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(2, hand.occurencesInHand(card1));
	}
    
    /**
     * Test for number of occurences of a card in hand.
     * Expected Output: 0.
     */
    @Test
	public void testForNumberOfOccurencesOfCardZero() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card1);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(0, hand.occurencesInHand(card7));
	}
    
    /**
     * Test for number of occurences of a rank in hand.
     * Expected Output: 2.
     */
    @Test
	public void testForNumberOfOccurencesOfRank() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card1);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(2, hand.occurencesInHand(rankTwo));
	}
    
    /**
     * Test for number of occurences of a rank in hand.
     * Expected Output: 0.
     */
   @Test
	public void testForNumberOfOccurencesOfRankZero() {
		NewHand hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card1);
    	hand.accept(card3);
    	hand.accept(card4);
    	hand.accept(card5);
    	hand.accept(card6);
		assertEquals(0, hand.occurencesInHand(rankK));
	}
	
	
}