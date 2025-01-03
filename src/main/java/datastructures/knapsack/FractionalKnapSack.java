package datastructures.knapsack;

import java.lang.*;
import java.util.Arrays;
import java.util.Comparator;

// Greedy approach
public class FractionalKnapSack {

    // Function to get maximum value
    private static double getMaxValue(ItemValue[] arr,
                                      int capacity)
    {
        // 1. Descending comparator with profit/weight ratios.
        Comparator<ItemValue> comparator = (item1, item2) ->
                Double.compare((double)item2.profit/(double)item2.weight, (double)item1.profit/item1.weight);
        Arrays.sort(arr, comparator);

        double totalValue = 0d;

        // 2. Iterate through each item.
        for (ItemValue i : arr) {
            int curWt = i.weight;
            int curVal = i.profit;

            if (capacity - curWt >= 0) {
                // This weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
                double fraction = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                break;
            }
        }
        return totalValue;
    }

    // Item value class
    static class ItemValue {

        int profit, weight;

        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.profit = val;
        }
    }

    // Driver code
    public static void main(String[] args)
    {

        ItemValue[] arr = { new ItemValue(120, 30),
                new ItemValue(100, 20),
                new ItemValue(60, 10) };

        int capacity = 50;

        double maxValue = getMaxValue(arr, capacity);

        // Function call
        System.out.println(maxValue);
    }
}
