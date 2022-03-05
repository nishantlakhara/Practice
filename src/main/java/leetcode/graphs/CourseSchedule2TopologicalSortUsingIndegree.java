package leetcode.graphs;

import java.util.*;

public class CourseSchedule2TopologicalSortUsingIndegree {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        //Create graph
        for(int i=0; i<prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);

            indegree[dest] += 1;
        }

        //Collect the elements with outdegree = 0 in a queue.
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        //Processing starts here.
        int i=0;
        while(!q.isEmpty()) {
            int node = q.poll();
            topologicalOrder[i] = node;
            i++;

            //Reduce indegree of neighbors and add to queue.
            for(int n: adjList.getOrDefault(node, new ArrayList<>())) {
                indegree[n]--;

                //If indegree becomes 0 add it to the queue.
                if(indegree[n] == 0) {
                    q.add(n);
                }
            }
        }

        //Check if topologicl sort is possible or not.
        if(i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}
