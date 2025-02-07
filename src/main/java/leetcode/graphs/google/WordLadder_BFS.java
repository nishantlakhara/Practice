package leetcode.graphs.google;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 *
 * O(M^2*N)
 * S(M*N)
 *
 * Swapping of arrays at every level.
 */
public class WordLadder_BFS {

         public int ladderLength(
         String beginWord,
         String endWord,
         List<String> wordList
     ) {
         Queue<String> q = new LinkedList<>();
         Set<String> words = new HashSet<>(wordList);
         if(!words.contains(endWord)) return 0;
         words.remove(beginWord);
         q.add(beginWord);
         int level = 0;

         while(!q.isEmpty()) {
             int size = q.size();
             level++;

             for(int i=0; i<size; i++) {
                 String currentWord = q.poll();

                 if(currentWord.equals(endWord))
                     return level;

                 List<String> neighbors = findNeighBors(currentWord);
                 for(String neigh: neighbors) {
                     if(words.contains(neigh)) {
                         words.remove(neigh);
                         q.add(neigh);
                     }
                 }
             }
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
