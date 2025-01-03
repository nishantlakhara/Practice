package leetcode.priorityqueue;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 */
public class TopKFrequent {

    /*
    Using simple sorting.
     */
    public int[] topKFrequent(int[] nums, int k) {

        // Create a map to store frequencies.
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort the map on basis of the values in descending order.
        // Convert map entry set to list.
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1,e2) -> e2.getValue().compareTo(e1.getValue()));

        // return the top k frequent elements.
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = entryList.get(i).getKey();
        }
        return res;
    }


    /*
    Solution 2 Priority Queue
     */
    public int[] topKFrequentPriorityQueue(int[] nums, int k) {

        // Create a map to store frequencies.
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort the map on basis of the values in descending order.
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()) );
        for(Map.Entry entry: map.entrySet())
            pq.offer(entry);

        // return the top k frequent elements.
        List<Integer> res = new ArrayList<>();
        int i=0;
        while(i < k) {
            res.add(pq.poll().getKey());
            i++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
