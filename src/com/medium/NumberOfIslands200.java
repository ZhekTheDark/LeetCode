package com.medium;

public class NumberOfIslands200 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n*m).
     * Space complexity : O(1).
     * <p>
     * Runtime: 2 ms, faster than 99.95% of Java online submissions for Move Zeroes.
     * Memory Usage: 50.9 MB, less than 51.87% of Java online submissions for Move Zeroes.
     */
    public int numIslands(char[][] grid) {
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
}
