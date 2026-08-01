package interviews.crunchyroll;

import java.util.*;

public class NearestExitFromStart {

    static class Cell {
        int r, c, dist;
        Cell(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.dist = d;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '.', '+'}
        };

        int startRow = 1;
        int startCol = 0;

        int result = shortestExit(grid, startRow, startCol);
        System.out.println("Shortest distance = " + result);
    }

    public static int shortestExit(char[][] grid, int sr, int sc) {
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();

        q.offer(new Cell(sr, sc, 0));
        visited[sr][sc] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            Cell curr = q.poll();

            for (int[] d : dirs) {
                int nr = curr.r + d[0];
                int nc = curr.c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n &&
                        grid[nr][nc] == '.' && !visited[nr][nc]) {

                    // check if exit (boundary) and not start
                    if (isBoundary(nr, nc, m, n)) {
                        return curr.dist + 1;
                    }

                    visited[nr][nc] = true;
                    q.offer(new Cell(nr, nc, curr.dist + 1));
                }
            }
        }

        return -1; // no exit reachable
    }

    private static boolean isBoundary(int i, int j, int m, int n) {
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }
}