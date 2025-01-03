package leetcode.dynamic;

public class RegularExpressionMatching {
    //Memoization
    enum Result {
        TRUE, FALSE
    };

    public static void main(String[] args) {
        String pattern = "a*b*a.";
        String text = "abaa";

        System.out.println(isMatch(text, pattern));
        System.out.println(isMatchTab(text, pattern));
    }

    public static boolean isMatch(String text, String patt) {
        Result[][] memo = new Result[text.length() + 1][patt.length() + 1];
        boolean isMatch = isMatch(0, 0, text, patt, memo);

        return isMatch;
    }

    public static boolean isMatch(int tIndex, int pIndex, String text, String patt, Result[][] memo) {

        // If already present in cache.
        if (memo[tIndex][pIndex] != null) {
            return memo[tIndex][pIndex] == Result.TRUE;
        }

        boolean ans;

        // Covered the pattern. Now pattern is empty.
        // Text should also be empty.
        if (pIndex == patt.length()) {
            ans = (tIndex == text.length());
        } else {
            // Find if first match
            boolean first_match = tIndex < text.length() && pIndex < patt.length() &&
                    (text.charAt(tIndex) == patt.charAt(pIndex)
                            || patt.charAt(pIndex) == '.');

            // Check if pattern contains *
            // Zero or more || first_match then move to next char.
            if (tIndex < text.length() && pIndex < patt.length() - 1 && patt.charAt(pIndex + 1) == '*') {
                return isMatch(tIndex, pIndex + 2, text, patt, memo)
                        || (first_match && isMatch(tIndex + 1, pIndex, text, patt, memo));
            } else {
                // Else pattern do not contain *
                return first_match && isMatch(tIndex + 1, pIndex + 1, text, patt, memo);
            }

        }

        memo[tIndex][pIndex] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }


    public static boolean isMatchTab(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match =
                        (i < text.length() &&
                                (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        for(int i=0; i< dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                System.out.print("memo[" + i + "][" + j + "]=" + dp[i][j] + ",");
            }
            System.out.println();
        }
        return dp[0][0];
    }

}
