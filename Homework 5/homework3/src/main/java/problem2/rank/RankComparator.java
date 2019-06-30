package problem2.rank;

import java.util.Comparator;

import problem2.card.Card;

/**
 * RankComparator class implements Comparator interface and compares two Card objects on their ranks.
 * @author farha
 * @version 1.0
 */
public class RankComparator implements Comparator<Card>{
	
	/**
	 * It compares two Card objects based on sorting value as defined in RankImpl class.
	 * @param cardOne first Card object
	 * @param cardTwo second Card object
	 * @return -1,0,1 if cardOne is less than, equal to or greater than cardTwo based on sorting value
	 */
	public int compare(Card cardOne, Card cardTwo) {
		return ((RankImpl) cardOne.getRank()).getSortValue().compareTo(((RankImpl) cardTwo.getRank())
				.getSortValue());
	}
	

}
