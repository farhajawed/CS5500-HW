package problem1;

/**
 * App is a class containing Main method for creating deck with cards
 * @author farha
 * @version 1.0
 */
public class App 
{
	/**
	 * Main method which creates a Standard Deck with 5-card hands.
	 * Number of hands is also 5.
	 * @param args
	 */
    public static void main( String[] args )
    {
    	Game game = new GameImpl();
        game.createDeck("Standard");
        game.setNumberOfHands(5);
        game.deal();
    
    }
}
