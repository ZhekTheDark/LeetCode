package com.easy

import kotlin.test.assertEquals

fun sortArrayByParity(nums: IntArray): IntArray {
    return intArrayOf()
}

fun main() {
    val example1Nums = intArrayOf(3,1,2,4)
    val example1Res = intArrayOf(2,4,3,1)
    assertEquals(example1Res, sortArrayByParity(example1Nums), "sortArrayByParity example1 error")

    val example2Nums = intArrayOf(0)
    val example2Res = intArrayOf(0)
    assertEquals(example2Res, sortArrayByParity(example2Nums), "sortArrayByParity example2 error")
}
