package problem2.rank;

/**
 * Rank in an interface which allows to get the name of rank and pip value
 * @author farha
 * @version 1.0
 */
public interface Rank {
	
	/**
	 * Returns the name of rank.
	 * @return the name of rank
	 */
	public String getName();
	
	/**
	 * Returns the pip value of a particular rank.
	 * @return integer value of pip
	 */
	public int getPips();

}
