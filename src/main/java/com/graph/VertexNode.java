package com.graph;

import java.util.List;

public class VertexNode {
	int vertex;
	List<Integer> edges;
	
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public List<Integer> getEdges() {
		return edges;
	}
	public void setEdges(List<Integer> edges) {
		this.edges = edges;
	}
}
