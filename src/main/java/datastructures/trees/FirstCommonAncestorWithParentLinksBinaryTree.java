package datastructures.trees;

public class FirstCommonAncestorWithParentLinksBinaryTree {
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

        System.out.println(firstCommonAncestor(node7, node6));
        System.out.println(firstCommonAncestor(rootNode, node5));
        System.out.println(firstCommonAncestor(node1, node2));
        System.out.println(firstCommonAncestor(node3, node5));
        System.out.println(firstCommonAncestor(node3, node4));
        System.out.println(firstCommonAncestor(node5, node6));
        System.out.println(firstCommonAncestor(node3, node7));
        System.out.println(firstCommonAncestor(node4, node7));
        System.out.println(firstCommonAncestor(node7, node1));
        System.out.println(firstCommonAncestor(node7, rootNode));
    }

    private static NodeWithParent firstCommonAncestor(NodeWithParent nodeA, NodeWithParent nodeB) {
        //Root node
        if(nodeA.parent == null) {
            return nodeA;
        }
        //Root node
        if(nodeB.parent == null) {
            return nodeB;
        }
        int diffDepth = depth(nodeA) - depth(nodeB);
        //System.out.println(diffDepth);
        NodeWithParent nodeLowDepth = diffDepth > 0 ? nodeB: nodeA;
        NodeWithParent nodeHighDepth = diffDepth > 0 ? nodeA: nodeB;

        //Reach high depth node to same level.
        for(int i=0; i<Math.abs(diffDepth); i++) {
            nodeHighDepth = nodeHighDepth.parent;
        }

        //Now both nodes are at same level - Check for intersecting node, That will be the common ancestor.
        while(true) {
            if(nodeLowDepth == nodeHighDepth) {
                return nodeLowDepth;
            }
            nodeLowDepth = nodeLowDepth.parent;
            nodeHighDepth = nodeHighDepth.parent;
        }
    }

    private static int depth(NodeWithParent node) {
        int depth = 0;
        //Root node
        if(node.parent == null) {
            return 0;
        }
        while(node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    private static void print(NodeWithParent rootNode) {
        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrderWithParent(sb, "", "", rootNode);
        System.out.println(sb.toString());
    }
}
