package problem2.iterator;

import problem2.hand.Hand;

/**
 * It defines an interface for creating an iterator object for traversing hand
 * @author farha
 * @version 1.1
 */
public interface Aggregate {
	/**
	 * It creates an iterator object for hand.
	 * @param hand
	 * @return instance of ConcreteIterator
	 */
    public ConcreteIterator createIterator(Hand hand);
}
