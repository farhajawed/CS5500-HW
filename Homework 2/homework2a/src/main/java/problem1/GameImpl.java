package problem1;

import java.util.ArrayList;
import java.util.List;


/**
 * Game interface provides methods for creating a deck, setting number of player or hands,
 * and dealing cards among the hands.
 * @author farha
 * @version 1.0
 */
public class GameImpl implements GameExtend{
    /**
     * DeckImpl object for implementing a deck
     */
	private DeckImpl deck;
	
	/**
	 * Keeps count of number of hands
	 */
	private int inHowManyHands;
	
	/**
	 * Keeps the list of hands
	 */
	private List<Hand>hands;
	
	/**
	 * Keeps the number of cards to be distributed among hands
	 */
	public static final int NUMBER_OF_CARDS = 5;
	
	/**
	 * Stores the string of deck type "Vegas"
	 */
	private String vegasDeckType = "Vegas";

	/**
	 * It creates a deck of "Standard","Pinochle","Vegas" or "Euchre".
	 * @param deckType of "Standard","Pinochle","Vegas","Euchre"
	 * @exception IllegalArgumentException if input doesn't match with
	 * above deckTypes.
	 */
	public void createDeck(String deckType) {
		if(deckType != vegasDeckType && deckType != "Standard"
				&& deckType != "Pinochle" 
				&& deckType != "Euchre") {
			throw new IllegalArgumentException("Deck type is invalid. "
					+ "Available decktypes are: Vegas, Standard, Pinochle, Euchre");
		}
	   else if(deckType == vegasDeckType) {
			deck = new VegasImpl();
		}
		else if(deckType == "Standard") {
			deck = new StandardImpl();
		}
		else if(deckType == "Pinochle") {
			deck = new PinochleImpl();
		}
		else if(deckType == "Euchre") {
			deck = new EuchreImpl();
		}
	}
 
	/**
	 * It creates a Vegas deck of size equal to the numberOfDecks.
	 * @param deckType
	 * @param numberOfDecks
	 * @exception IllegalArgumentException if deckType is not equal to "Vegas"
	 */
	public void createDeck(String deckType, int numberOfDecks) {
		if(deckType!=vegasDeckType) {
			throw new IllegalArgumentException("Deck type is invalid. It must be Vegas");
		}
		else {
			deck = new VegasImpl(numberOfDecks);
		}		
	}
	
	/**
	 * Sets the number of hands in a game.
	 * @param inHowManyHands
	 */
	public void setNumberOfHands(int inHowManyHands) {
		this.inHowManyHands = inHowManyHands;
	}
	
	
	/**
	 * It distributes 5 cards among the players.
	 * @exception IndexOutOfBoundsException if number of hands is greater 
	 * than number of cards in deck or if cards cannot be evenly distributed
	 * among the players
	 */
	public void deal() {
		int currentDeckSize = deck.getCards().size();
		if(this.inHowManyHands > currentDeckSize) {
			throw new IndexOutOfBoundsException("Number of cards in deck is less than number of players");
		}
		else if(this.inHowManyHands*NUMBER_OF_CARDS > currentDeckSize) {
			throw new IndexOutOfBoundsException(NUMBER_OF_CARDS+" "
					+ "cards cannot be evenly distributed among " 
					+ this.inHowManyHands+" players");
		}
		else {
			hands = new ArrayList<Hand>();
			for(int i = 0; i < this.inHowManyHands; i++) {	
				Hand hand = new HandImpl();
				hands.add(hand);
				 for(int j = 0; j < NUMBER_OF_CARDS; j++) {
				   Card card = deck.pullCard();
				   hand.accept(card);
				 }
			}
		}	
	}
    
    
    /**
     * Gets the Deck object created by the game
     * @return deck object
     */
    public Deck getDeck() {
		return deck;
	}
	
    /**
     * Gets the array of hands created by the game
     * @return array of hands
     */
	public List<Hand> getHands() {
		return hands;
	}
	
}
