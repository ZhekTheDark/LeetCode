package com.easy


/**
 * Complexity Analysis:
 * Time complexity : O(nxm).
 * Space complexity : O(n).
 *
 * Runtime: 172 ms, faster than 90.82% of Kotlin online submissions for Find Numbers with Even Number of Digits.
 * Memory Usage: 36.4 MB, less than 93.88% of Kotlin online submissions for Find Numbers with Even Number of Digits.
 */
fun findNumbers(nums: IntArray): Int {
    return nums
        .map { it.toString() }
        .count { it.length % 2 == 0 }
}