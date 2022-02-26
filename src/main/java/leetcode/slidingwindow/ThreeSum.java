package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            List<List<Integer>> listPairs = twoSum(i+1, nums.length-1, nums, 0-nums[i]);

            for(int j=0; j<listPairs.size(); j++) {
                listPairs.get(j).add(nums[i]);
                list.add(listPairs.get(j));
            }
        }

        return list;
    }

    public List<List<Integer>> twoSum(int start, int end, int[] nums, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = end;
        while(left < right) {
            if(left != start && nums[left] == nums[left-1] ) {
                left++;
                continue;
            }

            int t = nums[left] + nums[right];
            if(t == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                pairs.add(pair);
                left++;
                right--;
            } else if(t > target) {
                right--;
            } else {
                left++;
            }
        }
        //System.out.println("Pairs ==" + pairs);
        return pairs;
    }
}
