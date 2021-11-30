package com.easy

import kotlin.test.assertEquals

/**
 * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
 *
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more
 * than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
 *
 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
 *
 * Example 1:
 * Input: n = 4
 * Output: 10
 * Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
 *
 * Example 2:
 * Input: n = 10
 * Output: 37
 * Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
 *
 * Example 3:
 * Input: n = 20
 * Output: 96
 * Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
 *
 * Constraints:
 * 1 <= n <= 1000
 */

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
