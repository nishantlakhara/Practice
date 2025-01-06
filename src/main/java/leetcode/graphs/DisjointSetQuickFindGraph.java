package leetcode.graphs;

// UnionFind.class
class DisjointSetQuickFindGraph {
    private int[] root;

    public DisjointSetQuickFindGraph(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public void print() {
        for(int i=0; i<root.length-1; i++) {
            System.out.print(i + ":" + root[i] + ",");
        }
        System.out.println(root.length-1 + ":" + root[root.length-1]);
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


// App.java
// Test Case

    public static void main(String[] args) throws Exception {
        DisjointSetQuickFindGraph uf = new DisjointSetQuickFindGraph(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.print();

        uf.union(5, 2);
        uf.print();

        uf.union(5, 6);
        uf.print();

        uf.union(6, 7);
        uf.print();

        uf.union(3, 8);
        uf.print();

        uf.union(8, 9);
        uf.print();

        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        uf.print();

        System.out.println(uf.connected(4, 9)); // true
    }
}
