package leetcode.knapsack;

public class FitInBuckets {
    public static void main(String[] args) {
        int[] arr = new int[] {8,8,8,8,8};
        // 2,1,2,5, 4,4,2, 5,3, 5,5  3,7
        int packets = 4;
        int weight = 10;

        int total = 0;
        for(int i=0; i<arr.length; i++) {
            total += arr[i];
        }
        boolean[] vis = new boolean[arr.length];

        System.out.println(dfs(arr, vis, packets, weight, total, 0, 0));
    }

    private static boolean dfs(int[] arr, boolean[] vis, int packets, int weight, int total, int sum, int localTotal) {
        System.out.println("localTotal = " + localTotal + ",total = " + total + "" +
                "sum = " + sum + ", packets = " + packets);

        if(packets * weight < total - localTotal) {
            System.out.println("return");
            return false;
        }

        if(packets == 0) {
            if(total == localTotal) {
                return true;
            }
            return false;
        }

        if(sum == weight) {
            packets--;
            sum = 0;

            if(packets == 1) {
                int s = 0;
                for(int i=0; i<arr.length; i++) {
                    if(!vis[i]) {
                        s += arr[i];
                        if(s > weight) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(!vis[i] && sum + arr[i] <= weight) {
                vis[i] = true;
                boolean b = dfs(arr, vis, packets, weight, total, sum + arr[i], localTotal + arr[i]);
                if(b) {
                    return true;
                }
                vis[i] = false;
            } else {
                if(packets - 1 >= 0) {
                    boolean b = dfs(arr, vis, packets - 1, weight, total, 0, localTotal);
                    if (b) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
