package leetcode.binarySearch;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LowerUpperBound {

    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10};
        int target = 6;

        lowAndUpperBound(arr, target);
        lowAndUpperBound(arr, 7);
        lowAndUpperBound(arr, 8);

        arr = new int[] {1,2,2,2,4,6};
        lowAndUpperBound(arr, 2);
        lowAndUpperBound(arr, 3);

        // Also call it predecessor index
        findElementGreatestOfLessThanEqualSearchValue(arr,0, arr.length-1, 2);
        findElementGreatestOfLessThanEqualSearchValue(arr,0, arr.length-1, 3);

        findElementGreatestOfLessThanSearchValue(arr,0, arr.length-1, 2);
        findElementGreatestOfLessThanSearchValue(arr,0, arr.length-1, 3);

    }

    private static void lowAndUpperBound(int[] arr, int target) {
        int left = findLowerBound(arr, 0, arr.length-1, target);
        int right = findUpperBound(arr, 0, arr.length-1, target);

        System.out.println("Left = " + left + "\tRight = " + right);
    }

    private static int findUpperBound(int[] arr, int left, int right, int target) {
        System.out.println("\nSearching upper bound " + target + " in " + commaSeparatedArray(arr));
        while(left < right) {
            /** Middle Element is the floor. Very Very Important. */
            int mid = left + (right - left)/2;
//            System.out.println(arr[mid]);
            if(arr[mid] <= target) {    // Exclude mid, because arr[mid] is <= target
                left = mid + 1;
            } else {
                right = mid;            // Search the left half (including mid)
            }
        }
        System.out.println("Upper bound = " + arr[left] + " at index " + left);
        return left;
    }

    private static int findLowerBound(int[] arr, int left, int right, int target) {
        System.out.println("\nSearching lower bound " + target + " in " + commaSeparatedArray(arr));
        while(left < right) {
            /** Middle Element is the floor. Very Very Important. */
            int mid = left + (right - left)/2;
            System.out.println("mid = " + mid + "\tval=" + arr[mid]);

            if(arr[mid] < target) {         // Exclude mid, because arr[mid] is strictly less than target
                left = mid + 1;
            } else {
                right = mid;                // Search the left half (including mid)
            }
        }

        System.out.println("Lower bound = " + arr[left] + " at index " + left);
        return left;
    }


    /**
     *
     * [1,2,2,2,4,6] -> search 2, return 2 at index 3
     *               -> search 3, return 2 at index 3
     *
     *
     *
     *          * The problem happens when only two elements remain.
     *          *
     *          * Example
     *          * left = 2
     *          * right = 3
     *          *
     *          * Your original calculation:
     *          *
     *          * mid = left + (right - left) / 2;
     *          *
     *          * gives:
     *          *
     *          * mid = 2 + (3 - 2) / 2
     *          *     = 2
     *          *
     *          * Now suppose:
     *          *
     *          * arr[2] <= target
     *          *
     *          * You do:
     *          *
     *          * left = mid;
     *          *
     *          * which means:
     *          *
     *          * left = 2
     *          * right = 3
     *          *
     *          * Nothing changed!
     *
     */
    private static int findElementGreatestOfLessThanEqualSearchValue(int[] arr, int left, int right, int target) {
        /** predecessor index */

        System.out.println("\nSearching findElementGreatestOfLessThanEqualSearchValue " + target + " in " + commaSeparatedArray(arr));
        while (left < right) {
            /** Middle Element is the ceiling. Very Very Important. */
            int mid = left + (right - left + 1) / 2;

            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("findElementGreatestOfLessThanEqualSearchvalue = " + arr[left] + " at index " + left);
        return left;
    }

    private static int findElementGreatestOfLessThanSearchValue(int[] arr, int left, int right, int target) {
        /** predecessor index */

        System.out.println("\nSearching findElementGreatestOfLessThanSearchValue " + target + " in " + commaSeparatedArray(arr));
        while (left < right) {
            /** Middle Element is the ceiling. Very Very Important. */
            int mid = left + (right - left + 1) / 2;

            if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("findElementGreatestOfLessThanSearchValue = " + arr[left] + " at index " + left);
        return left;
    }

    private static String commaSeparatedArray(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
