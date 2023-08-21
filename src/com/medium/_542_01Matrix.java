package com.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class _542_01Matrix {

    /**
     * Runtime: 13ms Beats 82.81% of users with Java
     * Memory: 44.85MB Beats 99.08% of users with Java
     */
    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[x].length; y++) {
                if (mat[x][y] == 0) {
                    queue.add(new int[]{x, y});
                } else {
                    mat[x][y] = -1;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            for (int[] dir : directions) {
                int xNeighbour = coordinates[0] + dir[0];
                int yNeighbour = coordinates[1] + dir[1];
                if (xNeighbour >= 0 && xNeighbour < mat.length &&
                        yNeighbour >= 0 && yNeighbour < mat[xNeighbour].length &&
                        mat[xNeighbour][yNeighbour] == -1
                ) {
                    queue.add(new int[]{xNeighbour, yNeighbour});
                    mat[xNeighbour][yNeighbour] = mat[coordinates[0]][coordinates[1]] + 1;
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] res = updateMatrix(mat);
        System.out.println(res);
    }
}
