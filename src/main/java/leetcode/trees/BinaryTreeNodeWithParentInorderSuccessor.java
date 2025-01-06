package leetcode.trees;

public class BinaryTreeNodeWithParentInorderSuccessor {
    public static void main(String[] args) {
        NodeWithParent rootNode = new NodeWithParent(20);
        NodeWithParent node1 = new NodeWithParent(10);
        NodeWithParent node2 = new NodeWithParent(30);
        NodeWithParent node3 = new NodeWithParent(5);
        NodeWithParent node4 = new NodeWithParent(15);
        NodeWithParent node5 = new NodeWithParent(3);
        NodeWithParent node6 = new NodeWithParent(7);
        NodeWithParent node7 = new NodeWithParent(17);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setParent(rootNode);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setParent(rootNode);
        node3.setParent(node1);
        node3.setLeft(node5);
        node3.setRight(node6);
        node4.setParent(node1);
        node4.setRight(node7);
        node5.setParent(node3);
        node6.setParent(node3);
        node7.setParent(node4);

        System.out.println(rootNode.getValue() + "->" + inorderSuccessor(rootNode));
        System.out.println(node1.getValue() + "->" + inorderSuccessor(node1));
        System.out.println(node2.getValue() + "->" + inorderSuccessor(node2));
        System.out.println(node3.getValue() + "->" + inorderSuccessor(node3));
        System.out.println(node4.getValue() + "->" + inorderSuccessor(node4));
        System.out.println(node5.getValue() + "->" + inorderSuccessor(node5));
        System.out.println(node6.getValue() + "->" + inorderSuccessor(node6));
        System.out.println(node7.getValue() + "->" + inorderSuccessor(node7));
    }

    private static NodeWithParent inorderSuccessor(NodeWithParent node) {
        if(node.getRight() != null) {
            NodeWithParent leftMost = getLeftMostNode(node.getRight());
            return leftMost;
        } else if(node.getParent() != null) {
            if(node == node.getParent().getRight()) {
                NodeWithParent nodeTraverse = node;
                while(nodeTraverse != null) {
                    if(nodeTraverse.getParent() == null) {
                        return null;
                    }
                    if(nodeTraverse.getParent().getValue() < node.getValue())
                        nodeTraverse = nodeTraverse.getParent();
                    else
                        break;
                }
                return nodeTraverse.getParent();
            } else {
                return node.getParent();
            }
        }
        return null;
    }

    private static NodeWithParent getLeftMostNode(NodeWithParent node) {
        NodeWithParent leftMost = node;
        while(leftMost.left != null) {
            leftMost = leftMost.left;
        }
        return leftMost;
    }
}
