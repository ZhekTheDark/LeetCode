import kotlin.test.assertContentEquals

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 * Example 2:
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 *
 * Example 3:
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 *
 * Дан массив. Нужно вернуть массив, каждый элемент которого равен сумме всех предшествующих элементов и текущего элемента заданного массива.
 */

/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 160 ms, faster than 98.12% of Kotlin online submissions for Running Sum of 1d Array.
 * Memory Usage: 34.1 MB, less than 92.47% of Kotlin online submissions for Running Sum of 1d Array.
 */

private fun runningSum(nums: IntArray): IntArray {
    for (i in 1 until nums.size) {
        nums[i] = nums[i] + nums[i - 1]
    }

    return (nums)
}

private fun main() {
    val nums = intArrayOf(3, 1, 2, 10, 1)

    val result = runningSum(nums)
    assertContentEquals(result, intArrayOf(3, 4, 6, 16, 17), "runningSum error")
}
