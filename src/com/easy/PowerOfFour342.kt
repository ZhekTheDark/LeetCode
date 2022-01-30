package com.easy

import kotlin.math.floor
import kotlin.math.log
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 *
 * Example 1:
 * Input: n = 16
 * Output: true
 *
 * Example 2:
 * Input: n = 5
 * Output: false
 *
 * Example 3:
 * Input: n = 1
 * Output: true
 *
 * Constraints:
 * -231 <= n <= 231 - 1
 */

/**
 * Complexity Analysis:
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 * Runtime: 140 ms, faster than 68.63% of Kotlin online submissions for Power of Four.
 * Memory Usage: 33.4 MB, less than 78.43% of Kotlin online submissions for Power of Four.
 */
fun isPowerOfFour(n: Int): Boolean {
    val result = log(n.toDouble(), 4.0)
    val remain = result - floor(result)
    return remain == 0.0
}

fun main() {
    val example1 = 16
    assertTrue(isPowerOfFour(example1))

    val example2 = 5
    assertFalse(isPowerOfFour(example2))

    val example3 = 1
    assertTrue(isPowerOfFour(example3))
}