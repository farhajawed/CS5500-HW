package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Testing the implementation of factorial method
 * @author farha
 * @version 1.0
 */
public class TestFactorial {
	
	private static UnitTestingHomeworkImpl testing;
	
	@BeforeAll
	public static void setUp() {
		testing = new UnitTestingHomeworkImpl();
	}
	
	/**
	 * Testing for number at exact lower boundary(0)
	 */
	@Test
	public void testFactorialAtLowerBoundary() {
		assertEquals(1,testing.factorial(0));
	}
	
	/**
	 * Testing for number one above lower boundary(1)
	 */
	@Test
	public void testFactorialOneAboveLowerBoundary() {
		assertEquals(1,testing.factorial(1));
	}
	
	/**
	 * Testing for number one below lower boundary(-1)
	 * Expected: -1 
	 */
	@Test
	public void testFactorialOneBelowLowerBoundary() {
		assertEquals(-1,testing.factorial(-1));
	}
	
	/**
	 * Testing for number at exact lower boundary(0)
	 */
	@Test
	public void testFactorialAtUpperBoundary() {
		assertEquals(479001600,testing.factorial(12));
	}
	
	/**
	 * Testing for number one above lower boundary(1)
	 */
	@Test
	public void testFactorialOneAboveUpperBoundary() {
		assertEquals(-1,testing.factorial(13));
	}
	
	/**
	 * Testing for number one below lower boundary(-1)
	 * Expected: -1 
	 */
	@Test
	public void testFactorialOneBelowUpperBoundary() {
		assertEquals(39916800,testing.factorial(11));
	}
	
	/**
	 * Testing for number below lower boundary
	 * Expected: -1 as there will be overflow
	 */
	@Test
	public void testFactorialOutOfRangeNegative() {
		assertEquals(-1,testing.factorial(-15));
	}
	
	/**
	 * Testing for number above upper boundary
	 * Expected: -1 as there will be overflow
	 */
	@Test
	public void testFactorialOutOfRangePositive() {
		assertEquals(-1,testing.factorial(15));
	}
	
	/**
	 * Testing for valid number at center
	 */	
	@Test
	public void testFactorialThree() {
		assertEquals(6,testing.factorial(3));
	}
	
	/**
	 * Testing for valid number at center
	 */	
	@Test
	public void testFactorialFour() {
		assertEquals(24,testing.factorial(4));
	}
	
	
}
