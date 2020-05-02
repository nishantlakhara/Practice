package dynamicprogramming;

import java8.Timing;

import java.util.ArrayList;

public class KnapSackProblemDP {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int val[] = new int[]{60, 100, 120, 170, 250, 50, 70};
        int wt[] = new int[]{10, 20, 30, 40, 50, 10, 15};
        int W = 100;
        int n = val.length;

        int[][] mem = new int[W+1][n+1];
        for(int i=0; i<=W; i++)  {
            for(int j=0; j<=n; j++) {
                mem[i][j] = -1;
            }
        }
        //Expected 480 with below set
        //int val[] = new int[]{60, 100, 120, 170, 250, 50, 70};
        //int wt[] = new int[]{10, 20, 30, 40, 50, 10, 15};
        //System.out.println(knapSack(W, wt, val, n));
        //System.out.println(knapSackMemoized(W, wt, val, n, mem));

        Timing.timed(() -> knapSack(W, wt, val, n), System.out::println);
        Timing.timed(() -> knapSackMemoized(W, wt, val, n, mem), System.out::println);

    }

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

    private static int knapSackMemoized(int w, int[] wt, int[] val, int n, int[][] mem) {
        if(mem[w][n] != -1) {
            return mem[w][n];
        }

        //Base cases
        if (n == 0 || w == 0) {
            return 0;
        }

        //Exclude and move to next element if the weight of current element is greater than w
        if (wt[n - 1] > w) {
            return knapSackMemoized(w, wt, val, n - 1, mem);
        }

        //Include the knapsack
        int include = val[n - 1] + knapSackMemoized(w - wt[n - 1], wt, val, n - 1, mem);

        //Exclude the knapsack
        int exclude = knapSackMemoized(w, wt, val, n - 1, mem);

        mem[w][n] = Math.max(include, exclude);
        return mem[w][n];
    }
}