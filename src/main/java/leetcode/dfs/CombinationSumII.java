package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 40.
 *
 * Given a collection of candidate leetcode.numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate leetcode.numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(candidates);
            // for(int i=0; i<candidates.length; i++) {
            //     System.out.print(candidates[i] + ",");
            // }

            dfs(candidates, res, new ArrayList<>(), target, 0);

            return res;
        }

        public void dfs(int[] candidates,List<List<Integer>> res, List<Integer> curr, int target, int idx) {
            if(target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for(int i=idx; i<candidates.length; i++) {
                // Optimization
                if(candidates[i] > target) {
                    break;
                }

                // Avoid Duplicates
                if(i > idx && candidates[i] == candidates[i-1]) {
                    continue;
                }

                curr.add(candidates[i]);
                dfs(candidates, res, curr, target-candidates[i], i+1);
                curr.remove(curr.size() - 1);
            }
        }

}
