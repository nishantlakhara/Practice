package leetcode.slidingwindow;

public class LongestPalindrome {
    public String longestPalindrome(String s) {

        int max = 0;
        int[] indexMaxstr = new int[] {0, 0};
        for(int i=0; i<s.length(); i++) {
            //Find palindrome with odd number of characters.
            int[] index1 = expandFromCenter(s, i, i);
            int length1 = index1[1] - index1[0];
            // System.out.println("len1 = " + length1);

            //FInd palindrome with even number of characters.
            int[] index2 = expandFromCenter(s, i, i+1);
            int length2 = index2[1] - index2[0];
            // System.out.println("len2 = " + length2);

            int maxOfTwo = length2 > length1 ? length2 : length1;

            if(max < maxOfTwo) {
                max = maxOfTwo;
                if(maxOfTwo == length2) {
                    indexMaxstr = index2;
                } else {
                    indexMaxstr = index1;
                }
            }

            // System.out.println("indexMaxstr == " + indexMaxstr[0] + "\t" + indexMaxstr[1]);
        }
        return s.substring(indexMaxstr[0], indexMaxstr[1]);
    }

    public int[] expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            // System.out.println("left = " + left + "\tright = " + right);
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        // System.out.println("left return = " + left + "\t right return = " + right);
        return new int[] {left+1, right};
    }

    public String longestPalindromeOfficialLeetcode(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
