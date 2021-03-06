/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaalgorithms;

/**
 *
 * @author VVMajor <http://vvmajor.github.io/>
 */

public class FibonacciSequence {
    static long recursiveCount;
    
    static long calcNumberNaiveRecursive(int number)
    {
        recursiveCount++;
     if(number==1)
     {return 0;}
     if(number==2)
     {return 1;}
     return calcNumberNaiveRecursive(number-2)
             +calcNumberNaiveRecursive(number-1);
    }
    static long calcNumIncrementallyLoop(int number)
    {
        int i;
        if(number==1)
            {return 0;}
        if(number==2)
            {return 1;}
     
        long FibonacciPrevPrev=0;
        long FibonacciPrev=1;
        long FibonacciCurr=FibonacciPrev+FibonacciPrevPrev;
                
        for(i=3;i<=number;i++)
        {
            FibonacciCurr=FibonacciPrev+FibonacciPrevPrev;
            FibonacciPrevPrev=FibonacciPrev;
            FibonacciPrev=FibonacciCurr;
        }
        return FibonacciCurr;
    }
}
