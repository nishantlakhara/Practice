package datastructures.trie.basic;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private Character val;
    private Boolean isTerminal = false;
    private Map<Character, Trie> map = new TreeMap<>();

    public Character getVal() {
        return val;
    }

    public Boolean isTerminal() {
        return isTerminal;
    }

    public Map<Character, Trie> getMap() {
        return map;
    }

    public Trie(Character val) {
        this.val = val;
    }

    public void setIsTerminal(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }

    public void addWord(String word) {
        if(word.length() == 0) {
            return;
        }
        addWord(this, word);
    }

    public void addWord(Trie trie, String word) {
        Character c = word.charAt(0);
        if(!trie.getMap().containsKey(c)) {
            trie.getMap().put(c, new Trie(c));
        }
        if(word.length() == 1) {
            trie.getMap().get(c).setIsTerminal(true);
            return;
        }
        addWord(trie.getMap().get(c), word.substring(1));
    }

    public int hashCode() {
        return Character.hashCode(val);
    }

    public boolean equals(Object obj) {
        if(this.val == ((Trie)obj).val) {
            return true;
        }
        return false;
    }
}