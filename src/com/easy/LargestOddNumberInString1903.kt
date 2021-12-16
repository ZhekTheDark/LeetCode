package com.easy

import kotlin.test.assertEquals

/**
 * You are given a string num, representing a large integer.
 * Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string ""
 * if no odd integer exists.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: num = "52"
 * Output: "5"
 * Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
 *
 * Example 2:
 * Input: num = "4206"
 * Output: ""
 * Explanation: There are no odd numbers in "4206".
 *
 * Example 3:
 * Input: num = "35427"
 * Output: "35427"
 * Explanation: "35427" is already an odd number.
 *
 * Constraints:
 * 1 <= num.length <= 105
 * num only consists of digits and does not contain any leading zeros.
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 236 ms, faster than 52.22% of Kotlin online submissions for Largest Odd Number in String.
 * Memory Usage: 39.5 MB, less than 74.44% of Kotlin online submissions for Largest Odd Number in String.
 */
fun largestOddNumber(num: String): String {
    return num.dropLastWhile { Character.getNumericValue(it) % 2 == 0 }
}

fun main() {
    val example1Num = "52"
    assertEquals("5", largestOddNumber(example1Num), "LargestOddNumberInString1903.kt example1 error")

    val example2Num = "4206"
    assertEquals("", largestOddNumber(example2Num), "LargestOddNumberInString1903.kt example1 error")

    val example3Num = "35427"
    assertEquals("35427", largestOddNumber(example3Num), "LargestOddNumberInString1903.kt example3 error")
}
