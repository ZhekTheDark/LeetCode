package com.easy

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * Return the modified image after performing the flood fill.
 *
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 *
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 *
 * Constraints:
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 208 ms, faster than 99.26% of Kotlin online submissions for Flood Fill.
 * Memory Usage: 38.2 MB, less than 89.63% of Kotlin online submissions for Flood Fill.
 */
fun floodFill(
    image: Array<IntArray>,
    sr: Int,
    sc: Int,
    newColor: Int
): Array<IntArray> {
    fill(image, sc, sr, newColor)

    return image
}

fun fill(image: Array<IntArray>, x: Int, y: Int, newColor: Int) {
    val oldColor = image[y][x]
    if (oldColor == newColor) return
    image[y][x] = newColor

    if (x + 1 in image[y].indices && image[y][x + 1] == oldColor) fill(image, x + 1, y, newColor)
    if (x - 1 in image[y].indices && image[y][x - 1] == oldColor) fill(image, x - 1, y, newColor)
    if (y + 1 in image.indices && image[y + 1][x] == oldColor) fill(image, x, y + 1, newColor)
    if (y - 1 in image.indices && image[y - 1][x] == oldColor) fill(image, x, y - 1, newColor)

//    а можно и так
//    setOf(1, -1).forEach {
//        if (y + it in image.indices && image[y + it][x] == oldColor) fill(image, x, y + it, newColor);
//        if (x + it in image[y].indices && image[y][x + it] == oldColor) fill(image, x + it, y, newColor);
//    }
}

fun floodFillStack(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {

}

fun main() {
    val exampleImage1 = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1),
    )
    val resultImage1 = arrayOf(
        intArrayOf(2, 2, 2),
        intArrayOf(2, 2, 0),
        intArrayOf(2, 0, 1),
    )

    println(exampleImage1.forEach { line -> line.forEach { element -> print("$element ") }; println() })
    println(resultImage1.forEach { line -> line.forEach { element -> print("$element ") }; println() })
    val res1 = floodFill(exampleImage1, 1, 1, 2)
    println(res1.forEach { line -> line.forEach { element -> print("$element ") }; println() })
}
