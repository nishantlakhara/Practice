package leetcode.trees;

import java.util.Objects;
import java.util.Random;

public class TreeNode {
    int value;
    int size;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, int size) {
        this.value = value;
        this.size = size;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getRandomNode() {
        int leftSize = this.getLeft() == null ? 0: this.getLeft().getSize();
        Random random = new Random();
        int index = random.nextInt(this.getSize());
        if(index < leftSize) {
            return this.getLeft().getRandomNode();
        } else if(index == leftSize) {
            return this;
        } else {
            return this.getRight().getRandomNode();
        }
    }

    public void insertInorder(int value) {
        if(value <= this.value) {
            if(this.getLeft() == null) {
                this.setLeft(new TreeNode(value, 1));
            } else {
                this.getLeft().insertInorder(value);
            }
        } else {
            if(this.getRight() == null) {
                this.setRight(new TreeNode(value, 1));
            } else {
                this.getRight().insertInorder(value);
            }
        }
        size++;
    }

    public TreeNode find(int d) {
        if(d == value) {
            return this;
        } else if(d < value) {
            return this.getLeft() != null ? this.getLeft().find(d): null;
        } else {
            return this.getRight() != null ? this.getRight().find(d): null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return size == treeNode.size && Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, size);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", size=" + size +
                '}';
    }
}
