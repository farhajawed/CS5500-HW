package problem2;

import java.util.Comparator;

/**
 * SuitComparator class implements Comparator interface and compares two Card objects based on their suits.
 * It is used for sorting suits in alphabetical order: CLUBS, DIAMONDS, HEARTS, SPADES.
 * @author farha
 * @version 1.0
 */
public class SuitComparator implements Comparator<Card>{

	/**
	 * It compares two Card objects based on Suit name in alphabetical order.
	 * @param cardOne first Card object
	 * @param cardTwo second Card object
	 * @return -1,0,1 if cardOne is less than, equal to or greater than cardTwo based on suit name.
	 */
	public int compare(Card o1, Card o2) {
		return o1.getSuit().getName().compareTo(o2.getSuit().getName());
	}
	

}
