package problem1;
/**
 * EnumContainer is a class which contains the
 * enumeration of suits, and enumeration of ranks of Standard, Euchre,
 * and Pinochle decks.
 * @author farha
 * @version 1.0
 *
 */
public class EnumContainer {

	/**
	 * SuitsEnum contains 4 enumerators of suits
	 */
	enum SuitsEnum {
	      CLUBS,DIAMONDS,HEARTS,SPADES
	}
	
	
	/**
	 * StandardRankEnum contains 13 rank enumerators of Standard deck
	 */
	enum StandardRankEnum{
		TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,J,Q,K,A
	}
	
	
	/**
	 * EuchreRankEnum contains 6 rank enumerators of Euchre deck
	 */
	enum EuchreRankEnum{
		NINE,TEN,J,Q,K,A
	}
	
	
	/**
	 * PinochleRankEnum contains 6 rank enumerators of Pinochle deck
	 */
	enum PinochleRankEnum{
		NINE,TEN,J,Q,K,A
	}
         
}
