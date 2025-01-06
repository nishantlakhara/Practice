package leetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;

public class Weaver {
    public static void main(String[] args) {
        LinkedList<Integer> listA = new LinkedList<>(Arrays.asList(1, 2, 3));
        LinkedList<Integer> listB = new LinkedList<>(Arrays.asList(4, 5, 6));
        LinkedList<LinkedList<Integer>> listOfWeavedLists = new LinkedList<>();

        weave(listA, listB, new LinkedList<>(), listOfWeavedLists);
        System.out.println(listOfWeavedLists);
    }

    private static void weave(LinkedList<Integer> listA, LinkedList<Integer> listB, LinkedList<Integer> listWeaved, LinkedList<LinkedList<Integer>> listOfWeavedLists) {
        //Base condition of recursive function.
        if (listA.isEmpty() && listB.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (Integer item: listWeaved) {
                list.add(item);
            }
            listOfWeavedLists.add(list);
            System.out.println(listWeaved);
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
