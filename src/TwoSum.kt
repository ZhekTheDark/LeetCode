/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Дан массив и значение. Нужно вывести 2 индекса элементов массива, сумма которых равно значению.
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n^2).
 * Space complexity : O(1).
 */

/*fun twoSum(nums: IntArray, target: Int): IntArray? {

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

}*/

/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(n).
 */

fun twoSum(nums: IntArray, target: Int): IntArray? {

    val map: MutableMap<Int, Int> = HashMap()

    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }

    throw java.lang.IllegalArgumentException("No two sum solution")

}

fun main() {

    val testArray = intArrayOf(3, 4, 2, 6, 2, 7, 11, 15)
    val target = 11
    val res = twoSum(testArray, target)

    println("${res!![0]}  ${res[1]}")

}
