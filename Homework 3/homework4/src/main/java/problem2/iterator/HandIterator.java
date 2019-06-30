package problem2.iterator;

/**
 * It defines an iterator for accessing and traversing elements
 * @author farha
 * @param <T>
 * @version 1.1
 */
public interface HandIterator<T> {
	
	/**
	 * It keeps the position of first card in hand.
	 * @return the first position of card
	 */
	int first();    
	
	/**
	 * It increases the position of card in hand by 1.
	 * @return the next position of card
	 */
	int next();    
	
	/**
	 * It checks whether all cards in hand is traversed
	 * @return true if the position is equal to size of cards in hand
	 */
	boolean isDone(); 
	
	/**
	 * It returns the current card in hand
	 * @return current object
	 * @exception IndexOutOfBoundsException if there are no cards in hand or 
 	 * index position is greater than number of cards in hand
	 */
    T current();      
}
