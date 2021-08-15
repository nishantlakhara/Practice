package datastructures.trees;

import java.util.ArrayList;
import java.util.List;


public class ValidateBinarySearchTree {
    public static Integer lastPrinted = null;

    public static void main(String[] args) {
        validBSTTest();
        invalidBSTTest1();
        invalidBSTTest2();
        invalidBSTTest3();
    }

    private static void invalidBSTTest3() {
        Node rootNode = new Node(20);
        Node node1 = new Node(10);
        Node node2 = new Node(30);
        Node node3 = new Node(25);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setRight(node3);

        List<Integer> list = new ArrayList<>();
        //System.out.println(validateBSTUsingInorder(rootNode, list));
//        System.out.println(validateBSTUsingInorder(rootNode, null));
//        System.out.println(validateBSTMinMax(rootNode, null, null));
//        System.out.println("validity inorder 2 = " + checkBST(rootNode, true, null));

        System.out.println("validity min max 2 = " + checkBST(rootNode, null, null));
        lastPrinted = null;
        System.out.println(checkBST(rootNode, true));
        lastPrinted = null;
        System.out.println(validateBSTUsingInorder(rootNode));
    }

    private static void invalidBSTTest2() {
        Node rootNode = new Node(20);
        Node node1 = new Node(10);
        Node node2 = new Node(30);
        Node node3 = new Node(8);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node2.setLeft(node3);

        //List<Integer> list = new ArrayList<>();
        //System.out.println(validateBSTUsingInorder(rootNode, list));
//        System.out.println(validateBSTUsingInorder(rootNode, null));
//        System.out.println(validateBSTMinMax(rootNode, null, null));
//        System.out.println("validity inorder 2 = " + checkBST(rootNode, true, null));

        System.out.println("validity min max 2 = " + checkBST(rootNode, null, null));
        lastPrinted = null;
        System.out.println(checkBST(rootNode, true));
        lastPrinted = null;
        System.out.println(validateBSTUsingInorder(rootNode));

    }

    private static void invalidBSTTest1() {
        Node rootNode = new Node(20);
        Node node1 = new Node(10);
        Node node2 = new Node(30);
        Node node3 = new Node(5);
        Node node4 = new Node(15);
        Node node5 = new Node(3);
        Node node6 = new Node(7);
        Node node7 = new Node(21);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        node4.setLeft(node7);

        //List<Integer> list = new ArrayList<>();
        //System.out.println(validateBSTUsingInorder(rootNode, list));
//        System.out.println(validateBSTUsingInorder(rootNode, null));
//
//        System.out.println(validateBSTMinMax(rootNode, null, null));
//        System.out.println("validity inorder 2 = " + checkBST(rootNode, true, null));

        System.out.println("validity min max 2 = " + checkBST(rootNode, null, null));
        lastPrinted = null;
        System.out.println(checkBST(rootNode, true));
        lastPrinted = null;
        System.out.println(validateBSTUsingInorder(rootNode));

    }



    private static void validBSTTest() {
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

        //List<Integer> list = new ArrayList<>();
        //System.out.println(validateBSTUsingInorder(rootNode, list));
//        System.out.println(validateBSTUsingInorder(rootNode, null));
//
//        System.out.println(validateBSTMinMax(rootNode, null, null));
//        System.out.println("validity inorder 2 = " + checkBST(rootNode, true, null));

        System.out.println("validity min max 2 = " + checkBST(rootNode, null, null));
        lastPrinted = null;
        System.out.println(checkBST(rootNode, true));
        lastPrinted = null;
        System.out.println(validateBSTUsingInorder(rootNode));
    }

//    private static boolean validateBSTUsingInorder(Node rootNode, List<Integer> list) {
//        if(rootNode == null) {
//            return true;
//        }
//        boolean status = true;
//        status = validateBSTUsingInorder(rootNode.getLeft(), list);
//        if(status == false) return status;
//        if(!list.isEmpty() && !compareNodeWithList(rootNode.getValue(), list)) {
//            return false;
//        }
//        list.add(rootNode.getValue());
//        status = validateBSTUsingInorder(rootNode.getRight(), list);
//        return status;
//    }


    public static boolean validateBSTUsingInorder(Node node) {
        if(node == null) return true;

        //Left recursion
        if(!validateBSTUsingInorder(node.getLeft())) return false;

        //Check Current
        if(lastPrinted != null && node.getValue() <= lastPrinted) return false;
        lastPrinted = node.getValue();

        //Right recursion
        if(!validateBSTUsingInorder(node.getRight())) return false;

        //All good
        return true;
    }

    public static boolean checkBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.getValue() <= min) || (max != null && n.getValue() > max)) {
            return false;
        }
        if (!checkBST(n.getLeft(), min, n.getValue()) ||
                !checkBST(n.getRight(), n.getValue(), max)) {
            return false;
        }
        return true;
    }

//    // Allow "equal" value only for left child. This validates the BST property.
//    public static boolean checkBST(Node n, boolean isLeft, Integer lastPrinted) {
//        if (n == null) {
//            return true;
//        }
//
//        // Check / recurse left
//        if (!checkBST(n.getLeft(), true, lastPrinted)) {
//            return false;
//        }
//
//        // Check current
//        if (lastPrinted != null) {
//            if (isLeft) {
//                // left child "is allowed" be equal to parent.
//                if (n.getValue() < lastPrinted) {
//                    return false;
//                }
//            } else {
//                // Right child "is not allowed" be equal to parent.
//                if (n.getValue() <= lastPrinted) {
//                    return false;
//                }
//            }
//        }
//        lastPrinted = n.getValue();
//
//        // Check / recurse right
//        if (!checkBST(n.getRight(), false, lastPrinted)) {
//            return false;
//        }
//        return true;
//    }

//    public static boolean validateBSTMinMax(Node node, Integer min, Integer max) {
//        if(node == null) return true;
//
//        if((min != null && node.getValue() <= min) || (max != null && node.getValue() > max)) return false;
//
//        if(!validateBSTMinMax(node.getLeft(), min, node.getValue()) || !validateBSTMinMax(node.getRight(), node.getValue(), max)) return false;
//
//        return true;
//    }

//    private static boolean compareNodeWithList(int value, List<Integer> list) {
//        for(Integer val: list) {
//            if(val > value) {
//                return false;
//            }
//        }
//        return true;
//    }

    // Allow "equal" value only for left child. This validates the BST property.
    public static boolean checkBST(Node n, boolean isLeft) {
        if (n == null) {
            return true;
        }

        // Check / recurse left
        if (!checkBST(n.getLeft(), true)) {
            return false;
        }

        // Check current
        if (lastPrinted != null) {
            if (isLeft) {
                // left child "is allowed" be equal to parent.
                if (n.getValue() < lastPrinted) {
                    return false;
                }
            } else {
                // Right child "is not allowed" be equal to parent.
                if (n.getValue() <= lastPrinted) {
                    return false;
                }
            }
        }
        lastPrinted = n.getValue();

        // Check / recurse right
        if (!checkBST(n.getRight(), false)) {
            return false;
        }
        return true;
    }
}