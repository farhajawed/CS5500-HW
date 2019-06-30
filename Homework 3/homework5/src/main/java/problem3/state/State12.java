package problem3.state;
import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State12 implements BlackjackState{
    
	static Hand hand;

	private State12() {
	}
	
	private static State12 theInstance;
	
	static State12 instance() {
		if(theInstance == null) {
			theInstance = new State12();
		}
		return theInstance;
	}
	
   /**
    * It is used to hit or take card from deck.
    */
	public void dealerCardTwo(Blackjack b) {
		b.hit();
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardThree(Blackjack b) {
		b.hit();
	
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardFour(Blackjack b) {
		b.stand();
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardFive(Blackjack b) {
		b.stand();
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardSix(Blackjack b) {
		b.stand();
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardSeven(Blackjack b) {
		b.hit();
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardEight(Blackjack b) {
		b.hit();
		
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardNine(Blackjack b) {
		b.hit();
		
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardTen(Blackjack b) {
		b.hit();
		
	}


	/**
    * It is used to hit or take card from deck.
    */
	public void dealerCardA(Blackjack b) {
		b.hit();
	
	}
    
	@Override
	public String toString() {
		return "State for 12";
	}

}
