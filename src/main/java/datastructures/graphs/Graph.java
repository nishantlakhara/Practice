package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Node> nodes;
    private final Map<Node, List<Node>> nodeToImmediateChildrenMap = new HashMap<>();
    private final Map<Node, List<Node>> nodeToIncomingEdgeMap = new HashMap<>();

    public Graph() { this.nodes = new ArrayList<>(); }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Graph addNode(Node node) {
        nodeToImmediateChildrenMap.putIfAbsent(node, new ArrayList<>());
        nodeToIncomingEdgeMap.putIfAbsent(node, new ArrayList<>());
        nodes.add(node);
        return this;
    }

    public Graph addNodes(List<Node> nodes) {
        nodes.forEach(n -> nodeToImmediateChildrenMap.putIfAbsent(n, new ArrayList<>()));
        nodes.forEach(n -> nodeToIncomingEdgeMap.putIfAbsent(n, new ArrayList<>()));
        this.nodes.addAll(nodes);
        return this;
    }

//    public Graph addIncomingNode(Node node) {
//        nodeToIncomingEdgeMap.putIfAbsent(node, new ArrayList<>());
//        nodeToIncomingEdgeMap.get(node).add(node);
//        return this;
//    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Node> getNode(String nodeStr) {
        return nodeToImmediateChildrenMap.get(nodeStr);
    }

    public List<Node> getIncomingNode(String nodeStr) {
        return nodeToIncomingEdgeMap.get(nodeStr);
    }

    public List<Node> getNode(Node node) {
        return nodeToImmediateChildrenMap.get(node);
    }

    public List<Node> getIncomingNode(Node node) {
        return nodeToIncomingEdgeMap.get(node);
    }

    public void breakEdgeFromMap(Node node) {
        nodeToImmediateChildrenMap.put(node, new ArrayList<>());
    }

    public void removeFromIncomingAgeMap(Node node) {
        nodeToIncomingEdgeMap.remove(node);
    }
}