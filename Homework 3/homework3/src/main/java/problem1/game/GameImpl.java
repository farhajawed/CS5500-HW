package problem1.game;

import java.util.ArrayList;
import java.util.List;

import problem1.card.Card;
import problem1.deck.Deck;
import problem1.deck.DeckImpl;
import problem1.factory.DeckFactory;
import problem1.hand.Hand;

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
	 * Keeps the array of hands
	 */
	private List<Hand>hands;
	
	/**
	 * Keeps the number of cards to be distributed among hands
	 */
	public static final int NUMBER_OF_CARDS = 5;

	
	/**
	 * Instance of deckFactory
	 */
	private DeckFactory deckFactory;
	
	/**
	 * Constructs GameImpl object with the instantiation of deckFactory class
	 */
	public GameImpl() {
		 deckFactory = new DeckFactory();
	}

	/**
	 * It creates a deck of cards
	 * @param deckType i.e. the type of deck to be created
	 */
	public void createDeck(String deckType) {
		deck = (DeckImpl) deckFactory.getDeck(deckType);
	}
 
	/**
	 * It creates a deck of cards 
	 * @param deckType i.e. the type of deck to be created
	 * @param numberOfDecks i.e. number of decks to be created
	 */
	public void createDeck(String deckType, int numberOfDecks) {
		deck = (DeckImpl) deckFactory.getDeck(deckType, numberOfDecks);
	}
	
	/**
	 * Sets the number of hands in a game.
	 * @param inHowManyHands
	 * @exception IndexOutOfBoundsException if number of hands is less than 1.
	 */
	public void setNumberOfHands(int inHowManyHands) {
		if(inHowManyHands<1) {
			throw new IndexOutOfBoundsException("Number of hands must be greater than one");
		}
		this.inHowManyHands = inHowManyHands;
	}
		
	/**
	 * It creates the hands and distributes 5 cards among the players.
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
				Hand hand = deckFactory.createHand();
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
