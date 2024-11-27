package leetcode;

public class HitCounterMostOptimised {

    int[] times = new int[300];
    int[] hits = new int[300];

    /** Record a hit.
     @param timestamp - The current timestamp
     (in seconds granularity). */
    void hit(int timestamp)
    {
        int idx = timestamp % 300;
        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            hits[idx] = 1;
        }
        else {
            ++hits[idx];
        }
    }

// Time Complexity : O(1)

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in
     seconds granularity). */
    int getHits(int timestamp)
    {
        int res = 0;
        for (int i = 0; i < 300; ++i) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HitCounterMostOptimised counter = new HitCounterMostOptimised();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        int hits1 = counter.getHits(4); // should return 3
        counter.hit(300);
        int hits2 = counter.getHits(300); // should return 4
        int hits3 = counter.getHits(301); // should return 3
        System.out.println(hits1);
        System.out.println(hits2);
        System.out.println(hits3);

        System.out.println(counter.getHits(302));
        System.out.println(counter.getHits(303));
        System.out.println(counter.getHits(304));
        System.out.println(counter.getHits(599));
        System.out.println(counter.getHits(600));
    }
}
