package problem3.factory;

import problem3.deck.Deck;
import problem3.deck.euchre.EuchreImpl;
import problem3.deck.pinochle.PinochleImpl;
import problem3.deck.standard.StandardImpl;
import problem3.deck.vegas.VegasImpl;
import problem3.hand.NewHand;
import problem3.hand.NewHandImpl;

/**
 * DeckFactory class contains factory methods to make playing game with deck
 * and hand flexible
 * @author farha
 * @version 1.0
 */
public class DeckFactory extends AbstractFactory{

	private String vegasDeckType = "Vegas";
	
	/**
	 * Factory method for creating a deck of "Standard","Pinochle","Vegas" or "Euchre".
	 * @param deckType of "Standard","Pinochle","Vegas","Euchre"
	 * @exception IllegalArgumentException if input doesn't match with
	 * above deckTypes.
	 */
	 public Deck getDeck(String deckType) {
		if(deckType != vegasDeckType && deckType != "Standard"
				&& deckType != "Pinochle" 
				&& deckType != "Euchre") {
			throw new IllegalArgumentException("Deck type is invalid. "
					+ "Available decktypes are: Vegas, Standard, Pinochle, Euchre");
		}
	    if(deckType == "Vegas") {
			return new VegasImpl();
		}
	    else if(deckType == "Standard") {
	    	return new StandardImpl();
	    }
	    else if(deckType == "Pinochle") {
	    	return new PinochleImpl();
		}
	    else {
	    	return new EuchreImpl();
	    }      
	}
	
	 /**
	 * Factory method for creating a Vegas deck of size equal to the
	 * numberOfDecks * 52 Standard deck cards.
	 * @param deckType
	 * @param numberOfDecks
	 * @exception IllegalArgumentException if deckType is not equal to "Vegas"
	 */
	public Deck getDeck(String deckType, int numberOfDecks) {
		if(deckType!=vegasDeckType) {
			throw new IllegalArgumentException("Deck type is invalid. It must be Vegas");
		}
		else {
			return new VegasImpl(numberOfDecks);
		}	
	}
	
  
	/**
	 * Factory method for creating Hand
	 * @return Hand object
	 */
	@Override
	public NewHand createHand() {
		return new NewHandImpl();
	}

	
	
}
