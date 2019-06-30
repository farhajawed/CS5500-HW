package problem3;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import problem3.card.Card;
import problem3.card.CardImpl;
import problem3.deck.Deck;
import problem3.deck.DeckImpl;
import problem3.factory.DeckFactory;
import problem3.factory.GameFactory;
import problem3.game.Game;
import problem3.game.GameImpl;
import problem3.hand.Hand;
import problem3.rank.Rank;
import problem3.rank.RankImpl;
import problem3.state.Blackjack;
import problem3.state.BlackjackGame;
import problem3.state.DealerBlackjack;
import problem3.suit.Suit;
import problem3.suit.SuitImpl;

/**
 * Tests for verifying blackjack game.
 * @author farha
 * @version 1.0
 */
public class VerifyBlackjack {

	
	private static GameFactory gameFactory = new GameFactory();
	private static DeckFactory deckFactory = new DeckFactory();
	
	Rank rankTwo = new RankImpl("TWO");
	Rank rankThree = new RankImpl("THREE");
	Rank rankFour = new RankImpl("FOUR");
	Rank rankFive = new RankImpl("FIVE");
	Rank rankSix = new RankImpl("SIX");
	Rank rankSeven = new RankImpl("SEVEN");
	Rank rankEight = new RankImpl("EIGHT");
	Rank rankNine = new RankImpl("NINE");
	Rank rankTen = new RankImpl("TEN");
	Rank rankJ = new RankImpl("JACK");
	Rank rankQ = new RankImpl("QUEEN");
	Rank rankK = new RankImpl("KING");
	Rank rankA = new RankImpl("ACE");
	
   
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
	
	public static Hand hand;
	public static Game game;
	public static Deck deck;
	Blackjack bjack;
	
	@BeforeClass
	public static void setUp() {
		game = gameFactory.createNewGame("Vegas", 6, 5);
		deck = ((GameImpl) game).getDeck();
		
	}
	
	
	
