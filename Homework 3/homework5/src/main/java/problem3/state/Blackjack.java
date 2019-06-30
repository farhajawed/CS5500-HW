package problem3.state;

import java.util.ArrayList;
import java.util.List;

import problem3.card.Card;
import problem3.deck.Deck;
import problem3.hand.Hand;
import problem3.hand.NewHandImpl;
import problem3.rank.Rank;
import problem3.rank.RankImpl;

/**
 * Blackjack class localizes state specific behaviour and paritions
 * behaviour for different states.
 * @author farha
 * @version 1.1
 */
public class Blackjack {

	private Deck deck;
	private Hand hand;
	private int dealerFaceUpPip;
	private BlackjackState state;
	private List<Card>cardsInHand;
	private boolean isBlackjack = false;
	private boolean isMax = false;
	private boolean isBusted = false;
	private boolean hasSurrendered = false;
	private boolean isStand = false;
	private float betAmount = 1;
	private float winAmount = 0;
	private float lostAmount= 0;
	private List<Blackjack>splitHands = new ArrayList<Blackjack>();
	private int pip;
	
	/**
	 * Constructs a blackjack with hand, deck and dealer face up card
	 * @param hand
	 * @param deck
	 * @param dealerFaceUpPip
	 */
	public Blackjack(Hand hand,Deck deck,int dealerFaceUpPip) {
		this.deck = deck;
		this.hand= hand;	
		this.dealerFaceUpPip=dealerFaceUpPip;
		this.cardsInHand = hand.showCard();
	}
	
