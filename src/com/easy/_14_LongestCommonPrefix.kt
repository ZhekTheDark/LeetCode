package com.easy

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

/**
 * Complexity Analysis
 * Time complexity : O(n * m).
 * Space complexity : O(1).
 *
 * Runtime: 151 ms, faster than 92.47% of Kotlin online submissions for Longest Common Prefix.
 * Memory Usage: 34.7 MB, less than 91.16% of Kotlin online submissions for Longest Common Prefix.
 */
fun longestCommonPrefix(strs: Array<String>): String {
    val w = strs[0]
    w.forEachIndexed { index, c ->
        if (strs.any { it.length == index } || strs.any { it[index] != c }) return w.substring(0, index)
    }
    return w
}

/**
 * Complexity Analysis
 * Time complexity : O(n + m).
 * Space complexity : O(m * log(n)).
 *
 * Runtime: 148 ms, faster than 95.41% of Kotlin online submissions for Longest Common Prefix.
 * Memory Usage: 34 MB, less than 99.89% of Kotlin online submissions for Longest Common Prefix.
 */
fun longestCommonPrefixDivideAndConquer(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    return longestCommonPrefixDAC(strs, 0, strs.size - 1)
}

private fun longestCommonPrefixDAC(strs: Array<String>, l: Int, r: Int): String {
    if (l == r) return strs[l]
    val mid = (r + l) / 2
    val lcpLeft = longestCommonPrefixDAC(strs, l, mid)
    val lcpRight = longestCommonPrefixDAC(strs, mid + 1, r)
    return commonPrefix(lcpLeft, lcpRight)
}

private fun commonPrefix(left: String, right: String): String {
    left.forEachIndexed { index, c ->
        if (right.length == index || right[index] != c)
            return left.substring(0, index)
    }
    return left
}