	/**
	 * Test for total value of pips of cards in hand
	 */
	@Test
	public void testPipValueCalculation() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card2);
		bjack = new Blackjack(hand,deck,10);
		assertEquals(5,bjack.calculatePipValue());
	}
	
	
	/**
	 * Test for correct state call for hard total 5
	 */
	@Test
	public void testForStateChangeOnPipValue5() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card3);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	/**
	 * Test for correct state call for hard total 6
	 */
	@Test
	public void testForStateChangeOnPipValue6() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card4);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	
	/**
	 * Test for correct state call for hard total 7
	 */
	@Test
	public void testForStateChangeOnPipValue7() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card5);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	
	/**
	 * Test for correct state call for hard total 8
	 */
	@Test
	public void testForStateChangeOnPipValue8() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card6);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	
	/**
	 * Test for correct state call for hard total 9
	 */
	@Test
	public void testForStateChangeOnPipValue9() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card7);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	/**
	 * Test for correct state call for hard total 10
	 */
	@Test
	public void testForStateChangeOn10() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card8);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	/**
	 * Test for correct state call for hard total 11
	 */
	@Test
	public void testForStateChangeOn11() {
		hand = deckFactory.createHand();
		hand.accept(card2);
    	hand.accept(card7);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	/**
	 * Test for correct state call for A2
	 */
	@Test
	public void testForStateChangeOnA2() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	/**
	 * Test for correct state call for A3
	 */
	@Test
	public void testForStateChangeOnA3() {
		hand = deckFactory.createHand();
		hand.accept(card2);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	/**
	 * Test for correct state call for A4
	 */
	@Test
	public void testForStateChangeOnA4() {
		hand = deckFactory.createHand();
		hand.accept(card3);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	/**
	 * Test for correct state call for A5
	 */
	@Test
	public void testForStateChangeOnA5() {
		hand = deckFactory.createHand();
		hand.accept(card4);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	/**
	 * Test for correct state call for A6
	 */
	@Test
	public void testForStateChangeOnPair55() {
		hand = deckFactory.createHand();
		hand.accept(card5);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 5-11,A2-A6,Pair 55",bjack.getState().toString());
	}
	
	
	
	/**
	 * Test for correct state call for hard total 17-20,
	 * soft totals A8-A9 and Pair 10,10
	 */
	@Test
	public void testForStateChangeOnPipValueAllStands() {
		hand = deckFactory.createHand();
		hand.accept(card11);
    	hand.accept(card12);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 17-20,A8-A9,Pair 10",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair AA
	 */
	@Test
	public void testForStateChangeOnPipValueAllSplitsAA() {
		hand = deckFactory.createHand();
		hand.accept(card13);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pairs A,A and 8,8",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 88
	 */
	@Test
	public void testForStateChangeOnPipValueAllSplits88() {
		hand = deckFactory.createHand();
		hand.accept(card7);
    	hand.accept(card7);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pairs A,A and 8,8",bjack.getState().toString());	
	}
	
	
	/**
	 * Test for correct state call for A7
	 */
	@Test
	public void testForStateChangeOnA7() {
		hand = deckFactory.createHand();
		hand.accept(card6);
    	hand.accept(card13);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for A7",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 9,9
	 */
	@Test
	public void testForStateChangeOnPair99() {
		hand = deckFactory.createHand();
		hand.accept(card8);
    	hand.accept(card8);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pair 9,9",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 7,7
	 */
	@Test
	public void testForStateChangeOnPair77() {
		hand = deckFactory.createHand();
		hand.accept(card6);
    	hand.accept(card6);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pair 7,7",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 6,6
	 */
	@Test
	public void testForStateChangeOnPair66() {
		hand = deckFactory.createHand();
		hand.accept(card5);
    	hand.accept(card5);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pair 6,6",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 4,4
	 */
	@Test
	public void testForStateChangeOnPair44() {
		hand = deckFactory.createHand();
		hand.accept(card3);
    	hand.accept(card3);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pair 4,4",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 2,2
	 */
	@Test
	public void testForStateChangeOnPair22() {
		hand = deckFactory.createHand();
		hand.accept(card1);
    	hand.accept(card1);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pairs 2,2 and 3,3",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pair 3,3
	 */
	@Test
	public void testForStateChangeOnPair33() {
		hand = deckFactory.createHand();
		hand.accept(card2);
    	hand.accept(card2);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for pairs 2,2 and 3,3",bjack.getState().toString());	
	}
	
	
	/**
	 * Test for correct state call for pip value 16
	 */
	@Test
	public void testForStateChangeOnPipValue16() {
		hand = deckFactory.createHand();
		hand.accept(card11);
    	hand.accept(card5);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 16",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pip value 15
	 */
	@Test
	public void testForStateChangeOnPipValue15() {
		hand = deckFactory.createHand();
		hand.accept(card4);
    	hand.accept(card11);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 15",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pip value 13
	 */
	@Test
	public void testForStateChangeOnPipValue13() {
		hand = deckFactory.createHand();
		hand.accept(card10);
    	hand.accept(card2);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 13-14",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pip value 14
	 */
	@Test
	public void testForStateChangeOnPipValue14() {
		hand = deckFactory.createHand();
		hand.accept(card11);
    	hand.accept(card3);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 13-14",bjack.getState().toString());	
	}
	
	/**
	 * Test for correct state call for pip value 12
	 */
	@Test
	public void testForStateChangeOnPipValue12() {
		hand = deckFactory.createHand();
		hand.accept(card11);
    	hand.accept(card1);
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		assertEquals("State for 12",bjack.getState().toString());	
	}
	
	public Deck customDeck() {
		Deck deck = new DeckImpl();
		List<Card>cardsInDeck = deck.getCards();
		cardsInDeck.add(card1);
		cardsInDeck.add(card2);
		cardsInDeck.add(card3);
		cardsInDeck.add(card4);
		cardsInDeck.add(card5);
		cardsInDeck.add(card6);
		cardsInDeck.add(card7);
		cardsInDeck.add(card8);
		cardsInDeck.add(card9);
		cardsInDeck.add(card10);
		cardsInDeck.add(card11);
		cardsInDeck.add(card12);
		cardsInDeck.add(card13);
		cardsInDeck.add(card14);
		cardsInDeck.add(card15);
		cardsInDeck.add(card16);
		cardsInDeck.add(card17);
		cardsInDeck.add(card18);
		cardsInDeck.add(card19);
		cardsInDeck.add(card20);
		cardsInDeck.add(card21);
		cardsInDeck.add(card22);
		cardsInDeck.add(card23);
		cardsInDeck.add(card24);
		cardsInDeck.add(card25);
		cardsInDeck.add(card26);
		cardsInDeck.add(card27);
		cardsInDeck.add(card28);
		cardsInDeck.add(card29);
		cardsInDeck.add(card30);
		cardsInDeck.add(card31);
		cardsInDeck.add(card32);
		cardsInDeck.add(card33);
		cardsInDeck.add(card34);
		cardsInDeck.add(card35);
		cardsInDeck.add(card36);
		cardsInDeck.add(card37);
		cardsInDeck.add(card38);
		cardsInDeck.add(card39);
		cardsInDeck.add(card40);
		cardsInDeck.add(card41);
		cardsInDeck.add(card42);
		cardsInDeck.add(card43);
		cardsInDeck.add(card44);
		cardsInDeck.add(card45);
		cardsInDeck.add(card46);
		cardsInDeck.add(card47);
		cardsInDeck.add(card48);
		cardsInDeck.add(card49);
		cardsInDeck.add(card50);
		cardsInDeck.add(card51);
		cardsInDeck.add(card52);	
		return deck;
	}
	/**
	 * Tesing hit when pip value is 5 and dealer's face up card pip is 2.
	 * Expected: Number of cards in hand should increase
	 */
	@Test
	public void testHitPip5Dealer2() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card1); //pip2
    	hand.accept(card2); //pip3
		bjack = new Blackjack(hand,deck,2);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(true,cardsInHand.size()>2);
	}
	
	/**
	 * Tesing hit when pip value is 6 and dealer's face up card pip is 2.
	 * Expected: Number of cards in hand should increase
	 */
	@Test
	public void testHitPip6Dealer2() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card1); //pip2
		hand.accept(card1); //pip2
    	hand.accept(card1); //pip2
		bjack = new Blackjack(hand,deck,2);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(true,cardsInHand.size()>3);
	}
	/**
	 * Tesing hit when pip value is 5 and dealer's face up card is A.
	 * Expected: Number of cards in hand should increase
	 */
	@Test
	public void testHitPip5DealerA() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card1); //pip2
		hand.accept(card2); //pip3
		bjack = new Blackjack(hand,deck,11);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(true,cardsInHand.size()>2);
	}
	
	/**
	 * Tesing hit when pip value is 8 and dealer's face up card is A.
	 * Expected: Number of cards in hand should increase
	 */
	@Test
	public void testHitPip8DealerA() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card1); //pip2
		hand.accept(card1); //pip2
    	hand.accept(card1); //pip2
    	hand.accept(card1); //pip2
		bjack = new Blackjack(hand,deck,11);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(true,cardsInHand.size()>4);
	}
	
	
	/**
	 * Tesing hit when pip value is 7 and dealer's face up card is 7.
	 * Expected: Number of cards in hand should increase
	 */
	@Test
	public void testHitPip7Dealer7() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card1); //pip2
		hand.accept(card1); //pip2
    	hand.accept(card2); //pip3
		bjack = new Blackjack(hand,deck,7);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(true,cardsInHand.size()>3);
	}
	
	/**
	 * Tesing hit when pip value is soft 18 or A7 and dealer's face up card is A.
	 * Expected: Number of cards in hand should increase
	 */
	@Test
	public void testHitA7DealerA() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card13); //A
		hand.accept(card6); //pip 7
		bjack = new Blackjack(hand,deck,11);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(true,cardsInHand.size()>2);
	}
	
	
	
	/**
	 * Tesing stand when pip value is 17 and dealer's face up card is 2.
	 * Expected: Number of cards will remain same and isStand will be true.
	 */
	@Test
	public void testStandPip17Dealer2() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card11); //pip10
		hand.accept(card8); //pip7
		bjack = new Blackjack(hand,deck,2);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.getStand());
	}
	
	
	/**
	 * Tesing stand when pip value is 17 and dealer's face up card is A.
	 * Expected: Number of cards will remain same and isStand will be true.
	 */
	@Test
	public void testStandPip17DealerA() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card11); //pip10
		hand.accept(card8); //pip7
		bjack = new Blackjack(hand,deck,11);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.getStand());
	}
	
	
	/**
	 * Tesing stand when pip value is 20 and dealer's face up card is 2.
	 * Expected: Number of cards will remain same and isStand will be true.
	 */
	@Test
	public void testStandPip20Dealer2() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card11); //pip10
		hand.accept(card11); //pip10
		bjack = new Blackjack(hand,deck,2);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.getStand());
	}
	
	/**
	 * Tesing stand when pip value is 20 and dealer's face up card is A.
	 * Expected: Number of cards will remain same and isStand will be true.
	 */
	@Test
	public void testStandPip20DealerA() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card11); //pip10
		hand.accept(card11); //pip10
		bjack = new Blackjack(hand,deck,11);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.getStand());
	}
	
	/**
	 * Tesing stand when pip value is 19 and dealer's face up card is 7.
	 * Expected: Number of cards will remain same and isStand will be true.
	 */
	@Test
	public void testStandPip19Dealer7() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card11); //pip10
		hand.accept(card10); //pip9
		bjack = new Blackjack(hand,deck,7);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.getStand());
	}
	
	/**
	 * Tesing stand when soft total is 20 or A9 and dealer's face up card is 7.
	 * Expected: Number of cards will remain same and isStand will be true.
	 */
	@Test
	public void testStandSoft20Dealer7() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card13); //pip11 / A
		hand.accept(card6); //pip7
		hand.accept(card1); //pip2
		bjack = new Blackjack(hand,deck,7);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(3,cardsInHand.size());
		assertEquals(true,bjack.getStand());
	}
	
	/**
	 * Test for surrender when pip is 16 and dealer's face up card pip is 9.
	 * Expected: Hand will lose half of bet amount(1/2=0.5), number of cards
	 * will remain the same and hasSurrendered
	 * will be set true
	 */
	@Test
	public void testForSurrenderPip16Dealer9() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card10); 
		hand.accept(card5); 
		bjack = new Blackjack(hand,deck,9);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.hasPlayerSurrendered());
		assertEquals(0.5,bjack.getLostAmount(),0);
	}
	
	/**
	 * Test for surrender when pip is 16 and dealer's face up card pip is 10.
	 * Expected: Hand will lose half of bet amount(1/2=0.5) and hasSurrendered
	 * will be set true
	 */
	@Test
    public void testForSurrenderPip16Dealer10() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card10); //pip10
		hand.accept(card5); //pip6
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.hasPlayerSurrendered());
		assertEquals(0.5,bjack.getLostAmount(),0);
	}
    
    /**
	 * Test for surrender when pip is 16 and dealer's face up card is A.
	 * Expected: Hand will lose half of bet amount(1/2=0.5) and hasSurrendered
	 * will be set true
	 */
	@Test
    public void testForSurrenderPip16DealerA() {
    	Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card10); //pip10 
		hand.accept(card5); //pip6
		bjack = new Blackjack(hand,deck,11);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.hasPlayerSurrendered());
		assertEquals(0.5,bjack.getLostAmount(),0);
	}
    
    /**
	 * Test for surrender when pip is 15 and dealer's face up card pip is 10.
	 * Expected: Hand will lose half of bet amount(1/2=0.5) and hasSurrendered
	 * will be set true
	 */
	@Test
    public void testForSurrenderPip15Dealer10() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card10); 
		hand.accept(card4); 
		bjack = new Blackjack(hand,deck,10);
		bjack.changeState();
		bjack.play();
		List<Card>cardsInHand= bjack.getHand().showCard();
		assertEquals(2,cardsInHand.size());
		assertEquals(true,bjack.hasPlayerSurrendered());
		assertEquals(0.5,bjack.getLostAmount(),0);
	}
	
	/**
	 * Test for split when cards in hand are A,A and dealer's face up card pip is 7.
	 * Expected: Number of split hands will increase
	 */
	@Test
    public void testForSplitCardAADealer7() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card13); 
		hand.accept(card13); 
		bjack = new Blackjack(hand,deck,7);
		int initialHandSize = bjack.getSplitHands().size();
		bjack.changeState();
		bjack.play();
		assertEquals(true,bjack.getSplitHands().size()>initialHandSize);
	}
	
	/**
	 * Test for split when cards in hand are 2,2 and dealer's face up card pip is 7.
	 * Expected: Number of split hands will increase
	 */
	@Test
    public void testForSplitCard22Dealer5() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card1); 
		hand.accept(card1); 
		bjack = new Blackjack(hand,deck,7);
		int initialHandSize = bjack.getSplitHands().size();
		bjack.changeState();
		bjack.play();
		assertEquals(true,bjack.getSplitHands().size()>initialHandSize);
	}
	
	/**
	 * Test for split when cards in hand are 8,8 and dealer's face up card pip is 7.
	 * Expected: Number of split hands will increase
	 */
	@Test
    public void testForSplitCard88Dealer5() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card7); 
		hand.accept(card7); 
		bjack = new Blackjack(hand,deck,7);
		int initialHandSize = bjack.getSplitHands().size();
		bjack.changeState();
		bjack.play();
		assertEquals(true,bjack.getSplitHands().size()>initialHandSize);
	}
	
	/**
	 * Test for hit by dealer when hard total is 16 or less.
	 * Expected: Number of cards in hand will increase
	 */
	@Test
	public void testForDealerHitOnHard16OrLess() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card7); 
		hand.accept(card7); 
		DealerBlackjack dealer = new DealerBlackjack(deck,hand);
		dealer.changeState();
		List<Card>cardsInHand= dealer.getHand().showCard();
		assertEquals(true,cardsInHand.size()>2);
	}
	
	/**
	 * Test for stand by dealer when hard total is 17 or more.
	 * Expected: Number of cards in hand will remain the same
	 */
	@Test
    public void testForDealerStandOnHard17() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card7); 
		hand.accept(card8); 
		DealerBlackjack dealer = new DealerBlackjack(deck,hand);
		dealer.changeState();
		List<Card>cardsInHand= dealer.getHand().showCard();
		assertEquals(2,cardsInHand.size());	
	}
    
	/**
	 * Test for hit by dealer on soft 17.
	 * Expected: Number of cards in hand will increase
	 */
    @Test
    public void testForDealerHitOnSoft17() {
		Deck deck = customDeck();
		hand = deckFactory.createHand();
		hand.accept(card13); 
		hand.accept(card5); 
		DealerBlackjack dealer = new DealerBlackjack(deck,hand);
		dealer.changeState();
		List<Card>cardsInHand= dealer.getHand().showCard();
		assertEquals(true,cardsInHand.size()>2);	
	}
    
    /**
     * Test for invalid input for BlackjackGame when number of players
     * is less than 1.
     * Expected output: IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNumberOfPlayers() {
    	BlackjackGame bGame = new BlackjackGame("Vegas",1,-1);
    	bGame.handPlay();
    }
    
    /**
     * Test for invalid input for BlackjackGame when number of decks
     * is less than 1.
     * Expected output: IllegalArgumentException 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNumberOfDecks() {
    	BlackjackGame bGame = new BlackjackGame("Vegas",-1,2);
    	bGame.handPlay();
    }
		
}
