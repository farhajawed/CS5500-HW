package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test cases for finding square of integer number
 * @author farha
 * @version 1.0
 */
public class TestSqr {
	
   private static UnitTestingHomeworkImpl testing;

	
	@BeforeAll
	public static void setUp() {
		testing = new UnitTestingHomeworkImpl();
	}
	
	/**
	 * Testing square of 0 (number at center -valid)
	 */
	@Test
	public void testSquareZero() {
		assertEquals(0,testing.sqr(0));
	}
	
	/**
	 * Testing square of -1(number around center -valid)
	 */
	@Test
	public void testSquareNegativeOne() {
		assertEquals(1,testing.sqr(-1));
	}
	
	/**
	 * Testing square of 1 (number around center -valid)
	 */
	@Test
	public void testSquarePositiveOne() {
		assertEquals(1,testing.sqr(1));
	}
	
	/**
	 * Testing square of small number
	 */
	@Test
	public void testSquarePositiveSmall() {
		assertEquals(400,testing.sqr(20));
	}
	
	/**
	 * Testing square of medium number
	 */
	@Test
	public void testSquarePositiveMedium() {
		assertEquals(4840000,testing.sqr(2200));
	}
	
	/**
	 * Testing square of largest possible valid number at boundary
	 * (i.e. square root of largest integer number)
	 */
	@Test
	public void testSquarePositiveLargeBoundary() {
		assertEquals(2147395600,testing.sqr(46340));
	}
	
	/**
	 * Testing square of number one above upper boundary (invalid)
	 * Expected: -1 as there will be overflow
	 */
	@Test
	public void testSquarePositiveOneAboveUpperBoundary() {
		assertEquals(-1,testing.sqr(46341));
	}
	
	/**
	 * Testing square of number one below upper boundary
	 */
	@Test
	public void testSquarePositiveOneBelowUpperBoundary() {
		assertEquals(2147302921,testing.sqr(46339));
	}
	
	/**
	 * Testing square of number well above upper boundary (invalid)
	 */
	@Test
	public void testSquarePositiveOutOfRangeLarger() {
		assertEquals(-1,testing.sqr(70000));
	}
	
	/**
	 * Testing square of negative small number
	 */
	@Test
	public void testSquareNegativeSmall() {
		assertEquals(400,testing.sqr(-20));
	}
	
	/**
	 * Testing square of negative medium number
	 */
	@Test
	public void testSquareNegativeMedium() {
		assertEquals(4840000,testing.sqr(-2200));
	}
	
	/**
	 * Testing square of number at exact lower boundary
	 */
	@Test
	public void testSquareNegativeLargeLowerBoundary() {
		assertEquals(2147395600,testing.sqr(-46340));
	}
	
	/**
	 * Testing square of number one above lower boundary (invalid)
	 * Expected: -1 as there will be overflow
	 */
	@Test
	public void testSquareNegativeOneAboveLowerBoundary() {
		assertEquals(-1,testing.sqr(-46341));
	}
	
	/**
	 * Testing square of number one below lower boundary
	 */
	@Test
	public void testSquareNegativeOneBelowBoundary() {
		assertEquals(2147302921,testing.sqr(-46339));
	}
	
	/**
	 * Testing square of number well above lower boundary (invalid)
	 */
	@Test
	public void testSquareNegativeOutOfRangeLarger() {
		assertEquals(-1,testing.sqr(-70000));
	}
	
	
}
