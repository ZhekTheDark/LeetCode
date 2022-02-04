package com.easy

import kotlin.test.assertEquals

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 * Example 1:
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */
fun sortArrayByParity(nums: IntArray): IntArray {
    val oddInts = mutableListOf<Int>()
    val evenInts = mutableListOf<Int>()

    for (num in nums) {
        if (num % 2 == 0) {
            evenInts += num
        } else {
            oddInts += num
        }
    }

    return (evenInts + oddInts).toIntArray()
}

fun main() {
    val example1Nums = intArrayOf(3,1,2,4)
    val example1Res = intArrayOf(2,4,3,1)
    assertEquals(example1Res, sortArrayByParity(example1Nums), "sortArrayByParity example1 error")

    val example2Nums = intArrayOf(0)
    val example2Res = intArrayOf(0)
    assertEquals(example2Res, sortArrayByParity(example2Nums), "sortArrayByParity example2 error")
}
