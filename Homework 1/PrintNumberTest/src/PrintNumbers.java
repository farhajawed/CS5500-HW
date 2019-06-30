import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author farha
 * @version 1.0
 * PrintNumbers class takes as input two integers from users and prints
 * out all odd integers between those two numbers.
 */
public class PrintNumbers implements Numbers{

	/**
	 * This method is used to store the integer inputs of the user
	 * @return array of integers entered by user. 
	 * @exception InputMismatchException     
	 */
	public int[] storeUserInput() {
		int[] number = new int[2]; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first number:");
		number[0] = scanner.nextInt();
		
		System.out.println("Enter second number:");
		number[1] = scanner.nextInt();
		scanner.close();
		return number;
	}

	 /**
	   * This method is used to print odd numbers between two integers.
	   * @param firstNumber This is the first integer entered by user
	   * @param secondNumber This is the second integer entered by user
	   * @return ArrayList of odd integers between firstNumber and secondNumber
	   */
	public ArrayList<Integer> printOddNumbers(int firstNumber, int secondNumber) {
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		if(firstNumber == secondNumber) {
			System.out.println("Two numbers cannot be equal.");
		}
		else if(firstNumber > secondNumber) {
			System.out.println("Second number must be greater than the first number.");
		}
		
		else {
			for(int i = firstNumber+1; i<secondNumber; i++) {
				if(i%2 == 1) {
					System.out.println(i);
					listOfNumbers.add(i);
				}
			}
			if(listOfNumbers.size()==0) {
				System.out.println("No odd numbers within the range");
			}
		}
		return listOfNumbers;
	}
	
	/**
	 * This is the main function for printing all odd integers between 2 integers
	 * @param args
	 * @return nothing
	 */
	public static void main(String[] args) {
		PrintNumbers printNumbers = new PrintNumbers();
		int[] numbers = printNumbers.storeUserInput();
		printNumbers.printOddNumbers(numbers[0], numbers[1]);	
	}
	
}