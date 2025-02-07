package leetcode.strings.google;

public class ShortestPalindromeKMP {

    public static void main(String[] args) {
        ShortestPalindromeKMP shortestPalindrome = new ShortestPalindromeKMP();
        String s = "ababdabcabababd";
        int[] data = shortestPalindrome.buildPrefixTable(s);

        for(int i=0; i<data.length; i++) {
            System.out.println(i + "\t" + s.charAt(i) + " = " + data[i]);
        }

        ShortestPalindromeKMP shortestPalindromeKMP = new ShortestPalindromeKMP();
        System.out.println(shortestPalindromeKMP.shortestPalindrome("abcdc"));

    }

    /**
     * The prefix function or partial match table is an array where each element at index i
     * indicates the length of the longest prefix of the substring ending at i which is also a suffix.
     * This helps us identify the longest segment where the prefix of the original string matches a
     * suffix in the reversed string. The purpose is to identify how much of the original string matches
     * a suffix of the reversed string.
     *
     * @param s
     * @return
     */

    public String shortestPalindrome(String s) {

        // Intuition
        //   ___ bab cab -> Fill in the blanks.
        // bab is largest palindrome, rest needs to be reversed thats it.
        // Brute Force -> O(n^2)
        // Space.      -> O(n)

        // Can be improved by two pointer approach
        // left and right
        // b a b c b c -> c b c b a b
        // left    right
        // b       c
        // b       b    -> 1 (match in between)
        // a       c
        // a       b
        // a       a    -> 2 (match)
        // b       b    -> 3 (match)
        // Left = 3
        // If Left is N-1, then no need to add anything.
        // reverseSuffix + recurse(0,left) + nonPalindromicSuffix (i.e after left part)

        // Can be further improved by creating a prefix table.


        // Find longest palindrome in the string by
        // doing a prefix and suffix search

        //              a b c b a
        // Reverse      a b c b a

        //            b a b c a b -> bac bab cab
        // Reverse    b a c b a b -> bac bab cab

        //            abcabcbacc -> ccabcbacb a bcabcbacc
        // Reverse.   ccabcbacba

        String reversedString = new StringBuilder(s).reverse().toString();
        String combinedString = s + "#" + reversedString;

        int[] prefixTable = buildPrefixTable(combinedString);

        for (int i = 0; i < prefixTable.length; i++) {
            System.out.println("i = " + i + "\t=" + prefixTable[i]);
        }

        int palindromeLength = prefixTable[combinedString.length() - 1];
        StringBuilder suffix = new StringBuilder(
                s.substring(palindromeLength)
        ).reverse();
        return suffix.append(s).toString();
    }

    private int[] buildPrefixTable(String s) {
        int[] prefixTable = new int[s.length()];
        int length = 0;
        for (int i = 1; i < s.length(); i++) {
            System.out.println();
            while (length > 0 && s.charAt(i) != s.charAt(length)) {
                System.out.print("length=" + length + "\tCurrent=" + i
                        + "\ncharlen=" + s.charAt(length) + "\tcharCurrent=" + s.charAt(i));

                length = prefixTable[length - 1];

                System.out.print(" After length = " + length + "====================>>>>");
            }
            if (s.charAt(i) == s.charAt(length)) {
                length++;
            }
            prefixTable[i] = length;
        }
        return prefixTable;
    }
}
