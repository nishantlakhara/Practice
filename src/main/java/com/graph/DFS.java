package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFS {
	public void initialize() {

	}

	/*
	 * Graph DFS
	 * 
	 * Input : 4 5 1 2 2 4 3 1 3 4 4 2
	 * 
	 * Output :
	 */
	public static void main(String[] args) {
		Graph graph = takeInput();
		printAdjacencyList(graph);
		System.out.println("Call 1");
		dfsDirectedGraph(graph, 1);
		System.out.println("Call 3");
		dfsDirectedGraph(graph, 3);
	}

	public static Graph takeInput() {
		// Adjacency list
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Graph graph = new Graph();

		try {
			graph.setNoVertices(Integer.parseInt(br.readLine()));
			graph.setNoEdges(Integer.parseInt(br.readLine()));
			Map<Integer, List<Integer>> adjacencyMap = new HashMap<Integer, List<Integer>>();

			for (int i = 0; i < graph.getNoEdges(); i++) {
				String[] split = br.readLine().split(" ");
				int vertex = Integer.parseInt(split[0].trim());
				int node = Integer.parseInt(split[1].trim());
				if (adjacencyMap.get(vertex) == null) {
					List<Integer> adjacentNodesList = new ArrayList<Integer>();
					adjacencyMap.put(vertex, adjacentNodesList);
				}
				adjacencyMap.get(vertex).add(node);
			}

			graph.setAdjacencyMap(adjacencyMap);
			br.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return graph;
	}

	public static void printAdjacencyList(Graph graph) {
		Map<Integer, List<Integer>> adjacencyMap = graph.getAdjacencyMap();

		for (Map.Entry<Integer, List<Integer>> entry : adjacencyMap.entrySet()) {
			int vertex = entry.getKey();
			List<Integer> list = entry.getValue();

			System.out.print(vertex + " : ");
			int j = 0;
			for (; j < list.size() - 1; j++) {
				System.out.print(list.get(j) + "->");
			}
			System.out.println(list.get(j));
		}
	}

	public static void dfsDirectedGraph(Graph graph, int vertex) {
		Map<Integer, List<Integer>> adjacencyMap = graph.getAdjacencyMap();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(vertex);
		visited.put(vertex, true);
		while (!stack.isEmpty()) {
			vertex = stack.pop();
			System.out.println("vertex visted : " + vertex);
			List<Integer> edgeList = adjacencyMap.get(vertex);

			for (int i = 0; i < edgeList.size(); i++) {
				int node = edgeList.get(i);
				if (visited.get(node) == null) {
					stack.push(node);
					visited.put(node, true);
				}
			}
		}
	}
}
