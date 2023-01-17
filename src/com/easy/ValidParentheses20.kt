package com.easy

import java.util.*
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
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */

//fun isValid(s: String): Boolean {
//    val stack = ArrayDeque<Char>()
//    s.forEach {
//        when(it) {
//            '(', '[', '{' -> stack.push(it)
//            ')' -> if (stack.poll() != '(') return false
//            '}' -> if (stack.poll() != '{') return false
//            ']' -> if (stack.poll() != '[') return false
//        }
//    }
//    return stack.isEmpty()
//}

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(n).
 *
 * Runtime: 155 ms, faster than 83.41% of Kotlin online submissions.
 * Memory Usage: 34.9 MB, less than 43.81% of Kotlin online submissions.
 */
fun isValid(s: String): Boolean {
    val stack = Stack<String>()
    ArrayDeque<Char>()

    s.forEach { c: Char ->
        stack.popOrPush(c.toString())
    }

    return stack.isEmpty()
}

private fun <String> Stack<String>.popOrPush(str: String) {
    if (isEmpty()) {
        push(str)
    } else {
        val peek: String = peek()
        if (peek.isOpposite(str)) {
            pop()
        } else {
            push(str)
        }
    }
}

private fun <String> String.isOpposite(str: String): Boolean {
    return when (this) {
        "(" -> str == ")"
        "[" -> str == "]"
        "{" -> str == "}"
        ")", "]", "}" -> false
        else -> throw IllegalArgumentException("illegal char: $this")
    }
}

fun main() {
    val example1Sentence = "()"
    assertTrue(isValid(example1Sentence), "ValidParentheses20 example1 error")

    val example2Sentence = "()[]{}"
    assertTrue(isValid(example2Sentence), "ValidParentheses20 example2 error")

    val example3Sentence = "(]"
    assertFalse(isValid(example3Sentence), "ValidParentheses20 example3 error")
}
