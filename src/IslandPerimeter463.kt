import kotlin.test.assertEquals

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Example 1:
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 *
 * Example 2:
 * Input: grid = [[1]]
 * Output: 4
 *
 * Example 3:
 * Input: grid = [[1,0]]
 * Output: 4
 */

/**
 * Complexity Analysis:
 * Time complexity : O(mxn).
 * Space complexity : O(1).
 *
 * Runtime: 348 ms, faster than 96.96% of Kotlin online submissions for Island Perimeter.
 * Memory Usage: 57.9 MB, less than 87.88% of Kotlin online submissions for Island Perimeter.
 */
fun islandPerimeter(grid: Array<IntArray>): Int {
    var result = 0

    for (i in grid.indices) {
        for (j in 0 until grid[0].size) {
            if (grid[i][j] == 1) {
                if (i - 1 < 0 || grid[i - 1][j] == 0) result++
                if (i + 1 >= grid.size || grid[i + 1][j] == 0) result++
                if (j - 1 < 0 || grid[i][j - 1] == 0) result++
                if (j + 1 >= grid[i].size || grid[i][j + 1] == 0) result++
            }
        }
    }

    return result
}

private fun main() {
    val exampleGrid1 = arrayOf(
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 0, 0),
    )
    assertEquals(16, islandPerimeter(exampleGrid1), "example1 error")

    val exampleGrid2 = arrayOf(
        intArrayOf(1),
    )
    assertEquals(4, islandPerimeter(exampleGrid2), "example2 error")

    val exampleGrid3 = arrayOf(
        intArrayOf(1, 0),
    )
    assertEquals(4, islandPerimeter(exampleGrid3), "example3 error")
}