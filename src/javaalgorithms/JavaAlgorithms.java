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
      for(int i=1;i<=7;i++)
      {
          FibonacciSequence.recursiveCount=0;
          StopWatch.start();
          System.out.println("Fibonacci "+Integer.toString(i)+" = "
                  +Long.toString(FibonacciSequence.calcNumberNaiveRecursive(i))
                  +" recursiveCount = "
                  +Long.toString(FibonacciSequence.recursiveCount)
                  +" time elapsed = "
                  +Float.toString(StopWatch.secondsElapsed())
          );
          StopWatch.start();
          System.out.println("Fibonacci "+Integer.toString(i)+" = "
                  +Long.toString(FibonacciSequence.calcNumIncrementallyLoop(i))
                  +" time elapsed = "
                  +Float.toString(StopWatch.secondsElapsed())
          );
          
      }
    }
   
    static void checkSeeds(){
        int n=6086;
        //int n=6087; recursion failed
      long[] arr=new long[n];
      long seed;
      int maxSorted=0;
      long maxSeed=0;
      for(seed=0;seed<Integer.MAX_VALUE;seed++)
//        for(seed=0;seed<1;seed++)
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
          
          ArraysHandling.fillArray(arr,seed);
          ArraysHandling.initCounts();
          ArraysHandling.quickSortL(arr, 0, n-1);
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("QuickSortL");
          ArraysHandling.printCounts();
          System.out.println("arraySortedLength="
                  +Integer.toString(ArraysHandling.arraySortedLength(arr)));
          
          //ArraysHandling.fillArray(arr,seed);
          ArraysHandling.initCounts();
          ArraysHandling.quickSortF(arr, 0, n-1);
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("QuickSortF");
          ArraysHandling.printCounts();
          System.out.println("arraySortedLength="
                  +Integer.toString(ArraysHandling.arraySortedLength(arr)));
         
          ArraysHandling.fillArray(arr,seed);
          ArraysHandling.initCounts();
          //ArraysHandling.printArray(arr);
          ArraysHandling.heapSort(arr);
          
          //System.out.println(" sorted ");
          //ArraysHandling.printArray(arr);
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("HeapSort");
          ArraysHandling.printCounts();
          
          System.out.println("arraySortedLength="
                  +Integer.toString(ArraysHandling.arraySortedLength(arr)));
          
          
          ArraysHandling.fillArray(arr,seed);
     
          ArraysHandling.initCounts();
          
          //ArraysHandling.printArray(arr);
          ArraysHandling.mergeSort(arr, 0, n-1);
          
          //System.out.println(" sorted ");
          //ArraysHandling.printArray(arr);
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("mergeSort");
          ArraysHandling.printCounts();
          
          System.out.println("arraySortedLength="
                  +Integer.toString(ArraysHandling.arraySortedLength(arr)));
          
        //checkArrayPrintResult(arr);
      }
        System.out.println("maxSorted="+Integer.toString(maxSorted));
        System.out.println("maxSeed="+Long.toString(maxSeed));
        
    }
    
}
