package leetcode.priorityqueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {

        // Create a Min heap
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);

        Set<Long> visited = new HashSet<>();

        while(n-- > 1) {
            Long ugly = pq.poll();
            visited.add(ugly);
            // System.out.println(ugly);

            if(!visited.contains(ugly * 2)) {
                pq.offer(ugly * 2);
                visited.add(ugly * 2);
            }

            if(!visited.contains(ugly * 3)) {
                pq.offer(ugly * 3);
                visited.add(ugly * 3);
            }

            if(!visited.contains(ugly * 5)) {
                pq.offer(ugly * 5);
                visited.add(ugly * 5);
            }
        }

        return pq.peek().intValue();
    }
}
