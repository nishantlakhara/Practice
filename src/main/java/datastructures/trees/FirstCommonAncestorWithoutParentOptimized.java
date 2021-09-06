package datastructures.trees;

public class FirstCommonAncestorWithoutParentOptimized {
    public static void main(String[] args) {
        Node rootNode = new Node(20);
        Node node1 = new Node(10);
        Node node2 = new Node(30);
        Node node3 = new Node(5);
        Node node4 = new Node(15);
        Node node5 = new Node(3);
        Node node6 = new Node(7);
        Node node7 = new Node(17);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        node4.setRight(node7);

        print(rootNode);

        System.out.println(firstCommonAncestor(rootNode, new Node(11), node6));
        System.out.println(firstCommonAncestor(rootNode, node3, new Node(11)));
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
    }

    private static Node firstCommonAncestor(Node rootNode, Node p, Node q) {
        NodeData nodeData = firstCommonAncestorHelper(rootNode, p, q);
        if(nodeData.getStatus()) {
            return nodeData.getNode();
        } else {
            return null;
        }
    }

    private static NodeData firstCommonAncestorHelper(Node rootNode, Node p, Node q) {
        if(rootNode == null) {
            return new NodeData(null, false);
        }

        if(rootNode == p && rootNode == q) {
            return new NodeData(rootNode, true);
        }

        NodeData leftSubTree = firstCommonAncestorHelper(rootNode.getLeft(), p, q);
        if(leftSubTree.getStatus() == true) {
            return leftSubTree;
        }

        NodeData rightSubTree = firstCommonAncestorHelper(rootNode.getRight(), p, q);
        if(rightSubTree.getStatus() == true) {
            return rightSubTree;
        }

        if(leftSubTree.getNode() != null && rightSubTree.getNode() != null) {
            //That means one found p and other found q. Tree is having unique entries assumed.
            return new NodeData(rootNode, true);
        } else if(rootNode == p || rootNode == q) {
            //If Either got p or q. Check if we got p then q in subtree else if q then p in subtree.
            //Also note both node should be in same subtree.
            boolean isAncestor = leftSubTree.getNode() != null || rightSubTree.getNode() != null;
            return new NodeData(rootNode, isAncestor);
        } else {
            //Root node is not any of p and q. Return the one that is not null
            return leftSubTree.getNode() != null? leftSubTree: rightSubTree;
        }
    }

    static class NodeData {
        private Node node;
        private Boolean status;

        public NodeData(Node node, Boolean status) {
            this.node = node;
            this.status = status;
        }

        public Node getNode() {
            return node;
        }

        public Boolean getStatus() {
            return status;
        }

        @Override
        public String
        toString() {
            return "NodeData{" +
                    "node=" + node +
                    ", status=" + status +
                    '}';
        }
    }

    private static void print(Node rootNode) {
        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrder(sb, "", "", rootNode);
        System.out.println(sb.toString());
    }
}
