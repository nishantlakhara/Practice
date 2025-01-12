package leetcode.monotonicstack.google;

import java.util.Arrays;
import java.util.Stack;

public class OddEvenJumps {

    public int oddEvenJumps(int[] A) {
        int N = A.length;

        // Build the B array sorted by values of A for odd jumps
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            B[i] = i;
        }
        Arrays.sort(B, (i, j) -> Integer.compare(A[i], A[j]));

        // Find next valid odd jumps
        int[] oddNext = make(A, B);

        // Sort by A[i] in descending order for even jumps
        Arrays.sort(B, (i, j) -> Integer.compare(A[j], A[i]));

        // Find next valid even jumps
        int[] evenNext = make(A, B);

        // Arrays to store whether we can reach the end starting from position i using odd/even jumps
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];

        // Last position can always reach the end
        odd[N - 1] = even[N - 1] = true;

        // Process from second last element to the first element
        for (int i = N - 2; i >= 0; i--) {
            if (oddNext[i] != -1) {
                odd[i] = even[oddNext[i]];  // Can jump to the next odd position
            }
            if (evenNext[i] != -1) {
                even[i] = odd[evenNext[i]];  // Can jump to the next even position
            }
        }

        // Return the number of positions from which we can reach the end using odd jumps
        int result = 0;
        for (boolean b : odd) {
            if (b) result++;
        }
        return result;
    }

    // Helper method to compute next valid jump index for each position
    private int[] make(int[] A, Integer[] B) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);  // Initialize with -1 (meaning no valid jump)
        Stack<Integer> stack = new Stack<>();  // This will hold indices in decreasing order of A

        for (int i : B) {
            // Pop elements from the stack where A[i] > A[stack.peek()]
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }
}
