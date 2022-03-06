package utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorUtilities {
    public static void main(String[] args) {
        int[][] intervals = {
                {3,5},
                {3,4},
                {1,2},
                {0,5}
        };

        //Create a min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>();

        //Sort the intervals on basis of start_times.
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        Arrays.stream(intervals).forEach(s -> System.out.println(s[0] + "," + s[1]));

        allocator.add(4);
        allocator.add(3);
        allocator.add(2);

        while(!allocator.isEmpty()) {
            System.out.println(allocator.poll());
        }

        //Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<Integer>(Comparator.comparing(a -> (Integer)a).reversed());

        //Sort on basis of first and then second.
        Arrays.sort(intervals, Comparator.comparing(a -> ((int[])a)[1])
                .thenComparing(a -> ((int[])a)[0]));

    }
}
