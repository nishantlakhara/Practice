package leetcode.arrays;

public class NextPermutation {
    //158476531
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
