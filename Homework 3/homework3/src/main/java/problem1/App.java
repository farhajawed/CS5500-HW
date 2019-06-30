package problem1;


import problem1.card.Card;
import problem1.card.CardImpl;
import problem1.hand.NewHand;
import problem1.hand.NewHandImpl;
import problem1.rank.Rank;
import problem1.rank.RankImpl;
import problem1.suit.Suit;
import problem1.suit.SuitImpl;

/**
 * Main method finding the occurences of a card and
 * rank in hand
 *
 */
public class App 
{
    public static void main( String[] args )
   
	    {
    	
    	
    	Rank rankTwo = new RankImpl("TWO");
    	Rank rankThree = new RankImpl("THREE");
    	Rank rankJ = new RankImpl("J");
    	Rank rankA = new RankImpl("A");
    	
       
    	Suit suitClubs = new SuitImpl("CLUBS");
    	Suit suitDiamonds = new SuitImpl("DIAMONDS");
    	Suit suitHearts = new SuitImpl("HEARTS");
    	
    	Card card1 = new CardImpl(rankTwo,suitClubs);
    	Card card2 = new CardImpl(rankThree, suitClubs);
    	Card card3 = new CardImpl(rankA, suitHearts);
    	Card card4 = new CardImpl(rankJ, suitClubs);
    	Card card5 = new CardImpl(rankJ, suitDiamonds);
    	
    	
		NewHand hand = new NewHandImpl();
		hand.accept(card1);
		hand.accept(card2);
		hand.accept(card3);
		hand.accept(card4);
	    hand.accept(card5);
	    
	    hand.occurencesInHand(card4);
	    hand.occurencesInHand(rankTwo);

	  }  
}
