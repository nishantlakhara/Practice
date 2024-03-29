package leetcode.dynamicprogramming;

public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i: nums) {
            sum = sum + i;
            maxSum = Math.max(sum,maxSum);
            if(sum < 0) sum = 0;
        }

        return maxSum;
    }
}
