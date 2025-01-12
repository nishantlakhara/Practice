package leetcode.slidingwindow.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    //abcdecdbaf
    //0 a-1
    //1 b-2
    //2 c-3
    //3 d-4
    //4 e-5 , len = 5
    //5 c-3, i = max(3,0) = 3 i.e next index of c i.e d, len = max(5, dec i.e 3) = 5
    //6 d-4, i = max(4,3) = 4 len = max(5, ecd)
    //7 b-2, i = max(4,2) = 4 len = max(5, ecdb)
    //8 a-1, i = max(4,1) = 4, len = max(5, ecdba)
    //9 f-10, len = max(5, ecdbaf) = 6
    public int lengthOfLongestSubstringBestSolution(String s) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> mapCharToIndex = new HashMap<>();

        for(int right=0; right<s.length(); right++) {
            if(mapCharToIndex.containsKey(s.charAt(right))) {
                //Left shouldnt go backwards as windows should always go forward.
                left = Math.max(mapCharToIndex.get(s.charAt(right)), left);
            }
            res = Math.max(res, right-left+1);

            //Next index as value.
            mapCharToIndex.put(s.charAt(right), right+1);
        }
        return res;
    }

}
