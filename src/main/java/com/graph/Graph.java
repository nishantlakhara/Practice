package com.graph;

import java.util.List;
import java.util.Map;

public class Graph {
	private int noEdges;
	private int noVertices;
	private Map<Integer, List<Integer>> adjacencyMap;
	
	public int getNoEdges() {
		return noEdges;
	}	
	public void setNoEdges(int noEdges) {
		this.noEdges= noEdges;
	}
	public int getNoVertices() {
		return noVertices;
	}
	public void setNoVertices(int noVertices) {
		this.noVertices = noVertices;
	}
	public Map<Integer, List<Integer>> getAdjacencyMap() {
		return adjacencyMap;
	}
	public void setAdjacencyMap(Map<Integer, List<Integer>> adjacencyList) {
		this.adjacencyMap = adjacencyList;
	}
}
