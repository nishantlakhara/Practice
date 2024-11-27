package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter1 {

    private Queue<Long> q;

    public HitCounter1(Queue<Long> q) {
        this.q = q;
    }

    public void hit(Long timestamp) {
        q.offer(timestamp);
    }

    public int getHits(Long timestamp) {
        // Last 5 minutes hits.
        // say timestamp = 305, so timestamp till 6 to 305 are hits in queue.
        while(!q.isEmpty()) {
            // 305 - 302 < 300 -> break
            // 605 - 302 >= 300 -> remove from queue
            // 295 - 302 < 300 -> break
            if(timestamp - q.peek() >= 300) {
                q.poll();
            } else {
                break;
            }
        }

        System.out.println("hits at " + timestamp + " = " + q.size());
        return q.size();
    }

    public static void main(String[] args) {
        HitCounter1 hitCounter = new HitCounter1(new LinkedList<>());

        hitCounter.hit(1l);
        hitCounter.hit(2l);
        hitCounter.hit(2l);
        hitCounter.getHits(3l);


        hitCounter.hit(300l);
        hitCounter.hit(305l);
        hitCounter.getHits(305l);

        hitCounter.hit(605l);
        hitCounter.hit(750l);
        hitCounter.hit(905l);
        hitCounter.getHits(906l);

    }


}
