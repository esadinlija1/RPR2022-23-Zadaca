package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class ExpressionEvaluatorTest
{
    private static ExpressionEvaluator evaluator=new ExpressionEvaluator();

    /**
     * Test for expression which multiplies two numbers
     */
    @Test
    public void getTwoNumbersProduct(){
        String s="( 3 * 6 )";
        assertEquals(18.0,evaluator.evaluate(s));
    }

    /**
     * Basic sqrt test
     */
    @Test
    public void getSqrt(){
        String s="( sqrt 16 )";
        assertEquals(4.0,evaluator.evaluate(s));
    }

    /**
     * sqrt and another operator test
     */
    @Test
    public void getSqrt2(){
        String s="( 3 + sqrt ( 4 ) )";
        assertEquals(5.0,evaluator.evaluate(s));
    }

    /**
     * Multiple brackets in expression test
     */
    @Test
    public void multiOperatorsResult(){
        String s="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101.0,evaluator.evaluate(s));
    }

    /**
     * Two expressions written differently but give same result
     */
    @Test
    public void compareTwoExpressions(){
        String s="( 1 + ( 5 * ( 4 * 5 ) ) )";
        double val=evaluator.evaluate("( 1 + ( 5 * 20 ) )");
        assertEquals(val,evaluator.evaluate(s));
    }

    /**
     * Exception test when user misunderstood completely how input works
      */
    @Test
    public void basicExceptionTest(){
        assertThrows(RuntimeException.class, ()->{evaluator.evaluate("(3*4)");});
    }

    /**
     * Test for exception when exception is probably jus mistake in single place
     */
    @Test
    public void exceptionTest2(){
        assertThrows(RuntimeException.class, ()->{evaluator.evaluate("( 1 + (5 * 4 ) ");});
    }


    /**
     * Test method to check if double sqrt operation works
     */
    @Test
    public void bitMoreComplexTest(){
        assertEquals(2.0,evaluator.evaluate("( sqrt ( sqrt 16 ) )"));
    }
}
