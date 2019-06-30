import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class TestJunit {
	
	PrintNumbers printNumbers = new PrintNumbers();
	
	/**
	 * Test for printing odd integers within range where the first number
	 * is smaller than the second.
	 * Expected output is range of odd integers
	 */
    @Test
    public void shouldPrintIntegersWithinRange() {
       ArrayList<Integer>expectedOutputRangeTest = 
    			new ArrayList<>(Arrays.asList(11,13,15,17,19));
       ArrayList<Integer>actualOutputRangeTest = printNumbers.printOddNumbers(10, 21);
       assertEquals(expectedOutputRangeTest,actualOutputRangeTest);
    }
    
    
    /**
	 * Test for printing odd integers when both the numbers are equal.
	 * Expected output is null.
	 */
    @Test
    public void shouldNotPrintIntegersForEqualNumbers() {
    	ArrayList<Integer>expectedOutputEqualTest = 
    			new ArrayList<>();
       ArrayList<Integer>actualOutputEqualTest = printNumbers.printOddNumbers(10, 10);
       assertEquals(expectedOutputEqualTest,actualOutputEqualTest);
    	
    }
    
    /**
	 * Test for printing odd integers when first number is greater than the second.
	 * Expected output is null.
	 */
    @Test
    public void shouldNotPrintIntegersForFirstNumberLarger() {
    	ArrayList<Integer>expectedOutputLargeFirstNumber = 
    			new ArrayList<>();
       ArrayList<Integer>actualOutputLargeFirstNumber = printNumbers.printOddNumbers(30, 10);
       assertEquals(expectedOutputLargeFirstNumber,actualOutputLargeFirstNumber);
    	
    }
    
}