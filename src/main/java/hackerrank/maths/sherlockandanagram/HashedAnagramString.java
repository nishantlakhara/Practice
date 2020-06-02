package hackerrank.maths.sherlockandanagram;

public class HashedAnagramString
{
    /*
     * Make sure that two anagram strings will have some hashed code
     *
     * @frequencyTable - Dictionary<char, int>
     * The frequency table has to be sorted first and then construct
     * a string with each char in alphabetic numbers concatenated by
     * its occurrences.
     *
     */
    public static String GetHashedAnagram(int[] frequencyTable)
    {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 26; i++)
        {
            int value = frequencyTable[i];
            if (value > 0)
            {
                char c = (char)(i + 'a');
                key.append(c + value);
            }
        }

        return key.toString();
    }
}

