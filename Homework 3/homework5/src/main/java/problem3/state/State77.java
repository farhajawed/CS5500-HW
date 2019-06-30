package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State77 implements BlackjackState{
    
	static Hand hand;
	
	private State77() {
	}
	
	private static State77 theInstance;
	
	static State77 instance() {
		if(theInstance == null) {
			theInstance = new State77();
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
		b.split();
	}

	/**
	 * It is used to split hand
	 */
	public void dealerCardEight(Blackjack b) {
		b.hit();
	
	}

	/**
	 * It is used to split hand
	 */
	public void dealerCardNine(Blackjack b) {
		b.hit();
		
	}

	/**
	 * It is used to split hand
	 */
	public void dealerCardTen(Blackjack b) {
		b.hit();
	
	}

	/**
	 * It is used to split hand
	 */
	public void dealerCardA(Blackjack b) {
		b.hit();
	}
	
	@Override
	public String toString() {
		return "State for pair 7,7";
	}
}
