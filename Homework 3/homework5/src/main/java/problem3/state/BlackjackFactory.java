package problem3.state;

/**
 * Factory method for playing blackjack
 * @author farha
 * @version 1.1
 */
public class BlackjackFactory {
      
	private String deckType = "Vegas";
	
	/**
	 * Creates a deck of Vegas and plays blackjack among number of players defined
	 * maintaining blackjack strategy
	 * @param numberOfDecks : number of standard decks
	 * @param numberOfPlayers
	 * @return BlackjackGame instance
	 */
	public BlackjackGame playBlackjack(int numberOfDecks,int numberOfPlayers) {
		
		BlackjackGame bj = new BlackjackGame(deckType,numberOfDecks,numberOfPlayers);
		bj.handPlay();
		bj.dealerPlay();
		bj.result();
		bj.printResult();
		return bj;
	}
}
