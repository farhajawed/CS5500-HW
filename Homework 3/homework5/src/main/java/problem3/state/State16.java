package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State16 implements BlackjackState{
    
	static Hand hand;
	
	private State16() {
	}
	
	private static State16 theInstance;
	
	static State16 instance() {
		if(theInstance == null) {
			theInstance = new State16();
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
	 * It is used when player decides to hit
	 */
	public void dealerCardSeven(Blackjack b) {
		b.hit();
	
	}

	/**
	 * It is used when player decides to stand
	 */
	public void dealerCardEight(Blackjack b) {
		b.stand();
	
	}

	/**
	 * It is used when player decides to surrender
	 */
	public void dealerCardNine(Blackjack b) {
		b.surrender();
	}

	/**
	 * It is used when player decides to surrender
	 */
	public void dealerCardTen(Blackjack b) {
		b.surrender();
	}


	/**
	 * It is used when player decides to surrender
	 */
	public void dealerCardA(Blackjack b) {
		b.surrender();
	}

	@Override
	public String toString() {
		return "State for 16";
	}

}
