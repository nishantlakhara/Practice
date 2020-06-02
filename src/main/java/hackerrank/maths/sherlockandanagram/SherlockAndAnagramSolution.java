package hackerrank.maths.sherlockandanagram;

import java.util.HashMap;
import java.util.Map;

class SherlockAndAnagramSolution
{
    public static void RunSampleTestcase()
    {
        Map<String, Integer> hashedAnagramsDictionary = ConstructHashedAnagramsDictionary("abba");

        int pairs = CalculatePairs(hashedAnagramsDictionary);

        assert(pairs == 4);
    }

    public static void main(String[] args)
    {
        //var queries = int.Parse(Console.ReadLine());
        String[] strArr = new String[] {"abba", "abcd", "kkkkk"};

        for (String input: strArr)
        {

            Map<String, Integer>  hashedAnagramsDictionary = ConstructHashedAnagramsDictionary(input);

            int pairs = CalculatePairs(hashedAnagramsDictionary);

            System.out.println("String == " + input + ",Pairs ==" + pairs);
        }
    }

    /*
     * Prepare fequence table for N substring which starts from index 0
     * Do not need include all other substrings as we know there are total O(N*N) substrings.
     *
     * Work on one small test case:
     * "abcd"
     * so the frequency table for substrings, all starts from index = 0:
     * a
     * ab
     * abc
     * abcd
     * Only for those 4 substrings, not all of them.
     *
     * Time complexity:  O(N * N)
     * Space complexity: O(26*N), N is the string's length
     */
    public static int[][] PrepareFequencyTableForOnlyNSubstring(String input)
    {
        if (input == null || input.length() == 0)
        {
            return null;
        }

        int length = input.length();
        int[][] frequencyTables = new int[length][];

        for (int i = 0; i < length; i++)
        {
            frequencyTables[i] = new int[26];
        }

        for (int start = 0; start < length; start++) // go over the string once from the beginning
        {
            char current = input.charAt(start);
            int charIndex = current - 'a';

            for (int index = start; index < length; index++)
            {
                frequencyTables[index][charIndex]++;
            }
        }

        return frequencyTables;
    }

    /*
     * What should be taken cared of in the design?
     * Time complexity: O(26 * N * N), N is the string length.
     *
     *
     * I think that it is same idea as Leetcode 238 Product of array except itself. We
     * take advantage of alphabetic size is limited and constant, 26 chars, and then work
     * with substring (denote Si) starting from 0 to i, 0 < i < n ( n is string's length)
     * to calculate frequency table, and any substring starting from i and ending j can be
     * Sj's frequency table - Si's frequency table for those 26 alphabetic numbers.
     * So, the preprocessed frequency table size is O(N) ( N is the length of string)
     * instead of O(N^2) based on each of substrings. For any of substrings, there are only 26
     * calculation to compute for each alphabet number, so the time complexity goes
     * to O(26N^2) = O(n^2)
     *
     * Update hashed anagram counting dictionary - a statistics, basically
     * tell the fact like this:
     * For example, test case string abba,
     * substring ab -> hashed key a1b1, value is 2, because there are
     * two substrings: "ab","ba" having hashed key: "a1b1"
     * Here are all possible hashed keys:
     * a1   - a, a,
     * b1   - b, b
     * a1b1 - ab, ba
     * b2   - bb
     * a1b2 - abb, bba
     * a2b2 - abba
     *
     * Time complexity is O(N^2), not O(N^3).
     */
    public static Map<String, Integer> ConstructHashedAnagramsDictionary(String input)
    {
        Map<String, Integer> hashedAnagramsDictionary = new HashMap<>();

        int length = input.length();

        // frequency table memo is using time O(N * N)
        int[][] fequencyTableMemo = PrepareFequencyTableForOnlyNSubstring(input);

        for (int start = 0; start < length; start++)
        {
            for (int substringLength = 1; start + substringLength <= length; substringLength++)
            {
                int[] frequencyData = CalculateSubstringFequencyDiff(fequencyTableMemo, start, substringLength);

                String key = HashedAnagramString.GetHashedAnagram(frequencyData);

                // At most there are O(N*N) entry in the dictionary, go over once
                if (hashedAnagramsDictionary.containsKey(key))
                {
                    hashedAnagramsDictionary.put(key, hashedAnagramsDictionary.get(key) + 1);
                }
                else
                {
                    hashedAnagramsDictionary.put(key, 1);
                }
            }
        }

        return hashedAnagramsDictionary;
    }

    /*
     *
     * @start - substring' start position in the original string
     * @length - substring's length
     * Just a simple minus calculation for each alphabet number.
     */
    public static int[] CalculateSubstringFequencyDiff(int[][] fequencyTableMemo, int start, int length)
    {
    final int size = 26;
        int[] difference = new int[size];

        for (int i = 0; i < size; i++)
        {
            difference[i] = fequencyTableMemo[start + length - 1][i];
            if (start > 0)
            {
                difference[i] -= fequencyTableMemo[start-1][i];
            }
        }

        return difference;
    }

    /*
     * The formula to calculate pairs
     * For example, test case string abba,
     * substring ab -> hashed key a1b1, value is 2, because there are two substrings: "ab","ba" having hashed key: "a1b1"
     * Here are all possible hashed keys:
     * a1   - a, a,
     * b1   - b, b
     * a1b1 - ab, ba
     * b2   - bb
     * a1b2 - abb, bba
     * a2b2 - abba
     * So, how many pairs?
     * should be 4, from 4 hashed keys: a1, b1, a1b1 and a2b2
     */
    public static int CalculatePairs(Map<String, Integer> hashedAnagrams)
    {
        // get pairs
        int anagrammaticPairs = 0;

        for (int count : hashedAnagrams.values())
        {
            anagrammaticPairs += count * (count - 1) / 2;
        }

        return anagrammaticPairs;
    }
}

