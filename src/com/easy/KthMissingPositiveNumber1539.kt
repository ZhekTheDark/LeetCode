package com.easy

import kotlin.test.assertEquals

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 * Example 1:
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 *
 * Example 2:
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 * Constraints:
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 176 ms, faster than 61.29% of Kotlin online submissions for Kth Missing Positive Number.
 * Memory Usage: 36.8 MB, less than 58.06% of Kotlin online submissions for Kth Missing Positive Number.
 */
fun findKthPositive(arr: IntArray, k: Int): Int {
    var n = k
    val maxValue = arr[arr.size - 1]

    for (i in 1..maxValue) {
        if (!arr.contains(i)) n--
        if (n == 0) return i
    }

    return maxValue + n
}

fun main() {
    val example1Arr = intArrayOf(2, 3, 4, 7, 11)
    val example1K = 5
    assertEquals(9, findKthPositive(example1Arr, example1K), "KthMissingPositiveNumber1539 example1 error")

    val example2Arr = intArrayOf(1, 2, 3, 4)
    val example2K = 2
    assertEquals(6, findKthPositive(example2Arr, example2K), "KthMissingPositiveNumber1539 example2 error")
}
