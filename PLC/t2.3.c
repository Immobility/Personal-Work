#include <stdlib.h>
#include <time.h>

void staticFunction(void) 
{
        static int a[1];
}

void stackFunction(void)
{
        int b[1];
}

void heapFunction(void) 
{
        int *array = malloc(sizeof(int[1]));
        int c[1];
}

main(void)                                                                                  
{
        struct timespec time1, time2;
        clock_t t1 = clock();
        for(int i = 0; i < 100000; i++) 
        {
                staticFunction();                                                          
        }
                      
        t1 = clock() - t1;
        double time_taken = ((double)t1/CLOCKS_PER_SEC);
        printf("Took %f seconds \n", time_taken);
                                     
        
        clock_t t2 = clock();
        for(int i = 0; i < 100000; i++) 
        { 
                stackFunction(); 
        }
                      
        t2 = clock() - t2;
        double time2_taken = ((double)t2/CLOCKS_PER_SEC);
        printf("it took %f seconds to call staticFunction 100,000 times: \n", time2_taken);
        
        
        clock_t t3 = clock();
        for(int i = 0; i < 100000; i++) 
        { 
                heapFunction();  
        }
                      
        t3 = clock() - t3;
        double time3_taken = ((double)t3/CLOCKS_PER_SEC);
        printf("Took %f seconds \n", time3_taken);  
}
