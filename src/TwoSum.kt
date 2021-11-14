import kotlin.test.assertContentEquals

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Дан массив и значение. Нужно вывести 2 индекса элементов массива, сумма которых равно значению.
 */

/*
/**
 * Complexity Analysis:
 * Time complexity : O(n^2).
 * Space complexity : O(1).
 */

fun twoSum(nums: IntArray, target: Int): IntArray? {

    val result = IntArray(2)

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                result[0] = i
                result[1] = j
                return result
            }
        }
    }

    throw IllegalArgumentException("No two sum solution")

}
*/

/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(n).
 *
 * Runtime: 180 ms, faster than 94.97% of Kotlin online submissions for Two Sum.
 * Memory Usage: 35.1 MB, less than 76.70% of Kotlin online submissions for Two Sum.
 */

fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map = HashMap<Int, Int>()

    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }

    throw Exception("No two sum solution")
}

fun main() {
    val testArray = intArrayOf(3, 4, 2, 6, 2, 7, 11, 15)
    val target = 11
    val res = twoSum(testArray, target)

    assertContentEquals(intArrayOf(1, 5), res,  "twoSum error")
}
