package dynamicprogramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KnapSackProblemBruteForce {
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120, 170, 250, 50, 70};
        int wt[] = new int[]{10, 20, 30, 40, 50, 10, 15};
        int  W = 100;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(knapSack(W, wt, val, n, new ArrayList<Integer>()));
        System.out.println(finalList);
    }

    private static List<Integer> finalList = new ArrayList<>();
    private static int max = 0;

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        //Base cases
        if(n == 0 || w == 0) {
            return 0;
        }

        //Exclude and move to next element if the weight of current element is greater than w
        if(wt[n-1] > w) {
            return knapSack(w, wt, val, n-1);
        }

        //Include the knapsack
        int include = val[n-1] + knapSack(w-wt[n-1], wt, val, n-1);

        //Exclude the knapsack
        int exclude = knapSack(w, wt, val, n-1);

        return Math.max(include, exclude);
    }

    private static int knapSack(int w, int[] wt, int[] val, int n, List<Integer> list) {
        //Base cases
        if(n == 0 || w == 0) {
            //System.out.println(list);
            int max1 = list.stream().mapToInt(Integer::intValue).sum();
            if(max1 > max) {
                max = max1;
                finalList.clear();
                finalList.addAll(list);
            }
            return 0;
        }

        List<Integer> list1 = new ArrayList<>(list);

        //Exclude and move to next element if the weight of current element is greater than w
        if(wt[n-1] > w) {
            return knapSack(w, wt, val, n-1, list1);
        }

        //Include the knapsack
        List<Integer> list2 = new ArrayList<>(list);
        list2.add(val[n-1]);
        int include = val[n-1] + knapSack(w-wt[n-1], wt, val, n-1, list2);

        //Exclude the knapsack
        List<Integer> list3 = new ArrayList<>(list);
        int exclude = knapSack(w, wt, val, n-1, list3);

        return Math.max(include, exclude);
    }
}
