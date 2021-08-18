package datastructures.graphs;

import java.util.*;

public class Graph {
    private List<Node> nodes;
    private Map<Node, Node> nodeMap = new HashMap<>();
    private final Map<Node, List<Node>> nodeToImmediateChildrenMap = new HashMap<>();
    private final Map<Node, List<Node>> nodeToIncomingEdgeMap = new HashMap<>();

    public Map<Node, Node> getNodeMap() {
        return nodeMap;
    }

    public Graph() { this.nodes = new ArrayList<>(); }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Graph addNode(Node node) {
        nodeToImmediateChildrenMap.putIfAbsent(node, new ArrayList<>());
        nodeToIncomingEdgeMap.putIfAbsent(node, new ArrayList<>());
        nodes.add(node);
        nodeMap.put(node, node);
        return this;
    }

    public Graph addNodes(List<Node> nodes) {
        nodes.forEach(n -> nodeToImmediateChildrenMap.putIfAbsent(n, new ArrayList<>()));
        nodes.forEach(n -> nodeToIncomingEdgeMap.putIfAbsent(n, new ArrayList<>()));
        this.nodes.addAll(nodes);
        for (Node node: nodes) {
            nodeMap.put(node, node);
        }
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
        List<Node> n = nodeToImmediateChildrenMap.get(new Node(nodeStr));
        return n;
    }

    public List<Node> getIncomingNode(String nodeStr) {
        return nodeToIncomingEdgeMap.get(new Node(nodeStr));
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
        List<Node> nodes = nodeToImmediateChildrenMap.get(node);
        for(Node n: nodes) {
            nodeToIncomingEdgeMap.get(n).remove(node);
        }
    }

    public Node getNodeFromGraph(String nodeStr) {
        return nodeMap.get(new Node(nodeStr));
    }

}