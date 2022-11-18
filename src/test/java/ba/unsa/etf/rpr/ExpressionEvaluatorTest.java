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

    @Test
    public void getTwoNumbersProduct(){
        String s="( 3 * 6 )";
        assertEquals(18.0,evaluator.evaluate(s));
    }

    @Test
    public void getSqrt(){
        String s="( sqrt 16 )";
        assertEquals(4.0,evaluator.evaluate(s));
    }

    @Test
    public void getSqrt2(){
        String s="( 3 + sqrt ( 4 ) )";
        assertEquals(5.0,evaluator.evaluate(s));
    }

    @Test
    public void multiOperatorsResult(){
        String s="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101.0,evaluator.evaluate(s));
    }

    @Test
    public void compareTwoExpressions(){
        String s="( 1 + ( 5 * ( 4 * 5 ) ) )";
        double val=evaluator.evaluate("( 1 + ( 5 * 20 ) )");
        assertEquals(val,evaluator.evaluate(s));
    }

    @Test
    public void basicExceptionTest(){
        assertThrows(RuntimeException.class, ()->{evaluator.evaluate("(3*4)");});
    }
}
