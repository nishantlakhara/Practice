package permutecombine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationString {
    public static List<String> combine(String instr, StringBuffer outstr, int index, List<String> combinations)
    {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            combinations.add(outstr.toString());
            combine(instr, outstr, i + 1, combinations);
            outstr.deleteCharAt(outstr.length() - 1);
        }
        return combinations;
    }

    public static Set<String> combineWithoutRepetition(String instr, StringBuffer outstr, int index, Set<String> combinations)
    {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            combinations.add(outstr.toString());
            combineWithoutRepetition(instr, outstr, i + 1, combinations);
            outstr.deleteCharAt(outstr.length() - 1);
        }
        return combinations;
    }

    public static void main(String[] args) {
        String abc = "abc";
        List<String> combinations = combine(abc, new StringBuffer(), 0, new ArrayList<>());
        System.out.println("Combinations of string " + abc + " has total " + combinations.size() + " combinations. \nCombinations are = "+ combinations);

        String abcd = "abcd";
        List<String> combinations1 = combine(abcd, new StringBuffer(), 0, new ArrayList<>());
        System.out.println("Combinations of string " + abcd + " has total " + combinations1.size() + " combinations. \nCombinations are = "+ combinations1);

        String abacbd = "abacbd";
        List<String> combinations2 = combine(abacbd, new StringBuffer(), 0, new ArrayList<>());
        System.out.println("Combinations of string " + abacbd + " has total " + combinations2.size() + " combinations. \nCombinations are = "+ combinations2);


        Set<String> combinations4 = combineWithoutRepetition(abc, new StringBuffer(), 0, new HashSet<>());
        System.out.println("Combinations of string " + abc + " has total " + combinations4.size() + " combinations. \nCombinations are = "+ combinations4);

        Set<String> combinations5 = combineWithoutRepetition(abcd, new StringBuffer(), 0, new HashSet<>());
        System.out.println("Combinations of string " + abcd + " has total " + combinations5.size() + " combinations. \nCombinations are = "+ combinations5);

        Set<String> combinations6 = combineWithoutRepetition(abacbd, new StringBuffer(), 0, new HashSet<>());
        System.out.println("Combinations of string " + abacbd + " has total " + combinations6.size() + " combinations. \nCombinations are = "+ combinations6);
    }
}
