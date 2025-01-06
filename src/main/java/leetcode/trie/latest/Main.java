package leetcode.trie.latest;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie(' ', true);

        trie.insert("applet");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("bata");
        trie.insert("carrot");
        trie.insert("camel");
        trie.insert("cat");
        trie.insert("caterpillar");
        trie.insert("c");

        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("cat"));
        System.out.println(trie.startsWith("ca"));
        System.out.println(trie.startsWith("c"));
    }
}
