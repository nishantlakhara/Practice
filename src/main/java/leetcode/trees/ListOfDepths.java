package leetcode.trees;

import java.util.*;

public class ListOfDepths {
    public static void main(String[] args) {

        NodeMultilevel rootNodeMultilevel = new NodeMultilevel("a", new ArrayList<>());
        NodeMultilevel node1 = new NodeMultilevel("b", new ArrayList<>());
        NodeMultilevel node2 = new NodeMultilevel("c", new ArrayList<>());
        NodeMultilevel node3 = new NodeMultilevel("d", new ArrayList<>());
        NodeMultilevel node4 = new NodeMultilevel("e", new ArrayList<>());
        NodeMultilevel node5 = new NodeMultilevel("f", new ArrayList<>());
        NodeMultilevel node6 = new NodeMultilevel("g", new ArrayList<>());
        NodeMultilevel node7 = new NodeMultilevel("h", new ArrayList<>());
        NodeMultilevel node8 = new NodeMultilevel("i", new ArrayList<>());
        NodeMultilevel node9 = new NodeMultilevel("j", new ArrayList<>());
        NodeMultilevel node10Leaf = new NodeMultilevel("k");
        NodeMultilevel node11Leaf = new NodeMultilevel("l");
        NodeMultilevel node12Leaf = new NodeMultilevel("m");

        rootNodeMultilevel.addChildren(Arrays.asList(node1, node2, node3));
        node1.addChildren(Arrays.asList(node4, node5));
        node2.addChildren(Arrays.asList(node6, node7, node8));
        node3.addChildren(Arrays.asList(node9));
        node4.addChildren(Arrays.asList(node10Leaf));
        node5.addChildren(Arrays.asList(node11Leaf));
        node5.addChildren(Arrays.asList(node12Leaf));

        Map<Integer, List<NodeMultilevel>> depthLists = getListOfDepths(rootNodeMultilevel, new TreeMap<>(), 0);
        print(depthLists);
    }

    private static void print(Map<Integer, List<NodeMultilevel>> depthLists) {
        for(Map.Entry<Integer, List<NodeMultilevel>> entry: depthLists.entrySet()) {
            System.out.println("Level = " + entry.getKey() + "\tValue=" + entry.getValue());
        }
    }

    private static Map<Integer, List<NodeMultilevel>> getListOfDepths(NodeMultilevel rootNodeMultilevel,
                                                               Map<Integer, List<NodeMultilevel>> levelMap,
                                                                      int level) {
        levelMap.putIfAbsent(level, new ArrayList<>());
        levelMap.get(level).add(rootNodeMultilevel);

        if(rootNodeMultilevel.getChildren() != null && !rootNodeMultilevel.getChildren().isEmpty()) {
            for (NodeMultilevel nodeMultilevel:rootNodeMultilevel.getChildren()) {
                getListOfDepths(nodeMultilevel, levelMap, level+1);
            }
        }
        return levelMap;
    }
}
