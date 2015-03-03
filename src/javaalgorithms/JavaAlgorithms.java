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
public class JavaAlgorithms {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FibonacciPrint();
        checkSeeds();
        
    }
    
    static void FibonacciPrint()
    {
      for(int i=1;i<50;i++)
      {
          FibonacciSequence.recursiveCount=0;
          System.out.println("Fibonacci "+Integer.toString(i)+" = "
                  +Long.toString(FibonacciSequence.calcNumberNaiveRecursive(i))
                  +" recursiveCount = "
                  +Long.toString(FibonacciSequence.recursiveCount));
      }
    }
   
    static void checkSeeds(){
        int n=300;
      long[] arr=new long[n];
      long seed;
      int maxSorted=0;
      long maxSeed=0;
      for(seed=0;seed<Integer.MAX_VALUE;seed++)
      {
          if(seed%1000000==0)
          {
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("maxSorted="+Integer.toString(maxSorted));
          System.out.println("maxSeed="+Long.toString(maxSeed)+"\n");
        
          }
        //System.out.print("seed "+Long.toString(seed)+" ");
        ArraysHandling.fillArray(arr,seed);
        if(ArraysHandling.arraySortedLength(arr)>maxSorted)
        {
         maxSorted=ArraysHandling.arraySortedLength(arr);
         maxSeed=seed;
         System.out.println("new maxSorted="+Integer.toString(maxSorted));
         System.out.println("new maxSeed="+Long.toString(maxSeed)+"\n");
        
        }
          ArraysHandling.compareCount=0;
          ArraysHandling.quickSort(arr, 0, n-1);
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("compareCount="
                  +Integer.toString(ArraysHandling.compareCount));
          System.out.println("arraySortedLength="
                  +Integer.toString(ArraysHandling.arraySortedLength(arr)));
         
        //checkArrayPrintResult(arr);
      }
        System.out.println("maxSorted="+Integer.toString(maxSorted));
        System.out.println("maxSeed="+Long.toString(maxSeed));
        
    }
    
}
