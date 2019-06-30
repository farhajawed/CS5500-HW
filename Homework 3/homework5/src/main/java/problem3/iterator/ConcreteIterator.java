package problem3.iterator;

import java.util.List;

import problem3.card.Card;
import problem3.hand.Hand;

/**
 * It implements an iterator for accessing and traversing cards in hand
 * @author farha
 * @version 1.1
 */
public class ConcreteIterator implements HandIterator<Card>{

	 private List<Card> cards;
     private int position;
     
     /** 
      * It constructs an ConcreteIterator object with cards
      * in hand and intial position of card
      * @param hand
      */
     public ConcreteIterator(Hand hand) {
    	 this.cards = hand.showCard();
    	 this.position = 0;
     }
     
     /**
 	 * It keeps the position of first card in hand.
 	 * @return the first position of card
 	 */
     public int first() {
    	 this.position = 0;
    	 return this.position;
     }
     
     /**
 	 * It increases the position of card in hand by 1.
 	 * @return the next position of card
 	 */
     public int next() {
    	 this.position++;
    	 return this.position;
     }
     
     /**
 	 * It checks whether all cards in hand is traversed
 	 * @return true if the position is equal to size of cards in hand
 	 */
     public boolean isDone() {
    	 return this.position == cards.size();
     }
     
     /**
 	 * It returns the current card in hand
 	 * @return current card
 	 * @exception IndexOutOfBoundsException if there are no cards in hand or 
 	 * index position is greater than number of cards in hand
 	 */
     public Card current() {
    	 if(cards.isEmpty()) {
    		 throw new IndexOutOfBoundsException("No cards in hand");
    	 }
    	 else if(cards.size()<=this.position) {
    		 throw new IndexOutOfBoundsException("Card not found at this position");
    	 }
    	 return cards.get(this.position);
     }
	
}
