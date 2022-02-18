package com.easy

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
fun isValid(s: String): Boolean {
    return false
}

fun main() {
    val example1Sentence = "()"
    assertTrue(isValid(example1Sentence), "ValidParentheses20 example1 error")

    val example2Sentence = "()[]{}"
    assertTrue(isValid(example2Sentence), "ValidParentheses20 example2 error")

    val example3Sentence = "(]"
    assertFalse(isValid(example3Sentence), "ValidParentheses20 example3 error")

}