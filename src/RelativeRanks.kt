/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 *
 * Дан массив с результатами атлетов, нужно вывести тоже самое, но заменив первое место на золото и так далее
 */

/**
 * Runtime: 264 ms, faster than 100.00% of Kotlin online submissions for Relative Ranks.
 * Memory Usage: 38.1 MB, less than 100.00% of Kotlin online submissions for Relative Ranks.
 */
fun findRelativeRanks(nums: IntArray): Array<String> {
    return nums.mapIndexed { index, `val` -> Pair(`val`, index) }
        .sortedByDescending { it.first }
        .mapIndexed { index, pair -> Triple(pair.first, pair.second, index + 1) }
        .sortedBy { it.second }
        .map {
            when (it.third) {
                1 -> "Gold Medal"
                2 -> "Silver Medal"
                3 -> "Bronze Medal"
                else -> it.third.toString()
            }
        }.toTypedArray()
}

fun main() {
    val array1 = intArrayOf(5, 4, 3, 2, 1)
    val array2 = intArrayOf(10, 3, 8, 9, 4)
    val array3 = intArrayOf(1, 2, 3)
    val array4 = intArrayOf(3, 2, 1)

    println(findRelativeRanks(array1).joinToString())
    println(findRelativeRanks(array2).joinToString())
    println(findRelativeRanks(array3).joinToString())
    println(findRelativeRanks(array4).joinToString())
}