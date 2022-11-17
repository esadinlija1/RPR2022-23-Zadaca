package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This class has only one method, which implements Dijkstra algorithm for arithmetic expression evaluation
 *
 */
public class ExpressionEvaluator {
    private static ArrayList<String> validexps = new ArrayList<String>() {  //list containing valid expression returned by split method
        {
            add("(");
            add(")");
            add("+");
            add("-");
            add("/");
            add("*");
            add("sqrt");
            add(String.valueOf(0));
        }
    };

    public double evaluate(String expression) {  //implementation of Dijsktra algortihm
        Stack<String> ops = new Stack<String>(); //stack containing operators in expression
        Stack<Double> vals = new Stack<Double>(); //stack containing values
        double rez = 0;
        for (String e : expression.split(" ")) {
            if (!validexps.contains(e)) {
                throw new IllegalArgumentException("Expression not valid!");
            } else {
                if (e.equals("(")) ;
                else if (e.equals("+")) ops.push(e);
                else if (e.equals("-")) ops.push(e);
                else if (e.equals("*")) ops.push(e);
                else if (e.equals("/")) ops.push(e);
                else if (e.equals("sqrt")) ops.push(e);
                else if (e.equals(")")) {
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) v = vals.pop() + v;
                    else if (op.equals("-")) v = vals.pop() - v;
                    else if (op.equals("*")) v = vals.pop() * v;
                    else if (op.equals("/")) v = vals.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                }
                else vals.push(Double.parseDouble(e));
            }

        }
        return rez;
    }
}

