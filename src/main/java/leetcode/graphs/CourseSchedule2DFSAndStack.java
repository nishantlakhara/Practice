package leetcode.graphs;

import java.util.*;

public class CourseSchedule2DFSAndStack {
        static int WHITE = 1;
        static int GRAY = 2;
        static int BLACK = 3;
        boolean isPossible;
        Map<Integer, Integer> color;
        Map<Integer, List<Integer>> adjList;
        LinkedList<Integer> topologicalOrder;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //Create graph and initial data.
            createGraph(numCourses, prerequisites);

            //If the node is unprocessed call dfs on it.
            for(int i=0; i<numCourses; i++) {
                if(this.color.get(i) == WHITE) {
                    this.dfs(i);
                }
            }

            //return response
            int[] order;
            if(this.isPossible) {
                order = new int[numCourses];
                for(int i=0; i<numCourses; i++) {
                    order[i] = this.topologicalOrder.removeLast();
                }
            } else {
                return new int[0];
            }

            return order;
        }

        public void dfs(int node) {

            //Dont recurse if found a cycle.
            if(!this.isPossible) {
                return;
            }

            //Start the recursion
            this.color.put(node, GRAY);

            //Traverse neighbor vertices.
            for(int neighbor: this.adjList.getOrDefault(node, new ArrayList<>())) {
                if(this.color.get(neighbor) == WHITE) {
                    this.dfs(neighbor);
                } else if(this.color.get(neighbor) == GRAY) {
                    //CYCLE found.
                    this.isPossible = false;
                }
            }

            //Recursion ends. Mark the node as BLACK
            this.color.put(node, BLACK);
            this.topologicalOrder.addFirst(node);
        }

        public void createGraph(int numCourses, int[][] prerequisites) {
            this.isPossible = true;
            this.color = new HashMap<>();
            this.adjList = new HashMap<>();
            this.topologicalOrder = new LinkedList<>();

            for(int i=0; i<numCourses; i++) {
                this.color.put(i, WHITE);
            }

            for(int i=0; i<prerequisites.length; i++) {
                int src = prerequisites[i][0];
                int dest = prerequisites[i][1];

                this.adjList.putIfAbsent(src, new ArrayList<>());
                this.adjList.get(src).add(dest);
            }
        }
}
