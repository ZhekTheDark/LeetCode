package com.easy

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
class _13_RomanToInteger {

    private val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    private val subtraction = mapOf(
        'V' to 'I',
        'X' to 'I',
        'L' to 'X',
        'C' to 'X',
        'D' to 'C',
        'M' to 'C',
    )

    /**
     * Complexity Analysis
     * Time complexity : O(n).
     * Space complexity : O(1).
     *
     * Runtime: 222 ms, faster than 71.1% of Kotlin online submissions for Roman To Integer.
     * Memory Usage: 37.6 MB, less than 73.37% of Kotlin online submissions for Roman To Integer.
     */
    fun romanToInt(s: String): Int {
        var res = 0
        var i = 0
        while (i < s.length) {
            val next: Char? = if (i < s.length - 1) {
                s[i + 1]
            } else {
                null
            }
            res += eval(s[i], next)
            if (subtraction[next] == s[i]) i++
            i++
        }
        return res
    }

    private fun eval(first: Char, second: Char?): Int {
        return if (subtraction[second] == first) {
            map[second]!!.minus(map[first]!!)
        } else {
            map[first]!!
        }
    }
}

fun main() {
    println(_13_RomanToInteger().romanToInt("LVIII"))
}