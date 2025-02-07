package leetcode.graphs.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordLadder_BidirectionalSearch {
    public int ladderLength(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {

        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int length = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Swap if beginSet > endSet
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> newBeginSet = new HashSet<>();

            for(String word: beginSet) {
                List<String> neighbors = findNeighBors(word);

                for(String neigh: neighbors) {
                    if(endSet.contains(neigh)) 
                        return length+1;

                    if(words.contains(neigh)) {
                        newBeginSet.add(neigh);
                        words.remove(neigh);
                    }
                }
                
            }
            beginSet = newBeginSet;
            length++;
        }

        return 0;
    }

    public List<String> findNeighBors(String word) {
        char[] chars = word.toCharArray();

        List<String> result = new ArrayList<>();

        for(int i=0; i<chars.length; i++) {
            char temp = chars[i];    // Save memory by using array and backtrack.
            for(char c='a'; c<='z'; c++) {
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }
            chars[i] = temp;  
        }

        return result;
    }
}