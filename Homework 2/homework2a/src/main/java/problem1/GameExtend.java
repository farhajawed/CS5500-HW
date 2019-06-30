package problem1;

import java.util.List;


/**
 * It extends Game interface to get Deck and list of hands
 * @author farha
 * @version 1.0
 */
public interface GameExtend extends Game{
	
	 /**
     * Gets the Deck object created by the game
     * @return deck object
     */
    public Deck getDeck();
    
    /**
     * Gets the array of hands created by the game
     * @return array of hands
     */
	public List<Hand> getHands();
	
}
