package problem1.iterator;

import problem1.hand.Hand;

/**
 * Implements the Iterator creation interface to return an instance of 
 * the proper ConcreteIterator
 * @author farha
 * @version 1.1
 */
public class ConcreteAggregate implements Aggregate{

	/**
	 * It creates an iterator object for hand.
	 * @param hand
	 * @return instance of ConcreteIterator
	 */
	public ConcreteIterator createIterator(Hand hand) {
		return new ConcreteIterator(hand);
	}
 
}
