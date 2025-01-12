package leetcode.slidingwindow.google;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 *
 *
 * Solution:
 *
 *
 * This problem is a follow-up of Two Sum, and it is a good idea to first take a look at Two Sum and Two Sum II. An interviewer may ask to solve Two Sum first, and then throw 3Sum at you. Pay attention to subtle differences in problem description and try to re-use existing solutions!
 *
 * Two Sum, Two Sum II and 3Sum share a similarity that the sum of elements must match the target exactly. A difference is that, instead of exactly one answer, we need to find all unique triplets that sum to zero.
 *
 * Before jumping in, let's check the existing solutions and determine the best conceivable runtime (BCR) for 3Sum:
 *
 * Two Sum uses a hashmap to find complement values, and therefore achieves O(N) time complexity.
 * Two Sum II uses the two pointers pattern and also has O(N) time complexity for a sorted array. We can use this approach for any array if we sort it first, which bumps the time complexity to O(nlogn).
 * Considering that there is one more dimension in 3Sum, it sounds reasonable to shoot for O(n
 * 2
 *  ) time complexity as our BCR.
 *
 * Approach 1: Two Pointers
 * We will follow the same two pointers pattern as in Two Sum II. It requires the array to be sorted, so we'll do that first. As our BCR is O(n
 * 2
 *  ), sorting the array would not change the overall time complexity.
 *
 * To make sure the result contains unique triplets, we need to skip duplicate values. It is easy to do because repeating values are next to each other in a sorted array.
 *
 * If you are wondering how to solve this problem without sorting the array, go over the "No-Sort" approach below. There are cases when that approach is preferable, and your interviewer may probe your knowledge there.
 *
 * After sorting the array, we move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the two pointers pattern, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.
 *
 * As a quick refresher, the pointers are initially set to the first and the last element respectively. We compare the sum of these two elements to the target. If it is smaller, we increment the lower pointer lo. Otherwise, we decrement the higher pointer hi. Thus, the sum always moves toward the target, and we "prune" pairs that would move it further away. Again, this works only if the array is sorted. Head to the Two Sum II solution for the detailed explanation.
 *
 * Current
 *
 * Algorithm
 *
 * The implementation is straightforward - we just need to modify twoSumII to produce triplets and skip repeating values.
 *
 * For the main function:
 *
 * Sort the input array nums.
 * Iterate through the array:
 * If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
 * If the current value is the same as the one before, skip it.
 * Otherwise, call twoSumII for the current position i.
 * For twoSumII function:
 *
 * Set the low pointer lo to i + 1, and high pointer hi to the last index.
 * While low pointer is smaller than high:
 * If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
 * If sum is greater than zero, decrement hi.
 * Otherwise, we found a triplet:
 * Add it to the result res.
 * Decrement hi and increment lo.
 * Increment lo while the next value is the same as before to avoid duplicates in the result.
 * Return the result res.
 *
 *
 * Complexity Analysis
 *
 * Time Complexity: O(n
 * 2
 *  ). twoSumII is O(n), and we call it n times.
 *
 * Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n
 * 2
 *  ). This is asymptotically equivalent to O(n
 * 2
 *  ).
 *
 * Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.
 *
 * Approach 2: Hashset
 * Since triplets must sum up to the target value, we can try the hash table approach from the Two Sum solution. This approach won't work, however, if the sum is not necessarily equal to the target, like in 3Sum Smaller and 3Sum Closest.
 *
 * We move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the Two Sum: One-pass Hash Table approach, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.
 *
 * To do that, we process each element nums[j] to the right of the pivot, and check whether a complement -nums[i] - nums[j] is already in the hashset. If it is, we found a triplet. Then, we add nums[j] to the hashset, so it can be used as a complement from that point on.
 *
 * Like in the approach above, we will also sort the array so we can skip repeated values. We provide a different way to avoid duplicates in the "No-Sort" approach below.
 *
 * Algorithm
 *
 * The main function is the same as in the Two Pointers approach above. Here, we use twoSum (instead of twoSumII), modified to produce triplets and skip repeating values.
 *
 * For the main function:
 *
 * Sort the input array nums.
 * Iterate through the array:
 * If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
 * If the current value is the same as the one before, skip it.
 * Otherwise, call twoSum for the current position i.
 * For twoSum function:
 *
 * For each index j > i in A:
 * Compute complement value as -nums[i] - nums[j].
 * If complement exists in hashset seen:
 * We found a triplet - add it to the result res.
 * Increment j while the next value is the same as before to avoid duplicates in the result.
 * Add nums[j] to hashset seen
 * Return the result res.
 *
 *
 * Time Complexity: O(n
 * 2
 *  ). twoSum is O(n), and we call it n times.
 *
 * Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n
 * 2
 *  ). This is asymptotically equivalent to O(n
 * 2
 *  ).
 *
 * Space Complexity: O(n) for the hashset.
 *
 * Approach 3: "No-Sort"
 * What if you cannot modify the input array, and you want to avoid copying it due to memory constraints?
 *
 * We can adapt the hashset approach above to work for an unsorted array. We can put a combination of three values into a hashset to avoid duplicates. Values in a combination should be ordered (e.g. ascending). Otherwise, we can have results with the same values in the different positions.
 *
 * Algorithm
 *
 * The algorithm is similar to the hashset approach above. We just need to add few optimizations so that it works efficiently for repeated values:
 *
 * Use another hashset dups to skip duplicates in the outer loop.
 * Without this optimization, the submission will time out for the test case with 3,000 zeroes. This case is handled naturally when the array is sorted.
 * Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate it once. Values in the hashmap will indicate whether we have encountered that element in the current iteration. When we process nums[j] in the inner loop, we set its hashmap value to i. This indicates that we can now use nums[j] as a complement for nums[i].
 * This is more like a trick to compensate for container overheads. The effect varies by language, e.g. for C++ it cuts the runtime in half. Without this trick the submission may time out.
 *
 * Complexity Analysis
 *
 * Time Complexity: O(n
 * 2
 *  ). We have outer and inner loops, each going through n elements.
 *
 * While the asymptotic complexity is the same, this algorithm is noticeably slower than the previous approach. Lookups in a hashset, though requiring a constant time, are expensive compared to the direct memory access.
 *
 * Space Complexity: O(n) for the hashset/hashmap.
 *
 * For the purpose of complexity analysis, we ignore the memory required for the output. However, in this approach we also store output in the hashset for deduplication. In the worst case, there could be O(n
 * 2
 *  ) triplets in the output, like for this example: [-k, -k + 1, ..., -1, 0, 1, ... k - 1, k]. Adding a new number to this sequence will produce n / 3 new triplets.
 *
 * Further Thoughts
 * This is a well-known problem with many variations and its own Wikipedia page.
 *
 * For an interview, we recommend focusing on the Two Pointers approach above. It's easier to get it right and adapt for other variations of 3Sum. Interviewers love asking follow-up problems like 3Sum Smaller and 3Sum Closest!
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> triplets = new ArrayList<>();

        //1. Sort the array.
        Arrays.sort(nums);

        //2. Iterate through all the nodes and get2sum pairs.
        for(int i=0; i<nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            twoSum(nums, i, triplets);
        }
        return triplets;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> triplets) {
        int left = i + 1;
        int right = nums.length - 1;

        while(left < right) {
            if(left != i+1 && nums[left] == nums[left-1]) {
                left++;
                continue;
            }

            //System.out.println(i + " " + left + " " + right);

            int t = nums[i] + nums[left] + nums[right];
            if(t < 0) {
                left++;
            } else if(t > 0) {
                right--;
            } else {
                triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
            }
        }
    }
}
