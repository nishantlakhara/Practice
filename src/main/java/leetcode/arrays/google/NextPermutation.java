package leetcode.arrays.google;


/**
 *     https://leetcode.com/problems/next-permutation/
 *
 *      A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 *
 * Approach 2: Single Pass Approach
 * Algorithm
 *
 * First, we observe that for any given sequence that is in descending order, no next larger permutation is possible.
 * For example, no next permutation is possible for the following array:
 *
 * [9, 5, 4, 3, 1]
 * We need to find the first pair of two successive leetcode.numbers a[i] and a[i−1], from the right, which satisfy
 * a[i]>a[i−1]. Now, no rearrangements to the right of a[i−1] can create a larger permutation since that subarray consists of leetcode.numbers in descending order.
 * Thus, we need to rearrange the leetcode.numbers to the right of a[i−1] including itself.
 *
 * Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one. Therefore, we need to replace the number a[i−1] with the number which is just larger than itself among the leetcode.numbers lying to its right section, say a[j].
 *
 *  Next Permutation
 *
 * We swap the leetcode.numbers a[i−1] and a[j]. We now have the correct number at index i−1. But still the current permutation isn't the permutation
 * that we are looking for. We need the smallest permutation that can be formed by using the leetcode.numbers only to the right of a[i−1]. Therefore, we need to place those
 * leetcode.numbers in ascending order to get their smallest permutation.
 *
 * But, recall that while scanning the leetcode.numbers from the right, we simply kept decrementing the index
 * until we found the pair a[i] and a[i−1] where, a[i]>a[i−1]. Thus, all leetcode.numbers to the right of a[i−1] were already sorted in descending order.
 * Furthermore, swapping a[i−1] and a[j] didn't change that order.
 * Therefore, we simply need to reverse the leetcode.numbers following a[i−1] to get the next smallest lexicographic permutation.
 *
 * The following animation will make things clearer:
 *
 * Next Permutation
 *
 *
 * Complexity Analysis
 *
 * Let n be the size of the nums array.
 *
 * Time complexity: O(n)
 *
 * The first while loop runs at most n iterations, decrementing the variable i as it searches for the first decreasing element from the right. In the worst case, it checks all elements, so it takes O(n) time.
 *
 * The second while loop also runs at most n iterations, decrementing the variable j as it searches for the smallest element larger than nums[i]. Similarly, it can take O(n) time.
 *
 * The reverse function is called on a portion of the array, from index i + 1 to the end. In the worst case, this can cover the entire array, leading to a time complexity of O(n).
 *
 * The swap function runs in constant time, O(1), since it only exchanges two elements.
 *
 * Therefore, the overall time complexity is O(n).
 *
 * Space complexity: O(1)
 *
 * The function operates in-place on the nums array, meaning no extra space is used for storing additional data.
 *
 * Only a few constant space variables (i, j, and temp) are used.
 *
 * The built-in swap and reverse functions do not require additional space beyond what is already present in the input array.
 *
 * Hence, the space complexity is O(1).
 */
public class NextPermutation {

    /**
     1 5 8 4 7 6 5 3 1
     -> 4 is 1st decreasing (1,3,5,6,7)
     -> Swap 4 with 5 i.e 1,3,5 first greater than 4,
     -> Reverse remaining i.e starting from next element 7 i.e index + 1
     */
    public void nextPermutation(int[] nums) {
        //Go till the decreasing order.
        int i = nums.length-2;
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }

        //Swap with the ceiling of the ith number from backwards.
        if(i >= 0) {
            int j = nums.length-1;
            while(nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        //reverse the elements after swapping, next index to swapped index till the end.
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length-1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
