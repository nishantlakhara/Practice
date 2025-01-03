package leetcode.dynamic;

import java.util.Arrays;

/**
 * Leetcode 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] i: dp)
            Arrays.fill(i, -1);

        return dfs(0, 0, m, n, grid, dp);
    }

    public int dfs(int i, int j, int m, int n, int[][] grid, int[][] dp) {

        // reached the destination
        if(i == m-1 && j == n-1) {
            return grid[m-1][n-1];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        Integer down = Integer.MAX_VALUE;
        Integer right = Integer.MAX_VALUE;
        // Move right.
        if(j < n - 1) {
            right = grid[i][j] + dfs(i, j+1, m, n, grid, dp);
        }

        // Move down
        if(i < m - 1) {
            down = grid[i][j] + dfs(i+1, j, m, n, grid, dp);
        }

        int min = Math.min(down, right);
        return dp[i][j] = min == Integer.MAX_VALUE ? 0:min;
    }

}
