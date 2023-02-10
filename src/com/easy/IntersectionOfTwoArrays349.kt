package com.easy

import kotlin.test.assertContentEquals

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Explanation: [4,9] is also accepted.
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(n).
 *
 * Runtime: 200 ms, faster than 64.00% of Kotlin online submissions for Intersection of Two Arrays.
 * Memory Usage: 37.5 MB, less than 55.00% of Kotlin online submissions for Intersection of Two Arrays.
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    return nums1
        .filter { nums2.contains(it) }
        .distinct()
        .toIntArray()
}

fun main() {
    val nums1Example1 = intArrayOf(1, 2, 2, 1)
    val nums2Example1 = intArrayOf(2, 2)
    val resultExample1 = intArrayOf(2)
    assertContentEquals(resultExample1, intersection(nums1Example1, nums2Example1), "intersection example1 error")
}
