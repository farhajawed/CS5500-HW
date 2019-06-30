package problem1;

/**
 * Game interface provides methods for creating a deck, setting number of player or hands,
 * and dealing cards among the hands.
 * @author farha
 * @version 1.0
 */
public interface Game {
	
	/**
	 * It creates a deck of "Standard","Pinochle","Vegas" or "Euchre".
	 * @param deckType of "Standard","Pinochle","Vegas","Euchre"
	 * @exception IllegalArgumentException if input doesn't match with
	 * above deckTypes.
	 */
	public void createDeck(String deckType);
	
	/**
	 * It creates a Vegas deck of size equal to the numberOfDecks.
	 * @param deckType which is "Vegas"
	 * @param numberOfDecks
	 * @exception IllegalArgumentException if deckType is not equal to "Vegas"
	 */
	public void createDeck(String deckType,int numberOfDecks);
	
	/**
	 * Sets the number of hands in a game.
	 * @param inHowManyHands is the number of hands
	 */
	public void setNumberOfHands(int inHowManyHands);
	
	/**
	 * It distributes 5 cards among the players.
	 * @exception IndexOutOfBoundsException if number of hands is greater 
	 * than number of cards in deck or if cards cannot be evenly distributed
	 * among the players
	 */
	public void deal();
}
