package leetcode.trees;

public class FirstCommonAncestorBinaryTreeWithParentLinkWithBetterWorstCaseComplexity {
    public static void main(String[] args) {
        NodeWithParent rootNode = new NodeWithParent(10);
        NodeWithParent node1 = new NodeWithParent(5);
        NodeWithParent node2 = new NodeWithParent(6);
        NodeWithParent node3 = new NodeWithParent(11);
        NodeWithParent node4 = new NodeWithParent(12);
        NodeWithParent node5 = new NodeWithParent(14);
        NodeWithParent node6 = new NodeWithParent(8);
        NodeWithParent node7 = new NodeWithParent(3);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setParent(rootNode);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setParent(rootNode);
        node3.setParent(node1);
        node2.setLeft(node5);
        node2.setRight(node6);
        node4.setParent(node1);
        node5.setParent(node2);
        node6.setParent(node2);
        node3.setLeft(node7);
        node7.setParent(node3);

        print(rootNode);

        System.out.println(firstCommonAncestor(rootNode, node7, node6));
        System.out.println(firstCommonAncestor(rootNode, rootNode, node5));
        System.out.println(firstCommonAncestor(rootNode, node1, node2));
        System.out.println(firstCommonAncestor(rootNode, node3, node5));
        System.out.println(firstCommonAncestor(rootNode, node3, node4));
        System.out.println(firstCommonAncestor(rootNode, node5, node6));
        System.out.println(firstCommonAncestor(rootNode, node3, node7));
        System.out.println(firstCommonAncestor(rootNode, node4, node7));
        System.out.println(firstCommonAncestor(rootNode, node7, node1));
        System.out.println(firstCommonAncestor(rootNode, node7, rootNode));

//        Output:
//        NodeWithParent{value=10}
//        NodeWithParent{value=10}
//        NodeWithParent{value=10}
//        NodeWithParent{value=10}
//        NodeWithParent{value=5}
//        NodeWithParent{value=6}
//        NodeWithParent{value=11}
//        NodeWithParent{value=5}
//        NodeWithParent{value=5}
//        NodeWithParent{value=10}
    }

    private static NodeWithParent firstCommonAncestor(NodeWithParent rootNode, NodeWithParent p, NodeWithParent q) {
        // Check if either node is not in tree, or if one covers the other.
        if(!covers(rootNode, p) || !covers(rootNode, q)) {
            return null;
        } else if(covers(p, q)) {
            return p;
        } else if(covers(q, p)) {
            return q;
        }

        // Traverse upwards until you find a node that covers q.
        NodeWithParent sibling = getSibling(p);
        NodeWithParent parent = p.parent;

        while(!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private static NodeWithParent getSibling(NodeWithParent node) {
        if(node == null || node.parent == null) {
            return null;
        }
        NodeWithParent parent = node.parent;
        if(node.equals(parent.getLeft())) {
            return parent.getRight();
        } else {
            return parent.getLeft();
        }
    }

    private static boolean covers(NodeWithParent nodeA, NodeWithParent nodeB) {
        if(nodeA == null) return false;
        if(nodeA == nodeB) return true;
        return covers(nodeA.left, nodeB) || covers(nodeA.right, nodeB);
    }

    private static void print(NodeWithParent rootNode) {
        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrderWithParent(sb, "", "", rootNode);
        System.out.println(sb.toString());
    }
}
