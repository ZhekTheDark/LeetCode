package com.easy

import kotlin.test.assertEquals

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 156 ms, faster than 33.33% of Kotlin online submissions for Calculate Money in Leetcode Bank.
 * Memory Usage: 35.5 MB, less than 11.11% of Kotlin online submissions for Calculate Money in Leetcode Bank.
 */
fun totalMoney(n: Int): Int {
    var res = 0
    val weeks = n / 7
    val days = n % 7

    res += calculateSumDays(days, weeks + 1)
    if (weeks > 0)
        res += (1..weeks)
            .toSet()
            .map { (it-1) * 7 + 28 }
            .sum()

    return res
}


fun calculateSumDays(daysNum: Int, weekNum: Int): Int {
    return ((weekNum) until weekNum + daysNum)
        .toList()
        .sum()
}

fun main() {
    val example1 = 4
    assertEquals(10, totalMoney(example1), "CalculateMoneyInLeetcodeBank1716.kt example1 error")

    val example2 = 10
    assertEquals(37, totalMoney(example2), "CalculateMoneyInLeetcodeBank1716.kt example2 error")

    val example3 = 20
    assertEquals(96, totalMoney(example3), "CalculateMoneyInLeetcodeBank1716.kt example3 error")
}
