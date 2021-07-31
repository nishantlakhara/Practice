package datastructures.trees;

public class CheckBalancedBinaryTree {
    private static boolean checkBalancedBinaryTree(Node rootNode) {
        if(rootNode == null)
            return false;

        int leftHeight = getHeight(rootNode.getLeft(), 0);
        int rightHeight = getHeight(rootNode.getRight(), 0);
        System.out.println("Left Height = " + leftHeight);
        System.out.println("Right Height = " + rightHeight);
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1) {
            return false;
        }
        return true;
    }

    private static int getHeight(Node node, int currentHeight) {
        if(node == null) {
            return currentHeight;
        }

        return Math.max(getHeight(node.getLeft(), currentHeight+1),
                getHeight(node.getRight(), currentHeight+1));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test5() {
        System.out.println(checkBalancedBinaryTree(null));
    }

    private static void test4() {
        Node rootNode = new Node(1);
        print(rootNode);

        System.out.println(checkBalancedBinaryTree(rootNode));
    }

    private static void test3() {
        Node rootNode = new Node(1);
        Node node1 = new Node(2);

        rootNode.setLeft(node1);

        print(rootNode);

        System.out.println(checkBalancedBinaryTree(rootNode));
    }

    private static void test2() {
        Node rootNode = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);
        node7.setLeft(node8);

        print(rootNode);

        System.out.println(checkBalancedBinaryTree(rootNode));
    }

    private static void test1() {
        Node rootNode = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);

        print(rootNode);

        System.out.println(checkBalancedBinaryTree(rootNode));
    }



    private static void print(Node rootNode) {
        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrder(sb, "", "", rootNode);
        System.out.println(sb.toString());
    }
}
