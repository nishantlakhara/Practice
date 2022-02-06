package leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("dfghighiklmmn"));
    }

    //    Runtime: 12 ms, faster than 40.20% of Java online submissions for Longest Substring Without Repeating Characters.
    //    Memory Usage: 41.4 MB, less than 29.75% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstringOptimumSlidingWindow(String s) {
        //Sliding winsow solution
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        int i = 0;

        // "dvdfghighiklmmn"
        //               m
        //                n
        // "mn"
        while(right < s.length()) {
            //If Set already contains the character, then
            //slide the left side of window till that character and remove the characters               //till that. Dont remove the found element from the set as it can be used for               //next window.
            if(set.contains(s.charAt(right))) {
                while(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                //Add the unique character in window to the set.
                set.add(s.charAt(right));

                //Update the max size
                max = Math.max(max, set.size());
            }
            right++;
        }
        return max;
    }



    //    Runtime: 276 ms, faster than 6.30% of Java online submissions for Longest Substring Without Repeating Characters.
    //    Memory Usage: 113.1 MB, less than 5.81% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring(String s) {
        Set<Character> maxSet = new HashSet<>();
        int max = 0;
        int maxOfMax = 0;
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(!maxSet.contains(c)) {
                max++;
                maxSet.add(c);
            } else {
                if(max > maxOfMax) {
                    maxOfMax = max;
                }
                maxSet.clear();
                max = 0;
                i--;
                while(s.charAt(i) != c) {
                    i--;
                }
            }
        }
        if(max > maxOfMax)
            return max;
        else
            return maxOfMax;
    }
}
