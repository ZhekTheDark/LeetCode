package com.easy

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

}