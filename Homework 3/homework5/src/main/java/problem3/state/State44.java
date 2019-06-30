package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State44 implements BlackjackState{
    
	static Hand hand;
	
	private State44() {
	}
	
	private static State44 theInstance;
	
	static State44 instance() {
		if(theInstance == null) {
			theInstance = new State44();
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
		b.hit();
		
	}

	 /**
	   * It is used to split hand
	  */
	public void dealerCardFive(Blackjack b) {
		b.split();
	}

	 /**
	   * It is used to split hand
	  */
	public void dealerCardSix(Blackjack b) {
		b.split();
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
		return "State for pair 4,4";
	}

}
