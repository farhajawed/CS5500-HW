package problem3.hand;

import problem3.card.Card;
import problem3.iterator.Aggregate;
import problem3.iterator.ConcreteAggregate;
import problem3.iterator.HandIterator;
import problem3.rank.Rank;

/**
 * NewHandImpl implements NewHand interface and extends HandImpl class and 
 * overrides hasCard method
 * to use custom-built hand iterator and implements two additional methods for 
 * counting the number of occurences of a card and rank in hand
 * @author farha
 * @version 1.1
 */
public class NewHandImpl extends HandImpl implements NewHand{
	
	private Aggregate concreteAgg = new ConcreteAggregate();
	
	/**
	 * It checks whether a card is present in hand.
	 * @param card
	 * @return true if card is present
	 */
	@Override
	public Boolean hasCard(Card cardToFind) {
		Boolean found = false;
		HandIterator<Card> it = concreteAgg.createIterator(this);
		for(it.first();!it.isDone();it.next()) {
 			Card card = it.current();
 			if(card.equals(cardToFind)) {
		    	found = true;
		    	break;
		    }
 		}
		return found;
	}
	
	/**
	 * It counts the number of occurences of the given card in hand.
	 * @param card
	 * @return number of occurences of card
	 */
	public int occurencesInHand(Card card) {
		HandIterator<Card> it = concreteAgg.createIterator(this);
		int occurance = 0;
		for(it.first();!it.isDone();it.next()) {
 			Card c = it.current();
 			if(c.equals(card)) {
		    	occurance++;
		    }
 		}
		return occurance;
	}
	
	/**
	 * It counts the number of occurences of the given rank in hand.
	 * @param card
	 * @return number of occurences of rank
	 */
	public int occurencesInHand(Rank rank) {
		HandIterator<Card> it = concreteAgg.createIterator(this);
		int occurance = 0;
		for(it.first();!it.isDone();it.next()) {
 			Card c = it.current();
 			if(c.getRank().equals(rank)) {
		    	occurance++;
		    }
 		}
		return occurance;
	}


}
