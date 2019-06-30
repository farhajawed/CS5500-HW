package problem3.state;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import problem3.card.Card;
import problem3.deck.Deck;
import problem3.factory.GameFactory;
import problem3.game.Game;
import problem3.game.GameImpl;
import problem3.hand.Hand;

/**
 * Blackjack class is used to play a blackjack game by dealing cards among players,
 * following blackjack game strategy, and finding the winners of the game.
 * @author farha
 * @version 1.1
 */
public class BlackjackGame {

	private GameFactory gameFactory = new GameFactory();
	private Game game;
	private List<Hand>hands;
	private int numberOfPlayers;
	private Deck deck;
	private List<Blackjack>blackjackHands = new ArrayList<Blackjack>();
	private DealerBlackjack dealerBlackjack;
	
	/**
	 * Constructs a blackjack game with deck and cards dealt among hands and dealer
	 * @param deckType
	 * @param numberOfDecks
	 * @param numberOfPlayers
	 */
	public BlackjackGame(String deckType,int numberOfDecks,int numberOfPlayers) {
        if(numberOfPlayers<1 || numberOfDecks < 1) {
        	throw new IllegalArgumentException("Hands or number of decks should be greater than 1");
        }
       this.game = gameFactory.createNewGame(deckType, numberOfDecks, numberOfPlayers+1); 
       this.hands = ((GameImpl) game).getHands();
       this.numberOfPlayers = numberOfPlayers;
       this.deck = ((GameImpl) game).getDeck();
       this.dealerBlackjack = new DealerBlackjack(deck,hands.get(numberOfPlayers));
	}
	
	

	/**
	 * It returns a list of cards  in dealer's hand.
	 * @return list of cards in dealer's hand
	 */
	private List<Card> getDealerCards(){
		return hands.get(this.numberOfPlayers).showCard();
 	}
	
	/**
	 * It returns the pip value of first(face up) card of dealer
	 * @return integer pip value
	 */
	private int getDealerFaceUpPip() {
		List<Card>dealerCards = getDealerCards();
		return dealerCards.get(0).getRank().getPips();
	}
	
	/**
	 * It is used to play blackjack with each player. Game strategy is followed
	 * to determine which action to take next depending on overall pip value
	 * of cards in hand and pip value of dealer's face up card. Each player's
	 * latest state is stored in array list to determine the score for later use
	 */
	public void handPlay() {
		for(int i = 0; i<hands.size()-1; i++) {	
			Blackjack blackjack = new Blackjack(hands.get(i),deck,getDealerFaceUpPip());
			blackjack.changeState();
			blackjack.play();
			List<Blackjack>splitHands = blackjack.getSplitHands();
			if(!splitHands.isEmpty()) {
				for(Blackjack splitHand: splitHands) {
					blackjackHands.add(splitHand);
				}
			}
			else blackjackHands.add(blackjack);
	     }
	}
	
	/**
	 * It is used to determine the next card to play by dealer.
	 * Dealers must draw on "16 or less" and stand on "17 and more".
	 * Also dealers must hit their soft 17 rather than stand 
	 */
	public void dealerPlay() {
		if(!areAllBustedOrBlackJack()) {
			dealerBlackjack.changeState();
		}
	}
	
    /**
     * It checks whether all players are bursted or received blackjack or surrendered.
     * If so, dealers hand will not be complete
     * @return true if all players are bursted or received blackjack or surrendered.
     */
	public boolean areAllBustedOrBlackJack() {
		int num = 0;
		for(Blackjack b:blackjackHands) {
			if(b.isBusted() || b.isBlackjack()||b.hasPlayerSurrendered()) {
				num++;
			}
		}
		return (num == blackjackHands.size());
	}
 
	/**
	 * It sets the winning or losing amount depending on the result
	 */
	public void result() {
		for(Blackjack b:blackjackHands) {
			if(!b.playerHasSurrendered()) {
				if(winningCondition(b)){
					b.setWinAmount();
					dealerBlackjack.setLostAmount(b.getWinAmount());
				}
				else if(lossCondition(b)){
					 b.setLostAmount();
					 dealerBlackjack.setWinAmount(b.getLostAmount());
				 }
			}
			else if(b.playerHasSurrendered()){
				dealerBlackjack.setWinAmount(b.getLostAmount());
			}
		}
	}
	
	/**
	 * Player wins by not bursting and having a total higher than
	 * the dealer or not bursting and having the dealer burst or getting
	 * a blackjack without the dealer getting a blackjack
	 * @param blackjack b
	 * @return true if winning condition is met
	 */
	private boolean winningCondition(Blackjack b) {
		return (!b.isBusted() && b.getPip()>dealerBlackjack.getPip())
		  ||(!b.isBusted() && dealerBlackjack.isBusted())
		  ||(b.isBlackjack() && !dealerBlackjack.isBlackjack());
	}
	
	/**
	 * Player loses by bursting and having a total lower than
	 * the dealer or bursting and the dealer not getting burst or not getting
	 * a blackjack while the dealer gets a blackjack
	 * @param blackjack b
	 * @return true if losing condition is encountered
	 */
	private boolean lossCondition(Blackjack b) {
		return (!dealerBlackjack.isBusted() && b.getPip()<dealerBlackjack.getPip())
				||(b.isBusted() && !dealerBlackjack.isBusted())
				||(!b.isBlackjack() && dealerBlackjack.isBlackjack());
	}
	
	
	/**
	 * Logs the win and lost amount in dollars
	 */
	public void printResult() {
		LogManager lgmngr = LogManager.getLogManager(); 
		Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		for(Blackjack b:blackjackHands) {
		   log.log(Level.INFO, "Win Amount:"+b.getWinAmount()+" Lost Amount:"+b.getLostAmount());   
		}
		log.log(Level.INFO, "Dealer\nWin Amount:"+dealerBlackjack.getWinAmount()+" Lost Amount:"+dealerBlackjack.getLostAmount());  
	}
	
	
}
