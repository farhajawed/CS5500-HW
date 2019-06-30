package problem3.state;

/**
 * It defines an interface of interest to clients and maintains
 * a reference to Blackjack subclass that defines the current state.
 * @author farha
 * @version 1.1
 */
public interface BlackjackState {
    
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is TWO
	 * @param Blackjack b
	 */
	void dealerCardTwo(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is THREE
	 * @param Blackjack b
	 */
	void dealerCardThree(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is FOUR
	 * @param Blackjack b
	 */
	void dealerCardFour(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is FIVE
	 * @param Blackjack b
	 */
	void dealerCardFive(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is SIX
	 * @param Blackjack b
	 */
	void dealerCardSix(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is SEVEN
	 * @param Blackjack b
	 */
	void dealerCardSeven(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is EIGHT
	 * @param Blackjack b
	 */
	void dealerCardEight(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is NINE
	 * @param Blackjack b
	 */
	void dealerCardNine(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is TEN,JACK, QUEEN, KING or pip value of 10
	 * @param Blackjack b
	 */
	void dealerCardTen(Blackjack b);
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is ACE
	 * @param Blackjack b
	 */
	void dealerCardA(Blackjack b);
}
