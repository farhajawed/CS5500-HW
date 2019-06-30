package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test cases for finding the square root of an interger number
 * @author farha
 * @version 1.0
 */
public class TestSqrt {

	
	private static UnitTestingHomeworkImpl testing;

	@BeforeAll
	public static void setUp() {
		testing = new UnitTestingHomeworkImpl();
	}
	
	/**
	 * Testing square root of 0 (on lower boundary)
	 */
	@Test
	public void testSquareRootZero() {
		assertEquals(0.0,testing.sqrt(0));
	}
	
	/**
	 * Testing square root of 1 (one above lower boundary)
	 */
	@Test
	public void testSquareRootOne() {
		assertEquals(1.0,testing.sqrt(1));
	}
	
	/**
	 * Testing square root of -1 (one below lower boundary)
	 */
	@Test
	public void testSquareRootNegativeOne() {
		assertEquals(-1.0,testing.sqrt(-1));
	}
	
	/**
	 * Testing square root of valid small number 2
	 */
	@Test
	public void testSquareRootTwo() {
		assertEquals(1.41,testing.sqrt(2),0.1);
	}
	
	/**
	 * Testing square root of valid small number 3
	 */
	@Test
	public void testSquareRootThree() {
		assertEquals(1.73,testing.sqrt(3),0.1);
	}
	
	/**
	 * Testing square root of valid small number 4
	 */
	@Test
	public void testSquareRootFour() {
		assertEquals(2.0,testing.sqrt(4));
	}
	
	
	/**
	 * Testing square root of valid medium number 
	 */
	@Test
	public void testSquareRootValidMediumNumber() {
		assertEquals(92.5,testing.sqrt(8568),0.1);
	}
	
	/**
	 * Testing square root of invalid negative large number
	 */
	@Test
	public void testSquareRootLargeNegativeNumber() {
		assertEquals(-1.0,testing.sqrt(-2147483648));
	}
	
	/**
	 * Testing square root of valid largest number (at exact upper boundary)
	 */
	@Test
	public void testSquareRootValidLargestNumber() {
		assertEquals(46340.9,testing.sqrt(2147483647),0.1);
	}
}
