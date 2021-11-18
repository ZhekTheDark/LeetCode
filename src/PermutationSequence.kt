/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Нужно выывести k-й элемент из множества переборов из n чисел
 */

/**
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(n).
 *
 * Runtime: 136 ms, faster than 98.70% of Kotlin online submissions for Permutation Sequence.
 * Memory Usage: 32.6 MB, less than 68.83% of Kotlin online submissions for Permutation Sequence.
 */
fun getPermutation(n: Int, k: Int): String {
    val factorialArray = IntArray(n - 1) { 1 }
    for (i in 1 until factorialArray.size) {
        factorialArray[i] = factorialArray[i - 1] * (i + 1)
    }

    val possibleNumbers = MutableList(n) { it + 1 }
    var number = n - 1
    var value = k - 1
    var res = ""

    while (number > 0) {
        res += possibleNumbers[value / factorialArray[number - 1]]
        possibleNumbers.removeAt(value / factorialArray[number - 1])
        value %= factorialArray[number - 1]
        number--
    }

    res += possibleNumbers[0]

    return (res)
}

fun main() {
    println(getPermutation(4, 9))
}
