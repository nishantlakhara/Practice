package leetcode.graphs;

public class LongestIncreasingPathMatrixDFSDP {
    private static final int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    private int m;
    private int n;
    private static int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;

        m = matrix.length;
        n = matrix[0].length;
        cache = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }

        return res;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int res = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < m && y >= 0 && y < n
                    && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y));
            }
        }
        return ++cache[i][j];
    }
}
