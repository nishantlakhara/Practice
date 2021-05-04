package hackerrank.challenges;

import java.util.*;

//
//test
//7
//1 2 b
//2 3 r
//3 4 r
//4 5 b
//5 6 r
//6 7 b
//20
//
//5
//1 2 b
//2 3 b
//3 4 r
//4 5 r
//3
//
//4
//1 2 r
//2 3 r
//3 4 r
//4
//
//8
//1 2 b
//2 3 b
//3 4 r
//4 5 b
//5 6 b
//6 7 b
//7 8 r
//12
//
//10
//1 2 r
//2 3 b
//3 4 b
//4 5 b
//5 6 b
//6 7 r
//7 8 r
//8 9 r
//9 10 r
//60
//
//5
//2 3 b
//4 5 r
//3 4 b
//5 1 r
//3
//
//7
//2 3 b
//4 5 r
//3 4 b
//5 1 r
//1 6 b
//6 7 r
//17
//
//8
//1 2 b
//2 3 b
//3 4 r
//4 5 b
//5 6 b
//6 7 b
//7 8 r
//
//7
//1 2 b
//2 3 r
//3 4 r
//4 5 b
//5 6 r
//6 7 b
//20

public class KunduAndTreeRejected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Edge[] edges = new Edge[size - 1];
        HashMap<Integer, Integer> edgeMap = new HashMap<>();

        for (int i = 0; i < size - 1; i++) {
            //String[] split = sc.next().trim().split("\\s+");
            Edge edge = new Edge(Integer.parseInt(sc.next().trim()), Integer.parseInt(sc.next().trim()), sc.next().trim().charAt(0));
            edges[i] = edge;
        }



        int start = 0;
        int edgesSize = edges.length;
        for (int i = 0; i < edgesSize; i++) {
            while (i < edgesSize && edges[i].getColor() != 'r') {
                i++;
            }
            if (i >= size - 1) {
//                for(int k=start; k < edgesSize; k++) {
//                    edgeMap.putIfAbsent(edges[k].getFrom(), new ArrayList<>());
//                    edgeMap.get(edges[k].getFrom()).add(null);
//                }
                break;
            } else {
                //edgeMap.put(edges[i].getFrom(), new ArrayList<>());
                for (int k = start; k <= i; k++) {
                    edgeMap.put(edges[k].getFrom(), edges[i].getTo());
                }
            }
            start = i+1;
        }
        
        //display(edgeMap);

        System.out.println(caculateCount(edges, edgeMap));
    }

    private static int caculateCount(Edge[] edges, HashMap<Integer, Integer> edgeMap) {
        //Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0;
        for (int i=0; i<edges.length-1; i++) {
            int from = edges[i].getFrom();
            if(edgeMap.get(from) != null) {
                Integer next = edgeMap.get(from);
                for (int j = next; j <= edges.length; j++) {
                    if (edgeMap.get(j) != null) {
                        int to = edgeMap.get(j);
                        int diff = edges.length - to + 2;
                        sum += diff;
                    }
                }
            }
        }
        return sum;
    }

    private static void display(HashMap<Integer, Integer> edgeMap) {
        System.out.println(edgeMap);
    }

    static class Edge {
        int from;
        int to;
        char color;

        public Edge(int from, int to, char color) {
            this.from = from;
            this.to = to;
            this.color = color;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public char getColor() {
            return color;
        }

        public void setColor(char color) {
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return from == edge.from &&
                    to == edge.to &&
                    color == edge.color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, color);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", color=" + color +
                    '}';
        }
    }
}
