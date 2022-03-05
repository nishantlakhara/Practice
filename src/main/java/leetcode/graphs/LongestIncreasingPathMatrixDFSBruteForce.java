package leetcode.graphs;

public class LongestIncreasingPathMatrixDFSBruteForce {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };

        LongestIncreasingPathMatrixDFSBruteForce longestIncreasingPathMatrixDFSBruteForce = new LongestIncreasingPathMatrixDFSBruteForce();
        System.out.println(longestIncreasingPathMatrixDFSBruteForce.longestIncreasingPath(matrix));
    }

    private static final int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    private int m;
    private int n;

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;

        m = matrix.length;
        n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }

        return res;
    }

    public int dfs(int[][] matrix, int i, int j) {
        int res = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < m && y >= 0 && y < n
                    && matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix, x, y));
            }
        }
        return ++res;
    }

}
