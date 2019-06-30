package homework.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Testing the summation of 2 integer numbers X and Y
 * @author farha
 * @version 1.0
 */
public class TestSimpleFunctionXplusY {

	private static UnitTestingHomeworkImpl testing;

	@BeforeAll
	public static void setUp() {
		testing = new UnitTestingHomeworkImpl();
	}
	
	/**
	 * Testing both sum of 0 and 0
	 */
	@Test
	public void testBothZero() {
		assertEquals(0,testing.simpleFunctionXplusY(0, 0));
	}
	
	/**
	 * Testing sum of 2 positive numbers
	 */
	@Test
	public void testBothPositiveValid() {
		assertEquals(60,testing.simpleFunctionXplusY(20, 40));
	}
	
	/**
	 * Testing sum of positive number at upper boundary(2147483647)
	 */
	@Test
    public void testBothPositiveValidAtUpperBoundary() {
    	assertEquals(2147483647,testing.simpleFunctionXplusY(2147483600, 47));
	}
    
	/**
	 * Testing sum of positive number one below upper boundary(2147483646)
	 */
	@Test
    public void testBothPositiveValidOneBelowUpperBoundary() {
    	assertEquals(2147483646,testing.simpleFunctionXplusY(46, 2147483600));
	}
    
	/**
	 * Testing sum of positive number one above upper boundary(2147483648)
	 * Expected output: -1 as there will be overflow
	 */
	@Test
    public void testBothPositiveInvalidOneAboveUpperBoundary() {
    	assertEquals(-1,testing.simpleFunctionXplusY(48, 2147483600));
	}
	
	/**
	 * Testing first number positive and second number negative
	 */
    @Test
	public void testAPositiveBNegativeValid() {
		assertEquals(-38,testing.simpleFunctionXplusY(2, -40));
	}
	
    /**
	 * Testing first number positive and second number negative one below
	 * lower boundary(-2147483647)
	 */
    @Test
	public void testAPositiveBNegativeValidOneBelowLowerBoundary() {
		assertEquals(-2147483647,testing.simpleFunctionXplusY(1,-2147483648));
	}
    
    /**
	 * Testing first number negative and second number positive
	 */
    @Test
	public void testANegativeBPositiveValid() {
		assertEquals(-40,testing.simpleFunctionXplusY(-80, 40));
	}
	
    /**
	 * Testing first number negative and second number positive for
	 * one above lower boundary (valid)
	 */
    @Test
	public void testANegativeBPositiveValidOneAboveLowerBoundary() {
		assertEquals(-2147483647,testing.simpleFunctionXplusY(-2147483648,1));
	}
    
    /**
     * Test for both negative numbers
     */
    @Test
	public void testBothNegativeValid() {
		assertEquals(-500,testing.simpleFunctionXplusY(-100, -400));
	}
    
    /**
	 * Test for both negative number where output is at lower boundary
	 */
    @Test
   	public void testBothNegativeLowerBoundaryValid() {
   		assertEquals(-2147483648,testing.simpleFunctionXplusY(-100000000, -2047483648));
   	}
    
    /**
   	 * Test for both negative number where output is one above lower boundary
   	 */
    @Test
   	public void testBothNegativeOneBelowLowerBoundaryValid() {
   		assertEquals(-2147483647,testing.simpleFunctionXplusY(-100000000, -2047483647));
   	}
    
    /**
   	 * Test for both negative number where output creates overflow
   	 * Expected: -1
   	 */
    @Test
   	public void testBothNegativeOneAboveLowerBoundaryInvalid() {
   		assertEquals(-1,testing.simpleFunctionXplusY(-100000001, -2047483648));
   	}
    
    /**
     * Test for first number positive and second number 0
     */
    @Test
    public void testForAPositiveAndBZero() {
    	assertEquals(10,testing.simpleFunctionXplusY(10, 0));
    }
    
    /**
     * Test for first number positive and second number 0 where output
     * is at exact upper boundary
     */
    @Test
    public void testForAPositiveAndBZeroBoundaryValid() {
    	assertEquals(2147483647,testing.simpleFunctionXplusY(2147483647, 0));
    }
    
    /**
     * Test for first number positive and second number 0 where output
     * is one below upper boundary
     */
    @Test
    public void testForAPositiveAndBZeroOneBelowBoundaryValid() {
    	assertEquals(2147483646,testing.simpleFunctionXplusY(2147483646, 0));
    }
    
    /**
     * Test for first number 0 and second number positive
     */
    @Test
    public void testForAZeroAndBPositive() {
    	assertEquals(20,testing.simpleFunctionXplusY(0, 20));
    }
    
    /**
     * Test for first number 0 and second number positive where output
     * is at exact upper boundary
     */
    @Test
    public void testForAZeroAndBPositiveBoundaryValid() {
    	assertEquals(2147483647,testing.simpleFunctionXplusY(0,2147483647));
    }
    
    /**
     * Test for first number 0 and second number positive where output
     * is one below upper boundary
     */
    @Test
    public void testForAZeroAndBPositiveOneBelowBoundaryValid() {
    	assertEquals(2147483646,testing.simpleFunctionXplusY(0,2147483646));
    }
}
