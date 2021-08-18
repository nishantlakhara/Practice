package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private String name;
    private List<Node> children;
    private boolean visited;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Node(String name, List<Node> children) {
        this.name = name;
        this.children = children;
    }

    public void addChildren(Node node) {
        this.children.add(node);
    }

    public void addMultipleChildren(List<Node> nodes) {
        this.children.addAll(nodes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", visited=" + visited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
