package com.easy

import kotlin.test.assertTrue

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 * Example 1:
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 *
 * Example 2:
 * Input: sentence = "leetcode"
 * Output: false
 *
 * Constraints:
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 */

/**
 * Complexity Analysis:
 * Time complexity : O(nxm).
 * Space complexity : O(n).
 *
 * Runtime: 160 ms, faster than 65.96% of Kotlin online submissions for Check if the Sentence Is Pangram.
 * Memory Usage: 34.9 MB, less than 57.45% of Kotlin online submissions for Check if the Sentence Is Pangram.
 */
fun checkIfPangram(sentence: String): Boolean {
    val res = mutableSetOf<Char>()

    sentence.forEach { char -> res.add(char) }

    return res.size == 26
}

fun main() {
    val example1Sentence = "thequickbrownfoxjumpsoverthelazydog"
    assertTrue(checkIfPangram(example1Sentence), "CheckIfTheSentenceIsPangram1832 example1 error")
}