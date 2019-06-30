package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State15 implements BlackjackState{
    
	static Hand hand;
	
	private State15() {
	}
	
	private static State15 theInstance;
	
	static State15 instance() {
		if(theInstance == null) {
			theInstance = new State15();
		}
		return theInstance;
	}
	
	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardTwo(Blackjack b) {
		b.stand();
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardThree(Blackjack b) {
		b.stand();
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardFour(Blackjack b) {
		b.stand();
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardFive(Blackjack b) {
		b.stand();
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardSix(Blackjack b) {
		b.stand();
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardSeven(Blackjack b) {
		b.stand();
	
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardEight(Blackjack b) {
		b.stand();
		
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardNine(Blackjack b) {
		b.stand();
	
	}

	/**
	 * It is used when player decides to surrender
	 */
	public void dealerCardTen(Blackjack b) {
		b.surrender();
	}

	/**
	 * It is used when player decides to hit
	 */
	public void dealerCardA(Blackjack b) {
		b.hit();
	
	}
	
	@Override
	public String toString() {
		return "State for 15";
	}


}
