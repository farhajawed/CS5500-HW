import java.util.ArrayList;

/**
 * @author farha
 * @version 1.0
 * A Numbers is an interface that contains methods to be implemented by PrintNumbers class.
 */
public interface Numbers {
	
	/**
	 * This method is used to store the integer inputs of the user
	 * @return array of integers entered by user. 
	 * @exception InputMismatchException 
	 */
    public int[] storeUserInput();
    
    
    /**
	 * This method is used to print odd numbers between two integers.
	 * @param firstNumber This is the first integer entered by user
	 * @param secondNumber This is the second integer entered by user
	 * @return ArrayList of odd integers between firstNumber and secondNumber
	 */
    public ArrayList<Integer> printOddNumbers(int firstNumber, int secondNumber);    
}