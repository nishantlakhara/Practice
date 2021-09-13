package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {
    public static void main(String[] args) {
        //tree1();
        tree2();
    }

    private static void tree2() {
        Node rootNode = new Node(50);
        Node node1 = new Node(20);
        Node node2 = new Node(60);
        Node node3 = new Node(10);
        Node node4 = new Node(25);
        Node node5 = new Node(70);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node5);

        LinkedList<LinkedList<Integer>> result = allsequences(rootNode);
        for (LinkedList<Integer> r:result) {
            System.out.println(r);
        }

    }

    private static void tree1() {
        Node rootNode = new Node(50);
        Node node1 = new Node(20);
        Node node2 = new Node(60);
        Node node3 = new Node(10);
        Node node4 = new Node(25);
        Node node5 = new Node(70);
        Node node6 = new Node(5);
        Node node7 = new Node(15);
        Node node8 = new Node(65);
        Node node9 = new Node(80);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node5.setLeft(node8);
        node5.setRight(node9);

        LinkedList<LinkedList<Integer>> result = allsequences(rootNode);
        for (LinkedList<Integer> r:result) {
            System.out.println(r);
        }
    }

    private static LinkedList<LinkedList<Integer>> allsequences(Node node) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();

        if(node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.getValue());

        //Recurse on left and right
        LinkedList<LinkedList<Integer>> leftSeq = allsequences(node.getLeft());
        LinkedList<LinkedList<Integer>> rightSeq = allsequences(node.getRight());

        /*
        Weave together each list from right and left subtrees.
         */
        for(LinkedList<Integer> left: leftSeq) {
            for (LinkedList<Integer> right: rightSeq) {
                LinkedList<LinkedList<Integer>> weaved = new LinkedList<>();
                weave(left, right, prefix, weaved);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private static void weave(LinkedList<Integer> listA, LinkedList<Integer> listB, LinkedList<Integer> listWeaved, LinkedList<LinkedList<Integer>> listOfWeavedLists) {
        //Base condition of recursive function.
        if (listA.isEmpty() && listB.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (Integer item: listWeaved) {
                list.add(item);
            }
            listOfWeavedLists.add(list);
            //System.out.println(listWeaved);
            return;
        }

        if (!listA.isEmpty()) {
            //Change
            listWeaved.addLast(listA.removeFirst());
            //Recurse
            weave(listA, listB, listWeaved, listOfWeavedLists);
            //Backtrack
            listA.addFirst(listWeaved.removeLast());
        }

        if (!listB.isEmpty()) {
            //Change
            listWeaved.addLast(listB.removeFirst());
            //Recurse
            weave(listA, listB, listWeaved, listOfWeavedLists);
            //Backtrack
            listB.addFirst(listWeaved.removeLast());
        }
    }
}
