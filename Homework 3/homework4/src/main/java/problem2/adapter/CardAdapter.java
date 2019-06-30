package problem2.adapter;

import diErBao.Ka;
import diErBao.kaShiXia.KaDengJíEnum;
import problem2.card.Card;
import problem2.rank.Rank;
import problem2.rank.RankImpl;
import problem2.suit.Suit;
import problem2.suit.SuitImpl;

/**
 * CardAdapter class has a pointer to Ka and implements Card interface
 * @author farha
 * @version 1.1
 */
public class CardAdapter implements Card{

	
	private Ka ka;
	
	/**
	 * Constructs CardAdapter with ka as parameter
	 * @param ka
	 * @exception NullPointerException is ka is null
	 */
	public CardAdapter(Ka ka) {
	   if(ka == null) {
		   throw new IllegalArgumentException("Ill formed card");
	   }
		this.ka = ka;
	}
	
	/**
	 * Returns Rank of the Card by matching the rank name with the 
	 * ordinal position of enum in ka class
	 * e.g. if rank is 0, rank name is TWO
	 * if rank is 1, rank name is THREE
	 * if rank is 2, rank name is FOUR
	 * if rank is 9, rank name is JACK
	 * if rank is 10, rank name is QUEEN
	 * if rank is 11, rank name is KING
	 * if rank is 12, rank name is ACE
	 * @return Rank object
	 */
	@Override
	public Rank getRank() {
		int rank = ka.getRank();
		for(KaDengJíEnum s : KaDengJíEnum.values()) {
  	        if(s.ordinal()==rank) {
  	        	return new RankImpl(s.name());
  	        } 
   	     }
		return null;
	}

	/**
	 * Returns Suit of the Card depending on value of suit
	 * as returned by ka class.
	 * @return Suit object
	 */
	@Override
	public Suit getSuit() {
		int suit = ka.getSuit();
		if(suit == 0) {
			return new SuitImpl("CLUBS");
		}
		else if(suit == 1) {
			return new SuitImpl("DIAMONDS");
		}
		else if(suit == 2) {
			return new SuitImpl("HEARTS");
		}
		else
			return new SuitImpl("SPADES");
	}
	
	/**
	 * It returns instance of ka
	 * @return ka
	 */
	public Ka getKa() {
		return this.ka;
	}
	
	
	/**
	 * It compares two Card objects and returns true if two Cards have same rank name and suit name.
	 * @param object of Card instance
	 * @return true if both Cards have same rank and suit names.
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Card cannot be null");
		}
		else if (object instanceof CardAdapter) {
		   Ka kaObject = ((CardAdapter) object).ka;
		   return ka.equals(kaObject);
		}
		return false;
	}
	
	/**
	 * It overrides hashCode method as equals method has been overriden.
	 * @return the hashcode value of object
	 */
	@Override
	public int hashCode() {
		return ka.hashCode();
	}

	 /**
     * Returns the object in string format with name of rank and suit.
     * @return string with name of rank, and suit.
     */
	 @Override
	 public String toString() {
			return this.getRank().getName()+" "+this.getSuit().getName()+" \n";
	  }
	
}
