package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State99 implements BlackjackState{
    
	static Hand hand;
	
	private State99() {
	}
	
	private static State99 theInstance;
	
	static State99 instance() {
		if(theInstance == null) {
			theInstance = new State99();
		}
		return theInstance;
	}
	
	
	/**
	   * It is used to split hand
	  */
	public void dealerCardTwo(Blackjack b) {
		b.split();
		
	}

	/**
	   * It is used to split hand
	  */
	public void dealerCardThree(Blackjack b) {
		b.split();
		
	}

	/**
	   * It is used to split hand
	  */
	public void dealerCardFour(Blackjack b) {
		b.split();
		
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
	   * It is used to split hand
	  */
	public void dealerCardSeven(Blackjack b) {
		b.stand();
	}

	/**
	   * It is used to split hand
	  */
	public void dealerCardEight(Blackjack b) {
		b.split();
	}

	/**
	   * It is used to split hand
	  */
	public void dealerCardNine(Blackjack b) {
		b.split();
		
	}

	/**
	   * It is used to split hand
	  */
	public void dealerCardTen(Blackjack b) {
		b.stand();
	}

	/**
	   * It is used to split hand
	  */
	public void dealerCardA(Blackjack b) {
		b.stand();
	}
	
	@Override
	public String toString() {
		return "State for pair 9,9";
	}

}
