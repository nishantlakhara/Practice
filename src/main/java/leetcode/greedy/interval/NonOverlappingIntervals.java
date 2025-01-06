package leetcode.greedy.interval;


import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    /*
        https://leetcode.com/problems/non-overlapping-intervals/description/

     */

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[1]));

        int[] lastInterval = null;
        int count = 0;

        for(int[] interval: intervals) {
            // System.out.println("interval = " + interval[0] + "," + interval[1]);
            // if(lastInterval != null) System.out.println("lastInterval = " + lastInterval[0] + "," + lastInterval[1]);
            if(lastInterval == null) {
                lastInterval = interval;
            } else if(lastInterval[1] > interval[0]) { // Overlapping interval, So remove and skip
                // System.out.println(lastInterval[1] + ">" + interval[0]);
                count++;
            } else {
                lastInterval = interval;
            }
        }

        return count;
    }
}