	/**
	 * Calculates the totalpip value of card in hand
	 * @return interger pip value
	 */
	public int calculatePipValue() {
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
	 * Helper function for determining whether a pairs is present in hand.
	 * @return true if present
	 */
	private boolean isPair() {
		return cardsInHand.size()==2 &&
				cardsInHand.get(0).getRank().equals(cardsInHand.get(1).getRank());
	}
	
	/**
	 * It changes the state of object instance based on total
	 * pip value of cards in hand
	 */
	public void changeState() {
		this.pip = calculatePipValue();
		if(isPair()) {
			changeStateWhenPair();
		}
		else if(occurencesOfAce()>=1) {
			changeStateWhenSoftTotal();
		}
		else 
			changeStateWhenHardTotal();	
	}
	
	/**
	 * Changes the state when pairs is present in hand
	 */
	private void changeStateWhenPair() {
		Rank rank = cardsInHand.get(0).getRank();
		if(rank.getPips()==11 || rank.getPips()==8) {
			state = StateAllSplits.instance();
		}
		else if(rank.getPips()==10) {
			state = StateAllStands.instance();
		}
		else if(rank.getPips()==9) {
			state = State99.instance();
		}
		else if(rank.getPips()==7) {
			state = State77.instance();
		}
		else if(rank.getPips()==6) {
			state = State66.instance();
		}
		else if(rank.getPips()==5) {
			state = StateAllHits.instance();
		}
		else if(rank.getPips()==4) {
			state = State44.instance();
		}
		else if(rank.getPips()==3 || rank.getPips()==2) {
			state = State2233.instance();
		}
		
	}
	
	/**
	 * It changes state for soft total(ACE is present)
	 */
	private void changeStateWhenSoftTotal() {
		  if(this.pip>=13 && this.pip<=17) {
	    	  state = StateAllHits.instance();
	       }
	       else if(this.pip == 18) {
	    	   state = StateA7.instance();
	       }
	       else if(this.pip == 19 || this.pip == 20) {
	    	   state = StateAllStands.instance();
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
	 * that favours the player
	 */
	private void changeAcePipToOne() {
		for(int i = 0; i<occurencesOfAce();i++) {
  		  this.pip = this.pip-10;
  		  if(this.pip<=21) {
  			  changeStateWhenHardTotal();
  			  break;
  		  }
  	   }
	}
	
	/**
	 * It changes state for hard total
	 */
	public void changeStateWhenHardTotal() {
		if(this.pip >=5 && this.pip <=11) {
			state = StateAllHits.instance();
		}
		else if(this.pip == 12) {
			state = State12.instance();
		}
		else if(this.pip == 13 || this.pip==14) {
			state = State1314.instance();
		}
		else if(this.pip == 15) {
			state = State15.instance();
		}
		
		else if(this.pip == 16) {
			state = State16.instance();
		}
		else if(this.pip >= 17 && this.pip <= 20) {
			state = StateAllStands.instance();
		}
		else if(this.pip == 21) {
			this.isMax = true;
		}
		else if(this.pip>21) {
			this.isBusted = true;
		}
	}
	
	/**
	 * Determines which method to call depending on the face up card
	 * of dealer
	 */
	 public void play() {
		   if(!isBusted && !isBlackjack && !isMax) {
			if(dealerFaceUpPip==2) {
				dealerCardTwo();
			}
			else if(dealerFaceUpPip==3) {
				dealerCardThree();
			}
			else if(dealerFaceUpPip==4) {
				dealerCardFour();
			}
			else if(dealerFaceUpPip==5) {
				dealerCardFive();
			}
			else if(dealerFaceUpPip==6) {
				dealerCardSix();
			}
			else if(dealerFaceUpPip==7) {
				dealerCardSeven();
			}
			else if(dealerFaceUpPip==8) {
				dealerCardEight();
			}
			else if(dealerFaceUpPip==9) {
				dealerCardNine();
			}
			else if(dealerFaceUpPip==11) {
				dealerCardA();
			}
			else if(dealerFaceUpPip==10) {
				dealerCardTen();
			}
	     }
	}
	
	 
    /**
	 * It determines the next step to take when dealer's face up card 
	 * is TWO
	 */
	public void dealerCardTwo() {
		state.dealerCardTwo(this);
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is THREE
	 */
	public void dealerCardThree() {
		state.dealerCardThree(this);
		
	}
	
	/**
	 * It determines the next step to take when dealer's face up card 
	 * is FOUR
	 */
	public void dealerCardFour() {
		state.dealerCardFour(this);	
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is FIVE
	 */
	public void dealerCardFive() {
		state.dealerCardFive(this);
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is SIX
	 */
	public void dealerCardSix() {
		state.dealerCardSix(this);
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is SEVEN
	 */
	public void dealerCardSeven() {
		state.dealerCardSeven(this);
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is EIGHT
	 */
	public void dealerCardEight() {
		state.dealerCardEight(this);
		
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is NINE
	 */
	public void dealerCardNine() {
		state.dealerCardNine(this);
	}
	

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is TEN,JACK, QUEEN, KING or pip value of 10
	 */
	public void dealerCardTen() {
		state.dealerCardTen(this);
	}

	/**
	 * It determines the next step to take when dealer's face up card 
	 * is ACE
	 */
	public void dealerCardA() {
		state.dealerCardA(this);
	}
	
	/**
	 * It takes a card from the deck and changes state based on pip 
	 * value and dealer's face up card.
	 */
	public void hit() {
		Card card = deck.pullCard();
		hand.accept(card);
		changeState();
		play();
	}
	
	/**
	 * It is called when a hand surrenders.
	 * The hand loses half the amount of bet.
	 */
	public void surrender() {
		this.hasSurrendered = true;
		this.lostAmount = this.betAmount/2;
	}
	
	/**
	 * It splits the card in hands into 2 separate hands and each hand gets
	 * an additional card.
	 * Splitting is only possible when there are 2 cards in hand only.
	 */
	public void split() {
		
		Hand handNew = splitHands();
		changeState();
	    play();
	    
	    Blackjack b = new Blackjack(handNew,this.deck,this.dealerFaceUpPip);
	    b.changeState();
		b.play();
		
		this.splitHands.add(this);
		this.splitHands.add(b);
	}

	/**
	 * Helper method for spliting the cards into 2 hands
	 * @return new hand by splitting
	 */
	private Hand splitHands() {
		Card card = this.hand.pullCard();
		Hand handNew = new NewHandImpl();
		handNew.accept(card);
		card = deck.pullCard();
		handNew.accept(card);
		
		card = deck.pullCard();
		hand.accept(card);
		return handNew;
	}
		
	/**
	 * It gets the winning amount of hand
	 * @return win amount
	 */
	public float getWinAmount() {
		return winAmount;
	}

    /**
     * It sets the winning amount to equal to bet amount
     */
	public void setWinAmount() {
		this.winAmount = this.betAmount;
	}

	 /**
     * It sets the lost amount to equal to bet amount
     */
	public void setLostAmount() {
		this.lostAmount = this.betAmount;
	}

	/**
	 * It gets the lost amount of hand
	 * @return lost amount
	 */
	public float getLostAmount() {
		return lostAmount;
	}

  /**
   * It returns true if a player has surrendered the game.
   * @return true if surrendered
   */
	public boolean playerHasSurrendered() {
		return hasSurrendered;
	}

	 /**
	   * It returns true if a player choose to stand.
	   * @return true if stands
	   */
	public void stand() {
		this.isStand = true;
	}
	
	/**
	   * It returns true if a player has chosen to stand.
	   * @return true if surrendered
	   */
	public boolean getStand() {
		return this.isStand;
	} 
 
	
	/**
	 * It gets the List of hands after split
	 * @return Blackjack
	 */
	public List<Blackjack> getSplitHands() {
		return splitHands;
	}

	/**
	 * It gets the pip value
	 * @return integer pip
	 */
	public int getPip() {
		return pip;
	}

	/**
	 * It returns true if a player receives a blackjack
	 * @return true if player receives blackjack
	 */
	public boolean isBlackjack() {
		return isBlackjack;
	}

	/**
	   * It returns true if a player has reached the highest 21 score
	   * @return true if player receives 21
	   */
	public boolean isMax() {
		return isMax;
	}

	/**
	   * It returns true if a player exceeds 21
	   * @return true if player has busted
	   */
	public boolean isBusted() {
		return isBusted;
	}

	/**
	   * It returns true if a player has surrendered
	   * @return true if player surrenders
	   */
	public boolean hasPlayerSurrendered() {
		return hasSurrendered;
	}

	/**
	 * Returns the instance of BlackjackState object
	 * @return instance of BlackjackState
	 */
	public BlackjackState getState() {
		return state;
	}

	/**
	 * It is used to return hand
	 * @return hand
	 */
	public Hand getHand() {
		return hand;
	}

	
	
	
}
