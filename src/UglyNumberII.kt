import kotlin.math.min

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Найти уродливое n-ое число
 */


/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(n).
 *
 * Runtime: 148 ms, faster than 100.00% of Kotlin online submissions for Ugly Number II.
 * Memory Usage: 33.8 MB, less than 81.25% of Kotlin online submissions for Ugly Number II.
 */
fun nthUglyNumber(n: Int): Int {
    var last2 = 0
    var last3 = 0
    var last5 = 0
    val result = Array(n) { 0 }
    result[0] = 1

    for (i in 1 until n) {
        val prev = result[i - 1]

        while (result[last2] * 2 <= prev) {
            ++last2
        }

        while (result[last3] * 3 <= prev) {
            ++last3
        }

        while (result[last5] * 5 <= prev) {
            ++last5
        }

        val candidate1 = result[last2] * 2
        val candidate2 = result[last3] * 3
        val candidate3 = result[last5] * 5
        result[i] = min(candidate1, min(candidate2, candidate3))
    }

    return (result[n - 1])
}

fun main() {
    println(nthUglyNumber(12))
}
