package design.atlassian;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Long, Integer> timeMap = new HashMap<>();
    int rateLimit = 5;

    private boolean rateLimit(int userId) {
        // Check count of requests in last minute.
        long currentTs = System.currentTimeMillis();
        long nearMs = getFloor(currentTs);
        System.out.println("currentTs = " + currentTs + "\tnearMs = " + nearMs);

        // count in map
        if(!timeMap.containsKey(nearMs)) {
            timeMap.put(nearMs, 0);
        }
        timeMap.put(nearMs, timeMap.get(nearMs) + 1);
        if(timeMap.get(nearMs) > 5) {
            return false;
        }

        return true;
    }

    private long getFloor(long currentTs) {
        long floor = currentTs/1000;
        floor = floor * 1000;
//        System.out.println(floor);
        return floor;
    }


    public static void main(String[] args) throws InterruptedException {

        RateLimiter ratelimiter = new RateLimiter();
        System.out.println(ratelimiter.rateLimit(1));
        System.out.println(ratelimiter.rateLimit(1));
        System.out.println(ratelimiter.rateLimit(1));
        System.out.println(ratelimiter.rateLimit(1));
        System.out.println(ratelimiter.rateLimit(1));
        System.out.println(ratelimiter.rateLimit(1));
        System.out.println(ratelimiter.rateLimit(1));

        Thread.sleep(1000);

        System.out.println(ratelimiter.rateLimit(1));
    }

}
