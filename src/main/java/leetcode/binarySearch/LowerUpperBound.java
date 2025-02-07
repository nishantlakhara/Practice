package leetcode.binarySearch;

public class LowerUpperBound {

    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10};
        int target = 6;

        lowAndUpperBound(arr, target);
        lowAndUpperBound(arr, 7);
        lowAndUpperBound(arr, 8);
    }

    private static void lowAndUpperBound(int[] arr, int target) {
        int left = findLowerBound(arr, 0, arr.length-1, target);
        int right = findUpperBound(arr, 0, arr.length-1, target);

        System.out.println("Left = " + left + "\tRight = " + right);
    }

    private static int findUpperBound(int[] arr, int left, int right, int target) {
        while(left < right) {
            int mid = left + (right - left)/2;
//            System.out.println(arr[mid]);
            if(arr[mid] <= target) {    // Exclude mid, because arr[mid] is <= target
                left = mid + 1;
            } else {
                right = mid;            // Search the left half (including mid)
            }
        }

        return left;
    }

    private static int findLowerBound(int[] arr, int left, int right, int target) {

        while(left < right) {
            int mid = left + (right - left)/2;
//            System.out.println("mid = " + mid + "\tval=" + arr[mid]);

            if(arr[mid] < target) {         // Exclude mid, because arr[mid] is strictly less than target
                left = mid + 1;
            } else {
                right = mid;                // Search the left half (including mid)
            }
        }

        return left;
    }
}
