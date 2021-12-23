package com.easy

import kotlin.test.assertEquals

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
