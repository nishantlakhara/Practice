package leetcode.knapsack;

import java.util.Arrays;

public class PacketPacking {

    // Helper function to try placing the items into packets recursively
    public static boolean canPackRecursive(int[] arr, int n, int packets, int maxWeight, int[] packetWeights) {
        print(arr, n, packets, packetWeights);
        // Base case: If we've placed all items, return true
        if (n == arr.length) {
            return true;
        }

        // Try to place the current item (arr[n]) into any of the packets
        for (int i = 0; i < packets; i++) {
            // Check if the item fits in this packet
            if (packetWeights[i] + arr[n] <= maxWeight) {
                // Place the item in the packet
                packetWeights[i] += arr[n];

                // Recursively attempt to place the next item
                if (canPackRecursive(arr, n + 1, packets, maxWeight, packetWeights)) {
                    return true;  // If placing the next item worked, return true
                }

                // Backtrack: Remove the item from this packet
                packetWeights[i] -= arr[n];
            }

            // Optimization: If the packet is empty and it couldn't fit the current item,
            // no need to try further empty packets.
            if (packetWeights[i] == 0) {
                break;
            }
        }

        // If we couldn't place the current item in any packet, return false
        return false;
    }

    private static void print(int[] arr, int n, int packets, int[] packetWeights) {
        if(n < arr.length) {
            System.out.println(arr[n] + "\t");
            for(int i: packetWeights) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    // Main function to start the recursive packing process
    public static boolean canPackItems(int[] arr, int packets, int maxWeight) {
        // Sort the items in descending order to try larger items first (greedy)
        sortDescending(arr);

        // Array to store the current weight of each packet
        int[] packetWeights = new int[packets];

        // Start the recursion with the first item (index 0)
        return canPackRecursive(arr, 0, packets, maxWeight, packetWeights);
    }

    private static void sortDescending(int[] arr) {
        Arrays.sort(arr);

        int l = arr.length - 1;
        for(int i = 0; i< arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[l];
            arr[l] = temp;
            l--;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {3, 8, 5, 7, 6};          // False output data
        int[] arr = {2, 8, 5, 5, 6, 4};
        int packets = 3;
        int maxWeight = 10;

        if (canPackItems(arr, packets, maxWeight)) {
            System.out.println("Items can be packed into " + packets + " packets.");
        } else {
            System.out.println("Items cannot be packed into " + packets + " packets.");
        }
    }
}
