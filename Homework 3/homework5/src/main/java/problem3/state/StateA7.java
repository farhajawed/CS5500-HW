package problem3.state;

import problem3.hand.Hand;

/**
 * It implements BlackjackState interface and determines the action to take
 * based on the face up card of dealer
 * @author farha
 * @version 1.1
 */
public class StateA7 implements BlackjackState{
    
	static Hand hand;
	
	private StateA7() {
	}
	
	private static StateA7 theInstance;
	
	static StateA7 instance() {
		if(theInstance == null) {
			theInstance = new StateA7();
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
		return "State for A7";
	}

}
