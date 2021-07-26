package datastructures.graphs;

import java.util.ArrayList;

public class GraphSearch {
    public static void main(String[] args) {
        Node a = new Node("A", new ArrayList<>());
        a.addChildren(new Node("B"));

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
        y.addChildren(d);
        w.addChildren(f);
        x.addChildren(c);
        e.addChildren(f);
        f.addChildren(g);
        f.addChildren(d);

        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(c);
    }
}
