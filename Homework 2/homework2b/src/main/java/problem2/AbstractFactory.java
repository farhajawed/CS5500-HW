package problem2;

/**
 * Abstract factory class contains factory methods to make playing game with deck
 * and hand flexible
 * @author farha
 * @version 1.0
 */
public abstract class AbstractFactory {

	/**
	 * Factory method for creating a deck of "Standard","Pinochle","Vegas" or "Euchre".
	 * @param deckType of "Standard","Pinochle","Vegas","Euchre"
	 * @exception IllegalArgumentException if input doesn't match with
	 * above deckTypes.
	 */
	public abstract Deck getDeck(String deckType);

	
	/**
	 * Factory method for creating a Vegas deck of size equal to the numberOfDecks.
	 * @param deckType
	 * @param numberOfDecks
	 * @exception IllegalArgumentException if deckType is not equal to "Vegas"
	 */
	public abstract Deck getDeck(String deckType, int numberOfDecks);
		
		
	/**
	 * Factory method for creating Hand
	 * @return Hand object
	 */
	public abstract Hand createHand();
	
}
