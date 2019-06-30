package problem2;

import java.util.Objects;



/**
 * RankImpl is a class which allows to get the name of rank, it's pip value, and sorting order for 
 * sorting it in ascending order of values.
 * @author farha
 * @version 1.0
 */
public class RankImpl implements RankExtend{
	    
    /**
    * Variable for storing rank name
    */
    private String rank;
    
    /**
     * Variables which hold pip values 
     */
	public static final int J = 0;
	public static final int Q = 0;
	public static final int K  = 0;
	public static final int A   = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR  = 4;
	public static final int FIVE  = 5;
	public static final int SIX   = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE  = 9;
	public static final int TEN   = 10;
    
	/**
	 * Constructs a new RankImpl with rank value
	 * @param name of the rank
	 */
	public RankImpl(String rank) {
		this.rank = rank;
	}

	/**
	 * Returns the pip value of a particular rank.
	 * @return integer value of pip
	 */
	public String getName() {
		return this.rank;
	}
	
	/**
	 * Returns the pip value of a particular rank.
	 * @return integer value of pip
	 */
	public int getPips() {
		if(this.rank == "A")
			return A;
		else if(this.rank == "TWO")
			return TWO;
		else if(this.rank == "THREE")
			return THREE;
		else if(this.rank == "FOUR")
			return FOUR;
		else if(this.rank == "FIVE")
			return FIVE;
		else if(this.rank == "SIX")
			return SIX;
		else if(this.rank == "SEVEN")
			return SEVEN;
		else if(this.rank == "EIGHT")
			return EIGHT;
		else if(this.rank == "NINE")
			return NINE;
		else if(this.rank == "TEN")
			return TEN;
		else if(this.rank == "J")
			return J;
		else if(this.rank == "Q")
			return Q;
		else return K;	
	}
	
	/**
	 * Returns the sorting value of a rank to sort them in ascending order
	 * @return integer value of order. If rank name doesn't match with 
	 * specified ranks in EnumContainer class, it returns -1.
	 */
	public Integer getSortValue() {		
		Integer sortOrder = 1;
		for(EnumContainer.StandardRankEnum rankEnum : EnumContainer.StandardRankEnum.values()) {
			if(rankEnum.name() == this.rank) {
				return sortOrder;
			}
			sortOrder++;
		}
		return -1;
	}
	
	/**
	 * It compares two rank objects and returns true if two ranks have same name and pip value.
	 * @param object of Rank instance
	 * @return true if both ranks have same name and pip value
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rank) {
			Rank r = (Rank) o;
			return getName() == r.getName() && getPips() == r.getPips();
		}
		return false;
	}
	
	/**
	 * It overrides hashCode method as equals method has been overriden.
	 * @return the hashcode value of object
	 */
	 @Override
	 public int hashCode() {
	        return Objects.hash(rank);
	 }
	
	
	
	
}
