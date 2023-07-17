package hackerrank.graphs;

//import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NearestClone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here

        //Create undirected graphs.
        Graph graph = createUndirectedGraph(ids, graphFrom, graphTo);
        System.out.println(graph);
        //Apply brute force algorithm to find the shortest path
        int shortestPath = findShortestPath(graph, val);
        return shortestPath;
    }

    private int findShortestPath(Graph graph, int val) {
        int min = Integer.MAX_VALUE;
        for (Node node : graph.getNodeMap().values()) {
            if(val != node.getColor())
                continue;
            else {
                int count = traverse(0, new HashSet<>(), node, val);
                //System.out.println(count);
                min = Math.min(min, count);
            }
        }
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private int traverse(int count, HashSet<Integer> visitedSet, Node node, long val) {
        if(visitedSet.contains(node.getId())) {
            return count;
        }
        System.out.println(node.getId());
        visitedSet.add(node.getId());

//        if(count == 0 ) {
//            visitedSet.add(node.getId());
//        }

        int min = Integer.MAX_VALUE;
        for (Node n:node.getConnectedNodes()) {
            if(n.getColor() != val) {
                HashSet<Integer> vSet = cloneSet(visitedSet);
                //vSet.add(n.getId());
                System.out.println(vSet);
                int c = traverse(count+1, vSet, n, val);
                min = Math.min(min, c);
            } else {
                min = Math.min(count + 1, min);
                return min;
            }
        }
        return min;
    }

    private HashSet<Integer> cloneSet(HashSet<Integer> visitedSet) {
        return new HashSet<Integer>(visitedSet);
    }


    private Graph createUndirectedGraph(long[] ids, int[] graphFrom, int[] graphTo) {
        //Create a node map.
        Map<Integer, Node> nodeMap= new HashMap<>();
        for(int i=0; i<ids.length; i++) {
            Node node = new Node(i+1, ids[i]);
            nodeMap.put(i+1, node);
        }

//        Create undirected graph using the node map
        for(int i=0; i<graphFrom.length; i++) {
            Node node = nodeMap.get(graphFrom[i]);
            node.getConnectedNodes().add(nodeMap.get(graphTo[i]));

            node = nodeMap.get(graphTo[i]);
            node.getConnectedNodes().add(nodeMap.get(graphFrom[i]));
        }

        Graph graph = new Graph(nodeMap.get(0), nodeMap);
        graph.printGraph();
        return graph;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //System.out.println(System.getenv("OUTPUT_PATH"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = new NearestClone().findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    class Graph {
        private Node nodeRoot;
        private Map<Integer, Node> nodeMap;

        public Graph(Node nodeRoot, Map<Integer, Node> nodeMap) {
            this.nodeRoot = nodeRoot;
            this.nodeMap = nodeMap;
        }

        public Node getNodeRoot() {
            return nodeRoot;
        }

        public void setNodeRoot(Node nodeRoot) {
            this.nodeRoot = nodeRoot;
        }

        public Map<Integer, Node> getNodeMap() {
            return nodeMap;
        }

        public void setNodeMap(Map<Integer, Node> nodeMap) {
            this.nodeMap = nodeMap;
        }

        public void printGraph() {
            for (Node node : nodeMap.values()) {
                System.out.println("Node = " + node.getId() + "\tColor=" + node.getColor());
                for (Node node1 : node.getConnectedNodes()) {
                    System.out.println("Connected Node = " + node1.getId() + "\tColor=" + node1.getColor());
                }
                System.out.println("========");
            }
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "nodeRoot=" + nodeRoot +
                    ", nodeMap=" + nodeMap +
                    '}';
        }
    }

    class Node {
        long color;
        int id;
        List<Node> connectedNodes;

        public Node(int id, long color) {
            this.color = color;
            this.id = id;
            this.connectedNodes = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return color == node.color &&
                    id == node.id;
        }

        public long getColor() {
            return color;
        }

        public void setColor(long color) {
            this.color = color;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Node> getConnectedNodes() {
            return connectedNodes;
        }

        public void setConnectedNodes(List<Node> connectedNodes) {
            this.connectedNodes = connectedNodes;
        }

        @Override
        public int hashCode() {

            return Objects.hash(color, id);
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "color=" + color +
//                    ", id=" + id +
//                    ", connectedNodes=" + connectedNodes +
//                    '}';
//        }
    }
}


