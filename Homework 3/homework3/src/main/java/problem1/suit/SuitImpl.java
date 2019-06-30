package problem1.suit;

import java.util.Objects;

import problem1.card.EnumContainer;
import problem1.card.EnumContainer.SuitsEnum;

/**
 * SuitImpl class is used to get name, symbol of suits, and compare two suits.
 * @author farha
 * @version 1.0
 */
public class SuitImpl implements Suit{
	
	/**
	 * It holds the name of suit
	 */
	private String name;
	
	/**
	 * Constructs SuitImpl object with suit name
	 * @param suit
	 */
	public SuitImpl(String suit) {
		this.name = suit;
	}

	/**
	 * Returns the name of suit e.g. CLUBS, DIAMONDS, HEARTS, SPADES
	 * @Return name of suit 
	 * @exception IllegalArgumentException if suit name doesn't match with
	 * the names declared in EnumContainer class
	 */
	public String getName() {
		if(this.name != EnumContainer.SuitsEnum.CLUBS.name() &&
		    	this.name != EnumContainer.SuitsEnum.DIAMONDS.name() &&
		    	this.name != EnumContainer.SuitsEnum.SPADES.name() &&
		    	this.name != EnumContainer.SuitsEnum.HEARTS.name()) {
		    	throw new IllegalArgumentException("Invalid suit");
		}
		else {
			return this.name;
		}	
	}
    
	/**
	 * Returns the symbol of suit in unicode
	 * @return name of symbol in unicode
	 * @exception IllegalArgumentException if suit name doesn't match with
	 * the names declared in EnumContainer class
	 */
	public char getSymbol(){
	    if(this.name != EnumContainer.SuitsEnum.CLUBS.name() &&
	    	this.name != EnumContainer.SuitsEnum.DIAMONDS.name() &&
	    	this.name != EnumContainer.SuitsEnum.SPADES.name() &&
	    	this.name != EnumContainer.SuitsEnum.HEARTS.name()) {
	    	throw new IllegalArgumentException("Invalid suit");
	    }
	    else if(this.name == EnumContainer.SuitsEnum.CLUBS.name()) {
			return '\u2663';
		}
		else if(this.name == EnumContainer.SuitsEnum.DIAMONDS.name()) {
			return '\u2662';
		}
		else if(this.name == EnumContainer.SuitsEnum.SPADES.name()) {
			return '\u2664';
		}
		else return '\u2661';		
	}
	
	/**
	 * It compares two suit objects and returns true if two suits have same name and symbol.
	 * @param object of Suit instance
	 * @return true if both suits have same name and symbol
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Suit) {
			Suit s = (Suit) o;
			return getName() == s.getName() && getSymbol() == s.getSymbol();
		}
		return false;
	}
	
	/**
	 * It overrides hashCode method as equals method has been overriden.
	 * @return the hashcode value of object
	 */
	 @Override
	 public int hashCode() {
	        return Objects.hash(name);
	 }
}
