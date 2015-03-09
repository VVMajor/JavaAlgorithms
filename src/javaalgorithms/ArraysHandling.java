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
public class ArraysHandling {
  
    
     static int compareCount;
     static int swapCount;
    
    static void initCounts()
    {
        compareCount=0;
        swapCount=0;
        StopWatch.start();
    }
    static void printCounts()
    {
     p(" compareCount = "+compareCount);
     p(" swapCount = "+swapCount);
     p(" time elapsed = "+Float.toString(StopWatch.secondsElapsed()));
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
    
    static void printArray(long[] arrayForPrint, int start, int finish)
    {
        int i;
    for(i=start;i<=finish;i++)
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
    
    //QuickSort
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
      swapCount++;
      long temp=testedArray[first];
      testedArray[first]=testedArray[second];
      testedArray[second]=temp;
    }
    
    //Heap//HeapSort
    static int leftChild(int n)
    {
        return ((n+1)*2)-1;
    }
    
    static int rightChild(int n)
    {
        return (n+1)*2;
    }
    
    static void Heapify(long[] testedArray, int n, boolean recursive, int limit)
    {
        //System.out.println(""+n);   
        if(rightChild(n)<limit 
                && compareProcedure(testedArray[rightChild(n)],
                        testedArray[leftChild(n)]))
        {
            if(compareProcedure(testedArray[rightChild(n)], testedArray[n]))
            {
                swap(testedArray,n,rightChild(n));
                if(recursive)
                {
                    Heapify(testedArray, rightChild(n), recursive, limit);
                }
            }
        }else{
            if(leftChild(n)<limit 
                && compareProcedure(testedArray[leftChild(n)], testedArray[n]))
            {
                swap(testedArray,n,leftChild(n));
                if(recursive)
                {
                    Heapify(testedArray, leftChild(n), recursive, limit);
                }
            }
        }
    }

    static void heapSort(long[] sortedArray)
    {
        int i;
        int searched;
        for(i=sortedArray.length/2;i>=0;i--)
          {
             // System.out.println("i="+i);
            Heapify(sortedArray, i, true, sortedArray.length);  
          }
        
        //System.out.println("heap built");
        
        //printArray(sortedArray);
        
        for(searched=sortedArray.length-1;searched>=0;searched--)
        {
          swap(sortedArray,0,searched);
          Heapify(sortedArray, 0, true, searched);
          
        }
        
    }
    //MergeSort, version without double memory use, but with many swaps inestead
    static void merge(long[] sortedArray, int leftStart, int leftFinish,
            int rightStart, int rightFinish)
    {
        
       // p(" "+leftStart+" "+leftFinish
       //     +" "+rightStart+" "+rightFinish);
       // if(leftStart==0 && rightFinish==9)
       // {
       //     p("0-9");
       // }
        int i;
        //long temp;
        //int leftCursor=leftStart;
        //int rightCursor=rightStart;
        do{            
            if(compareProcedure(sortedArray[leftStart], sortedArray[rightStart]))
            {
               // temp=sortedArray[rightStart];
              for(i=rightStart;i>leftStart;i--)
              {
                  swap(sortedArray, i, i-1);
              }
              //sortedArray[leftStart]=temp;
              rightStart++;
              leftStart++;
              leftFinish++;
            }else{
                leftStart++;
              //leftFinish++;
            }
        }while (leftStart<=leftFinish && rightStart<=rightFinish);
    }
    
    static void mergeSort(long[] sortedArray, int start, int finish)
    {
        int length=finish-start;
        if(length>2)
        {
         //  p("length="+length);
         //  p("before merge");
         //   printArray(sortedArray, start, finish);
            mergeSort(sortedArray, start, start+(length/2));
            mergeSort(sortedArray, start+(length/2)+1, finish);
            merge(sortedArray, start, start+(length/2), start+(length/2)+1, finish);
        //    p("after merge");
         //   printArray(sortedArray, start, finish);
  //            printArray(sortedArray);
        }
        if(length==2)
        {
          //  p("length="+length);
          //  p("before merge");
          //  printArray(sortedArray, start, finish);
           
            merge(sortedArray, start, start+1, finish, finish);
          //p("after merge");
          //  printArray(sortedArray, start, finish);
  //          printArray(sortedArray);
        }
        if(length==1)
        {
           // p("length="+length);
           // p("before merge");
           // printArray(sortedArray, start, finish);

            merge(sortedArray, start, start, finish, finish);
          //p("after merge");
          //  printArray(sortedArray, start, finish);
  //          printArray(sortedArray);
        }
    }
    
    static void p(String s)
    {
        System.out.println(s);
    }
}
