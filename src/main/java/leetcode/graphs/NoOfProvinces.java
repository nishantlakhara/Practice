package leetcode.graphs;

import java.util.HashSet;
import java.util.Set;

public class NoOfProvinces {
    public static void main(String[] args) {
//        int[][] isConnected = new int[][] {
//                {1,1,0}
//                ,{1,1,0}
//                ,{0,0,1}
//        };

//        int[][] isConnected = new int[][] {
//                {1,1,0}
//                ,{1,1,0}
//                ,{0,0,1}
//        };
        int[][] isConnected = new int[][] {{1,1,0,0,0,0,0,1,0,1},
            {1,1,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0},
            {0,0,1,0,0,0,1,1,0,0},
            {1,0,0,0,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,0,1,1},
            {1,0,0,0,0,0,0,0,1,1}};

        NoOfProvinces noOfProvinces = new NoOfProvinces();
        System.out.println(noOfProvinces.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);

        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected.length; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        uf.print();
        return uf.getDistinctRootsLength();
    }
}

class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];

        for(int i=0; i<size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    //Return root of the node
    public int find(int x) {
        if(root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else if(rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    public int getDistinctRootsLength() {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<root.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    public void print() {
        for(int i=0; i<root.length; i++) {
            System.out.print(i + ":" + root[i] + ",");
        }
        System.out.println();
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
