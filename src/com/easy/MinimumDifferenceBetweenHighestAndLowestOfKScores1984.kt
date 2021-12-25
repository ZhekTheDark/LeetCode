package com.easy

import kotlin.test.assertEquals

/**
 * You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
 * Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
 * Return the minimum possible difference.
 *
 * Example 1:
 * Input: nums = [90], k = 1
 * Output: 0
 * Explanation: There is one way to pick score(s) of one student:
 * - [90]. The difference between the highest and lowest score is 90 - 90 = 0.
 * The minimum possible difference is 0.
 *
 * Example 2:
 * Input: nums = [9,4,1,7], k = 2
 * Output: 2
 * Explanation: There are six ways to pick score(s) of two students:
 * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
 * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
 * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
 * - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
 * - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
 * - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
 * The minimum possible difference is 2.
 *
 * Constraints:
 * 1 <= k <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n*log(n)).
 * Space complexity : O(1).
 *
 * Runtime: 212 ms, faster than 100.00% of Kotlin online submissions for Minimum Difference Between Highest and Lowest of K Scores.
 * Memory Usage: 38.3 MB, less than 77.78% of Kotlin online submissions for Minimum Difference Between Highest and Lowest of K Scores.
 */
fun minimumDifference(nums: IntArray, k: Int): Int {
    nums.sort()
    var res = nums[k - 1] - nums[0]
    for (i in k..nums.lastIndex) {
        res = minOf(res, nums[i] - nums[i - k + 1])
    }
    return res
}

fun main() {
    val example1Nums = intArrayOf(90)
    val example1K = 1
    assertEquals(0, minimumDifference(example1Nums, example1K), "MinimumDifferenceBetweenHighestAndLowestOfKScores1984 example1 error")

    val example2Nums = intArrayOf(9,4,1,7)
    val example2K = 1
    assertEquals(0, minimumDifference(example2Nums, example2K), "MinimumDifferenceBetweenHighestAndLowestOfKScores1984 example1 error")
}
