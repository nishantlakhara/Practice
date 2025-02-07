package leetcode.mix;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * HARD BUT ONCE INTUITION IS CLEAR PRETTY EASY
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 *
 */
public class WordSearchII_Trie_DFS_Backtrack {

    public static void main(String[] args) {
        // Defining the board as a 2D character array
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        // Defining the words as a string array
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(new WordSearchII_Trie_DFS_Backtrack().findWords(board, words));
    }


    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build a trie
        TrieNode rootNode = new TrieNode();
        buildTrie(rootNode, words);

        for(int i=0; i< board.length; i++)
            for(int j=0; j<board[0].length; j++)
                dfs(board, i, j, rootNode);

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1)
            return;

        char ch = board[i][j];
        TrieNode n = node.children.get(ch);

        // Match
        if(n != null) {
            if(n.word != null) {
                res.add(n.word);
                n.word = null;         // Duplicate optimization. Once found remove word from trie tail.
            }
            board[i][j] = '#';         // Dont revisit in the trail

            dfs(board, i+1, j, n);
            dfs(board, i, j+1, n);
            dfs(board, i-1, j, n);
            dfs(board, i, j-1, n);

            board[i][j] = ch;

            if(n.children.isEmpty())
                node.children.remove(ch);      // Space Optimization: Remove leaf nodes from trie.
        }
    }

    private void buildTrie(TrieNode rootNode, String[] words) {
        for(String word: words) {
            TrieNode node = rootNode;

            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                if(!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = word;
        }
    }

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }
}
