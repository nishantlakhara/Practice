package leetcode.maps;

import java.util.HashMap;

public class CowAndBulls {

    //1,2,3,1
    //0,1,1,1

    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap();

        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);
            if (s == g) {
                bulls++;
            } else {
                if (h.getOrDefault(s, 0) < 0)
                    cows++;
                if (h.getOrDefault(g, 0) > 0)
                    cows++;
                h.put(s, h.getOrDefault(s, 0) + 1);
                h.put(g, h.getOrDefault(g, 0) - 1);
            }
        }

        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }


    //More optimized. Fastes solution: Tradeoff with hashmap and string builder.
    class Solution {
        public String getHint(String secret, String guess) {
            int[] h = new int[10];

            int bulls = 0, cows = 0;
            int n = guess.length();
            for (int idx = 0; idx < n; ++idx) {
                char s = secret.charAt(idx);
                char g = guess.charAt(idx);
                if (s == g) {
                    bulls++;
                } else {
                    if (h[s - '0'] < 0)
                        cows++;
                    if (h[g - '0'] > 0)
                        cows++;
                    h[s - '0']++;
                    h[g - '0']--;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(bulls);
            sb.append("A");
            sb.append(cows);
            sb.append("B");
            return sb.toString();
        }
    }

}
