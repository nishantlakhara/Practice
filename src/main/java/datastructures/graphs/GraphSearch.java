package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {
    public static void main(String[] args) {
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
        graph.addNode(c);

        for (int i = 0; i < graph.getNodes().size(); i++) {
            depth_first_search(graph.getNodes().get(i));
            System.out.println();
        }

        a.setVisited(false);
        b.setVisited(false);
        c.setVisited(false);
        d.setVisited(false);
        y.setVisited(false);
        w.setVisited(false);
        e.setVisited(false);
        f.setVisited(false);
        g.setVisited(false);
        x.setVisited(false);

        for (int i = 0; i < graph.getNodes().size(); i++) {
            breadth_first_search(graph.getNodes().get(i));
            System.out.println();
        }
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
