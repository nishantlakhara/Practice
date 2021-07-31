package datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class NodeMultilevel {
    private String name;
    private List<NodeMultilevel> children;

    public NodeMultilevel(String name) {
        this.name = name;
    }

    public NodeMultilevel(String name, List<NodeMultilevel> children) {
        this.name = name;
        this.children = children;
    }

    public void addChild(NodeMultilevel node) {
        this.children.add(node);
    }

    public void addChildren(List<NodeMultilevel> nodes) {
        this.children.addAll(nodes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeMultilevel> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}

