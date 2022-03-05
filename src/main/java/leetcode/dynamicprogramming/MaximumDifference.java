package leetcode.dynamicprogramming;

/**
 * Maximum Difference Between Increasing Elements
 */
public class MaximumDifference {
    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        // Space: O(n)
        int[] maxVal = new int[n];
        maxVal[n - 1] = nums[n - 1];

        // Time: O(n)
        for (int i = n - 2; i >= 0; i--) {
            maxVal[i] = Math.max(maxVal[i + 1], nums[i]);
        }

        int maximum = 0;
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maxVal[i] - nums[i], maximum);
        }

        return maximum == 0 ? -1 : maximum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {7,1,5,4};

        MaximumDifference md = new MaximumDifference();
        System.out.println(md.maximumDifference(nums));

        nums = new int[] {9,4,3,2};
        System.out.println(md.maximumDifference(nums));

        nums = new int[] {1,5,2,10};
        System.out.println(md.maximumDifference(nums));

    }
}
