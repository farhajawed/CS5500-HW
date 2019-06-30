package problem2.game;

/**
 * Game interface provides methods for creating a deck, setting number of player or hands,
 * and dealing cards among the hands.
 * @author farha
 * @version 1.0
 */
public interface Game {
	
	/**
	 * It creates a deck of cards
	 * @param deckType i.e. the type of deck to be created
	 */
	public void createDeck(String deckType);
	
	/**
	 * It creates a deck of cards 
	 * @param deckType i.e. the type of deck to be created
	 * @param numberOfDecks i.e. number of decks to be created
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
