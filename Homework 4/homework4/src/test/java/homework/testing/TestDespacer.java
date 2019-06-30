package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test cases for implementation of despacer method
 * @author farha
 * @version 1.0
 */
public class TestDespacer {

	private static UnitTestingHomeworkImpl testing;

	@BeforeAll
	public static void setUp() {
		testing = new UnitTestingHomeworkImpl();
	}
	
	/**
	 * No space and text
	 */
	@Test
	public void testNoSpace() {
		assertEquals("",testing.despacer(""));
	}
	
	/**
	 * Single space without text
	 */
	@Test
	public void testOneSpace() {
		assertEquals(" ",testing.despacer(" "));
	}
	
	/**
	 * Multiple spaces without text
	 * Expected: Single space
	 */
	@Test
	public void testMultipleContiguousSpace() {
		assertEquals(" ",testing.despacer("  "));
	}
	
	/**
	 * No space between strings
	 */
	@Test
	public void testNoSpaceWithText() {
		assertEquals("Iamgood",testing.despacer("Iamgood"));
	}
	
	/**
	 * One spaces in between each strings 
	 */
	@Test
	public void testMultipleOneSpaceInText() {
		assertEquals("I am good",testing.despacer("I am good"));
	}
	
	/**
	 * Multiple spaces in between last 2 strings 
	 */
	@Test
	public void testMultipleSpaceInBetweenText() {
		assertEquals("I am good",testing.despacer("I am  good"));
	}
	
	/**
	 * Multiple spaces in between each strings(2 spaces)
	 */
	@Test
	public void testMultipleSpacesTwo() {
		assertEquals("I am good",testing.despacer("I  am  good"));
	}
	
	/**
	 * Multiple spaces in between each strings(more than 2 spaces)
	 */
	@Test
	public void testMultipleSpaceInTextThree() {
		assertEquals("I am good",testing.despacer("I    am    good"));
	}
	
	/**
	 * Multiple spaces in between each strings and one space in the beginning and end
	 */
	@Test
	public void testMultipleSpaceInTextFour() {
		assertEquals(" I am good ",testing.despacer(" I    am    good "));
	}
	
	/**
	 * Multiple spaces in between each strings and in the beginning
	 */
	@Test
	public void testMultipleSpaceInTextFive() {
		assertEquals(" I am good",testing.despacer("   I    am    good"));
	}
	
	/**
	 * Multiple spaces in between each strings and one space in the end
	 */
	@Test
	public void testMultipleSpaceInTextSix() {
		assertEquals("I am good ",testing.despacer("I    am    good "));
	}
	
	/**
	 * Multiple spaces in between each strings and in the end
	 */
	@Test
	public void testMultipleSpaceInTextSeven() {
		assertEquals("I am good ",testing.despacer("I    am    good   "));
	}
}
