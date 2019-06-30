
package homework.testing;

/**
 * This class implements the methods of UnitTestingHomework class.
 * 
 * @author Farha Jawed
 * @version 1.0
 *
 */
public class UnitTestingHomeworkImpl {

	/**
	 * Sqrt.
	 *
	 * @param n the radicand
	 * @return the square root of the radicant
	 */
	public double sqrt(int n) {
		if(n<0) {
			return -1;
		}
		return Math.sqrt(n);
	}
	
	
	/**
	 * Sqr.
	 *
	 * @param n the factor 
	 * @return the product of the factor times itself
	 */
	public int sqr (int n) {
		long square = (long)n*(long)n;
		if(square>Integer.MAX_VALUE) {
			return -1;
		}
		return (int)square;
	}
	
	/**
	 * Factorial.
	 *
	 * @param n the largest factor to consider
	 * @return n!
	 */
	public int factorial (int n) {
		if(n < 0 ) {
			return -1;
		}
		long fact = 1;
		for(int i=1;i<=n;i++){    
		      fact=fact*i;    
		      if(fact > Integer.MAX_VALUE) {
		    	  return -1;
		      }
		 }   
		return (int)fact;
	}
	
	 /**
 	 * Produces the sum from 0 to n.
 	 *
 	 * @param n the largest addend
 	 * @return the sum
 	 */
 	public int sumUp(int n) {
 		long sum = 0;
 		if(n<0) {
 			return -1;
 		}
 		for(int i = 1 ; i<= Math.abs(n); i++) {
 			sum+=i;
 		}
 		return (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) ? -1:(int)sum;
 	}
 	
 	/**
	  * Simple function that adds two numbers together.
	  *
	  * @param x the first addend
	  * @param y the second addend
	  * @return the sum of x and y
	  */
	 public int simpleFunctionXplusY(int x, int y) {
		 long sum = (long)x+y;
		 if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			 return -1;
		 }
		 return (int)sum;
		 
	 }
	 
	 
	 /**
 	 * Despacer.  Replace multiple contiguous spaces with a single space
 	 *
 	 * @param inputText the input text
 	 * @return the string with only single spaces in it
 	 */
 	public String despacer(String inputText) {
 		return inputText.replaceAll("\\s{2,}", " ");
 	}
 	
}
