package leetcode.monotonicstack.google;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/odd-even-jump/editorial/
 *
 * https://www.youtube.com/watch?v=oH7g5GLHWeU
 *
 * https://www.youtube.com/watch?v=BZGarmxTa-E
 *
 * Approach 1: Monotonic Stack
 * Intuition
 *
 * First, we notice that where you jump to is determined only by the state of your current index and the jump number parity.
 *
 * For each state, there is exactly one state you could jump to (or you can't jump.) If we somehow knew these jumps, we could solve the problem by a simple traversal.
 *
 * So the problem reduces to solving this question: for some index i during an odd numbered jump, what index do we jump to (if any)? The question for even-numbered jumps is similar.
 *
 * Algorithm
 *
 * Let's figure out where index i jumps to, assuming this is an odd-numbered jump.
 *
 * Let's consider each value of A in order from smallest to largest. When we consider a value A[j] = v, we search the values we have already processed (which are <= v) from largest to smallest. If we find that we have already processed some value v0 = A[i] with i < j, then we know i jumps to j.
 *
 * Naively this is a little slow, but we can speed this up with a common trick for harder problems: a monotonic stack. (For another example of this technique, please see the solution to this problem: (Article - Sum of Subarray Minimums))
 *
 * Let's store the indices i of the processed values v0 = A[i] in a stack, and maintain the invariant that this is monotone decreasing. When we add a new index j, we pop all the smaller indices i < j from the stack, which all jump to j.
 *
 * Afterwards, we know oddnext[i], the index where i jumps to if this is an odd numbered jump. Similarly, we know evennext[i]. We can use this information to quickly build out all reachable states using dynamic programming.
 *
 *
 * Complexity Analysis
 *
 * Time Complexity: O(NlogN), where N is the length of A.
 *
 * Space Complexity: O(N).
 *
 *
 *
 * Approach 2: Tree Map
 * Intuition
 *
 * As in Approach 1, the problem reduces to solving this question: for some index i during an odd numbered jump, what index do we jump to (if any)?
 *
 * Algorithm
 *
 * We can use a TreeMap, which is an excellent structure for maintaining sorted data. Our map vals will map values v = A[i] to indices i.
 *
 * Iterating from i = N-2 to i = 0, we have some value v = A[i] and we want to know what the next largest or next smallest value is. The TreeMap.lowerKey and TreeMap.higherKey functions do this for us.
 *
 * With this in mind, the rest of the solution is straightforward: we use dynamic programming to maintain odd[i] and even[i]: whether the state of being at index i on an odd or even numbered jump is possible to reach.
 *
 *
 * Complexity Analysis
 *
 * Time Complexity: O(NlogN), where N is the length of A.
 *
 * Space Complexity: O(N).
 */
public class OddEvenJumpsTreeMap {
    public int oddEvenJumps(int[] arr) {
        int N = arr.length;
        if(N <= 1) {
            return N;
        }

        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = true;
        even[N-1] = true;

        // Value to Index map.
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        tMap.put(arr[N-1], N-1);

        for(int i=N-2; i>=0; i--) {
            int val = arr[i];

            if(tMap.containsKey(val)) {
                odd[i] = even[tMap.get(val)];
                even[i] = odd[tMap.get(val)];
            } else {
                Integer lower = tMap.lowerKey(val);
                Integer higher = tMap.higherKey(val);

                if(lower != null) {
                    even[i] = odd[tMap.get(lower)];
                }
                if(higher != null) {
                    odd[i] = even[tMap.get(higher)];
                }
            }

            tMap.put(val, i);
        }

        int res = 0;
        for(boolean b: odd) {
            if(b) res++;
        }
        return res;
    }
}
