package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Testing the summation of number from 0 to n (where n is the largest addend)
 * @author farha
 * @version 1.0
 */
public class TestSumup {


	private static UnitTestingHomeworkImpl testing;

	@BeforeAll
	public static void setUp() {
		testing = new UnitTestingHomeworkImpl();
	}
	
	/**
	 * Testing for number at exact lower boundary(0)
	 */
	@Test
	public void testForZero() {
		assertEquals(0,testing.sumUp(0));
	}
	
	/**
	 * Testing for number one above lower boundary(1)
	 */
	@Test
	public void testForOne() {
		assertEquals(1,testing.sumUp(1));
	}
	
	/**
	 * Testing for number one below lower boundary(-1): invalid
	 * Expected:-1 
	 */
	@Test
	public void testForNegativeOne() {
		assertEquals(-1,testing.sumUp(-1));
	}
	
	/**
	 * Testing for small valid number
	 */
	@Test
	public void testForTwo() {
		assertEquals(3,testing.sumUp(2));
	}
	
	/**
	 * Testing for small valid number
	 */
	@Test
	public void testForThree() {
		assertEquals(6,testing.sumUp(3));
	}
	
	/**
	 * Testing for small valid number
	 */
	@Test
	public void testForFour() {
		assertEquals(10,testing.sumUp(4));
	}
	
	/**
	 * Testing for small valid number
	 */
	@Test
	public void testForFive() {
		assertEquals(15,testing.sumUp(5));
	}
	
	/**
	 * Testing for medium valid number
	 */
	@Test
	public void testForMediumNumber() {
		assertEquals(9876790,testing.sumUp(4444));
	}
	
	/**
	 * Test for number one below upper boundary: 65534
	 */
	@Test
	public void testForOneBelowUpperBoundary() {
		assertEquals(2147385345,testing.sumUp(65534));
	}
	
	/**
	 * Test for number at upper boundary: 65535
	 */
	@Test
	public void testForNumberOnUpperBoundary() {
		assertEquals(2147450880,testing.sumUp(65535));
	}
	
	/**
	 * Test for number one above upper boundary: invalid
	 */
	@Test
	public void testForOneAboveUpperBoundary() {
		assertEquals(-1,testing.sumUp(65536));
	}
	
	/**
	 * Test for large number above upper boundary: invalid
	 */
	@Test
	public void testForOverflowNumberLarge() {
		assertEquals(-1,testing.sumUp(80000));
	}

	/**
	 * Test for small number below lower boundary: invalid
	 */
	@Test
	public void testForNegOverflowNumberLarge() {
		assertEquals(-1,testing.sumUp(-65536));
	}
	
	
}
