package problem1.factory;

import problem1.deck.Deck;
import problem1.game.Game;
import problem1.game.GameImpl;

/***
 * Abstract factory class contains factory methods to make playing game with deck
 * and hand flexible
 * @author farha
 * @version 1.1
 */
public class GameFactory extends AbstractFactoryGame{

	/**
	 * Factory method for creating game where number of decks can be defined
	 * @param deck type, number of decks and number of hands
	 * @return Game object
	 */
	@Override
	public Game createNewGame(String decktype,int numberOfDecks,int numberOfHands) {
		Game game = new GameImpl();
		game.createDeck(decktype,numberOfDecks);
		Deck deck = ((GameImpl) game).getDeck();
		deck.shuffle();
		game.setNumberOfHands(numberOfHands);
		game.deal();
		return game;
	}
	
	/**
	 * Factory method for creating games
	 * @param deck type and number of hands
	 * @return Game object
	 */
	@Override
	public Game createNewGame(String decktype,int numberOfHands) {
		Game game = new GameImpl();
		game.createDeck(decktype);
		Deck deck = ((GameImpl) game).getDeck();
		deck.shuffle();
		game.setNumberOfHands(numberOfHands);
		game.deal();
		return game;
	}

}
