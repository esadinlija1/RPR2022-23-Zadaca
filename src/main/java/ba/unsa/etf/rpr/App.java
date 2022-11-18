package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * App main class, in which we take arithemtic expression and calculate its value
 *
 */
public class App 
{
    /**
     * Main method
     * @param args
     */
    public static void main( String[] args )
    {
        ExpressionEvaluator e=new ExpressionEvaluator(); //evaluator declaration
        String s=args[0]; //get string from args, expression should be given with ""
        System.out.println(e.evaluate(s)); //print returned result
    }
}
