package problem1.suit;

/**
 * Suit in an interface which allows to get the name of suit and symbol.
 * @author farha
 * @version 1.0
 */
public interface Suit {

	/**
	 * Returns the name of suit e.g. CLUBS, DIAMONDS, HEARTS, SPADES
	 * @return name of suit
	 * @exception IllegalArgumentException if suit name doesn't match with
	 * the names declared in EnumContainer class
	 */
	public String getName();
	
	/**
	 * Returns the symbol of suit in unicode
	 * @return name of symbol in unicode
	 * @exception IllegalArgumentException if suit name doesn't match with
	 * the names declared in EnumContainer class
	 */
	public char getSymbol();

}
