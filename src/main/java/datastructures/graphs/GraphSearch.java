package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {
    public static void main(String[] args) {
        dfsExample();

        bfsExample();

        checkRouteExistsExample();
    }

    private static void checkRouteExistsExample() {
        Node a = new Node("A", new ArrayList<>());
        Node b = new Node("B");
        a.addChildren(b);

        Node c = new Node("C", new ArrayList<>());
        Node d = new Node("D", new ArrayList<>());
        Node y = new Node("Y", new ArrayList<>());
        Node w = new Node("W", new ArrayList<>());
        Node e = new Node("E", new ArrayList<>());
        Node f = new Node("F", new ArrayList<>());
        Node g = new Node("G");
        Node x = new Node("X", new ArrayList<>());

        c.addChildren(d);
        c.addChildren(y);
        //d.addChildren(w);
        d.addChildren(e);
        d.addChildren(x);
        y.addChildren(d);
        w.addChildren(f);
        x.addChildren(c);
        e.addChildren(f);
        f.addChildren(g);
        f.addChildren(d);

        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(y);
        graph.addNode(w);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(x);

        System.out.println("Route between a and a exists = " + checkRouteExists(graph,  a, a));
        System.out.println("Route between a and a exists = " + checkRouteExists(graph,  a, b));
        System.out.println("Route between a and c exists = " + checkRouteExists(graph,  a, c));
        System.out.println("Route between a and d exists = " + checkRouteExists(graph,  a, d));
        System.out.println("Route between y and d exists = " + checkRouteExists(graph,  y, d));
        System.out.println("Route between e and g exists = " + checkRouteExists(graph,  y, d));
        System.out.println("Route between e and g exists = " + checkRouteExists(graph,  w, g));
        System.out.println("Route between e and w exists = " + checkRouteExists(graph,  e, w));

    }

    private static boolean checkRouteExists(Graph graph, Node start, Node end) {
        if(start == end) {
            return true;
        }

        for(Node node: graph.getNodes()) {
            node.setVisited(false);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            current.setVisited(true);
            if(current != null && current.getChildren() != null && !current.getChildren().isEmpty()) {
                for (Node n:current.getChildren()) {
                    if(!n.isVisited()) {
                        if(n == end) {
                            return true;
                        } else {
                            queue.add(n);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void bfsExample() {
        Graph graph = createGraph();

        for (int i = 0; i < graph.getNodes().size(); i++) {
            breadth_first_search(graph.getNodes().get(i));
            //System.out.println();
        }
        System.out.println();
    }

    private static void dfsExample() {
        Graph graph1 = createGraph();

        for (int i = 0; i < graph1.getNodes().size(); i++) {
            depth_first_search(graph1.getNodes().get(i));
            //System.out.println();
        }
        System.out.println();
    }

    private static Graph createGraph() {
        Node a = new Node("A", new ArrayList<>());
        Node b = new Node("B");
        a.addChildren(b);

        Node c = new Node("C", new ArrayList<>());
        Node d = new Node("D", new ArrayList<>());
        Node y = new Node("Y", new ArrayList<>());
        Node w = new Node("W", new ArrayList<>());
        Node e = new Node("E", new ArrayList<>());
        Node f = new Node("F", new ArrayList<>());
        Node g = new Node("G");
        Node x = new Node("X", new ArrayList<>());

        c.addChildren(d);
        c.addChildren(y);
        d.addChildren(w);
        d.addChildren(e);
        d.addChildren(x);
        y.addChildren(d);
        w.addChildren(f);
        x.addChildren(c);
        e.addChildren(f);
        f.addChildren(g);
        f.addChildren(d);

        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(y);
        graph.addNode(w);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(x);
        return graph;
    }

    /*
    dfs - depth first search on a graph.
     */
    public static void depth_first_search(Node root) {
        if (root != null && !root.isVisited()) {
            System.out.println(root.getName());
            root.setVisited(true);
            if (root.getChildren() != null) {
                for (int i = 0; i < root.getChildren().size(); i++) {
                    depth_first_search(root.getChildren().get(i));
                }
            }
        }
    }

    /*
    bfs - breadth first search on a graph.
    */
    public static void breadth_first_search(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(!node.isVisited()) {
                System.out.println(node.getName());
                node.setVisited(true);

                if (node.getChildren() != null) {
                    for (int i = 0; i < node.getChildren().size(); i++) {
                        if (!node.getChildren().get(i).isVisited()) {
                            queue.add(node.getChildren().get(i));
                        }
                    }
                }
            }
        }
    }
}
