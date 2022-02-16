package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Integer, TrieNode> children;
    int weight;
    public TrieNode() {
        children = new HashMap();
        weight = 0;
    }
}
