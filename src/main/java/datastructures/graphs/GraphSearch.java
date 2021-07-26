package datastructures.graphs;

import java.util.ArrayList;

public class GraphSearch {
    public static void main(String[] args) {
        Node node = new Node("A", new ArrayList<>());
        node.addChildren(new Node(""));
    }
}
