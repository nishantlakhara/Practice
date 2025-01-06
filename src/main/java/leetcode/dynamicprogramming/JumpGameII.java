package leetcode.dynamicprogramming;

import java.util.Arrays;

public class JumpGameII {

        public int jump(int[] nums) {
            int[] cache = new int[nums.length];
            Arrays.fill(cache, -1);
            return jump(nums, 0, cache);
        }

        public int jump(int[] nums, int start, int[] cache) {
            if(start >= nums.length - 1) {
                cache[start] = 0;
                return 0;
            }

            if(cache[start] != -1) {
                return cache[start];
            }

            if(cache[start] == Integer.MAX_VALUE) {
                return cache[start];
            }

            int min = Integer.MAX_VALUE;
            for(int i=1; i<=nums[start] && start+i < nums.length; i++) {
                int jumps = jump(nums, start+i, cache);
                if(jumps != Integer.MAX_VALUE) {
                    min = Math.min(min, jumps + 1);
                }
            }

            return cache[start] = min;
        }

}
