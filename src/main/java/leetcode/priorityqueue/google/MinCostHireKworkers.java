package leetcode.priorityqueue.google;

import java.util.*;

/**
 *
 * 857. Minimum Cost to Hire K Workers
 * Hard
 * Topics
 * Companies
 * There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.
 *
 * We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
 *
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
 * Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.
 */
public class MinCostHireKworkers {


        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;
            double totalCost = Double.MAX_VALUE;
            double currentTotalQuality = 0;
            List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();

            // Calculate wage-to-quality ratio for each worker
            for (int i = 0; i < n; i++) {
                wageToQualityRatio.add(
                        new Pair<>((double) wage[i] / quality[i], quality[i])
                );
            }

            // Sort workers based on their wage-to-quality ratio
            Collections.sort(
                    wageToQualityRatio,
                    Comparator.comparingDouble(Pair::getKey)
            );

            // Use a priority queue to keep track of the highest quality workers
            PriorityQueue<Integer> workers = new PriorityQueue<>(
                    Collections.reverseOrder()
            );

            // Iterate through workers
            for (int i = 0; i < n; i++) {
                workers.add(wageToQualityRatio.get(i).getValue());
                currentTotalQuality += wageToQualityRatio.get(i).getValue();

                // If we have more than k workers,
                // remove the one with the highest quality
                if (workers.size() > k) {
                    currentTotalQuality -= workers.poll();
                }

                // If we have exactly k workers,
                // calculate the total cost and update if it's the minimum
                if (workers.size() == k) {
                    totalCost = Math.min(
                            totalCost,
                            currentTotalQuality * wageToQualityRatio.get(i).getKey()
                    );
                }
            }
            return totalCost;
        }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

}


