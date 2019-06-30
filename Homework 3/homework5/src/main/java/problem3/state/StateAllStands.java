package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class StateAllStands implements BlackjackState{
    
	static Hand hand;
	
	private StateAllStands() {
	}
	
	private static StateAllStands theInstance;
	
	static StateAllStands instance() {
		if(theInstance == null) {
			theInstance = new StateAllStands();
		}
		return theInstance;
	}
	

	
	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardTwo(Blackjack b) {
		b.stand();
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardThree(Blackjack b) {
		b.stand();
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardFour(Blackjack b) {
		b.stand();
		
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardFive(Blackjack b) {
		b.stand();
		
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardSix(Blackjack b) {
		b.stand();
		
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardSeven(Blackjack b) {
		b.stand();
		
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardEight(Blackjack b) {
		b.stand();
		
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardNine(Blackjack b) {
		b.stand();
		
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardTen(Blackjack b) {
		b.stand();
	}

	/**
	   * It is used when player's next move is stand
	  */
	public void dealerCardA(Blackjack b) {
		b.stand();
		
	}
	
	@Override
	public String toString() {
		return "State for 17-20,A8-A9,Pair 10";
	}

}
