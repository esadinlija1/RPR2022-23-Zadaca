package ba.unsa.etf.rpr;



import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that contains only one public method for string evaluation using Dijsktra algorithm
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
            add(String.valueOf(1));
            add(String.valueOf(2));
            add(String.valueOf(3));
            add(String.valueOf(4));
            add(String.valueOf(5));
            add(String.valueOf(6));
            add(String.valueOf(7));
            add(String.valueOf(8));
            add(String.valueOf(9));

        }
    };  //static list shared by all instances of class, saves memory resources from possible multiple list allocation

    /**
     * //method that checks if string returned from split method contains only digits, should help app to recognise multidigit numbers as valid
     * @param s
     * @return
     */
    private static boolean onlyDigits(String s){
        String regex = "[0-9]+";  //regex that describes range of allowed strings
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(s);  //check if string matches range set by regex
        return m.matches();
    }

    /**
     * Method for string validation, uses onlyDigits to check if string has only numbers and checks if string is in validexps
     * @param s
     * @return
     */
    private static boolean validString(String s){  //method to decide if string is valid, and based on that, if exception should or shouldn't be thrown
        if(onlyDigits(s) || validexps.contains(s))
            return true;
        return false;
    }


    /**
     *Central method of class, evaluates expression using Dijsktra algorithm
     * @param expression
     * @return
     */
    public double evaluate(String expression) {  //implementation of Dijsktra algortihm
        Stack<String> ops = new Stack<String>(); //stack containing operators in expression
        Stack<Double> vals = new Stack<Double>(); //stack containing values
        double rez = 0;
        for (String e : expression.split(" ")) {

            if(!validString(e)){ //check if string is valid
                throw new IllegalArgumentException("Expression not valid!");
            }else {  //look for operators
                if (e.equals("(")) ;
                else if (e.equals("+")) ops.push(e);
                else if (e.equals("-")) ops.push(e);
                else if (e.equals("*")) ops.push(e);
                else if (e.equals("/")) ops.push(e);
                else if (e.equals("sqrt")) ops.push(e);
                else if (e.equals(")")) { //operations processing
                    String op = ops.pop();  //get last operator from stack
                    rez = vals.pop();  // get last value calculated
                    if (op.equals("+")) rez = vals.pop() + rez;
                    else if (op.equals("-")) rez = vals.pop() - rez;
                    else if (op.equals("*")) rez = vals.pop() * rez;
                    else if (op.equals("/")) rez = vals.pop() / rez;
                    else if (op.equals("sqrt")) rez = Math.sqrt(rez);
                    vals.push(rez);
                }
                else vals.push(Double.parseDouble(e));  //if there isn't operation to be processed, push to stack string interpreted as double
            }

        }
        return rez;
    }
}

