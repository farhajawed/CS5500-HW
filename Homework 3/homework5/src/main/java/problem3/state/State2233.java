package problem3.state;


import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class State2233 implements BlackjackState{
    
	static Hand hand;
	
	private State2233() {
	}
	
	private static State2233 theInstance;
	
	static State2233 instance() {
		if(theInstance == null) {
			theInstance = new State2233();
		}
		return theInstance;
	}
	

	/**
	 * It is used when player decides to split
	 */
	public void dealerCardTwo(Blackjack b) {
		b.split();
	}

	/**
	 * It is used when player decides to split
	 */
	public void dealerCardThree(Blackjack b) {
		b.split();
	
	}

	/**
	 * It is used when player decides to split
	 */
	public void dealerCardFour(Blackjack b) {
		b.split();
		
	}

	/**
	 * It is used when player decides to split
	 */
	public void dealerCardFive(Blackjack b) {
		b.split();
		
	}

	/**
	 * It is used when player decides to split
	 */
	public void dealerCardSix(Blackjack b) {
		b.split();
	}

	/**
	 * It is used when player decides to split
	 */
	public void dealerCardSeven(Blackjack b) {
		b.split();
	
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
		return "State for pairs 2,2 and 3,3";
	}


}
