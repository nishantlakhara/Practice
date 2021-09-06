package datastructures.trees;

public class NodeWithParent {
    int value;
    NodeWithParent left;
    NodeWithParent right;
    NodeWithParent parent;

    public NodeWithParent(int value) {
        this.value = value;
    }

    public NodeWithParent(int value, NodeWithParent left, NodeWithParent right, NodeWithParent parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeWithParent getLeft() {
        return left;
    }

    public void setLeft(NodeWithParent left) {
        this.left = left;
    }

    public NodeWithParent getRight() {
        return right;
    }

    public void setRight(NodeWithParent right) {
        this.right = right;
    }

    public NodeWithParent getParent() {
        return parent;
    }

    public void setParent(NodeWithParent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "NodeWithParent{" +
                "value=" + value +
                '}';
    }
}
