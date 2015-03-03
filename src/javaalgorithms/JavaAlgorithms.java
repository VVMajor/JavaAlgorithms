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
    
     static int compareCount;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        checkSeeds();
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
        fillArray(arr,seed);
        if(arraySortedLength(arr)>maxSorted)
        {
         maxSorted=arraySortedLength(arr);
         maxSeed=seed;
         System.out.println("new maxSorted="+Integer.toString(maxSorted));
         System.out.println("new maxSeed="+Long.toString(maxSeed)+"\n");
        
        }
          compareCount=0;
          quickSort(arr, 0, n-1);
          System.out.println("seed "+Long.toString(seed)+" ");
          System.out.println("compareCount="+Integer.toString(compareCount));
          System.out.println("arraySortedLength="+Integer.toString(arraySortedLength(arr)));
         
        //checkArrayPrintResult(arr);
      }
        System.out.println("maxSorted="+Integer.toString(maxSorted));
        System.out.println("maxSeed="+Long.toString(maxSeed));
        
    }
    
    static void checkArrayPrintResult(long[] arr)
    {
    if(isArraySorted(arr))
        {
          System.out.println("sorted "
                  +Integer.toString(arraySortedLength(arr)));
          //System.out.println(arr.toString());
          //printArray(arr);
        }else{
         System.out.println("not sorted "
                 +Integer.toString(arraySortedLength(arr)));
         //System.out.println(arr.toString());
         //printArray(arr);
         //System.out.println(Integer.toString(arraySortedLength(arr)));
        }
    }
    
    static void fillArray(long[] arrayForFill, long seed)
    {
        java.util.Random  generator = new java.util.Random(seed);
        for(int i=0;i<arrayForFill.length;i++)
        {
            arrayForFill[i]=generator.nextLong();
        }
        
    }
    
    static void fillArray(long[] arrayForFill)
    {
        long seed=System.currentTimeMillis();
        java.util.Random  generator = new java.util.Random(seed);
        for(int i=0;i<arrayForFill.length;i++)
        {
            arrayForFill[i]=generator.nextLong();
        }
        
    }
    
    static void printArray(long[] arrayForPrint)
    {
        int i;
    for(i=0;i<arrayForPrint.length;i++)
            System.out.println(Long.toString(arrayForPrint[i]));
    }
    
    static boolean isArraySorted(long[] testedArray){
        int i;
        if(testedArray.length<2)
        {
            return true;
        }
        for(i=1;i<testedArray.length;i++)
        {
         if(testedArray[i-1]>testedArray[i])
         {
             return false;
         }
        }
        return true;
    }
    
    static int arraySortedLength(long[] testedArray){
        int sortedLength=0;
        int i;
        if(testedArray.length<2)
        {
            sortedLength=testedArray.length;
            return sortedLength;
        }
        for(i=1;i<testedArray.length;i++)
        {
            sortedLength=i;
         if(testedArray[i-1]>testedArray[i])
         {
             return sortedLength;
         }
        }
        return sortedLength+1;
    }
    
    
    static boolean compareProcedure(long a, long b)
    {
        compareCount++;
        return a>b;
        
    }
    static int partition(long[] testedArray, int l, int r)
    {
        int m;
         m = l;
        
       for(int i=l+1;i<=r;i++)
       {
           if(compareProcedure(testedArray[m],testedArray[i]))
           {
               swap(testedArray, m, i);
               swap(testedArray, m+1, i);
               m++;
           }
       }
       return m;
    }
    
    static void quickSort(long[] sortedArray,int l,int r)
    {
        if(l>=r)
        {
          return;
        }
        int m;
        m=partition(sortedArray, l, r);
        quickSort(sortedArray, l, m-1);
        quickSort(sortedArray, m+1, r);
    }
    static void swap(long[] testedArray,int first,int second)
    {
      long temp=testedArray[first];
      testedArray[first]=testedArray[second];
      testedArray[second]=temp;
    }
}
