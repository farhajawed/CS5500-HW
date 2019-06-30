package problem3.factory;

import problem3.game.Game;


/**
 * Abstract factory class contains factory methods to make playing game with deck
 * and hand flexible
 * @author farha
 * @version 1.1
 */
public abstract class AbstractFactoryGame {
	/**
	 * Factory method for creating game where number of decks can be defined
	 * @param deck type, number of decks and number of hands
	 * @return Game object
	 */
	public abstract Game createNewGame(String decktype,int numberOfDecks,int numberOfHands);
	
	/**
	 * Factory method for creating games
	 * @param deck type and number of hands
	 * @return Game object
	 */
	public abstract Game createNewGame(String decktype,int numberOfHands);
	

}
