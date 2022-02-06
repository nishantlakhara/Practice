package leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWithConcatenationAllWords {


    //Time limit exceeded.
    public List<Integer> findSubstring(String s, String[] words) {
        //Create a map of all combinations
        Set<String> allSubstrings = new HashSet<>();
        createAllSubstrings(words, 0, allSubstrings);

        System.out.println(allSubstrings);

        List<Integer> list = new ArrayList<>();
        int strSize = allSubstrings.stream().findAny().get().length();
        for(int i=0; i<s.length() - strSize - 1; i++) {
            String subStr = s.substring(i, i+strSize);
            if(allSubstrings.contains(subStr)) {
                list.add(i);
            }
        }

        return list;
    }

    public void createAllSubstrings(String[] words, int index, Set<String> set) {
        if(index == words.length - 1) {
            set.add(concatenated(words));
            return;
        }
        for(int i=index; i<words.length; i++) {
            swap(i, index, words);

            createAllSubstrings(words, index+1, set);

            swap(index, i, words);
        }
    }

    public void swap(int i, int j, String[] words) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public String concatenated(String words[]) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
