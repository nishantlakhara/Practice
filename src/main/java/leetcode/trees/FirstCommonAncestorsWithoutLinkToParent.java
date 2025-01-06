package leetcode.trees;

public class FirstCommonAncestorsWithoutLinkToParent {
    public static void main(String[] args) {
        Node rootNode = new Node(10);
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        Node node3 = new Node(11);
        Node node4 = new Node(12);
        Node node5 = new Node(14);
        Node node6 = new Node(8);
        Node node7 = new Node(3);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);

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
    }

    private static Node firstCommonAncestor(Node rootNode, Node p, Node q) {
        //If root doesn't covers both, its not in tree
        if(!covers(rootNode, p) || !covers(rootNode, q)) {
            return null;
        }

        return ancestorHelper(rootNode, p, q);
    }

    private static Node ancestorHelper(Node rootNode, Node p, Node q) {
        if(rootNode == p || rootNode == q) {
            return rootNode;
        }

        boolean pInLeftSide = covers(rootNode.getLeft(), p);
        boolean qInLeftSide = covers(rootNode.getLeft(), q);

        //Both are on different sides.
        if(pInLeftSide != qInLeftSide) {
            return rootNode;
        }

        Node childNode = pInLeftSide ? rootNode.getLeft(): rootNode.getRight();
        return ancestorHelper(childNode, p, q);
    }

    private static boolean covers(Node rootNode, Node node) {
        //System.out.println(rootNode + "---" + node);
        if(rootNode == null) return false;
        if(rootNode == node) return true;
        return covers(rootNode.getLeft(), node) || covers(rootNode.getRight(), node);
    }

    private static void print(Node rootNode) {
        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrder(sb, "", "", rootNode);
        System.out.println(sb.toString());
    }
}
