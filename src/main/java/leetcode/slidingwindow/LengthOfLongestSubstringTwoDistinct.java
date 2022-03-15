package leetcode.slidingwindow;

import java.util.Collections;
import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //Base case
        if(s.length() < 3) {
            return s.length();
        }

        //Memory
        HashMap<Character, Integer> map = new HashMap<>();

        //Return
        int max = 2;

        //Sliding window approach.
        int left = 0;
        int right = 0;

        while(right < s.length()) {

            //Store index of the character in the map.
            map.put(s.charAt(right), right);


            //Check if sliding window contains more than 3 characters.
            //If so remove the one wih lowest index value.
            if(map.size() == 3) {
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                left = delIndex + 1;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
