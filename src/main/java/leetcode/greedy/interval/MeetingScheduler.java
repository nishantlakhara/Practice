package leetcode.greedy.interval;

import java.util.*;

public class MeetingScheduler {

    /**
     * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
     *
     * If there is no common time slot that satisfies the requirements, return an empty array.
     *
     * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
     *
     * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
     *
     *
     *
     * Example 1:
     *
     * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
     * Output: [60,68]
     * Example 2:
     *
     * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
     * Output: []
     *
     *
     * Constraints:
     *
     * 1 <= slots1.length, slots2.length <= 10^4
     * slots1[i].length, slots2[i].length == 2
     * slots1[i][0] < slots1[i][1]
     * slots2[i][0] < slots2[i][1]
     * 0 <= slots1[i][j], slots2[i][j] <= 10^9
     * 1 <= duration <= 10^6
     *
     *
     * @param slots1
     * @param slots2
     * @param duration
     * @return
     *
     *
     *
     * Complexity Analysis
     *
     * Time complexity: O(MlogM+NlogN), when M is the length of slots1 and N is the length of slots2.
     *
     * Sorting both arrays would take O(MlogM+NlogN). The two pointers take O(M+N) because, during each iteration, we would visit a new element, and there are a total of M+N elements. Putting these together, the total time complexity is O(MlogM+NlogN).
     *
     * Space complexity: O(n) or O(logn)
     *
     * Some extra space is used when we sort an array of size n in place. The space complexity of the sorting algorithm depends on the programming language.
     *
     * In Python, the sort method sorts a list using the Timsort algorithm which is a combination of Merge Sort and Insertion Sort and has a space complexity of O(n)
     * In C++, the sort() function is implemented as a hybrid of Quick Sort, Heap Sort, and Insertion Sort, with a worst-case space complexity of O(logn)
     * In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(logn)
     * Thus, the total space complexity of the algorithm is O(n) or O(logn).
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        List<Integer> list = new ArrayList<>();

        // Two Pointer approach
        int startMax = 0;
        int endMin = 0;
        int i=0;
        int j=0;

        // Sort by start time.
        Arrays.sort(slots1, Comparator.comparing(k -> k[0]));
        Arrays.sort(slots2, Comparator.comparing(k -> k[0]));

        while(i < slots1.length && j < slots2.length) {
            startMax = Math.max(slots1[i][0], slots2[j][0]);
            endMin = Math.min(slots1[i][1], slots2[j][1]);

            if(endMin - startMax >= duration) {
                list.add(startMax);
                list.add(startMax + duration);
                return list;
            }

            if(endMin == slots1[i][1]) i++;
            if(endMin == slots2[j][1]) j++;
        }

        return list;
    }


    /**
     Using Heap.

     The problem description states that the time slots for a single person do not overlap. This means that if, for example, we have the time slots [10, 15] and [14, 20], then we know that these time slots cannot be for the same person. Otherwise, we would have a contradiction. So, given that a common time slot has to overlap, the two slots have to be from different people.

     A heap returns the smallest items first. Because of this time slots we remove from the heap are sorted by the start time. Taking advantage of this, we can then compare the time slots in the order of time.

     Time complexity: O((M+N)log(M+N)), when M is the length of slots1 and N is the length of slots2.

     There are two parts to be analyzed: 1) building up the heap; 2) the iteration when we keep popping elements from the heap. For the second part, popping one element takes O(log(M+N)), therefore, in the worst case, popping M+N elements takes O((M+N)log(M+N)).

     Regarding the first part, we have different answers for Java and Python implementations. For Python, heapq.heapify transforms a list into a heap, in-place, in linear time; however, in Java, we choose to pop each element into the heap, which leads to a time complexity of O((M+N)log(M+N)). Note that it is possible to convert the array into a heap in linear time using the constructor of PriorityQueue; however, that will not influence the overall time complexity and will make it less readable.

     When we put these two parts together, the total time complexity is O((M+N)log(M+N)), which is determined by the first part.

     Space complexity: O(M+N). This is because we store all M+N time slots in a heap.


     */
    public List<Integer> minAvailableDurationHeap(int[][] slots1, int[][] slots2, int duration) {

        // Interval sort by start time.
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(k -> k[0]));

        for(int[] slot: slots1) {
            if(duration <= (slot[1] - slot[0]))
                pq.offer(slot);
        }

        for(int[] slot: slots2) {
            if(duration <= (slot[1] - slot[0]))
                pq.offer(slot);
        }

        System.out.println("Hello");
        while(pq.size() > 1) {
            int[] slot1 = pq.poll();
            int[] slot2 = pq.peek();

            //If they overlap, that means they are from different person.
            //end1 >= start2 + duration
            //[60,80] [65,75] duration=8 -> [65,73]
            //[60,80] [65,72] duration=8 > Already [65,72 is discarded above while pushing to queue since duration is lesser 72-65=7]
            System.out.println(slot1[1] + "," + slot2[0]);
            if(slot1[1] >= slot2[0] + duration) {
                return new ArrayList<Integer>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<>();
    }
}
