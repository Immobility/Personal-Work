import java.util.*;

public class F1 
{
    private static String type;
    public static void main(String[] args)
	{
        System.out.println("Determining if literals");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = scan.nextLine();
        scan.close();

        if(validString(input))
		{
            type = "Sting Literal";
        }

        else if(validIdentifier(input))
		{
            type = "Variable Name";
        }

        else if(validFloat(input))
		{
            type = "Floating Point Literal";
        }

        else if(validInt(input))
		{
            type = "Integer Literal";
        }

        else
		{
            type = "Invalid input"
        }

        System.out.println("Your input of " + input + " is a " + type);

    }

    private static boolean validString(String input)
	{
        String strReg = "^\"{1}[^\"]*\"{1}$";
        if (input.matches(strReg))
            return true;
        else
            return false;
    }

    private static boolean validInt(String input)
	{
        String intReg = "^[-+]?[0-9]+$";
        if (input.matches(intReg))
            return true;
        else
            return false;
    }

    private static boolean validIdentifier(String input)
	{
        String identifierReg = "^[a-zA-Z_$][a-zA-Z0-9_$]*$";
        if (input.matches(identifierReg))
            return true;
        else
            return false;
    }

    private static boolean validFloat(String input)
	{
        String floatReg = "[+-]?([0-9]*[.])?[0-9]+[fFlL]?[+]?[eE]?[0-9]*";
        if(input.matches(floatReg))
            return true;
        else
            return false;
    }

}