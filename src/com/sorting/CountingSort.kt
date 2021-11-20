/**
 * Counting sort
 *
 * Сортировка подсчётом
 *
 * Complexity Analysis:
 * Time complexity : O(n).
 * Space complexity : O(n + k).
 */

private fun countingSort(array: IntArray) {
    val countsArray = Array((array.maxOrNull() ?: 0) + 1) { 0 }
    val sortedArray = Array(array.size) { 0 }

    for (i in array.indices)
        countsArray[array[i]]++

    for (j in 1 until countsArray.size)
        countsArray[j] = countsArray[j] + countsArray[j - 1]

    for (i in array.size - 1 downTo 0) {
        sortedArray[countsArray[array[i]] - 1] = array[i]
        countsArray[array[i]] = countsArray[array[i]] - 1
    }

    for (i in array.indices) {
        array[i] = sortedArray[i]
    }
}

fun main() {
    val array = intArrayOf(2, 5, 3, 0, 2, 3, 0, 3)

    println("Before CountingSort\n ${array.joinToString()}")

    countingSort(array)

    println("\nAfter CountingSort\n ${array.joinToString()}")
}