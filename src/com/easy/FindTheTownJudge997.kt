package com.easy

import kotlin.test.assertEquals

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 * Input: n = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 * Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 * Constraints:
 * 1 <= n <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 */

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

    val example2N = 3
    val example2Trust = arrayOf(intArrayOf(1,3), intArrayOf(2,3))
    assertEquals(3, findJudge(example2N, example2Trust), "FindTheTownJudge997.kt example 2 error")
}
