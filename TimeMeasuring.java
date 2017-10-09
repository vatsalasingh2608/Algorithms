/**
 * TimeMeasuring.java
 *
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */
/**
 * This class measures the executing time for the algorithm
 *
 * @author Aditya S Murthy
 * @author Vatsala Singh
 */
public class TimeMeasuring {
    static long startTime, endTime, execTime;
    private static final long MB = 1024L*1024L;

    public static long bytesToMegabytes( long bytes) {
        return bytes/MB;
    }

    /**
     * this methods resets everything to zero
     */
    public static void setToZero(){
        startTime = 0;
        endTime = 0;
        execTime = 0;
    }

    /**
     * fetches the system time
     *
     * @return  system time
     */

    public static long getSystemTime() {
        return System.nanoTime();
    }

    /**
     * This method starts the timer
     *
     */
    public void timerStarts() {
        startTime = getSystemTime();
    }

    /**
     *
     * This method ends the timer
     */
    public void timerEnds() {
        endTime = getSystemTime();
    }

    /**
     * this method returns the exection time
     *
     * @return  total time of execution
     */
    public long totalTime() {
        execTime = endTime - startTime;
        return execTime;
    }

    /**
     * main program
     *
     * @param args  Input1 Input2
     */
    public static void main(String[] args) {
        TimeMeasuring tm = new TimeMeasuring();
        long meanTime = 0;
        //NaiveRecursive nLcs = new NaiveRecursive();
        tm.setToZero();

        // running the algorithm for 100 times for one set of input
        // and then finding the mean time of execution
        for ( int i = 0; i < 100; i++){
            memoizedLCS nLcs = new memoizedLCS();
            tm.timerStarts();
            //int len = nLcs.callActualLCS(args[0], args[1]);

            int m = args[0].length();
            int n = args[1].length();
            String subsequence = nLcs.callActualLCS(args[0], args[1]);
            tm.timerEnds();
            meanTime = meanTime + tm.totalTime();
            if (i == 99) {
//                System.out.println("Input 1: " + args[0] + "\n" + "Input 2: " +
//                        args[1]);
                System.out.print(m + ",");
                System.out.print(n + ",");
                System.out.print(subsequence);
                System.out.print("," + subsequence.length() );
                //System.out.print("," + );
                //System.out.print("," + nLcs.NumberOfRec());
            }
        }
//        HirshbergLCS nLcs = new HirshbergLCS();
//            tm.timerStarts();
            //int len = nLcs.callActualLCS(args[0], args[1]);

//            int m = args[0].length();
//            int n = args[1].length();
//            String subsequence = nLcs.algoC(m, n, args[0], args[1]);
//            tm.timerEnds();
//        System.out.print(subsequence);
//                System.out.print("," + subsequence.length());
//        System.out.print("," + tm.totalTime() + "\n");

        // get java runtime
        //Runtime runtime = Runtime.getRuntime();
        // run the garbage collector
        //runtime.gc();
        // calculate the used memory
        //long memory = runtime.totalMemory() - runtime.freeMemory();
        //System.out.println("Used memory in bytes:" + memory);
        //System.out.println("Used memory in megabytes: " + bytesToMegabytes
                //(memory));
        System.out.print("," + meanTime / 100 + "\n");


    }



}
