package problem3.state;

import java.util.List;

import problem3.card.Card;
import problem3.deck.Deck;
import problem3.hand.Hand;
import problem3.rank.Rank;
import problem3.rank.RankImpl;
import problem3.hand.NewHandImpl;

/**
 * It implements methods to play hand by dealer
 * @author farha
 * @version 1.1
 */
public class DealerBlackjack{
	private Deck deck;
	private Hand hand;
	private boolean isBlackjack = false;
	private boolean isMax = false;
	private boolean isBusted = false;
	private List<Card>cardsInHand;
	private int pip;
	private float winAmount = 0;
	private float lostAmount= 0;
	
	/**
	 * Constructs the object with deck of cards and hand with 2 cards
	 * @param deck
	 * @param hand
	 */
	public DealerBlackjack(Deck deck, Hand hand) {
		this.deck = deck;
		this.hand = hand;
		this.cardsInHand = hand.showCard();
	}
	
	/**
	 * Calculates the totalpip value of card in hand
	 * @return interger pip value
	 */
	private int calculatePipValue() {
		int pipValue = 0;
		for(Card card : cardsInHand) {
			pipValue+=card.getRank().getPips();
	    }
		this.pip = pipValue;
		return pipValue;
	}
	
	/**
	 * Finds the number of ACE in hand
	 * @return number of ACE
	 */
	private int occurencesOfAce() {
		Rank rank = new RankImpl("ACE");
		return ((NewHandImpl) hand).occurencesInHand(rank);
	}
	
	/**
	 * It determines the next move to take my dealer.
	 * Dealer must draw on 16 or less and stand on 
	 * 17 or more. Also they must hit their soft 17
	 * rather than stand
	 */
	public void changeState() {
		this.pip = calculatePipValue();
		if(occurencesOfAce()>=1) {
			changeStateWhenSoftTotal();
		}
		else 
			changeStateWhenHardTotal();	
	}
	
	/**
	 * Helper function for determining next move by pip value
	 * when ACE is present
	 */
	private void changeStateWhenSoftTotal() {
		
		if(this.pip<=17) {
			hit();
		}
		else if(this.pip == 21 && cardsInHand.size()==2) {
			this.isBlackjack = true;
		}
		else if(this.pip == 21) {
	    	   this.isMax = true;
	    }
        else if(this.pip>21) {
        	changeAcePipToOne();
        }
	}
	
	/**
	 * Determines the value of ACE to be either 1 or 11
	 * that favours the dealer
	 */
	private void changeAcePipToOne() {
		for(int i = 0; i<occurencesOfAce();i++) {
			this.pip = this.pip-10;
			if(this.pip<=21) {
			  if(this.pip == 21) {
		    	    this.isMax = true;
		      }
  			  break;
  		  }
   		  }
  	   }
	
	/**
	 * Helper function for determining next move by pip value
	 * ofor hard total
	 */
    private void changeStateWhenHardTotal() {
    	if(this.pip<=16) {
			hit();
		}
		else if(this.pip == 21) {
			this.isMax = true;
		}
		else if(this.pip>21) {
			this.isBusted = true;
		}
	}
	
    /**
	 * It takes a card from the deck and changes state based on pip 
	 * value.
	 */
    public void hit() {
		Card card = deck.pullCard();
		hand.accept(card);
		changeState();
	}

    /**
	 * It returns true if a dealer receives a blackjack
	 * @return true if dealer receives blackjack
	 */
	public boolean isBlackjack() {
		return isBlackjack;
	}


	/**
	   * It returns true if a dealer has reached the highest 21 score
	   * @return true if dealer receives 21
	   */
	public boolean isMax() {
		return isMax;
	}

	
	/**
	   * It returns true if a dealer exceeds 21
	   * @return true if dealer has busted
	   */
	public boolean isBusted() {
		return isBusted;
	}

	/**
	 * It returns the total pip value of cards in hand
	 * @return pip value
	 */
	public int getPip() {
		return pip;
	}

	

	/**
	 * It is used to return hand
	 * @return hand
	 */
	public Hand getHand() {
		return hand;
	}

	
	 /**
     * It sets the winning amount to equal to bet amount
     */
	public void setWinAmount(float amount) {
		this.winAmount+= amount;
	}

	/**
	 * It gets the winning amount of hand
	 * @return win amount
	 */
	public float getWinAmount() {
		return winAmount;
	}
	
	 /**
     * It sets the lost amount to equal to bet amount
     */
	public void setLostAmount(float amount) {
		this.lostAmount+= amount;
	}

	/**
	 * It gets the lost amount of hand
	 * @return lost amount
	 */
	public float getLostAmount() {
		return lostAmount;
	}
	
	
	
}
