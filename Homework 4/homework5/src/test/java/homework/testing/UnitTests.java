package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for method UnitImpl (counts the number of multiple contiguous 
 * space substrings in a given string)
 * @author farha
 * @version 1.0
 */
public class UnitTests {
	
	private static UnitTestImpl test;
	
	@BeforeAll
	public static void setUp() {
		test = new UnitTestImpl();
	}
	
	/**
	 * Test for empty string
	 * Expected: 0
	 */
	@Test
	public void testForEmptyString() {
		String inputText = "";
		assertEquals(0,test.example(inputText));
	}
	
	/**
	 * Test for strings without multiple contiguous spaces
	 * Expected: 0
	 */
	@Test
	public void testForString() {
		String inputText = "I am good";
		assertEquals(0,test.example(inputText));
	}
	
	/**
	 * Test for one substring with multiple contiguous spaces
	 */
	@Test
	public void testStringOne() {
		String inputText = "  I am good";
		assertEquals(1,test.example(inputText));
	}
	
	/**
	 * Test for two substrings with multiple contiguous spaces
	 */
	@Test
	public void testString() {
		String inputText = "I    am  good";
		assertEquals(2,test.example(inputText));
	}

	/**
	 * Test for three substrings with multiple contiguous spaces
	 */
	@Test
	public void testStringTwo() {
		String inputText = "  I  am  good    ";
		assertEquals(3,test.example(inputText));
	}
	
}
