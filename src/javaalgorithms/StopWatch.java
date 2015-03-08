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
public class StopWatch {
    static long startTime;
    public static void start()
    {
        startTime=System.nanoTime();
    }
    
    public static long nanoSecondsElapsed()
    {
        return System.nanoTime()-startTime;
    }
    
    public static float secondsElapsed()
    {
        return 0f+(System.nanoTime()-startTime)/1000000000f;
    }
    
    
    
}
