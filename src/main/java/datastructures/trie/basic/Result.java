package datastructures.trie.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



class Result {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        List<List<String>> list = new ArrayList<>();
        // Collections.sort(repository);

        Trie trie = createTrie(repository);

        for(int i=2; i<customerQuery.length(); i++) {
            list.add(search(customerQuery.substring(0,i), trie));
        }

        System.out.println(list);
        return list;
    }

    public static List<String> search(String customerQuery, Trie trie) {
        List<String> list = new ArrayList<>();

        String s = customerQuery;

        for(int i=0; i<customerQuery.length(); i++) {
            trie = trie.getMap().get(customerQuery.charAt(i));
            if(trie == null) {
                return new ArrayList<>();
            }
        }

        for(Map.Entry<Character, Trie> entry: trie.getMap().entrySet()) {
            Character key = entry.getKey();
            Trie val = entry.getValue();

            list.addAll(getWords(s+key, val));
        }
        return list;
    }

    public static List<String> getWords(String word, Trie trie) {
        List<String> list = new ArrayList<>();
        if(trie.isTerminal()) {
            list.add(word);
        }
        if(trie.getMap().isEmpty()) {
            return list;
        }
        for(Map.Entry<Character, Trie> entry: trie.getMap().entrySet()) {
            Character key = entry.getKey();
            Trie val = entry.getValue();

            list.addAll(getWords(word+key, val));
        }
        return list;
    }

    public static Trie createTrie(List<String> repository) {
        Trie trie = new Trie('0');

        for(int i=0; i<repository.size(); i++) {
            trie.addWord(repository.get(i));
        }
        return trie;
    }

}






