package com.easy

import kotlin.test.assertEquals

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 * Example 1:
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 *
 * Example 2:
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 *
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */

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

fun main() {
    val example1Nums = intArrayOf(12, 345, 2, 6, 7896)
    assertEquals(2, findNumbers(example1Nums), "FindNumbersWithEvenNumberOfDigits1295 example1 error")

    val example2Nums = intArrayOf(555, 901, 482, 1771)
    assertEquals(1, findNumbers(example2Nums), "FindNumbersWithEvenNumberOfDigits1295 example2 error")
}
