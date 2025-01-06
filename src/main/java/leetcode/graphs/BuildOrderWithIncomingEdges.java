package leetcode.graphs;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

//Built by me. May lose some edge cases.
public class BuildOrderWithIncomingEdges {
    public static void main(String[] args) {
        List<String> projects = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        List<String[]> dependencies = Arrays.asList(
                new String[]{"f", "c"},
                new String[]{"f", "b"},
                new String[]{"f", "a"},
                new String[]{"c", "a"},
                new String[]{"b", "a"},
                new String[]{"b", "e"},
                new String[]{"a", "e"},
                new String[]{"d", "g"}
        );

        List<String> buildOrder = createBuildOrder(projects, dependencies);
    }

    private static List<String> createBuildOrder(List<String> projects, List<String[]> dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        List<String> buildOrder = createBuildOrder(graph);
        System.out.println(buildOrder);
        return buildOrder;
    }

    private static List<String> createBuildOrder(Graph graph) {
        List<String> buildOrderList = new ArrayList<>();
        Set<Node> visitedNodes = new HashSet<>();
        int graphSize = graph.getNodes().size();
        int visitedCount = 0;
        while(visitedCount != graphSize) {
            for (Node node : graph.getNodeMap().keySet()) {
                System.out.println(node.getName());
                List<Node> nodes = graph.getIncomingNode(node);
                System.out.println("Nodes = " + nodes);
                if (nodes == null) {
                    //Already build order completed.
                    System.out.println(nodes + "is null");
                    continue;
                }
                if (!node.isVisited()) {
                    if (nodes.isEmpty()) {
                        buildOrderList.add(node.getName());
                        node.setVisited(true);
                        visitedCount++;
                        visitedNodes.add(node);
                        graph.removeFromIncomingAgeMap(node);
                        graph.breakEdgeFromMap(node);
                        System.out.println(node.getName());
                    }
                }
            }
            for (Node node: visitedNodes) {
                graph.getNodeMap().remove(node);
            }

            visitedNodes.clear();
        }

        return buildOrderList;
    }

    private static BiConsumer<Graph, String[]> addDependency = (g, arr) ->
    {
        g.getNode(arr[0]).add(g.getNodeFromGraph(arr[1]));
        g.getNodeFromGraph(arr[0]).addChildren(g.getNodeFromGraph(arr[1]));
    };
    private static BiConsumer<Graph, String[]> addIncomingEdge = (g, arr) -> {
        g.getIncomingNode(arr[1]).add(g.getNodeFromGraph(arr[0]));
    };

    private static Graph buildGraph(List<String> projects, List<String[]> dependencies) {
        final Graph graph = new Graph().addNodes(
                                 projects.stream().map(Node::new).collect(Collectors.toList()));
        dependencies.stream().forEach(arr -> addDependency.accept(graph, arr));
        dependencies.stream().forEach(arr -> addIncomingEdge.accept(graph, arr));
        return graph;
    }
}
