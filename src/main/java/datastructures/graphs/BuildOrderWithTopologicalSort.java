package datastructures.graphs;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class BuildOrderWithTopologicalSort {
    public static void main(String[] args) {
        List<String> projects = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        List<String[]> dependencies = Arrays.asList(
                new String[]{"f", "c"},
                new String[]{"f", "b"},
                new String[]{"f", "a"},
                new String[]{"a", "c"},
                new String[]{"b", "e"},
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
        for (Node node:graph.getNodes()) {
            List<Node> nodes = graph.getIncomingNode(node);
            if(nodes == null) {
                //Already build order completed.
                continue;
            }
            if(!node.isVisited()) {
                if (nodes.isEmpty()) {
                    buildOrderList.add(node.getName());
                    node.setVisited(true);
                    visitedNodes.add(node);
                    graph.breakEdgeFromMap(node);
                    graph.removeFromIncomingAgeMap(node);
                }
            }
        }
        return buildOrderList;
    }

    private static BiConsumer<Graph, String[]> addDependency = (g, arr) -> g.getNode(arr[0]).add(new Node(arr[1]));
    private static BiConsumer<Graph, String[]> addIncomingEdge = (g, arr) -> g.getIncomingNode(arr[1]).add(new Node(arr[0]));

    private static Graph buildGraph(List<String> projects, List<String[]> dependencies) {
        final Graph graph = new Graph().addNodes(
                                 projects.stream().map(Node::new).collect(Collectors.toList()));
        dependencies.stream().forEach(arr -> addDependency.accept(graph, arr));
        dependencies.stream().forEach(arr -> addIncomingEdge.accept(graph, arr));
        return graph;
    }
}
