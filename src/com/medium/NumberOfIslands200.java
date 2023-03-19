package com.medium;

import java.util.LinkedList;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands200 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n*m).
     * Space complexity : O(1).
     * <p>
     * Runtime: 2 ms, faster than 99.95% of Java online submissions for Move Zeroes.
     * Memory Usage: 50.9 MB, less than 51.87% of Java online submissions for Move Zeroes.
     */
    public int numIslandsDfs(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    destroyIsland(grid, i, j, rows, cols);
                }
            }
        }

        return count;
    }

    private void destroyIsland(char[][] grid, int x, int y, int rows, int cols) {
        grid[x][y] = '0';

        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            destroyIsland(grid, x - 1, y, rows, cols);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            destroyIsland(grid, x, y - 1, rows, cols);
        }
        if (x + 1 < rows && grid[x + 1][y] == '1') {
            destroyIsland(grid, x + 1, y, rows, cols);
        }
        if (y + 1 < cols && grid[x][y + 1] == '1') {
            destroyIsland(grid, x, y + 1, rows, cols);
        }
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(n*m).
     * Space complexity : O(n*m).
     * <p>
     * Runtime: 14 ms, faster than 8.32% of Java online submissions for Move Zeroes.
     * Memory Usage: 50.1 MB, less than 91.96% of Java online submissions for Move Zeroes.
     */
    public int numIslandsBfs(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }

                count++;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.addFirst(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] t = queue.removeFirst();
                    if (!visited[t[0]][t[1]] && grid[t[0]][t[1]] == '1') {
                        if (t[0] < grid.length - 1) {
                            queue.addFirst(new int[]{t[0] + 1, t[1]});
                        }
                        if (t[1] < grid[0].length - 1) {
                            queue.addFirst(new int[]{t[0], t[1] + 1});
                        }
                        if (t[0] > 0) {
                            queue.addFirst(new int[]{t[0] - 1, t[1]});
                        }
                        if (t[1] > 0) {
                            queue.addFirst(new int[]{t[0], t[1] - 1});
                        }
                    }
                    visited[t[0]][t[1]] = true;
                }

            }
        }

        return count;
    }
}
