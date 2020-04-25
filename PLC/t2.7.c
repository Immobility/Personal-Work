#include<stdio.h>

int func1()
{
    int a = 1000, b = 100, c = 10;
    if(a > b && b > c)
    { 
        printf("True\n");
    }
    else
    {
        printf("False\n");
    }
}

// Func1 is the arithmetic way of representing a > b > c. This is what is to be expected, where it prints "True".

int func2()
{
    int a = 1000, b = 100, c = 10;
    if(a > b > c)
    {
        printf("True\n");
    }
    else
    {
        printf("False\n");
    }
}

// Fun2 Returns "False" becuase of the operator precedence. a > b gets evaluated first, then the result of that to c. So even if this statements is supposed to be true, a > b reutrns 1, but 1 > c will return False.
