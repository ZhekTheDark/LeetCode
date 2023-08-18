package com.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _542_01Matrix {

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
