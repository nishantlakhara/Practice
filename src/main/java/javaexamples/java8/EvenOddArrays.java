package javaexamples.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOddArrays {

    public static void main(String[] args) {
        Object object;
        int[] arr = new int[] {1,5,6,3,2,78,43,12,11};
        System.out.println("Input: " + Arrays.toString(arr));
        // Output: [6, 2, 78, 12, 1, 5, 3, 43, 11]

        Comparator<Integer> integerComparator = (a, b) -> Integer.compare(a % 2, b % 2);

        List<Integer> res = Arrays.stream(arr)
                .boxed()  // Convert to Integer stream
                .sorted(integerComparator) // Sort evens first
                .collect(Collectors.toList());

        System.out.println(res);

        // If sorting is not required
        // Use Streams to filter evens first, then odds
        int[] result = IntStream.concat(
                Arrays.stream(arr).filter(x -> x % 2 == 0), // Even leetcode.numbers first
                Arrays.stream(arr).filter(x -> x % 2 != 0)  // Odd leetcode.numbers after
        ).toArray();  // Collect as an array

        // Output the result
        System.out.println(Arrays.toString(result));  // Output: [2, 4, 1, 3]
    }
}
