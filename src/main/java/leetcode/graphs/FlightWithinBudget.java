package leetcode.graphs;

import java.util.*;

public class FlightWithinBudget {

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("SIN", "BLR", 50));
        flights.add(new Flight("BLR", "DEL", 150));
        flights.add(new Flight("DEL", "PUNE", 5));
        flights.add(new Flight("BLR", "MUM", 5));
        flights.add(new Flight("MUM", "HYD", 5));
        flights.add(new Flight("HYD", "DEL", 111));
        flights.add(new Flight("SIN", "CHN", 75));
        flights.add(new Flight("CHN", "DEL", 120));

        Set<String> destInBudget = getDestinationsWithinBudgetBFS("SIN", flights, 171);
        System.out.println(destInBudget);

        Set<String> destInBudgetDfs = getDestinationsWithinBudgetDFS("SIN", flights, 171);
        System.out.println(destInBudgetDfs);
    }

    private static Set<String> getDestinationsWithinBudgetDFS(String source, List<Flight> flights, int budget) {
        Set<String> des = new HashSet<>();

        Map<String, List<Flight>> map = new HashMap<>();
        for(Flight flight: flights) {
            map.putIfAbsent(flight.getSrc(), new ArrayList<>());
            map.get(flight.getSrc()).add(flight);
        }

        dfs(source, map, budget, des, 0);

        return des;
    }

    private static void dfs(String source, Map<String, List<Flight>> map, int budget, Set<String> des, int currPrice) {
        if(currPrice <= budget && currPrice != 0) {
            des.add(source);
        }

        if(map.get(source) != null) {
            for (Flight flight : map.get(source)) {
                dfs(flight.getDest(), map, budget, des, flight.getPrice() + currPrice);
            }
        }
    }

    private static Set<String> getDestinationsWithinBudgetBFS(String src, List<Flight> flights, int budget) {
        Set<String> des = new HashSet<>();

        Map<String, List<Flight>> map = new HashMap<>();
        for(Flight flight: flights) {
            map.putIfAbsent(flight.getSrc(), new ArrayList<>());
            map.get(flight.getSrc()).add(flight);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, src));

        while(!q.isEmpty()) {
            Pair data = q.poll();
            String source = data.getSource();
            int price = data.getPrice();

            if(map.get(source) != null) {
                for (Flight flight : map.get(source)) {
                    int p = price + flight.getPrice();
                    if (p > budget) {
                        continue;
                    }
                    des.add(flight.getDest());
                    q.add(new Pair(p, flight.getDest()));
                }
            }
        }

        return des;
    }


    private static class Flight {
        private String src;
        private String dest;
        private int price;

        public Flight(String src, String dest, int price) {
            this.src = src;
            this.dest = dest;
            this.price = price;
        }

        public String getSrc() {
            return src;
        }

        public String getDest() {
            return dest;
        }

        public int getPrice() {
            return price;
        }
    }

    private static class Pair {
        private Integer price;
        private String source;

        public Pair(Integer price, String source) {
            this.price = price;
            this.source = source;
        }

        public Integer getPrice() {
            return price;
        }

        public String getSource() {
            return source;
        }
    }
}
