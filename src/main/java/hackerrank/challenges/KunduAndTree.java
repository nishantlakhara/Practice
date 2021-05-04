//package hackerrank.challenges;
//
//import java.util.*;
//
//public class KunduAndTree {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
////        Edge[] edges = new Edge[size - 1];
//        List<Integer>[] tree = new List[size];
//        for(int i=0; i<size; i++) {
//            tree[i] = new ArrayList<>();
//        }
//
////        HashMap<Integer, Integer> edgeMap = new HashMap<>();
//
//        for (int i = 0; i < size - 1; i++) {
//            //String[] split = sc.next().trim().split("\\s+");
////            Edge edge = new Edge(Integer.parseInt(sc.next().trim())-1, Integer.parseInt(sc.next().trim())-1, sc.next().trim().charAt(0));
////            edges[i] = edge;
//            int from = Integer.parseInt(sc.next().trim())-1;
//            int to = Integer.parseInt(sc.next().trim())-1;
//            char color = sc.next().trim().charAt(0);
//
//            if(color == 'b') {
//                tree[from] =
//            }
//
//        }
//
//        List<Integer> groups = createGroups(new HashSet<>(), edges);
//        System.out.println(groups);
//    }
//
//    private static List<Integer> createGroups(Set<Integer> visited, Edge[] edges) {
//        List<Integer> groups = new ArrayList<>();
//        for(int i = 0; i<edges.length; i++) {
//            if(!visited.contains(i)) {
//                if (edges[i].getColor() == 'r') {
//
//                    visited.add(i);
//                    groups.add(1);
//                } else if(edges[i].getColor() == 'b') {
//                    int groupCount = 1 + createGroup(visited, edges[i], edges);
//                    groups.add(groupCount);
//                }
//            }
//        }
//        return groups;
//    }
//
//    private static int createGroup(Set<Integer> visited, Edge edge, Edge[] edges) {
//        if(edge.getColor() == 'r') {
//            return 0;
//        } else {
//            if(edge.getTo() < edges.length) {
//                if(edges[edge.getTo()].getColor() != 'r') {
//                    visited.add(edge.getTo());
//                }
//                return 1 + createGroup(visited, edges[edge.getTo()], edges);
//            } else {
//                return 1;
//            }
//        }
//    }
//
//    static class Edge {
//        int from;
//        int to;
//        char color;
//
//        public Edge(int from, int to, char color) {
//            this.from = from;
//            this.to = to;
//            this.color = color;
//        }
//
//        public int getFrom() {
//            return from;
//        }
//
//        public void setFrom(int from) {
//            this.from = from;
//        }
//
//        public int getTo() {
//            return to;
//        }
//
//        public void setTo(int to) {
//            this.to = to;
//        }
//
//        public char getColor() {
//            return color;
//        }
//
//        public void setColor(char color) {
//            this.color = color;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Edge edge = (Edge) o;
//            return from == edge.from &&
//                    to == edge.to &&
//                    color == edge.color;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(from, to, color);
//        }
//
//        @Override
//        public String toString() {
//            return "Edge{" +
//                    "from=" + from +
//                    ", to=" + to +
//                    ", color=" + color +
//                    '}';
//        }
//    }
//}
