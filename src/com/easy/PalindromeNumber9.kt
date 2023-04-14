package com.easy

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 204 ms, faster than 92.09% of Kotlin online submissions for Palindrome Number.
 * Memory Usage: 35.8 MB, less than 80.73% of Kotlin online submissions for Palindrome Number.
 */
fun isPalindrome(x: Int): Boolean {
    val s = x.toString()

    for (i in 0..(s.length / 2))
        if (s[i] != s[s.length - 1 - i]) return false

    return true
}

fun main() {
    val example1x = 121
    assertTrue(isPalindrome(example1x), "PalindromeNumber9 example1 error")

    val example2x = -121
    assertFalse(isPalindrome(example2x), "PalindromeNumber9 example2 error")

    val example3x = 10
    assertFalse(isPalindrome(example3x), "PalindromeNumber9 example3 error")
}
