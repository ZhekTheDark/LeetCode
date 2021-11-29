package com.easy

import kotlin.test.assertEquals

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(n).
 *
 * Runtime: 416 ms, faster than 81.69% of Kotlin online submissions for Find the Town Judge.
 * Memory Usage: 58.6 MB, less than 88.73% of Kotlin online submissions for Find the Town Judge.
 */
fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val trusts = n - 1
    val trustList = Array(n) { mutableListOf(0, 0) }

    for (people in trust) {
        trustList[people[1] - 1][0]++
        trustList[people[0] - 1][1]++
    }

    for (i in trustList.indices) {
        if (trustList[i][0] == trusts && trustList[i][1] == 0) return (i + 1)
    }

    return -1
}

fun main() {
    val example1N = 2
    val example1Trust = arrayOf(intArrayOf(1, 2))
    assertEquals(2, findJudge(example1N, example1Trust), "FindTheTownJudge997.kt example 1 error")
}
