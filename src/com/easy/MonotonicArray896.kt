package com.easy

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 1366 ms, faster than 6.90% of Kotlin online submissions for Monotonic Array.
 * Memory Usage: 123.3 MB, less than 6.90% of Kotlin online submissions for Monotonic Array.
 */
fun isMonotonic(nums: IntArray): Boolean {
    var direction = 0
    for (i in 0..nums.size - 2) {
        if (nums[i] < nums[i + 1] && direction == 0) direction++
        if (nums[i] > nums[i + 1] && direction == 0) direction--

        if (nums[i] == nums[i + 1]) continue
        if ((nums[i] < nums[i + 1] && direction > 0)
            || (nums[i] > nums[i + 1] && direction < 0)
        ) continue
        else return false
    }

    return true

    /*var isAscending = false
    if (nums[0] < nums[nums.size - 1]) isAscending = true

    if (isAscending) {
        for (i in 0..nums.size - 2) {
            if (nums[i] > nums[i + 1]) return false
        }
    } else {
        for (i in 0..nums.size - 2) {
            if (nums[i] < nums[i + 1]) return false
        }
    }

    return true*/
}

fun main() {
    val num1example = intArrayOf(1, 2, 2, 3)
    assertTrue(isMonotonic(num1example), "isMonotonic example1 error")

    val num2example = intArrayOf(6, 5, 4, 4)
    assertTrue(isMonotonic(num2example), "isMonotonic example2 error")

    val num3example = intArrayOf(1, 3, 2)
    assertFalse(isMonotonic(num3example), "isMonotonic example3 error")

    val num4example = intArrayOf(1, 2, 4, 5)
    assertTrue(isMonotonic(num4example), "isMonotonic example4 error")

    val num5example = intArrayOf(1, 1, 1)
    assertTrue(isMonotonic(num5example), "isMonotonic example5 error")
}
