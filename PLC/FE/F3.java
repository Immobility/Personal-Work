import textio.TextIO;
import java.util.*;

public class F3
{

    private static class ParseError extends Exception 
	{
        ParseError(String message) 
		{
            super(message);
        }
    }

    public static void main(String[] args) 
	{
        while (true) 
		{
            System.out.println("\n\nEnter a fully parenthesized expression,");
            System.out.println("or press return to end.");
            System.out.print("\n?  ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n')
                break;
            try 
			{
                double val = expressionValue();
                TextIO.skipBlanks();
                if ( TextIO.peek() != '\n' )
                    throw new ParseError("Extra data after end of expression.");
                TextIO.getln();
                System.out.println("\nValue is " + val);
            }
			
            catch (ParseError e) 
			{
                System.out.println("\n*** Error in input:    " + e.getMessage());
                System.out.println("*** Discarding input:  " + TextIO.getln());
            }
        }

        System.out.println("\n\nDone.");

    }

    private static double expressionValue() throws ParseError 
	{
        TextIO.skipBlanks();
        if ( Character.isDigit(TextIO.peek()) ) 
		{
                // The next item in input is a number, so the expression
                // must consist of just that number.  Read and return
                // the number.
            return TextIO.getDouble();
        }
		
        else if ( TextIO.peek() == '(' ) 
		{
                // The expression must be of the form 
                //         "(" <expression> <operator> <expression> ")"
                // Read all these items, perform the operation, and
                // return the result.
				
            TextIO.getAnyChar();
            double leftVal = expressionValue();
            char op = getOperator();
            double rightVal = expressionValue(); 
            TextIO.skipBlanks();
			
            if ( TextIO.peek() != ')' ) 
			{
                throw new ParseError("Missing right parenthesis.");
            }
			
            TextIO.getAnyChar();
            switch (op) 
			{ 
            case '+':  return leftVal + rightVal;
            case '-':  return leftVal - rightVal;
            case '*':  return leftVal * rightVal;
            case '/':  return leftVal / rightVal;
            default:   return 0;
            }
        }
        else 
		{
            throw new ParseError("Encountered unexpected character, \"" + 
                    TextIO.peek() + "\" in input.");
        }
		
    }

    static char getOperator() throws ParseError 
	{
        TextIO.skipBlanks();
        char op = TextIO.peek(); 
        if ( op == '+' || op == '-' || op == '*' || op == '/' ) 
		{
            TextIO.getAnyChar();
            return op;
        }
        else if (op == '\n')
            throw new ParseError("Missing operator at end of line.");
		
        else
            throw new ParseError("Missing operator.  Found \"" +
                    op + "\" instead of +, -, *, or /.");
    }

}