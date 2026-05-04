package interviews.micro1;

import java.util.*;

public class Playlist {

    static Map<String, Pair> memo = new HashMap<>();

    public static void main(String[] args) {

        Integer[] arr = {120, 200, 360, 140, 80};
        int max = 500;

        Arrays.sort(arr, Collections.reverseOrder());

        Pair res = dfs(arr, max, 0, 0);
        System.out.println(res.list + "\t" + res.sum);
    }

    public static Pair dfs(Integer[] arr, int max, int idx, int currSum) {

        if (idx == arr.length) {
            return new Pair(new ArrayList<>(), currSum);
        }

        String key = idx + "-" + currSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // skip
        Pair skip = dfs(arr, max, idx + 1, currSum);

        // take
        Pair take = new Pair(new ArrayList<>(), 0);
        if (currSum + arr[idx] <= max) {
            Pair next = dfs(arr, max, idx + 1, currSum + arr[idx]);
            take = new Pair(new ArrayList<>(next.list), next.sum);
            take.list.add(0, arr[idx]); // add current at front
        }

        Pair best = better(skip, take);
        memo.put(key, best);
        return best;
    }

    private static Pair better(Pair p1, Pair p2) {
        if (p1.sum > p2.sum) return p1;
        if (p2.sum > p1.sum) return p2;

        return (p1.list.size() <= p2.list.size()) ? p1 : p2;
    }

    static class Pair {
        List<Integer> list;
        int sum;

        public Pair(List<Integer> list, int sum) {
            this.list = list;
            this.sum = sum;
        }
    }
}