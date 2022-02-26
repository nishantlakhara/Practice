package conversion;

import java.util.*;

public class ConversionUtilities {
    public static void main(String[] args) {
        wrapperListToArrayPrimitive();

        convertCharToInt();

        convertToSet();

        // sorting primitive array int[] in descending order
        int[] squares = { 4, 25, 9, 36, 49 };
        System.out.println("int[] array before sorting : " + Arrays.toString(squares));
        System.out.println("sorting array in ascending order");
        Arrays.sort(squares);
        System.out.println("reversing array in place");
        reverse(squares);
        System.out.println("Sorted array in descending order : " + Arrays.toString(squares));

    }

    public static void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++)
        {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }


    private static void convertToSet() {
        String t = "ABC";
        convertToSet(t.toCharArray());
    }

    public static Set<Character> convertToSet(char[] charArray) {

        // Result hashset
        Set<Character> resultSet = new HashSet<Character>();

        for (int i = 0; i < charArray.length; i++) {
            resultSet.add(new Character(charArray[i]));
        }

        // Return result
        return resultSet;
    }

    private static void convertCharToInt() {
        char c = '3';
        System.out.println(c);

        int i = c - '0';
        System.out.println(i);
    }

    private static void wrapperListToArrayPrimitive() {
        //Convert list of wrapper class to array of primitive.
        List<Integer> ints = Arrays.asList(1,2,3,4);
        int[] intArray = ints.stream().mapToInt(Integer::intValue).toArray();
    }
}
