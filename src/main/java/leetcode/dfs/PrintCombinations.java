package leetcode.dfs;

public class PrintCombinations {

    public static void main(String[] args) {
        String s = "abcd";

        combinations(s);
    }

    private static void combinations(String s) {
        combi("", s);
    }

    private static void combi(String prefix, String remaining) {
        if(remaining.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        combi(prefix + remaining.charAt(0), remaining.substring(1));
        combi(prefix, remaining.substring(1));
    }
}
