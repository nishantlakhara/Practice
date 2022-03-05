package leetcode.kadane;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] nums = new int[] {7,1,5,4};

        MaximumDifference md = new MaximumDifference();
        System.out.println(md.maximumDifference(nums));

        nums = new int[] {9,4,3,2};
        System.out.println(md.maximumDifference(nums));

        nums = new int[] {1,5,2,10};
        System.out.println(md.maximumDifference(nums));
    }

    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int globalMax = 0;
        int localMax = 0;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            localMax = Math.max(diff, localMax + diff);
            globalMax = Math.max(globalMax, localMax);
            System.out.println(nums[i] + "," + diff + "," + localMax + "," + globalMax);
        }

        return globalMax == 0 ? -1: globalMax;
    }
}
