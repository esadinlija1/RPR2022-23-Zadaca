package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * App main class, in which we take arithemtic expression and calculate its value
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ExpressionEvaluator e=new ExpressionEvaluator();
        String s=args[0];
        /*Scanner ulaz=new Scanner(System.in);
        String s=ulaz.nextLine();*/
        System.out.println(e.evaluate(s));
    }
}
