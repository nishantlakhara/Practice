package leetcode.dynamicprogramming;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        return minDist(0, 0, word1, word2, dp);
    }

    public int minDist(int i, int j, String word1, String word2, int[][] dp) {

        if((i == word1.length() - 1) && (j == word2.length() - 1)) {
            if(word1.charAt(i) == word2.charAt(j))
                return 0;
            else { // Could be replaced.
                return 1;
            }
        }

        if(i == word1.length()) {
            // Delete all j
            return word2.length() - j;
        }

        if(j == word2.length()) {
            // Delete all i
            return word1.length() - i;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int insert = Integer.MAX_VALUE;
        int replace = Integer.MAX_VALUE;
        int delete = Integer.MAX_VALUE;

        if(word1.charAt(i) == word2.charAt(j)) {
            return minDist(i+1, j+1, word1, word2, dp);
        } else {
            insert = 1 + minDist(i+1, j, word1, word2, dp);
            replace = 1 + minDist(i+1, j+1, word1, word2, dp);
            delete = 1 + minDist(i, j+1, word1, word2, dp);
        }

        return dp[i][j] = Math.min(insert, Math.min(replace, delete));
    }
}
