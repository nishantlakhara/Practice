package leetcode.dynamicprogramming;

import java.util.Arrays;

/*

70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
 */
public class ClimbingStairs {
    public int climbStairsTabulation(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return dfs(dp, n, 0);
    }

    public int dfs(int[] dp, int n, int idx) {

        if(idx >= n) {
            return 1;
        }

        if(idx == n-1) {
            return 1;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        return dp[idx] = dfs(dp, n, idx+1) + dfs(dp, n, idx+2);
    }
}
