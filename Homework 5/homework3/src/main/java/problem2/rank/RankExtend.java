package problem2.rank;

public interface RankExtend extends Rank{
	
	/**
	 * Returns the sorting value of a rank to sort them in ascending order
	 * @return integer value of order. If rank name doesn't match with 
	 * specified ranks in EnumContainer class, it returns -1.
	 */
	public Integer getSortValue();
}
