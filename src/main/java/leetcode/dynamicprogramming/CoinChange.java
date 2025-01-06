package leetcode.dynamicprogramming;

import java.util.Arrays;


/**
 * Leetcode 322.
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // +1 because its easier to track index, 1 -> 1 index, amount -> amount index instead of -1.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        Integer res = dfs(coins, amount, dp);

        // Unreachability check.
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dfs(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCount = Integer.MAX_VALUE;
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                count = 1 + dfs(coins, amount - coins[i], dp);

                if (count > 0) {
                    minCount = Math.min(count, minCount);
                }
            }
        }

        return dp[amount] = minCount;
    }


}
