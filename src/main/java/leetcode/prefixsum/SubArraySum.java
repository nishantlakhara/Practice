package leetcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        // Stores prefix sum with its frequency.
        Map<Integer, Integer> map = new HashMap<>();

        // Initially sum 0 and frequency 1.
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            // If difference is already present, that means those number of occurences can be done.
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Set or Update frequency of prefix sum.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
