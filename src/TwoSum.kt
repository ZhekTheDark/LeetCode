/**
 * Complexity Analysis
 * Time complexity : O(n^2).
 * Space complexity : O(1).
 */

/*fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        map[nums[i]] = i
    }
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement) && map[complement] != i) {
            return intArrayOf(i, map[complement]!!)
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

fun main(){
    val testArray = intArrayOf(3, 4, 2, 6, 2, 7, 11, 15)
    val res = twoSum(testArray, 9)
    println("${res!![0]}  ${res[1]}")
}