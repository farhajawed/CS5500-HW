package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State1314 implements BlackjackState{
    
	static Hand hand;
	
	private State1314() {
	}
	
	private static State1314 theInstance;
	
	static State1314 instance() {
		if(theInstance == null) {
			theInstance = new State1314();
		}
		return theInstance;
	}
	

	/**
	 * It is used when player stands
	 */
	public void dealerCardTwo(Blackjack b) {
		b.stand();
	}


	/**
	 * It is used when player stands
	 */
	public void dealerCardThree(Blackjack b) {
		b.stand();
	}


	/**
	 * It is used when player stands
	 */
	public void dealerCardFour(Blackjack b) {
		b.stand();
	}


	/**
	 * It is used when player stands
	 */
	public void dealerCardFive(Blackjack b) {
		b.stand();
	}


	/**
	 * It is used when player stands
	 */
	public void dealerCardSix(Blackjack b) {
		b.stand();
	}


	/**
	 * It is used when player hits
	 */
	public void dealerCardSeven(Blackjack b) {
		b.hit();
	
	}


	/**
	 * It is used when player hits
	 */
	public void dealerCardEight(Blackjack b) {
		b.hit();
	
	}


	/**
	 * It is used when player hits
	 */
	public void dealerCardNine(Blackjack b) {
		b.hit();
	
	}


	/**
	 * It is used when player hits
	 */
	public void dealerCardTen(Blackjack b) {
		b.hit();
		
	}


	/**
	 * It is used when player hits
	 */
	public void dealerCardA(Blackjack b) {
		b.hit();
	
	}
	
	@Override
	public String toString() {
		return "State for 13-14";
	}

}
