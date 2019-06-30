package problem1.card;
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
	public enum SuitsEnum {
	      CLUBS,DIAMONDS,HEARTS,SPADES
	}
	
	
	/**
	 * StandardRankEnum contains 13 rank enumerators of Standard deck
	 */
	public enum StandardRankEnum{
		TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE
	}
	
	
	/**
	 * EuchreRankEnum contains 6 rank enumerators of Euchre deck
	 */
	public enum EuchreRankEnum{
		NINE,TEN,JACK,QUEEN,KING,ACE
	}
	
	
	/**
	 * PinochleRankEnum contains 6 rank enumerators of Pinochle deck
	 */
	public enum PinochleRankEnum{
		NINE,TEN,JACK,QUEEN,KING,ACE
	}
         
}
