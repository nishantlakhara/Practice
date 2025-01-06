package leetcode.trees;

public class CheckSuBTree {
    public static void main(String[] args) {
        // Tree 1
        Node t1 = tree1();

        // Tree 2 i.e subtree
        Node t2 = tree2();

        // Tree 3 i.e not a subtree.
        Node t3 = tree3();

        String preorderT1 = extractedPreorder(t1);
        String preorderT2 = extractedPreorder(t2);
        String preorderT3 = extractedPreorder(t3);
        System.out.println(preorderT1.indexOf(preorderT2) != -1);
        System.out.println(preorderT1.indexOf(preorderT3) != -1);
    }


    private static String extractedPreorder(Node rootNode) {
        StringBuilder nodesPreorder = new StringBuilder();
        preOrder(rootNode, nodesPreorder);
        System.out.println(nodesPreorder.toString());
        return nodesPreorder.toString();
    }

    private static void print(Node rootNode) {
        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrder(sb, "", "", rootNode);
        System.out.println(sb.toString());
    }

    private static void preOrder(Node rootNode, StringBuilder nodes) {
        if(rootNode == null) {
            nodes.append("X ");
            return;
        }
        nodes.append(rootNode.getValue() + " ");
        preOrder(rootNode.getLeft(), nodes);
        preOrder(rootNode.getRight(), nodes);
    }

    private static Node tree1() {
        Node rootNode = new Node(55);
        Node node1 = new Node(75);
        Node node2 = new Node(85);
        Node node3 = new Node(52);
        Node node4 = new Node(53);
        Node node5 = new Node(10);
        Node node6 = new Node(5);
        Node node7 = new Node(15);
        Node node8 = new Node(17);
        Node node9 = new Node(6);
        Node node10 = new Node(8);
        Node node11 = new Node(12);
        Node node12 = new Node(6);
        Node node13 = new Node(85);

        // Tree 1
        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);
        node3.setRight(node8);
        node5.setLeft(node9);
        node6.setLeft(node10);
        node6.setRight(node11);
        node8.setLeft(node12);
        node12.setRight(node13);
        print(rootNode);
        return rootNode;
    }

    private static Node tree2() {
        Node node2 = new Node(85);
        Node node5 = new Node(10);
        Node node6 = new Node(5);
        Node node9 = new Node(6);
        Node node10 = new Node(8);
        Node node11 = new Node(12);

        // Tree 2
        node2.setLeft(node5);
        node2.setRight(node6);
        node5.setLeft(node9);
        node6.setLeft(node10);
        node6.setRight(node11);
        print(node2);
        return node2;
    }

    private static Node tree3() {
        Node node2 = new Node(85);
        Node node5 = new Node(10);
        Node node6 = new Node(5);
        Node node9 = new Node(6);
        Node node10 = new Node(8);
        Node node11 = new Node(12);

        // Tree 2
        node2.setLeft(node5);
        node2.setRight(node6);
        node5.setRight(node9);
        node6.setLeft(node10);
        node6.setRight(node11);
        print(node2);
        return node2;
    }

}
