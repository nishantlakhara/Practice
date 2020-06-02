package hackerrank.maths.sherlockandanagram;

public class SherlockAndAnagram {

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
    public static int[][] PrepareFequencyTableForOnlyNSubstring(char[] input)
    {
        if (input == null || input.length == 0)
        {
            return null;
        }

        int length = input.length;
        int[][] frequencyTables = new int[length][];

        for (int i = 0; i < length; i++)
        {
            frequencyTables[i] = new int[26];
        }

        for (int start = 0; start < length; start++) // go over the string once from the beginning
        {
            char current = input[start];
            int charIndex = current - 'a';

            for (int index = start; index < length; index++)
            {
                frequencyTables[index][charIndex]++;
            }
        }

        return frequencyTables;
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


}
