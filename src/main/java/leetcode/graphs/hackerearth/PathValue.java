package leetcode.graphs.hackerearth;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class PathValue {
    public static void main(String args[] ) throws Exception {

/*
5 7
2 5
1 2
2 3
3 4
4 5
1 3
1 4
1 5
20 23 21 45 21
 */
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        split = br.readLine().trim().split(" ");

        int S = Integer.parseInt(split[0]);
        int E = Integer.parseInt(split[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<M; i++) {
            split = br.readLine().trim().split(" ");
            int src = Integer.parseInt(split[0]);
            int dest = Integer.parseInt(split[1]);

            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(dest);

            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(dest).add(src);
        }

        int[] cost = new int[N];
        split = br.readLine().trim().split(" ");
        for(int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(split[i]);
        }

        // Write your code here
        //System.out.println("N="+N + ",M=" + M + ",S=" + S + ",E="+ E);
        //System.out.println(graph);
        //System.out.println(cost[0]);

        Integer res = Integer.MAX_VALUE;
        Queue<Pair<Integer, CachedLinkedHashSet<Integer>>> q = new LinkedList<>();
        CachedLinkedHashSet<Integer> set = new CachedLinkedHashSet<>();
        set.add(S);
        q.add(new Pair(0, set));

        while(!q.isEmpty()) {
            Pair<Integer, CachedLinkedHashSet<Integer>> curr = q.poll();

            CachedLinkedHashSet<Integer> path = curr.getSecond();
            Integer valuePath = curr.getFirst();
            Integer lastInPath = path.getLast();
            List<Integer> adj = graph.get(lastInPath);
            //System.out.println("valuepath = " + valuePath);
            //System.out.println("path = " + path);
            //System.out.println("lastInpath = " + lastInPath);

            if(adj != null) {
                for (int i = 0; i < adj.size(); i++) {
                    Integer node = adj.get(i);
                    if(!path.contains(node)) {
                        Integer currCost = cost[lastInPath - 1];
                        Integer nodeCost = cost[node - 1];
                        //System.out.println("currNode = " + lastInPath + ",currCost = " + currCost + ",node = " + node + ",nodeCost = " + nodeCost);
                        Integer absDiff = Math.abs(currCost - nodeCost);

                        int newValuePath = valuePath;
                        if (absDiff > valuePath) {
                            // Update value path to this.
                            newValuePath = absDiff;
                            //System.out.println("-----------------newValuePath = " + valuePath);
                        }

                        if(node == E) {
                            // if destination found.
                            //System.out.println("+++++++++++++++++++destination found with newValuePath = " + valuePath);
                            //System.out.println(path);
                            res = Math.min(newValuePath, res);
                            continue;
                        }

                        CachedLinkedHashSet copy = new CachedLinkedHashSet<>(path);
                        copy.add(node);
                        q.add(new Pair(newValuePath, copy));
                    }
                }
            }
        }

        System.out.println(res);

    }

    private static class Pair<K, V> {
        K k;
        V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getFirst() {
            return k;
        }

        public V getSecond() {
            return v;
        }
    }

    private static class CachedLinkedHashSet<E> extends LinkedHashSet<E> {
        private E last = null;

        public CachedLinkedHashSet() {
            super();
        }

        public CachedLinkedHashSet(CachedLinkedHashSet<E> c) {
            super(c);
        }

        @Override
        public boolean add(E e) {
            last = e;
            return super.add(e);
        }

        public E getLast() {
            return last;
        }
    }
}
