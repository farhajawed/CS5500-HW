package problem3;

import problem3.state.BlackjackFactory;


/**
 * Plays blackjack consisting of 6 standard decks and 5 players
 * @author farha
 * @version 1.1
 */
public class App 
{
    public static void main( String[] args )
    {
      
        BlackjackFactory bjack = new BlackjackFactory();
        bjack.playBlackjack(5, 6); 
        
    }
}
