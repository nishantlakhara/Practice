package leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

//Built by me. May lose some edge cases.
public class BuildOrderWithDFSOrTopologicalSort {

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

        List<String> buildOrder = createBuildOrderDFS(projects, dependencies);
    }

    private static List<String> createBuildOrderDFS(List<String> projects, List<String[]> dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        List<String> buildOrder = createBuildOrderDFS(graph);
        System.out.println(buildOrder);
        return buildOrder;
    }

    private static List<String> createBuildOrderDFS(Graph graph) {
        Stack<String> stack = new Stack<>();
        List<String> buildOrder = new ArrayList<>();
        for (Node node: graph.getNodes()) {
            dfs(node, stack);
        }
        while (!stack.isEmpty()) {
            System.out.println(buildOrder.add(stack.pop()));
        }
        return buildOrder;
    }

    private static void dfs(Node node, Stack<String> stack) {
        if(!node.isVisited()) {
            node.setVisited(true);
            for (int i = 0; i < node.getChildren().size(); i++) {
                dfs(node.getChildren().get(i), stack);
            }
            stack.push(node.getName());
        }
    }

    private static Graph buildGraph(List<String> projects, List<String[]> dependencies) {
        final Graph graph = new Graph().addNodes(
                projects.stream().map(Node::new).collect(Collectors.toList()));
        dependencies.stream().forEach(arr -> addDependency.accept(graph, arr));
        return graph;
    }

    private static BiConsumer<Graph, String[]> addDependency = (g, arr) -> {
        g.getNodeFromGraph(arr[0]).addChildren(g.getNodeFromGraph(arr[1]));
    };



}


