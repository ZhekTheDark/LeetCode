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
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 151 ms, faster than 92.47% of Kotlin online submissions for Remove Duplicates from Sorted List.
 * Memory Usage: 34.7 MB, less than 91.16% of Kotlin online submissions for Remove Duplicates from Sorted List.
 */
fun longestCommonPrefix(strs: Array<String>): String {
    val w = strs[0]
    w.forEachIndexed { index, c ->
        if (strs.any { it.length == index } || strs.any { it[index] != c }) return w.substring(0, index)
    }
    return w
}