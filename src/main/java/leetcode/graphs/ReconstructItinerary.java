package leetcode.graphs;

import java.util.*;

public class  ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "JFK"));
        tickets.add(Arrays.asList("ATL", "CBT"));

        List<String> itinerary = ri.findItinerary(tickets);
        System.out.println(itinerary);
    }

    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets) {
            if(!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<String>());
            }
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }

    public void dfs(String s) {
        PriorityQueue<String> q = map.get(s);

        while(q != null && !q.isEmpty()) {
            String node = q.poll();
            dfs(node);
        }

        res.addFirst(s);
    }
}
