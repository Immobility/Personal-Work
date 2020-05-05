import java.util.*;

public class F6
{
	public static void main(String[] args)
	{
        int a, b, c;
        int max = 0, min = 0, mid = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers: ");

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if(a > b && a > c && b > c)
        {
            max = a;
            min = c;
            mid = b;
        }

        else if(a > b && a > c && b < c)
        {
            max = a;
            min = b;
            mid = c;
        }

        else if(b > c && b > a && a > c)
        {
            max = b;
            min = c;
            mid = a;
        }

        else if(b > c && b > a && c > a)
        {
            max = b;
            min = a;
            mid = c;
        }

        else if(c > a && c > b && a > b)
        {
            max = c;
            min = b;
            mid = a;
            
        }
        else
        {
            max = c;
            min = a;
            mid = b;
        }

        System.out.println("Max is "+ max);
        System.out.println("Min is "+ min);
        System.out.println("Mid is "+ mid);

	}
}

/*
import java.util.*;

public class F6_nested 
{
    public static void main(String[] args) 
{

         int a, b, c;
        int max = 0,min = 0,mid = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers: ");

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        
        if(a > b)
        {
            if(a > c)
            {
                if(b > c)
                {
                     max = a;
                     min = c;
                     mid = b;
                }
                else
                {
                    max = a;
                    min = b;
                    mid = c; 
                }
            }
            else
            {
                    max = c;
                    min = b;
                    mid = a;
            
                
            }
            
        }

        else
        {
            if(b < c)
            {
                max = c;
                min = a;
                mid = b;

            }
            else
            {
                if(a < c)
                {
                  max = b;
                  min = a;
                  mid = c;  
                }
                else
                {
                    max = b;
                    min = c;
                    mid = a; 
                }
            }
            
        }
        
        System.out.println("Max is "+ max);
        System.out.println("Min is "+ min);
        System.out.println("Mid is "+ mid);

    }
    
}
*/