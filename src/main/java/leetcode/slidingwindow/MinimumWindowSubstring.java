package leetcode.slidingwindow;


import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) throws IOException {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));

        String s = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\Practice\\src\\input\\s.txt")));
        String t = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\Practice\\src\\input\\t.txt")));

        System.out.println(mws.minWindowMine(s, t));
        System.out.println(mws.minWindow(s, t));
    }

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public String minWindowMine(String s, String t) {

        //1. Initial boundary cases.
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        //2. Form unique character set.
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        //3. Unique characters required
        int required = mapT.size();

        //4. Unique characters that will be formed while iterating.
        int formed = 0;

        //5. Initialize left and right pointers for sliding window and response.
        int left = 0;
        int right = 0;
        int[] res = new int[]{-1, 0, 0};

        //6. live window map on iteration.
        Map<Character, Integer> mapW = new HashMap<>();

        //7. Start slding window
        while (right < s.length()) {
            //Get character on right index.
            Character c = s.charAt(right);

            mapW.put(c, mapW.getOrDefault(c, 0) + 1);

            //Put in windows map if it exists in t string.
            if (mapT.containsKey(c) && mapW.get(c).intValue() == (mapT.get(c).intValue())) {
                formed++;
            }

            //Check if the string is formed
            while (left <= right && formed == required) {
                c = s.charAt(left);

                //Updated minimum count with left and right indices.
                if (res[0] == -1 || res[0] > right - left + 1) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }

                mapW.put(c, mapW.get(c) - 1);
                if (mapT.containsKey(c) && mapW.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }

                //Increment left.
                left++;
            }

            //Increment right count
            right++;
        }

        if (res[0] == -1) {
            return "";
        } else {
            return s.substring(res[1], res[2] + 1);
        }
    }

    public String minWindowOptimized(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}
