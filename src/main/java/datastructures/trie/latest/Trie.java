package datastructures.trie.latest;

import java.util.*;

public class Trie {
    private Character c;
    private Map<Character, Trie> children;
    private boolean isTerminal;
    private boolean sorted;

//    public Trie(Character c, Map<Character, Trie> children) {
//        this.c = c;
//        this.children = children;
//
//        //Not necessary default value in java is false.
//        isTerminal = false;
//    }

    public Trie(Character c, boolean sorted) {
        this.c = c;
        this.sorted = sorted;

        if(sorted)
            this.children = new TreeMap<>();
        else
            this.children = new HashMap<>();

        //Not necessary default value in java is false.
        isTerminal = false;

    }

    public void insert(String word) {
        insert(word, this);
    }

    private void insert(String word, Trie trie) {
        if(word.length() == 0) {
            trie.isTerminal = true;
            return;
        }
        char c = word.charAt(0);
        if(!trie.children.containsKey(c)) {
            trie.children.put(c, new Trie(c, sorted));
        }
        insert(word.substring(1), trie.children.get(c));
    }

    public List<String> startsWith(String prefix) {
        List<String> list = new ArrayList<>();
        startsWith(prefix, this, list);
        return list;
    }

    private void startsWith(String prefix, Trie trie, List<String> list) {
        for(int i=0; i<prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            if(!trie.children.containsKey(ch)) {
                return;
            } else {
                trie = trie.children.get(ch);
            }
        }

        appendToPrefix(new StringBuilder(prefix), trie,  list);
    }

    private void appendToPrefix(StringBuilder sb, Trie trie, List<String> list) {
        if(trie.isTerminal) {
            list.add(sb.toString());
        }

        for(Map.Entry<Character, Trie> entry : trie.children.entrySet()) {
            //Add
            sb.append(entry.getKey());

            //Recurse
            appendToPrefix(sb, trie.children.get(entry.getKey()), list);

            //Backtrack
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
