/**
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 *
 * Example 1:
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 *
 * Example 2:
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 *
 * Example 3:
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 * Example 4:
 * Input: nums = [1,1,0,0,1,1,1,0,1]
 * Output: 4
 *
 * Example 5:
 * Input: nums = [0,0,0]
 * Output: 0
 *
 * Дан массив из нулей и единиц, нужно удалить одно значение и вывести максимально возможный подмассив единиц.
 * Сделал скользящим окном.
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 280 ms, faster than 66.67% of Kotlin online submissions for Longest Subarray of 1's After Deleting One Element.
 * Memory Usage: 45.1 MB, less than 73.33% of Kotlin online submissions for Longest Subarray of 1's After Deleting One Element.
 */
private fun longestSubarray(nums: IntArray): Int {

    var i = 0
    var max = 0
    var start = 0
    var zeros = 0

    while (i < nums.size) {
        if (nums[i] == 0)
            zeros++

        while (zeros > 1) {
            if (nums[start] == 0)
                zeros--
            start++
        }
        max = kotlin.math.max(max, i - start + 1 - zeros)
        i++
    }

    return if (max == nums.size) max - 1 else max

}

private fun main() {

    val array1 = intArrayOf(1, 1, 0, 1)
    val array2 = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
    val array3 = intArrayOf(1, 1, 1)
    val array4 = intArrayOf(1, 1, 0, 0, 1, 1, 1, 0, 1)
    val array5 = intArrayOf(0, 0, 0)
    val array6 = intArrayOf(1, 0, 0, 0, 0)
    val array7 = intArrayOf(0, 0, 1, 1)

    if (longestSubarray(array1) != 3) println("\u001B[31m 1")
    if (longestSubarray(array2) != 5) println("\u001B[31m 2")
    if (longestSubarray(array3) != 2) println("\u001B[31m 3")
    if (longestSubarray(array4) != 4) println("\u001B[31m 4")
    if (longestSubarray(array5) != 0) println("\u001B[31m 5")
    if (longestSubarray(array6) != 1) println("\u001B[31m 6")
    if (longestSubarray(array7) != 2) println("\u001B[31m 7")

}